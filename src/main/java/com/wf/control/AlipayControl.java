package com.wf.control;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

@Controller
public class AlipayControl {

	private AlipayClient alipayClient;
	
	private Environment env;
	
	private String alipayPublicKey;
	
	@Autowired
	public AlipayControl(AlipayClient alipayClient, Environment env) throws IOException {
		super();
		this.alipayClient = alipayClient;
		this.env = env;
		alipayPublicKey = FileUtils.readFileToString(new File(
				env.getProperty("alipay.alipayPublicKey")), "UTF-8");
	}
//订单页
	@RequestMapping(value = "/alipay/success", method = RequestMethod.GET)
	public String order() {
		return "success";
	}
	
	
		@RequestMapping(value = "/alipay/pay", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
		@ResponseBody
		public String pay() throws AlipayApiException {
			 AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
			 alipayRequest.setReturnUrl(env.getProperty("alipay.returnUrl")); // 当前端页面完成了支付跳转回商户的地址
			 alipayRequest.setNotifyUrl(env.getProperty("alipay.notifyUrl"));// 当支付宝服务端确认支付完成时通知的地址
			 
			 String orderId = ""+new Date().getTime();
			//填充业务参数
			 alipayRequest.setBizContent("{" +
			 // 商户订单号
			        "    \"out_trade_no\":\" "+orderId+"\"," +
			 // 销售产品码,固定
			        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
			 // 订单总额
			        "    \"total_amount\": 0.01," +
			 // 订单概要
			        "    \"subject\":\"Iphone6 16G\"," +
			 // 订单描述(可选)
			        "    \"body\":\"Iphone6 16G\"" +
			        "  }");
			 
			String form= alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单(用于用户支付的页面html)
			System.out.println("------------------");
			System.out.println(form);
			System.out.println("------------------");
			return form;
		}
		
		@RequestMapping(value = "/alipay/cb/sync", method=RequestMethod.GET)
		public String payOk(@RequestParam(name = "out_trade_no") Long orderId,
				@RequestParam Map<String,String> paramMap) {
			// 当前端支付结束后，浏览器被支付宝跳回到该页面
			if(!verifySig(paramMap)){
				System.out.println("---跳转回商户请求签名无效，忽略");
				return "error";// 自定义error.jsp
			}
			return "pay-ok";
		}
		@RequestMapping(value = "/alipay/cb/async",method=RequestMethod.POST)
		@ResponseBody // 响应内容应该是text/plain
		public String payOkAsync(@RequestParam(name = "out_trade_no") Long orderId,
				@RequestParam(name="total_amount") Double totalAmount,
				@RequestParam(name="trade_status") String tradeStatus,
				@RequestParam Map<String,String> paramMap) {
			if(!verifySig(paramMap)){
				System.out.println("---支付结果异步通知签名无效，忽略");
				return "failure";
			}
			// 支付宝系统发给商户的支付结果异步通知，以此为准
			System.out.println("---支付结果异步通知：订单#"+orderId);
			
			if(tradeStatus.equals("TRADE_SUCCESS")||tradeStatus.equals("TRADE_FINISHED")){
				System.out.println("---收到付款￥"+totalAmount);
				// 应该把该订单的状态改为“已支付”
			}else{
				System.out.println("---支付失败："+tradeStatus);
			}
			return "success";//异步通知已处理，支付宝看到success将不再发送此通知
		}
		
		
		private boolean verifySig(Map<String, String> paramMap) {
			try{//调用SDK验证签名
				return AlipaySignature.rsaCheckV1(paramMap, alipayPublicKey, "UTF-8", "RSA2");
			}catch(AlipayApiException e){
				e.printStackTrace();
			}
			return false;
		}
}

package com.wf.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wf.entity.Address;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;
import com.wf.service.CarService;
import com.wf.service.VipService;

@Controller
public class VipControl {
	
	private VipService vipService;
	private CarService carService;
	
	@Autowired
	public VipControl(VipService vipService,CarService carService) {
		super();
		this.vipService = vipService;
		this.carService = carService;
	}
	
	//vip会员中心--订单列表   通过用户id，收货地址id,显示订单
			@RequestMapping(method = RequestMethod.GET, value = "/vipOrder")
			public String vipOrderPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
				List<OrderItem> orderList= vipService.findVipOrder(login.getId());
				model.addAttribute("orderList", orderList);
				return "vipOrder";
			}	
//			提交订单，创建，清空
//			id,order_id,address_id
			
			@RequestMapping(method = RequestMethod.POST, value = "/vipOrder")
			public String vipOrder(Model model,
					@RequestParam List<Long> carId,
					@RequestParam Long addressId,
					@AuthenticationPrincipal(expression = "login") Login login) {
				vipService.createOrders(login.getId(),addressId, carId);
				vipService.delCom(carId);
				return "redirect:/vipOrder";
			}	
			
			
			//vip会员中心--订单详情
			@RequestMapping(method = RequestMethod.GET, value = "/vipXiaofei/{id}")
			public String vipXiaofeiPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login,
					@PathVariable Long id) {
				OrderItem order = vipService.findXiaofei(id);
				model.addAttribute("order", order);
				return "vipXiaofei";
			}
			
			
			//vip会员中心--个人信息   找到注入信息
			@RequestMapping(method = RequestMethod.GET, value = "/userinfo")
			public String vipPhone(
					@AuthenticationPrincipal(expression = "login") Login login, 
					Model model) {
				Vip flag = vipService.findVip(login.getId());
				if(flag!=null)
					model.addAttribute("vip", flag);
				return "vip";
			}
			
			
			//vip--个人信息     登录时获取到id，根据id显示出已有的vip详情，没有则插入数据
					@RequestMapping(method = RequestMethod.POST, value = "/userinfo")
					public  String VipPhone(
							@AuthenticationPrincipal(expression = "login") Login login, @ModelAttribute Vip vip) {
						
						vip.setId(login.getId());
						vipService.creatVip(vip);
							return "redirect:/userinfo";
							
						
					}
			
					//vip会员中心--收获地址管理    根据用户id查看该用户的收货地址
					@RequestMapping(method = RequestMethod.GET, value = "/vipAddress")
					public String vipAddressPhone(Model model,
							@AuthenticationPrincipal(expression = "login") Login login
							) {
						List<Address> addresses = vipService.findAddress(login.getId());
						model.addAttribute("address", addresses);
						
								return "‬vipAddress";
					}
					
					//vip会员中心--收获地址管理    判断？ 增加
					@RequestMapping(method = RequestMethod.POST, value = "/vipAddress")
					public String AddressCreat(@ModelAttribute Address address,
							@AuthenticationPrincipal(expression = "login") Login login
							) {
		
							
								address.setLogin(login);
								
								vipService.creatAddress(address);
						
						return "redirect:/vipAddress";
						
					}
					
				
					//修改
					
					//vip会员中心--收获地址管理  ：修改
					@RequestMapping(method = RequestMethod.GET, value = "/vipAddress/{id}")
					public String Edit(Model model,@PathVariable Long id,
							@AuthenticationPrincipal(expression = "login") Login login
							) {
						Address a= vipService.findOne(id);//地址id查找
						model.addAttribute("a", a);
//						查询地址集合，用form:select
						List<Address> provinces = vipService.findprovinces();
						model.addAttribute("provinces", provinces);
						
								return "add-edit";
					}
					
					//vip会员中心--收获地址管理    ：修改
					@RequestMapping(method = RequestMethod.POST, value = "/vipAddress/{id}")
					public String Edit(@ModelAttribute Address address,@PathVariable Long id,
							@AuthenticationPrincipal(expression = "login") Login login
							) {
							address.setId(id);
							vipService.updateAddress(address);//更新
						return "redirect:/vipAddress";
						
					}
					
					
					//密码修改
					@RequestMapping(method = RequestMethod.GET, value = "/vipPwd/{id}")
					public String Pwd(Model model,@AuthenticationPrincipal(expression="login") Login login) {
						return "vip-pwd";
					}
					
					
					@RequestMapping(method = RequestMethod.POST, value = "/vipPwd/{id}")
					public String PwdChange(@AuthenticationPrincipal(expression="login") Login login,
							@RequestParam String pwd1,@RequestParam String pwd2) {
						if(pwd1.equals(pwd2)){
							vipService.changePwd(pwd1,login.getId());
								return "redirect:/vipAddress";
							}else{
								
								return "vip-pwd";
							}
					}
					
					
					
			
			
			 //订单成功创建页
			@RequestMapping(method = RequestMethod.GET, value = "/success")
			public String successPhone(Model model) {
						return "success";
			}
			
			
					
		
					
			
	
}

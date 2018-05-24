package com.wf.control;


import java.io.Console;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;
import com.wf.service.UserService;


@Controller
public class UserControl {
	
	private UserService userService;
	
	@Autowired
	public UserControl(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(method = RequestMethod.GET, value = "/login")
//	                                        @RequestParam    获取前端传参                             false:不一定要有这个值
	public  String loginPhone(@RequestParam(required=false) String error) {
		if(error!=null){
			System.out.println("登录失败");
		}
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg")
	public  String regPhone() {
		return "reg";
	}
			
			
	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	public  String RegPhone(@ModelAttribute Reg reg) {
		System.out.println("333");
		//查看是否注册
		String msg= userService.register(reg);
		
		if(msg!=null && msg.equals("success")){
			//对象传参
			return "redirect:/login";
		}else{
			
			return "reg";
		}
	}
	

	//商品列表页
	@RequestMapping(method = RequestMethod.GET, value = "/prolist")
	public String prolistPhone(@ModelAttribute Reg reg,
			@AuthenticationPrincipal(expression = "login") Login login,Model model) {
		List<Commodity> commodity = userService.findCommodity();
		
		model.addAttribute("prolists", commodity);
		return "prolist";
	}
	//商品详情页
	@RequestMapping(method = RequestMethod.GET, value = "/buyinfo")
	public String buyPhone(@ModelAttribute Reg reg,@AuthenticationPrincipal(expression = "login") Login login,
			Model model,@ModelAttribute Commodity commodity) {
		/*Commodity goodDetails = userService.findDetails(commodity.getId());
		model.addAttribute("goodDetails", goodDetails);*/
		return "buyinfo";
	}
	
	
		
		
		//订单确认页
		@RequestMapping(method = RequestMethod.GET, value = "/order")
		public String orderPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
			List<Commodity> commodities= userService.findCommodity();
			model.addAttribute("commodities", commodities);
			return "order";
		}
		
}

package com.wf.control;


import java.io.Console;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wf.entity.Address;
import com.wf.entity.Login;
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
	public  String loginPhone(@ModelAttribute Reg reg,Model model,@RequestParam(required=false) String error) {
		model.addAttribute("reg", reg);
		if(error!=null){
			System.out.println("登录失败");
		}
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg")
	public  String regPhone(@ModelAttribute Reg reg,Model model) {
		return "reg";
	}
	//商品详情页
			@RequestMapping(method = RequestMethod.GET, value = "/buyinfo")
			public String buyPhone(@ModelAttribute Reg reg) {
				return "buyinfo";
			}
			
			
	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	public  String RegPhone(@ModelAttribute Reg reg) {
		//查看是否存在
		Reg flag = userService.findSearch(reg);
		if(flag==null){
			//对象传参
			userService.register(reg);
			return "redirect:/login";
		}else{
			return "reg";
		}
	}
	
		//vip会员中心--个人信息   找到注入信息
		@RequestMapping(method = RequestMethod.GET, value = "/userinfo")
		public String vipPhone(
				@AuthenticationPrincipal(expression = "login") Login login, 
				Model model) {
			Vip flag = userService.findVip(login.getId());
			if(flag!=null)
				model.addAttribute("vip", flag);
			return "vip";
		}
		
		
		//vip--个人信息     登录时获取到id，根据id显示出已有的vip详情，没有则插入数据
				@RequestMapping(method = RequestMethod.POST, value = "/userinfo")
				public  String VipPhone(
						@AuthenticationPrincipal(expression = "login") Login login, 
						@ModelAttribute Vip vip) {
					
					vip.setId(login.getId());
					userService.creatVip(vip);
						return "redirect:/userinfo";
						
					
				}
		
				//vip会员中心--收获地址管理    根据用户id查看该用户的收货地址
				@RequestMapping(method = RequestMethod.GET, value = "/vipAddress")
				public String vipAddressPhone(Model model,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
					
					// @AuthenticationPrincipal默认拿到的是principal(UserDetailsImpl)，所以需要.user获得实体User对象（来自dao层）
					List<Address> addresses = userService.findAddress(login.getId());
					model.addAttribute("address", addresses);
					
							return "‬vipAddress";
				}
				
				//vip会员中心--收获地址管理     增加
				@RequestMapping(method = RequestMethod.POST, value = "/vipAddress/create")
				public String AddressCreat(@ModelAttribute Address address,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
							address.setLogin(login);
//							address.setRegId(address.getLogin().getId());
							System.out.println("login+creat"+address.getLogin().getId());
							userService.creatAddress(address);
							return "redirect:/vipAddress";
				}
				
				//vip会员中心--收获地址管理    修改
				@RequestMapping(method = RequestMethod.POST, value = "/vipAddress/edit")
				public String AddressEdit(@ModelAttribute Address address,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
					address.setId(login.getId());
							userService.updateAddress(address);
							return "redirect:/vipAddress";
				}
				
				//购物车
				@RequestMapping(method = RequestMethod.GET, value = "/car/")
				public String carPhone(Model model) {
					return "car";
				}
				
				
	   //订单确认页
		@RequestMapping(method = RequestMethod.GET, value = "/order/")
		public String orderPhone(Model model) {
					return "order";
		}
		
		
		 //订单成功创建页
		@RequestMapping(method = RequestMethod.GET, value = "/success/")
		public String successPhone(Model model) {
					return "success";
		}
		
		
				
				
		//vip会员中心--订单详情
				@RequestMapping(method = RequestMethod.GET, value = "/vipXiaofei/")
				public String vipXiaofeiPhone(Model model) {
							return "vipXiaofei";
				}
				
				
		
}

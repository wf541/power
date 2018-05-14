package com.wf.control;


import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


	@RequestMapping(method = RequestMethod.GET, value = "/login/")
	public  String loginPhone(@ModelAttribute Reg reg,Model model) {
		model.addAttribute("reg", reg);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg/")
	public  String regPhone(@ModelAttribute Reg reg,Model model) {
		return "reg";
	}
	//商品详情页
			@RequestMapping(method = RequestMethod.GET, value = "/buyinfo/")
			public String buyPhone(@ModelAttribute Reg reg,Model model) {
				model.addAttribute("reg", reg);
				return "buyinfo";
			}
			
			
	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg/")
	public  String RegPhone(@ModelAttribute Reg reg) {
		//查看是否存在
		
		Reg flag = userService.findSearch(reg);
		
		if(flag==null){
			//对象传参
			userService.register(reg);
			return "login";
		}else{
			return "reg";
		}
	}
	
	
	//登录
		@RequestMapping(method = RequestMethod.POST, value = "/login/")
		public  String LoginPhone(@ModelAttribute Login login,Model model) {
			//查看是否存在   返回对象
			Login flag = userService.findSearch(login);
			model.addAttribute("reg", flag);
			if(flag==null){
				return "reg";
			}else{
				return "buyinfo";
			}
		}
		
		//vip会员中心--个人信息
		@RequestMapping(method = RequestMethod.GET, value = "/login/vip/{id}")
		public String vipPhone(@ModelAttribute Reg reg,Model model,@PathVariable Long id) {
					model.addAttribute("reg", reg);
					System.out.println(reg);
					return "vip";
		}
		
		
		//vip--个人信息     登录时获取到id，根据id显示出已有的vip详情，没有则插入数据
				@RequestMapping(method = RequestMethod.POST, value = "/login/vip/{id}")
				public  String VipPhone(@ModelAttribute Vip vip,@PathVariable Long id) {
					vip.setId(id);
					//查看是否存在   返回对象
					//不存在的情况下
					 /*userService.findSearch(reg)
					if(flag!=null){
						
					}*/
					userService.creatVip(vip);
						return "vip";
					
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
				
				
		//vip会员中心--收获地址管理
				@RequestMapping(method = RequestMethod.GET, value = "/vipAddress/")
				public String vipAddressPhone(Model model) {
							return "vipAddress";
				}
}

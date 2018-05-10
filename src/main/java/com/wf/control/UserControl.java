package com.wf.control;


import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wf.entity.Reg;
import com.wf.service.UserService;


@Controller
public class UserControl {
	
	private UserService userService;
	
	@Autowired
	public UserControl(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(method = RequestMethod.GET, value = "/login/")
	public  String loginPhone(Model model) {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reg/")
	public  String regPhone(Model model) {
		return "reg";
	}
	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg/")
	public  String RegPhone(@ModelAttribute Reg reg) {
		String userName = reg.getUserName();
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
		public  String LoginPhone(@ModelAttribute Reg reg) {
			//查看是否存在   返回对象
			Reg flag = userService.findSearch(reg);
			if(flag==null){
				return "reg";
			}else{
				return "buy";
			}
		}
		
		//
		@RequestMapping(method = RequestMethod.GET, value = "/buy/")
		public  String buyPhone(Model model) {
			return "buy";
		}
}

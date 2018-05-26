package com.wf.control;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public  String regPhone(@ModelAttribute Reg reg) {
		return "reg";
	}
			
			
	//注册
	@RequestMapping(method = RequestMethod.POST, value = "/reg")
	public  String RegPhone(@ModelAttribute Reg reg, 
			Model model,String pwd1) {

		if(!reg.getPassword().equals(pwd1)){
			model.addAttribute("error","密码不一致");
			return "reg";
		}
		else{
			//查看是否注册
			String msg= userService.register(reg);
			
			if(msg!=null && msg.equals("success")){
				//对象传参
				return "redirect:/login";
			}else{
				
				return "reg";
			}
			
		}
	}
	

	
	
	
	
		
		
		
		
}

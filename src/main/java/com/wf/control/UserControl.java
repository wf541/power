package com.wf.control;


import java.io.Console;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	//购物车
	@RequestMapping(method = RequestMethod.GET, value = "/car")
	public String carPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
		List<Address> addresses = userService.findAddress(login.getId());
		model.addAttribute("addresses", addresses);
		
		/*List<Commodity> commodities= userService.findCommodity();
		model.addAttribute("commodities", commodities);*/
		
		List<Car> car =userService.findAllCar(login.getId());
		model.addAttribute("car", car);
		return "car";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/del/{id}")
	public String carDel(@PathVariable Long id){
		userService.del(id);
		return "redirect:/car";
	}
	@RequestMapping(method=RequestMethod.GET,value="/add/{id}")
	public String carInsert(@PathVariable Long id,@AuthenticationPrincipal(expression = "login") Login login){
		userService.addCar(id,login.getId());
		return "redirect:/car";
	}
	//购物车加减
		@RequestMapping(method = RequestMethod.POST, value = "/car")
		@ResponseBody
		public Car car(Model model,@AuthenticationPrincipal(expression = "login") Login login,@RequestBody Car car) {
			userService.addCount(car.getId());
			return userService.findOneCar(car.getId());
		}
		
		@RequestMapping(method = RequestMethod.POST, value = "/jiancar")
		@ResponseBody
		public Car carA(Model model,@AuthenticationPrincipal(expression = "login") Login login,@RequestBody Car car) {
			userService.jianCount(car.getId());
			return userService.findOneCar(car.getId());
		}
		
		
		
		//vip会员中心--订单列表   通过用户id，收货地址id,显示订单
		@RequestMapping(method = RequestMethod.GET, value = "/vipOrder")
		public String vipOrderPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
			
			List<Order> orderList= userService.findVipOrder(login.getId());
			model.addAttribute("orderList", orderList);
			System.out.println(orderList);
			return "vipOrder";
		}	
//		提交订单，创建，清空
//		id,order_id,address_id
		@RequestMapping(method = RequestMethod.POST, value = "/vipOrder")
		public String vipOrder(Model model,
				@RequestParam List<Long> orderId,
				@RequestParam Long addressId,
				@AuthenticationPrincipal(expression = "login") Login login) {
			
			userService.createOrder(addressId,orderId);
			
			
//			userService.delCom(commodityId);
			return "redirect:/vipOrder";
		}	
		
		
		//vip会员中心--订单详情
		@RequestMapping(method = RequestMethod.GET, value = "/vipXiaofei/{id}")
		public String vipXiaofeiPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login,
				@PathVariable Long id) {
			Order order = userService.findXiaofei(id);
			model.addAttribute("order", order);
			System.out.println("详情："+order);
			return "vipXiaofei";
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
						@AuthenticationPrincipal(expression = "login") Login login, @ModelAttribute Vip vip) {
					
					vip.setId(login.getId());
					userService.creatVip(vip);
						return "redirect:/userinfo";
						
					
				}
		
				//vip会员中心--收获地址管理    根据用户id查看该用户的收货地址
				@RequestMapping(method = RequestMethod.GET, value = "/vipAddress")
				public String vipAddressPhone(Model model,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
					List<Address> addresses = userService.findAddress(login.getId());
					model.addAttribute("address", addresses);
					
							return "‬vipAddress";
				}
				
				//vip会员中心--收获地址管理    判断？ 增加
				@RequestMapping(method = RequestMethod.POST, value = "/vipAddress")
				public String AddressCreat(@ModelAttribute Address address,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
	
						
							address.setLogin(login);
							
							userService.creatAddress(address);
					
					return "redirect:/vipAddress";
					
				}
				
			
				//修改
				
				//vip会员中心--收获地址管理  ：修改
				@RequestMapping(method = RequestMethod.GET, value = "/vipAddress/{id}")
				public String Edit(Model model,@PathVariable Long id,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
					Address a= userService.findOne(id);//地址id查找
					model.addAttribute("a", a);
//					查询地址集合，用form:select
					List<Address> provinces = userService.findprovinces();
					model.addAttribute("provinces", provinces);
					
							return "add-edit";
				}
				
				//vip会员中心--收获地址管理    ：修改
				@RequestMapping(method = RequestMethod.POST, value = "/vipAddress/{id}")
				public String Edit(@ModelAttribute Address address,@PathVariable Long id,
						@AuthenticationPrincipal(expression = "login") Login login
						) {
						address.setId(id);
						userService.updateAddress(address);//更新
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
							userService.changePwd(pwd1,login.getId());
							return "redirect:/vipAddress/{id}";
						}else{
							
							return "vip-pwd";
						}
				}
				
				
				
		
		
		 //订单成功创建页
		@RequestMapping(method = RequestMethod.GET, value = "/success")
		public String successPhone(Model model) {
					return "success";
		}
		
		
				
				
		//订单确认页
		@RequestMapping(method = RequestMethod.GET, value = "/order")
		public String orderPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
			List<Commodity> commodities= userService.findCommodity();
			model.addAttribute("commodities", commodities);
			return "order";
		}
				
		
}

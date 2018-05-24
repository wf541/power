package com.wf.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Login;
import com.wf.service.CarService;
import com.wf.service.VipService;

@Controller
public class CarControl {
	private VipService vipService;
	private CarService carService;
	
	@Autowired
	
	public CarControl(VipService vipService, CarService carService) {
		super();
		this.vipService = vipService;
		this.carService = carService;
	}

	//购物车
		@RequestMapping(method = RequestMethod.GET, value = "/car")
		public String carPhone(Model model,@AuthenticationPrincipal(expression = "login") Login login) {
			List<Address> addresses = vipService.findAddress(login.getId());
			model.addAttribute("addresses", addresses);
			
			/*List<Commodity> commodities= userService.findCommodity();
			model.addAttribute("commodities", commodities);*/
			
			List<Car> car =carService.findAllCar(login.getId());
			model.addAttribute("car", car);
			return "car";
		}
		
		@RequestMapping(method=RequestMethod.GET,value="/del/{id}")
		public String carDel(@PathVariable Long id){
			carService.del(id);
			return "redirect:/car";
		}
		@RequestMapping(method=RequestMethod.GET,value="/add/{id}")
		public String carInsert(@PathVariable Long id,@AuthenticationPrincipal(expression = "login") Login login){
			carService.addCar(id,login.getId());
			return "redirect:/car";
		}
		//购物车加减
			@RequestMapping(method = RequestMethod.POST, value = "/car")
			@ResponseBody
			public Car car(Model model,@AuthenticationPrincipal(expression = "login") Login login,@RequestBody Car car) {
				carService.addCount(car.getId());
				return carService.findOneCar(car.getId());
			}
			
			@RequestMapping(method = RequestMethod.POST, value = "/jiancar")
			@ResponseBody
			public Car carA(Model model,@AuthenticationPrincipal(expression = "login") Login login,@RequestBody Car car) {
				carService.jianCount(car.getId());
				return carService.findOneCar(car.getId());
			}
			
}

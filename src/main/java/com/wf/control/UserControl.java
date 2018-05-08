package com.wf.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserControl {
	@RequestMapping(method = RequestMethod.GET, value = "/login/")
	public  String findAll(Model model) {
		return "login";
	}
}

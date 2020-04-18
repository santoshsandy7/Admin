package com.ors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.dao.LoginDao;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {
	@Autowired
	public LoginDao loginDao;
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return ("LoginPage");
	}
	@RequestMapping(value = "/validate")
	public ModelAndView validateLogin(@RequestParam String loginId,@RequestParam String loginPwd,ModelAndView model) {
		
		boolean validate =loginDao.validateLogin(loginId, loginPwd);
		if(validate) {
			model.setViewName("redirect:/admin/homePage");
		}else {
			model.setViewName("redirect:/admin/login");
		}
		return model;
		
	}

}

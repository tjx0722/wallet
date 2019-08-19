package com.woniu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.domain.User;
import com.woniu.service.IUserService;

@Controller
@RequestMapping("/authorityModule")
public class LoginController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login")
	private String login(User user) {
		User loginUser = userService.login(user);
		System.out.println(loginUser);
		if (loginUser==null) {
			return "/authorityModule/login";
		}else {
			return "redirect:/index.jsp";
		}
	}
}





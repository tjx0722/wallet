package com.woniu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.domain.User;
import com.woniu.service.IUserService;

@Controller
@RequestMapping("/authorityModule")
public class UserController {

	@Resource
	private IUserService service;
	
	@RequestMapping("save")
	public String save(User user) {
		service.save(user);
		return "index";
	}
	
}

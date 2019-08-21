package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.domain.User;
import com.woniu.service.ITreeService;
import com.woniu.service.IUserService;

@Controller
@RequestMapping("/authorityModule")
public class LoginController {
	@Resource
	private IUserService userService;
	@Resource
	private ITreeService treeService;
	
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
	
	@RequestMapping("/adminlogin")
	private String adminlogin(User user,HttpSession session) throws JsonProcessingException {
		user = userService.login(user);
		System.out.println(user);
		if (user==null) {
			return "/authorityModule/GLYlogin";
		}else {
			List trees = treeService.findAll();
			ObjectMapper mapper =  new ObjectMapper();
			String json = mapper.writeValueAsString(user.getTrees());
			session.setAttribute("user", user);
			session.setAttribute("json", json);
			return "redirect:houtai/index.jsp";
		}
	}
}





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
	private String login(User user,HttpSession session) {
		User LoginUser = userService.login(user);
		System.out.println(LoginUser);
		if (LoginUser==null) {
			return "/authorityModule/login";
		}else {
			session.setAttribute("user", LoginUser);
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping("/adminlogin")
	private String adminlogin(User user,HttpSession session) throws JsonProcessingException {
		User LoginUser  = userService.login(user);
		System.out.println(LoginUser);
		if (LoginUser==null) {
			return "/authorityModule/GLYlogin";
		}else {
			List trees = treeService.findAll();
			ObjectMapper mapper =  new ObjectMapper();
			String json = mapper.writeValueAsString(LoginUser.getTrees());
			session.setAttribute("user", LoginUser);
			session.setAttribute("json", json);
			return "redirect:houtai/index.jsp";
		}
	}
}





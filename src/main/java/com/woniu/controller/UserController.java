package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.woniu.domain.PageBean;
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
	
	@RequestMapping("findAll")
	public String findAll(PageBean pb,ModelMap map) {
		List list = service.findAll(pb);
		map.put("list", list);
		map.put("page", pb);
//		map.put("user", user);
		
		return "authorityModule/houtai/userlist";
	}
	
	@RequestMapping("test")
	public String test(PageBean pb,ModelMap map) {
		List list = service.findAll(pb);
		map.put("list", list);
		map.put("page", pb);
//		map.put("user", user);
		
		return "authorityModule/houtai/userlist";
	}
	
}

package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.domain.User;
import com.woniu.service.IUserService;

@Controller
@RequestMapping("/authorityModule")
public class UserController {

	@Resource
	private IUserService service;
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@RequestMapping("save")
	public String save(User user,String phone,String number) {
		
		
		System.out.println("=====2"+redisTemplate);
		String redisNumber = redisTemplate.opsForValue().get(phone);
		System.out.println(phone+"  "+number+" "+redisNumber);
		redisTemplate.opsForValue().set(phone, null);
		System.out.println(phone+"  "+number+" "+redisNumber);
		if(redisNumber!=null&&number!=null&&number.equals(redisNumber)) {
			System.out.println("开始插入数据库，证明这个手机就是你的");
			service.save(user);
			return "index";
		}else {
			return "index";
		}
		
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
	
	@RequestMapping("findByUserid")
	public String findByUserid(ModelMap map,HttpSession session) {
//		User user = service.findByUserid(userid);
		User user = (User) session.getAttribute("user");
		//int userid = user.getUserid();
		map.put("user", user);
	
		System.out.println("personal");
		return "authorityModule/houtai/personal";
	}
	
	@RequestMapping("updateUser")
	public String updateUser(User user) {
		System.out.println(user+"+++++");
		service.update(user);
		System.out.println("update");
		return "authorityModule/houtai/personal";
	}
	
	@RequestMapping("editPage")
	public String editPage(Integer userid,HttpSession session,ModelMap map) {
		//User user = (User) session.getAttribute("user");
		User user = service.findByUserid(userid);
		System.out.println(user+".....");
		map.put("user", user);
		return "authorityModule/houtai/editUser"; 
	}
}

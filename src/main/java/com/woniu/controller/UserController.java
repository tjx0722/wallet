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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.woniu.domain.Bankcard;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.domain.User;
import com.woniu.service.IUserService;
import com.woniu.service.IUserinfoService;
import com.woniu.service.IRoleService;
@Controller
@RequestMapping("/authorityModule")
public class UserController {

	@Resource
	private IUserService service;
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Resource
	private IRoleService roleservice;
	
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
	@RequestMapping("adminfindAll")
	public String adminfindAll(PageBean pb,ModelMap map) {
		List list = service.findAll(pb);
		map.put("list", list);
		map.put("page", pb);
//		map.put("user", user);
		return "authorityModule/admin/userlist";
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
	@RequestMapping("findUserinfoByUserid")
	public String findUserinfoByUserid(ModelMap map,Integer userid) {
		System.out.println(userid);
		Userinfo userinfo=service.findUserinfoByUserid(userid);
		System.out.println(userinfo.toString());
		map.put("userinfo",userinfo);
		return null;
	}
	@RequestMapping("delete")
	public @ResponseBody Map delete(Integer userid,PageBean pb) {
		service.delete(userid);
		Map map = new HashMap();
		List list = service.findAll(pb);
		map.put("list", list);
		map.put("page", pb);
//		map.put("user", user);
		return map;
	}
	@RequestMapping("revoke")
	public String revoke(Integer userid) {
		service.revoke(userid);
		return "redirect:houtai/userlistVue.jsp";
	}
	@RequestMapping("goupdate/{userid}")
	public String goupdate(@PathVariable Integer userid,ModelMap map) {
//		ModelAndView mav = new ModelAndView("authorityModule/admin/updatePage");
		User user = service.findByUserid(userid);
		List roles = roleservice.findAll();
		map.put("user",user);
		map.put("roles",roles);
		return "authorityModule/admin/updatePage";
	}
	@RequestMapping("updateAuthority")
	public String updateAuthority(Integer[] chk,User user) {
		service.updateAuthority(user, chk);
		return "authorityModule/admin/updatePage";
	}
	
	@RequestMapping("findJson")
	public @ResponseBody Map findJson(PageBean pb) {
		Map map = new HashMap();
		List list = service.findAll(pb);
		map.put("list", list);
		map.put("page", pb);
//		map.put("user", user);
		return map;
	}
	
}

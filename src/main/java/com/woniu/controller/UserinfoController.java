package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.domain.Message;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.service.IUserinfoService;

@Controller
@RequestMapping("userinfo")
public class UserinfoController {
   @Resource
   private IUserinfoService userinfoServiceImpl;
   
   @RequestMapping("findAll")
   public @ResponseBody Map findAll(PageBean pageBean) {
	   List rows=userinfoServiceImpl.findAll(pageBean);
	   Map map=new HashMap();
	   map.put("total",pageBean.getCount());
	   map.put("rows",rows);
	   return map;
   }
   @RequestMapping("save")
	public @ResponseBody Message save(Userinfo userinfo) {
		Message msg = null;
	
		try {
			
			userinfoServiceImpl.save(userinfo);
			msg = new Message(true, "用户详细信息增加成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "用户详细信息增加失败"+e.getMessage());
		}
		return msg;
	}
   @RequestMapping("findById")
	public @ResponseBody Userinfo findById(Integer userinfoid) {
	   Userinfo userinfo = userinfoServiceImpl.findById(userinfoid);
		return userinfo;
	}
	@RequestMapping("delete")
	public @ResponseBody Message delete(Integer userinfoid) {
		Message msg = null;
		try {
			int  count = userinfoServiceImpl.delete(userinfoid);
			msg = new Message(true, "客户信息删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "客户信息删除失败"+e.getMessage());
		}
		return msg;
	}
	@RequestMapping("deleteBatch")
	public @ResponseBody Message deleteBatch(String userinfoidstring) {// 1,2,3
		Message msg = null;
		try {
			String[] tempStrings = userinfoidstring.split(",");
			Integer[] userinfoids = new Integer[tempStrings.length];
			for (int i = 0; i < tempStrings.length; i++) {
				userinfoids[i] = Integer.parseInt(tempStrings[i]);
			}
			userinfoServiceImpl.deleteBatch(userinfoids);
			msg = new Message(true, "用户详细信息批量删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "用户详细信息批量删除失败"+e.getMessage());
		}
		return msg;
	}
	@RequestMapping("update")
	public @ResponseBody Message update(Userinfo userinfo) {
		Message msg = null;
		try {
			userinfoServiceImpl.update(userinfo);
			msg = new Message(true, "用户详细信息修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "用户详细信息修改失败"+e.getMessage());
		}
		return msg;
	}
}

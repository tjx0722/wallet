package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.domain.PageBean;
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
}

package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.service.IDebttransferapplyService;
import com.woniu.domain.PageBean;

@RestController
@RequestMapping("/debttransferapply")
public class DebttransferapplyController {
	@Resource
	private IDebttransferapplyService debttransferapplyServiceImpl;
	
	@RequestMapping("/findAll")
	public Map findAll(PageBean pageBean) {
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAll();
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
}

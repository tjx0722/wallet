package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.domain.PageBean;
import com.woniu.service.IDebttransferdisplayService;

@RestController
@RequestMapping("/debttransferdispaly")
public class DebttransferdispalyController {
	@Resource
	private IDebttransferdisplayService debttransferdisplayServiceImpl;
	
	@RequestMapping("/findAll")
	public Map findAll(PageBean pageBean) {
		Map map=new HashMap();
		List rows=debttransferdisplayServiceImpl.findAll();
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
}

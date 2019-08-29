package com.woniu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.domain.Loanapply;
import com.woniu.domain.PageBean;
import com.woniu.service.IDebitService;
import com.woniu.service.IUserinfoService;

@Controller
@RequestMapping("/Loandisplay")
public class LoandisplayController {
	
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@Resource
	private IDebitService debitServiceImpl; 
	
	@RequestMapping("findAllLoanapply")
	private @ResponseBody Map  findAllLoanapply(PageBean pageBean){
		
		List<Loanapply> rows = debitServiceImpl.findAllLoanapply(pageBean);
		Map map = new HashMap();
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	@RequestMapping("findAllCount")
	private String   findAllCount(PageBean pageBean){
		List list=new ArrayList();
		Map map = new HashMap();
		map.put("借款次数", list);
		return null;
	}
}

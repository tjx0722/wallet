package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.domain.Loanapply;
import com.woniu.service.IDebitService;
import com.woniu.service.IUserinfoService;

@Controller
@RequestMapping("/Loandisplay")
public class LoandisplayController {
	
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@Resource
	private IDebitService debitServiceImpl; 
	@ResponseBody
	@RequestMapping("findAllLoanapply")
	private List<Loanapply> findAllLoanapply(ModelMap map){
		List<Loanapply> list = debitServiceImpl.findAllLoanapply();
		map.put("list", list);
		return list;
	}
}

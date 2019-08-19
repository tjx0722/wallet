package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.domain.Loantime;
import com.woniu.service.IDebitService;
@RequestMapping("/Debit/")
@Controller
public class DebitController {
	@Resource
	private IDebitService debitServiceImpl;
	
	@RequestMapping("findAllLoantime")
	private String findAllLoantime(ModelMap map) {
		List<Loantime> list = debitServiceImpl.findAllLoantime();
		map.put("list", list);
		return null;
	}
}

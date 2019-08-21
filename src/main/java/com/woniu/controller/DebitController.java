package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.domain.Loanapply;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.service.IDebitService;
@RequestMapping("/debit/")
@Controller
public class DebitController {
	@Resource
	private IDebitService debitServiceImpl;
	
	
	@RequestMapping("findAllLoantime")
	private String findAllLoantime(ModelMap map) {
		List<Loantime> Loantimes = debitServiceImpl.findAllLoantime();
		map.put("Loantimes", Loantimes);
		return "forward:findAllLoanrate";
	}
	@RequestMapping("findAllLoanrate")
	private String findAllLoanrate(ModelMap map) {
		List<Loanrate> loanrates = debitServiceImpl.findAllLoanrate();
		map.put("loanrates", loanrates);
		return "/debit/loanapply";
	}
	@RequestMapping("test")
	private String test(Loanapply loanapply) {
		System.out.println("DebitController.test()");
		System.out.println(loanapply.toString());
		return null;
	}
}

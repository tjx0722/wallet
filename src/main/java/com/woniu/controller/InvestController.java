package com.woniu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.domain.Loanapply;
import com.woniu.domain.Loandisplay;
import com.woniu.service.IInvestService;

@RestController
@RequestMapping("/invest/")
public class InvestController {
	@Resource
	private IInvestService investServiceImpl;
	
	@RequestMapping("findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplay() {
		List<Loandisplay> list = investServiceImpl.findAllLoadDisplay();
		Loandisplay apply=list.get(0);
		System.out.println(apply+" "+apply.getLoanapply().getLoanrate().getLoanrate());
		return investServiceImpl.findAllLoadDisplay();
	}

}

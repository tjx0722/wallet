package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.service.impl.DebtInvestServiceImpl;
@RestController
@RequestMapping("/debtinvest")
public class DebtInvestController {
	@Resource
	private DebtInvestServiceImpl debtInvestServiceImpl;
	@RequestMapping("findUndead")
	public List findUndead() {
		return debtInvestServiceImpl.findUndead();
		
	}
	
}

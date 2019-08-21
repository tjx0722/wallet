package com.woniu.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.domain.Loanapply;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.domain.Servicecharge;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.IDebitService;
import com.woniu.service.IServicechargeService;
@RequestMapping("/debit/")
@Controller
public class DebitController {
	@Resource
	private IDebitService debitServiceImpl;
	
	@Resource
	private IServicechargeService servicechargeServiceImpl;
	
	@RequestMapping("findAllLoantimeAndLoanrate")
	private String findAllLoantimeAndLoanrate(ModelMap map) {
		List<Loantime> Loantimes = debitServiceImpl.findAllLoantime();
		map.put("Loantimes", Loantimes);
		List<Loanrate> loanrates = debitServiceImpl.findAllLoanrate();
		map.put("loanrates", loanrates);
		return "/debit/loanapply";
	}
	@RequestMapping("test1")
	private String test1(Userinfo userinfo,HttpSession session) {
		System.out.println(userinfo.toString());
		session.setAttribute("userinfo", userinfo);
		return "forward:findAllLoantimeAndLoanrate";
	}
	@RequestMapping("test")
	private String test(Loanapply loanapply,HttpSession session) {
		loanapply.setUserinfoid(((Userinfo) session.getAttribute("userinfo")).getUserinfoid());
		loanapply.setApplytime(new Date());
		loanapply.setChecked(false);
		loanapply.setServicechargeid(1);
		Servicecharge servicecharge = servicechargeServiceImpl.findByServicechargeid(loanapply.getServicechargeid());
		Double chargerate = servicecharge.getChargerate();
		loanapply.setServicecharge(loanapply.getLoanamount()*chargerate);
		System.out.println(loanapply.toString());
		return null;
	}
}

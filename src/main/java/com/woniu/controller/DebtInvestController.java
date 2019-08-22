package com.woniu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.Repay;
import com.woniu.service.IDebtInvestService;
import com.woniu.service.IRepayService;
@Controller
@RequestMapping("/debtinvest")
public class DebtInvestController {
	@Resource
	private IDebtInvestService debtInvestServiceImpl;
	
	@Resource
	private IRepayService repayServiceImpl;
	
	@RequestMapping("findUndead")
	@ResponseBody
	public List findUndead() {
		return debtInvestServiceImpl.findUndead();
		
	}
	@RequestMapping("findById")
	public String  findUndead(Integer debttransferdisplay,ModelMap map) {
		Debttransferdisplay debttransfer = debtInvestServiceImpl.findById(debttransferdisplay);
		List<Repay> repays = repayServiceImpl.findByUser(debttransfer.getLoanapply().getUserinfo().getUserinfoid());
		map.put("invest", debttransfer.getInvest());
		map.put("loanapply", debttransfer.getLoanapply());
		map.put("loantime", debttransfer.getLoanapply().getLoantime());
		map.put("loanrate", debttransfer.getLoanapply().getLoanrate());
		map.put("userinfo", debttransfer.getLoanapply().getUserinfo());
		map.put("loandispaly",debttransfer.getInvest().getLoandisplay());
		map.put("repays", repays);
		System.out.println("DebtInvestController.findUndead()");
		return "/debtinvest/debtinfo";
		
	}
	
}

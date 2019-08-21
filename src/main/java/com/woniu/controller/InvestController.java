package com.woniu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		return investServiceImpl.findAllLoadDisplay();
	}
	
	@RequestMapping("findLoandisplayById/{loandisplayid}")
	public ModelAndView findLoandisplayById(@PathVariable Integer loandisplayid) {
		Loandisplay loandisplay=investServiceImpl.findLoandisplayById(loandisplayid);
		ModelAndView mav=new ModelAndView("invest/info");
		mav.addObject("loandisplay", loandisplay);
		return mav;
	}
	
	@RequestMapping("purchase")
	public ModelAndView purchase(Integer loandisplayid,Double investamount) {
		System.out.println(loandisplayid+" "+investamount);
		return null;
	}

}

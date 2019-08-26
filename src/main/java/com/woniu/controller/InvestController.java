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
import com.woniu.domain.PageBean;
import com.woniu.service.IInvestService;

@RestController
@RequestMapping("/invest/")
public class InvestController {
	@Resource
	private IInvestService investServiceImpl;
	
	@RequestMapping("findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplay(PageBean pb) {
		return investServiceImpl.findAllLoadDisplay(pb);
	}
	
	@RequestMapping("findLoandisplayById/{loandisplayid}")
	public ModelAndView findLoandisplayById(@PathVariable Integer loandisplayid) {
		Loandisplay loandisplay=investServiceImpl.findLoandisplayById(loandisplayid);
		ModelAndView mav=new ModelAndView("invest/info");
		mav.addObject("loandisplay", loandisplay);
		return mav;
	}
	
	@RequestMapping("purchase/{investamount}!{loandisplayid}")
	public ModelAndView purchase(@PathVariable Integer loandisplayid,@PathVariable Double investamount) {
		ModelAndView mav=new ModelAndView("invest/paypage");
		mav.addObject("investamount", investamount);
		mav.addObject("loandisplayid", loandisplayid);
		return mav;
	}
	
	@RequestMapping("pay")
	public ModelAndView pay(Integer loandisplayid,Double investamount,String payPassword_rsainput) {
		System.out.println(loandisplayid+" "+investamount+" "+payPassword_rsainput);
		ModelAndView mav=new ModelAndView("invest/back");
		mav.addObject("investamount", investamount);
		mav.addObject("loandisplayid", loandisplayid);
		return mav;
	}
	
	//admin
	@RequestMapping("admin/findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb) {
		return investServiceImpl.findAllLoanDisplayByadmin(pb);
	}
	
	@RequestMapping("admin/findLoandisplayById/{loandisplayid}")
	public ModelAndView findLoandisplayByAdmin(@PathVariable Integer loandisplayid) {
		Loandisplay loandisplay=investServiceImpl.findLoandisplayById(loandisplayid);
		ModelAndView mav=new ModelAndView("invest/admin/info");
		mav.addObject("loandisplay", loandisplay);
		return mav;
	}

}

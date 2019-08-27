package com.woniu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.domain.Loanapply;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.ILoanApplyService;

@RequestMapping("/repayment/")
@RestController
public class RepaymentController {
	@Resource
	private ILoanApplyService loanApplyServiceImpl;
	
	@RequestMapping("findRepaymentWithUser")
	public ModelAndView findRepaymentWithUser(HttpSession session) throws JsonProcessingException {
		ModelAndView mav=new ModelAndView("repayment/index");
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = user.getUserinfo();
		List<Loanapply> list = loanApplyServiceImpl.findByUser(userinfo.getUserinfoid());
		ObjectMapper om=new ObjectMapper();
		String json = om.writeValueAsString(list);
//		System.out.println(list.);
		mav.addObject("list",list);
		mav.addObject("json",json);
		return mav;
	}

	@RequestMapping("test1")
	public String test1(HttpSession session, ModelMap map) {
		return null;
	}
}

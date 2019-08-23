package com.woniu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.domain.Loanapply;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.domain.Servicecharge;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.IDebitService;
import com.woniu.service.IServicechargeService;
import com.woniu.service.IUserinfoService;
@RequestMapping("/debit/")
@Controller
public class DebitController {
	@Resource
	private IDebitService debitServiceImpl;
	
	@Resource
	private IServicechargeService servicechargeServiceImpl;
	
	@Resource
	private IUserinfoService UserinfoServiceImpl;
	
	@RequestMapping("findAllLoantimeAndLoanrate")
	public String findAllLoantimeAndLoanrate(ModelMap map,HttpSession session) {
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			Userinfo userinfo = user.getUserinfo();
			List<Loantime> Loantimes = debitServiceImpl.findAllLoantime();
			List<Loanrate> loanrates = debitServiceImpl.findAllLoanrate();
			map.put("Loantimes", Loantimes);
			map.put("loanrates", loanrates);
			map.put("userinfo", userinfo);
			return "/debit/loanapply";
		}else {
			return "/unauthorized";
		}
		
	}
	@RequestMapping("test1")
	public String test1(Userinfo userinfo,HttpSession session) {
		System.out.println(userinfo.toString());
		session.setAttribute("userinfo", userinfo);
		return "redirect:findAllLoantimeAndLoanrate";
	}
	@RequestMapping("findLoanapplybyLoanapplyid")
	public String findLoanapplybyLoanapplyid(int loanapplyid) {
		Loanapply loanapply = debitServiceImpl.findLoanapplybyLoanapplyid(loanapplyid);
		if(loanapply.getChecked()) {
			loanapply.setChecked(false);
		}else {
			loanapply.setChecked(true);
		}
		debitServiceImpl.update(loanapply);
		return "redirect:/loandisplay/index.jsp";
	}
	
	@RequestMapping("excessive")
	public  ModelAndView excessive(Loanapply loanapply,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = user.getUserinfo();
		loanapply.setUserinfoid(userinfo.getUserinfoid());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String datetime = sdf.format(date);
		loanapply.setApplytime(date);
		loanapply.setChecked(false);
		loanapply.setServicechargeid(1);
		Integer loantime = debitServiceImpl.findLoantimeByLoantimeid(loanapply.getLoantimeid()).getLoantime();
		 DecimalFormat df = new DecimalFormat("#.00");
		//手续费
		Servicecharge servicecharge =servicechargeServiceImpl.findByServicechargeid(loanapply.getServicechargeid());
		Double chargerate = servicecharge.getChargerate();
		 Double serviceMoney = Double.parseDouble(df.format(loanapply.getLoanamount()*chargerate));
		 loanapply.setServicecharge(serviceMoney);
//		String username = UserinfoServiceImpl.findById(loanapply.getUserinfoid()).getUsername();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/debit/verify");
		mav.addObject("loanapply", loanapply);
		mav.addObject("userinfo", userinfo);
		mav.addObject("datetime", datetime);
		mav.addObject("loantime", loantime);
		return mav;
	}
	
}	

package com.woniu.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.domain.Invest;
import com.woniu.domain.Loanapply;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.service.IInvestService;

@RestController
@RequestMapping("/invest/")
public class InvestController {
	@Resource
	private IInvestService investServiceImpl;
	
	@RequestMapping("findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplay(PageBean pb,String sort,String order) {
		if(sort!=null&&order!=null) {
			return investServiceImpl.findAllLoadDisplay(pb,sort,order);
		}
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
	public ModelAndView purchase(@PathVariable Integer loandisplayid,@PathVariable Double investamount,HttpSession session) {
		Integer rest=(Integer) session.getAttribute("rest");
		if(rest!=null&&rest==0) {
			ModelAndView mav=new ModelAndView("invest/payfailed");
			mav.addObject("msg", "您的账户已被锁定，24小时内不能支付");
			return mav;
		}
		ModelAndView mav=new ModelAndView("invest/paypage");
		mav.addObject("investamount", investamount);
		mav.addObject("loandisplayid", loandisplayid);
		
		return mav;
	}
	
	@RequestMapping("pay")
	public ModelAndView pay(Integer loandisplayid,Double investamount,String payPassword_rsainput,HttpSession session) {
		User user=(User) session.getAttribute("user");
		String applypass = user.getUserinfo().getApplypass();
		if(applypass.equals(payPassword_rsainput)) {
			session.removeAttribute("rest");
			ModelAndView mav=new ModelAndView("invest/back");
			Invest invest=new Invest();
			invest.setUserinfoid(user.getUserinfo().getUserinfoid());
			invest.setInvestamount(investamount);
			invest.setPaytime(new Date());
			invest.setLoandisplayid(loandisplayid);
			invest.setIstransfer(false);
			invest.setServicecharge(investamount*0.005);
			invest.setServicechargeid(4);
			investServiceImpl.insert(invest);
			return mav;
		}else {
			ModelAndView mav=new ModelAndView("invest/payfailed");
			mav.addObject("investamount", investamount);
			mav.addObject("loandisplayid", loandisplayid);
			Integer rest = (Integer) session.getAttribute("rest");
			if(rest==null) {
				rest=2;
				session.setAttribute("rest", rest);
			}else {
				if(rest>0) {
					rest--;
					session.setAttribute("rest", rest);
				}else {
					session.removeAttribute("rest");
				}
			}
			mav.addObject("msg", "支付密码错误，您还有   "+rest+"次机会");
			return mav;
		}
		
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

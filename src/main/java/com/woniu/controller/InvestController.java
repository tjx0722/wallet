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
import com.woniu.domain.Userinfo;
import com.woniu.service.IInvestService;
import com.woniu.service.IUserinfoService;

@RestController
@RequestMapping("/invest/")
public class InvestController {
	@Resource
	private IInvestService investServiceImpl;
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@RequestMapping("findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplay(PageBean pb,HttpSession session) {
		String name = (String) session.getAttribute("name");
		String value = (String) session.getAttribute("value");
		if(name!=null) {
			return investServiceImpl.findAllLoadDisplay(pb,name,value);
		}
		return investServiceImpl.findAllLoadDisplay(pb);
	}
	
	@RequestMapping("findInvested")
	public List<Invest> findInvested(HttpSession session,PageBean pb,String sort,String order) {
		User user=(User) session.getAttribute("user");
		Integer userinfoid = user.getUserinfo().getUserinfoid();
		if(sort!=null&&order!=null) {
			return investServiceImpl.findAllLoadDisplay(userinfoid,pb,sort,order);
		}
		return investServiceImpl.findInvested(userinfoid,pb);
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
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = userinfoServiceImpl.findById(user.getUserinfo().getUserinfoid());
		Integer chance = userinfo.getChance();
		if(chance==0) {
			ModelAndView mav=new ModelAndView("invest/payfailed");
			mav.addObject("msg", "您的账户已被锁定，24小时内不能支付");
			mav.addObject("chance", chance);
			return mav;
		}
		ModelAndView mav=new ModelAndView("invest/paypage");
		mav.addObject("investamount", investamount);
		mav.addObject("loandisplayid", loandisplayid);
		
		return mav;
	}
	
	@RequestMapping("pay")
	public ModelAndView pay(Integer loandisplayid,Double investamount,String payPassword_rsainput,HttpSession session) {
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = userinfoServiceImpl.findById(user.getUserinfo().getUserinfoid());
		Integer chance = userinfo.getChance();
		String applypass = user.getUserinfo().getApplypass();
		if(applypass.equals(payPassword_rsainput)) {
			//输入密码正确之后，重置密码输错机会为3，入库。
			userinfo.setChance(3);
			userinfoServiceImpl.update(userinfo);
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
			//输错密码之后，机会减一，入库。
			chance--;
			userinfo.setChance(chance);
			userinfoServiceImpl.update(userinfo);
			
			if(chance==0) {
				ModelAndView mav=new ModelAndView("invest/payfailed");
				mav.addObject("chance", chance);
				mav.addObject("msg", "您的账户已被锁定，24小时内不能支付");
				return mav;
			}
			ModelAndView mav=new ModelAndView("invest/payfailed");
			mav.addObject("chance", chance);
			mav.addObject("investamount", investamount);
			mav.addObject("loandisplayid", loandisplayid);
			mav.addObject("msg", "支付密码错误，您还有   "+chance+"次机会");
			return mav;
		}
	}
	
	//此controller用来设置筛选条件
	@RequestMapping("setselect/{name}!{value}")
	public ModelAndView setselectCondition(@PathVariable String name,@PathVariable String value,HttpSession session) {
		if(name==null) {
			session.removeAttribute("name");
		}else {
			session.setAttribute("name", name);
			session.setAttribute("value", value);
		}
		return null;
	}
	
	//admin
	@RequestMapping("admin/findAllLoanDisplay")
	public List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb) {
		return investServiceImpl.findAllLoanDisplayByadmin(pb);
	}
	
	@RequestMapping("admin/findAllInvested")
	public List<Invest> findAllInvested(PageBean pb,HttpSession session) {
		String name = (String) session.getAttribute("name");
		String value = (String) session.getAttribute("value");
		if(name!=null) {
			return investServiceImpl.findAllInvested(pb,name,value);
		}
		return investServiceImpl.findAllInvested(pb);
	}
	
	@RequestMapping("admin/findLoandisplayById/{loandisplayid}")
	public ModelAndView findLoandisplayByAdmin(@PathVariable Integer loandisplayid) {
		Loandisplay loandisplay=investServiceImpl.findLoandisplayById(loandisplayid);
		ModelAndView mav=new ModelAndView("invest/admin/info");
		mav.addObject("loandisplay", loandisplay);
		return mav;
	}
	
	@RequestMapping("admin/findUserinfoById/{userinfoid}")
	public ModelAndView findUserinfoById(@PathVariable Integer userinfoid) {
		Userinfo userinfo = userinfoServiceImpl.findById(userinfoid);
		ModelAndView mav=new ModelAndView("invest/admin/userinfo");
		mav.addObject("userinfo", userinfo);
		return mav;
	}


}

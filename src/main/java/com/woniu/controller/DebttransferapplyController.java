package com.woniu.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.service.IDebttransferapplyService;
import com.woniu.service.IInvestService;
import com.woniu.service.IUserinfoService;
import com.woniu.domain.Debttransferapply;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;

@RestController
@RequestMapping("/debttransferapply")
public class DebttransferapplyController {
	@Resource 
	private IDebttransferapplyService debttransferapplyServiceImpl;
	@Resource
	private IInvestService investServiceImpl;
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@RequestMapping("/admin/findAll")
	public Map findAll(PageBean pageBean) {
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAll(pageBean);
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/admin/check/{debttransferapplyid}")
	public ModelAndView check(@PathVariable int debttransferapplyid) {
		ModelAndView mdv=new ModelAndView("redirect:/debttransferapply/admin/applylist.jsp");
		debttransferapplyServiceImpl.check(debttransferapplyid);
		return mdv;
	}
	
	@RequestMapping("/admin/pass/{debttransferapplyid}")
	public ModelAndView pass(@PathVariable int debttransferapplyid) {
		ModelAndView mdv=new ModelAndView("redirect:/debttransferapply/admin/applylist.jsp");
		debttransferapplyServiceImpl.pass(debttransferapplyid);
		return mdv;
	}
	
	@RequestMapping("/findAllInvest")
	public Map findAllInvest(PageBean pageBean,HttpSession session) {
		Map map=new HashMap();
		
		User user=(User) session.getAttribute("user"); 
		int userinfoid=user.getUserinfo().getUserinfoid();
		List rows=investServiceImpl.findAllInvest(pageBean,userinfoid) ;
		/* int userinfoid=3; */
		map.put("total", pageBean.getCount()); map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/findOneInvest/{investId}")
	public ModelAndView findOneInvest(@PathVariable int investId) {
		ModelAndView mdv=new ModelAndView("debttransferapply/investinfo");
		mdv.addObject("invest",investServiceImpl.findOneInvest(investId));
		return mdv;
	}
	
	@RequestMapping("/admin/findOneInvest/{investId}")
	public ModelAndView findOneInvestadmin(@PathVariable int investId) {
		ModelAndView mdv=new ModelAndView("debttransferapply/admin/investinfo");
		mdv.addObject("invest",investServiceImpl.findOneInvest(investId));
		return mdv;
	}
	
	@RequestMapping("/findOneUser/{investId}")
	public ModelAndView findOneUser(@PathVariable int investId) {
		ModelAndView mdv=new ModelAndView("debttransferapply/userinfo");
		mdv.addObject("invest",investServiceImpl.findOneInvest(investId));
		return mdv;
	}
	
	@RequestMapping("/admin/findOneUser/{userinfoid}")
	public ModelAndView findOneUseradmin(@PathVariable int userinfoid) {
		ModelAndView mdv=new ModelAndView("debttransferapply/admin/userinfo");
		mdv.addObject("userinfo",userinfoServiceImpl.findById(userinfoid));
		return mdv;
	}
	
	@RequestMapping("/istransfer/{investId}")
	public ModelAndView istransfer(@PathVariable int investId,HttpSession session) {
		ModelAndView mdv=new ModelAndView("debttransferapply/tipsinfo");
		
		  User user=(User) session.getAttribute("user"); 
		  int userinfoid=user.getUserinfo().getUserinfoid();
		 
		/* int userinfoid=3; */
		Debttransferapply debttransferapply=debttransferapplyServiceImpl.get(investId,userinfoid);
		System.out.println(debttransferapply.getUserinfo());
		mdv.addObject("apply", debttransferapply);
		return mdv;
	}
	
	@RequestMapping("/pay/{investId},{userinfoid}")
	public ModelAndView pay(@PathVariable int investId,@PathVariable int userinfoid) {
		int count=userinfoServiceImpl.findById(userinfoid).getChance();
		if (count>0) {
			ModelAndView mdv=new ModelAndView("debttransferapply/paypage");
			mdv.addObject("investid", investId);
			mdv.addObject("userinfoid", userinfoid);
			return mdv;
		}else {
			ModelAndView mdv=new ModelAndView("debttransferapply/info");
			return mdv;
		}
	}
	
	@RequestMapping("/transfer")
	public ModelAndView transfer(String payPassword_rsainput,Integer investid,Integer userinfoid) {
		Userinfo userinfo=userinfoServiceImpl.findById(userinfoid);
		int count=userinfo.getChance();
		boolean flag=userinfoServiceImpl.findPwdByUid(userinfoid,payPassword_rsainput);
		if (flag) {
			userinfo.setChance(3);
			userinfoServiceImpl.update(userinfo);
			ModelAndView mdv=new ModelAndView("debttransferapply/success");
			investServiceImpl.transfer(investid);
			debttransferapplyServiceImpl.add(investid,userinfoid);
			return mdv; 
		}else {
			count--;
			userinfo.setChance(count);
			userinfoServiceImpl.update(userinfo);
			if (count>0) {
				ModelAndView mdv=new ModelAndView("debttransferapply/defeat");
				mdv.addObject("count", count);
				mdv.addObject("investid", investid);
				mdv.addObject("userinfoid", userinfoid);
				return mdv;
			}else {
				ModelAndView mdv=new ModelAndView("debttransferapply/info");
				return mdv;
			}
		}
	}
}
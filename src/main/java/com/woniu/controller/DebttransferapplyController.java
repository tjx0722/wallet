package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.service.IDebttransferapplyService;
import com.woniu.service.IInvestService;
import com.woniu.service.impl.InvestServiceImpl;
import com.woniu.domain.Debttransferapply;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;

@RestController
@RequestMapping("/debttransferapply")
public class DebttransferapplyController {
	@Resource 
	private IDebttransferapplyService debttransferapplyServiceImpl;
	@Resource
	private IInvestService investServiceImpl;
	
	@RequestMapping("/findAll")
	public Map findAll(PageBean pageBean) {
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAll();
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/findAllInvest")
	public Map findAllInvest(PageBean pageBean) {
		Map map=new HashMap();
		List rows=investServiceImpl.findAllInvest() ;
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/findOneInvest/{investId}")
	public ModelAndView findOneInvest(@PathVariable int investId) {
		ModelAndView mdv=new ModelAndView("debttransferapply/investinfo");
		mdv.addObject("invest",investServiceImpl.findOneInvest(investId));
		return mdv;
	}
	
	@RequestMapping("/findOneUser/{investId}")
	public ModelAndView findOneUser(@PathVariable int investId) {
		ModelAndView mdv=new ModelAndView("debttransferapply/userinfo");
		mdv.addObject("invest",investServiceImpl.findOneInvest(investId));
		return mdv;
	}
	
	@RequestMapping("/istransfer/{investId}")
	public ModelAndView istransfer(@PathVariable int investId,HttpSession session) {
		ModelAndView mdv=new ModelAndView("debttransferapply/tipsinfo");
		/*
		 * User user=(User) session.getAttribute("user"); int
		 * userinfoid=user.getUserinfo().getUserinfoid();
		 */
		int userinfoid=1;
		Debttransferapply debttransferapply=debttransferapplyServiceImpl.get(investId,userinfoid);
		mdv.addObject("apply", debttransferapply);
		return mdv;
	}
	
	@RequestMapping("/transfer/{investid},{userinfoid}")
	public ModelAndView transfer(@PathVariable Integer investid,@PathVariable Integer userinfoid) {
		ModelAndView mdv=new ModelAndView("redirect:/debttransferapply/investlist.jsp");
		investServiceImpl.transfer(investid);
		debttransferapplyServiceImpl.add(investid,userinfoid);
		return mdv;
	}
	
}
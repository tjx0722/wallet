package com.woniu.controller;

import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.service.IDebttransferapplyService;
import com.woniu.service.IInvestService;
import com.woniu.service.IUserinfoService;
import com.woniu.service.IWalletService;
import com.woniu.service.impl.WalletServiceImpl;
import com.woniu.domain.Debttransferapply;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;

@RestController
@RequestMapping("/debttransferapply")
public class DebttransferapplyController {
	@Resource 
	private IDebttransferapplyService debttransferapplyServiceImpl;
	@Resource
	private IInvestService investServiceImpl;
	@Resource
	private IUserinfoService userinfoServiceImpl;
	@Resource
	private IWalletService walletServiceImpl;
	
	@RequestMapping("/admin/findAll")
	public Map findAll(PageBean pageBean) {
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAll(pageBean);
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/findAllByUname")
	public Map findAllByUnamez(PageBean pageBean,String username,HttpSession session) {
		if (username.equals("")) {
			return findAllInvest(pageBean,session);
		}
		User user=(User) session.getAttribute("user");
		int userinfoid=user.getUserinfo().getUserinfoid();
		Map map=new HashMap();
		List rows=investServiceImpl.findAllByUname(pageBean,username,userinfoid);
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/admin/findAllByUname")
	public Map findAllByUname(PageBean pageBean,String username) {
		if (username.equals("")) {
			return findAll(pageBean);
		}
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAllByUname(pageBean,username);
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/admin/findAllByDate")
	public Map findAllByDate(PageBean pageBean,Date begin,Date end) {
		Map map=new HashMap();
		List rows=debttransferapplyServiceImpl.findAllByDate(pageBean,begin,end);
		map.put("total", pageBean.getCount());
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping("/findAllByDate")
	public Map findAllByDatezz(PageBean pageBean,Date begin,Date end,HttpSession session) {
		Map map=new HashMap();
		User user=(User) session.getAttribute("user");
		int userinfoid=user.getUserinfo().getUserinfoid();
		List rows=investServiceImpl.findAllByDate(pageBean,begin,end,userinfoid);
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
	
	@RequestMapping("/findOneUser/{userinfoid}")
	public ModelAndView findOneUser(@PathVariable int userinfoid) {
		ModelAndView mdv=new ModelAndView("debttransferapply/userinfo");
		mdv.addObject("userinfo",userinfoServiceImpl.findById(userinfoid));
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
	public ModelAndView transfer(String payPassword_rsainput,Integer investid,Integer userinfoid,HttpSession session) {
		Userinfo userinfo=userinfoServiceImpl.findById(userinfoid);
		int count=userinfo.getChance();
		boolean flag=userinfoServiceImpl.findPwdByUid(userinfoid,payPassword_rsainput);
		if (flag) {
			userinfo.setChance(3);
			userinfoServiceImpl.update(userinfo);
			ModelAndView m=istransfer(investid,session);
			Debttransferapply debttransferapply=(Debttransferapply) m.getModel().get("apply");
			Wallet wallet=userinfo.getWallet();
			if (debttransferapply.getServicecharge()<=wallet.getBalance()) {
				wallet.setBalance(wallet.getBalance()-debttransferapply.getServicecharge());
				walletServiceImpl.update(wallet);
				ModelAndView mdv=new ModelAndView("debttransferapply/success");
				investServiceImpl.transfer(investid);
				debttransferapplyServiceImpl.add(investid,userinfoid);
				return mdv; 
			}else {
				ModelAndView mdv=new ModelAndView("debttransferapply/banlance");
				return mdv;
			}
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
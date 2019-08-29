package com.woniu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.Invest;
import com.woniu.domain.Message;
import com.woniu.domain.PageBean;
import com.woniu.domain.Repay;
import com.woniu.domain.Servicecharge;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.service.IDebtInvestService;
import com.woniu.service.IDebttransferdisplayService;
import com.woniu.service.IInvestService;
import com.woniu.service.IRepayService;
import com.woniu.service.IServicechargeService;
import com.woniu.service.IUserinfoService;
import com.woniu.service.IWalletService;
@Controller
@RequestMapping("/debtinvest")
public class DebtInvestController {
	@Resource
	private IDebtInvestService debtInvestServiceImpl;
	
	@Resource
	private IRepayService repayServiceImpl;
	
	@Resource
	private IServicechargeService servicechargeServiceImpl;
	
	@Resource
	private IInvestService investServiceImpl;
	
	@Resource
	private IDebttransferdisplayService debttransferdisplayServiceImpl;
	
	@Resource
	private IWalletService walletService;
	
	@Resource
	private IUserinfoService userinfoServiceImpl;
	
	@RequestMapping("findUndead")
	@ResponseBody
	public Map findUndead(PageBean page) {
		Map map=new HashMap();
		List<Debttransferdisplay> list = debtInvestServiceImpl.findUndead(page);
		map.put("page", page);
		map.put("total", page.getCount());
		map.put("rows", list);
		return map;
		
	}
	@RequestMapping("findById")
	public String  findUndead(HttpSession session,Integer debttransferdisplay,ModelMap map) {
		Debttransferdisplay debttransfer = debtInvestServiceImpl.findById(debttransferdisplay);
		List<Repay> repays = repayServiceImpl.findByUser(debttransfer.getLoanapply().getUserinfo().getUserinfoid());
		Servicecharge servicecharge = servicechargeServiceImpl.findByServicechargeid(3);
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			Userinfo loginuserinfo = user.getUserinfo();
			Wallet wallet = walletService.findByUserinfo(loginuserinfo.getUserinfoid());
			map.put("wallet", wallet);
		}		
		map.put("invest", debttransfer.getInvest());
		map.put("loanapply", debttransfer.getLoanapply());
		map.put("loantime", debttransfer.getLoanapply().getLoantime());
		map.put("loanrate", debttransfer.getLoanapply().getLoanrate());
		map.put("userinfo", debttransfer.getLoanapply().getUserinfo());		
		map.put("loandispaly",debttransfer.getInvest().getLoandisplay());
		map.put("servicecharge", servicecharge);
		map.put("realcharge", debttransfer.getInvest().getInvestamount()*servicecharge.getChargerate());
		map.put("repays", repays);
		map.put("payment", debttransfer.getInvest().getInvestamount()+debttransfer.getInvest().getInvestamount()*servicecharge.getChargerate());
		map.put("debttransferdisplay",debttransferdisplay);
		return "/debtinvest/debtinfo";
		
	}
	@RequestMapping("debtinvestPay/{payment}/{servicechargeid}/{debttransferdisplay}")
	public String  debtinvsetPay(HttpSession session,@PathVariable double payment,@PathVariable Integer servicechargeid,@PathVariable Integer debttransferdisplay) {
		User user = (User) session.getAttribute("user");
//	往debtinvset表插数据	
		Userinfo userinfo = user.getUserinfo();
		Debtinvest debtinvest=new Debtinvest();		
		debtinvest.setUserinfoid(userinfo.getUserinfoid());
		debtinvest.setInvestamount(payment);
		debtinvest.setPaytime(new Date());
		debtinvest.setServicecharge(servicechargeServiceImpl.findByServicechargeid(servicechargeid).getChargerate());
		debtinvest.setServicechargeid(servicechargeid);
		debtinvest.setDebttransferdisplay(debttransferdisplay);
		debtInvestServiceImpl.save(debtinvest);
//	把债权转让审核表的isfinished改为1	
		Debttransferdisplay debttransfer = debtInvestServiceImpl.findById(debttransferdisplay);
		debttransfer.setIsfinished(true);
		debttransferdisplayServiceImpl.update(debttransfer);
//	更改invset表某项记录的userinfoid	
		
		Invest invest = debttransfer.getInvest();
		invest.setUserinfoid(userinfo.getUserinfoid());
		investServiceImpl.update(invest);
		return "redirect:/debtinvest/debttransferdisplay.jsp";
	}
	
	@RequestMapping("admin/findAll")
	@ResponseBody
	public Map findAll(PageBean page) {
		Map map=new HashMap();
		List<Debtinvest> debtinvests = debtInvestServiceImpl.findAll(page);
		map.put("page", page);
		map.put("total", page.getCount());
		map.put("rows", debtinvests);
		return map;
	}
//	按照买进用户查询
	@RequestMapping("admin/findByUserinfo")
	@ResponseBody
	public Map findByUserinfo(PageBean page,Userinfo userinfo,Date begin,Date end) {
		Map map=new HashMap();
		List<Debtinvest> debtinvests=null;
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			List<Userinfo> userinfos = userinfoServiceImpl.findByName(userinfo.getUsername());
			if(userinfos.size()==0) {
				debtinvests = debtInvestServiceImpl.findAll(page);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
				map.put("msg", new Message(false,"用户不存在，已显示所有！"));
			}else {
				debtinvests = debtInvestServiceImpl.findByUserinfo(page,userinfo,begin,end);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
			}
		}else {
			debtinvests = debtInvestServiceImpl.findByUserinfo(page,userinfo,begin,end);
			map.put("page", page);
			map.put("total", page.getCount());
			map.put("rows", debtinvests);
		}
		return map;
	}
	
	
	
//	通过债权转让用户查询
	@RequestMapping("admin/findByDebttransfer")
	@ResponseBody
	public Map  findByDebttransfer(PageBean page,Userinfo userinfo,Date begin,Date end) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		List<Debtinvest> debtinvests=null;
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			List<Userinfo> userinfos = userinfoServiceImpl.findByName(userinfo.getUsername());
			if(userinfos.size()==0) {
				debtinvests = debtInvestServiceImpl.findAll(page);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
				map.put("msg", new Message(false,"用户不存在，已显示所有！"));
			}else {
				debtinvests = debtInvestServiceImpl.findByDebttransfer(page,userinfo,begin,end);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
			}
		}else {
			debtinvests = debtInvestServiceImpl.findByDebttransfer(page,userinfo,begin,end);
			map.put("page", page);
			map.put("total", page.getCount());
			map.put("rows", debtinvests);
		}
		return map;
	}
//	通过借款人查询
	@RequestMapping("admin/findByLoanapply")
	@ResponseBody
	public Map  findByLoanapply(PageBean page,Userinfo userinfo,Date begin,Date end) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		List<Debtinvest> debtinvests=null;
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			List<Userinfo> userinfos = userinfoServiceImpl.findByName(userinfo.getUsername());
			if(userinfos.size()==0) {
				debtinvests = debtInvestServiceImpl.findAll(page);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
				map.put("msg", new Message(false,"用户不存在，已显示所有！"));
			}else {
				debtinvests = debtInvestServiceImpl.findByLoanapply(page,userinfo,begin,end);
				map.put("page", page);
				map.put("total", page.getCount());
				map.put("rows", debtinvests);
			}
		}else {
			debtinvests = debtInvestServiceImpl.findByLoanapply(page,userinfo,begin,end);
			map.put("page", page);
			map.put("total", page.getCount());
			map.put("rows", debtinvests);
		}
		return map;
	}
	
}

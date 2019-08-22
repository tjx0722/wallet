package com.woniu.controller;

import java.util.Date;
import java.util.List;

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
import com.woniu.domain.Repay;
import com.woniu.domain.Servicecharge;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.IDebtInvestService;
import com.woniu.service.IDebttransferdisplayService;
import com.woniu.service.IInvestService;
import com.woniu.service.IRepayService;
import com.woniu.service.IServicechargeService;
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
	
	
	@RequestMapping("findUndead")
	@ResponseBody
	public List findUndead() {
		return debtInvestServiceImpl.findUndead();
		
	}
	@RequestMapping("findById")
	public String  findUndead(Integer debttransferdisplay,ModelMap map) {
		Debttransferdisplay debttransfer = debtInvestServiceImpl.findById(debttransferdisplay);
		List<Repay> repays = repayServiceImpl.findByUser(debttransfer.getLoanapply().getUserinfo().getUserinfoid());
		Servicecharge servicecharge = servicechargeServiceImpl.findByServicechargeid(3);
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
		System.out.println("DebtInvestController.debtinvsetPay()");
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
}

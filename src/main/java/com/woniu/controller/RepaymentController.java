package com.woniu.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.domain.Loanapply;
import com.woniu.domain.Repay;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.ILoanApplyService;
import com.woniu.service.IRepayService;
import com.woniu.service.IWalletService;
import com.woniu.service.impl.WalletServiceImpl;

@RequestMapping("/repayment/")
@RestController
public class RepaymentController {
	@Resource
	private ILoanApplyService loanApplyServiceImpl;
	@Resource
	private IRepayService repayServiceImpl;
	@Resource
	private IWalletService walletServiceImpl;
	@RequestMapping("findRepaymentWithUser")
	public ModelAndView findRepaymentWithUser(HttpSession session) throws JsonProcessingException {
		ModelAndView mav=new ModelAndView("repayment/list");
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = user.getUserinfo();
		List<Loanapply> list = loanApplyServiceImpl.findByUser(userinfo.getUserinfoid());
		ObjectMapper om=new ObjectMapper();
		String json = om.writeValueAsString(list);
		mav.addObject("list",list);
		mav.addObject("json",json);
		return mav;
	}
	
	@RequestMapping("repay")
	public  ModelAndView repay(HttpSession session) {
		User user = (User) session.getAttribute("user");
		Userinfo userinfo = user.getUserinfo();
		List<Repay> AllRepay = repayServiceImpl.findByUser(userinfo.getUserinfoid());
		
		Date firstDay,lastday;
		Calendar cal1,cal2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cal1=Calendar.getInstance();
		cal1.add(Calendar.MONTH, 0);
        cal1.set(Calendar.DAY_OF_MONTH, 1);  
         firstDay = cal1.getTime();		
         
         cal2 = Calendar.getInstance();  
         cal2.add(Calendar.MONTH, 1);  
         cal2.set(Calendar.DAY_OF_MONTH, 0);  
         lastday=cal2.getTime();
         
         List<Repay> currentRepay=new ArrayList<Repay>();
         int count = 0 ;
         for (Repay repay : AllRepay) {
        	 Date d=repay.getRepaytime();
			if(d.getTime()<=lastday.getTime()&&d.getTime()>=firstDay.getTime()) {
				currentRepay.add(repay);
				count++;
			}
		}
         Double restamount =0.0;
         for (Repay repay : currentRepay) {
        	  restamount += repay.getRestamount();
		}
         DecimalFormat df = new DecimalFormat("#.00");
         restamount = Double.parseDouble(df.format(restamount));
         
//         walletServiceImpl.findBankcardByWalletid(walletid)
         
         
         ModelAndView mdv=new ModelAndView("/repayment/repay");
         mdv.addObject("currentRepay",currentRepay);
         mdv.addObject("AllRepay",AllRepay);
         mdv.addObject("restamount",restamount);
         mdv.addObject("count",count);
		return mdv;
	}
}

package com.woniu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.domain.Bankcard;
import com.woniu.domain.Message;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.service.IBankcardService;
import com.woniu.service.impl.WalletServiceImpl;



@Controller
@RequestMapping("userinfo/wallet/bankcard")
public class BankcardController {
	private Integer obj;
	@Resource
	private WalletServiceImpl walletServiceImpl;
	 @Resource
	   private IBankcardService bankcardServiceImpl;
	 
	 @RequestMapping("findAll")
	   public @ResponseBody Map findAll(PageBean pageBean) {
		   List rows=bankcardServiceImpl.findAll(pageBean);
		   Map map=new HashMap();
		   map.put("total",pageBean.getCount());
		   map.put("rows",rows);
		   return map;
	   }
	   @RequestMapping("save")
		public @ResponseBody Message save(Bankcard bankcard) {
			Message msg = null;
		
			try {
				
				bankcardServiceImpl.save(bankcard);
				msg = new Message(true, "用户详细信息增加成功");
			} catch (Exception e) {
				// TODO: handle exception
				msg = new Message(false, "用户详细信息增加失败"+e.getMessage());
			}
			return msg;
		}
	   @RequestMapping("findById")
		public @ResponseBody Bankcard findById(Integer bankcardid) {
		   Bankcard bankcard = bankcardServiceImpl.findById(bankcardid);
		return bankcard;
		}
	   @ResponseBody
	   @RequestMapping("findByIdss")
		public  List findById() {
		   Integer walletid=obj;
		   System.out.println(walletid+"--------------");
		   Wallet wallet = walletServiceImpl.findById(walletid);
                     
		   Bankcard bankcard = wallet.getBankcard();   
		   System.out.println(bankcard);
		   List<Bankcard> list= new ArrayList<Bankcard>();
		   list.add(bankcard);
	 	return list;
		}
	   @RequestMapping("skip")
		public  ModelAndView skip(Integer walletid) {
		   obj=walletid;
		   System.out.println(obj+"!!");
		   ModelAndView mav=new ModelAndView("/userinfo/wallet/bankcard/yhk");
		return mav;
		}
		@RequestMapping("delete")
		public @ResponseBody Message delete(Integer bankcardid) {
			Message msg = null;
			try { 
				int  count = bankcardServiceImpl.delete(bankcardid);
				msg = new Message(true, "客户信息删除成功");
			} catch (Exception e) {
				// TODO: handle exception
				msg = new Message(false, "客户信息删除失败"+e.getMessage());
			}
			return msg;
		}
		@RequestMapping("deleteBatch")
		public @ResponseBody Message deleteBatch(String bankcardidstring) {// 1,2,3
			Message msg = null;
			try {
				String[] tempStrings = bankcardidstring.split(",");
				Integer[] bankcardids = new Integer[tempStrings.length];
				for (int i = 0; i < tempStrings.length; i++) {
					bankcardids[i] = Integer.parseInt(tempStrings[i]);
				}
				bankcardServiceImpl.deleteBatch(bankcardids);
				msg = new Message(true, "用户详细信息批量删除成功");
			} catch (Exception e) {
				// TODO: handle exception
				msg = new Message(false, "用户详细信息批量删除失败"+e.getMessage());
			}
			return msg;
		}
		@RequestMapping("update")
		public @ResponseBody Message update(Bankcard bankcard) {
			Message msg = null;
			try {
				
				bankcardServiceImpl.update(bankcard);
				msg = new Message(true, "用户详细信息修改成功");
			} catch (Exception e) {
				// TODO: handle exception
				msg = new Message(false, "用户详细信息修改失败"+e.getMessage());
			}
			return msg;
		}
}

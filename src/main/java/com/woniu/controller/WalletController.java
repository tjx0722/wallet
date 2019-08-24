package com.woniu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.domain.Bankcard;
import com.woniu.domain.Message;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.service.IWalletService;

@Controller
@RequestMapping("userinfo/wallet")
public class WalletController {
	@Resource
	   private IWalletService walletServiceImpl;
	@RequestMapping("findAll")
	   public @ResponseBody Map findAll(PageBean pageBean) {

		   List rows=walletServiceImpl.findAll(pageBean);
		   Map map=new HashMap();
		   map.put("total",pageBean.getCount());
		   map.put("rows",rows);
		   return map;
	   }
	@RequestMapping("save")
	public @ResponseBody Message save(Wallet wallet) {
		Message msg = null;
	
		try {
			
			walletServiceImpl.save(wallet);
			msg = new Message(true, "钱包信息增加成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "用户详细信息增加失败"+e.getMessage());
		}
		return msg;
	}
	@RequestMapping("findById")
	public @ResponseBody Wallet findById(Integer walletid) {
		Wallet wallet = walletServiceImpl.findById(walletid);
		return wallet;
	}
	@RequestMapping("delete")
	public @ResponseBody Message delete(Integer walletid) {
		Message msg = null;
		try {
			int  count = walletServiceImpl.delete(walletid);
			msg = new Message(true, "钱包信息删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "钱包信息删除失败"+e.getMessage());
		}
		return msg;
	}
	@RequestMapping("deleteBatch")
	public @ResponseBody Message deleteBatch(String walletidstring) {// 1,2,3
		Message msg = null;
		try {
			String[] tempStrings = walletidstring.split(",");
			Integer[] walletids = new Integer[tempStrings.length];
			for (int i = 0; i < tempStrings.length; i++) {
				walletids[i] = Integer.parseInt(tempStrings[i]);
			}
			walletServiceImpl.deleteBatch(walletids);
			msg = new Message(true, "钱包信息批量删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "钱包信息批量删除失败"+e.getMessage());
		}
		return msg;
	}
	@RequestMapping("update")
	public @ResponseBody Message update(Wallet wallet) {
		Message msg = null;
		try {
			walletServiceImpl.update(wallet);
			msg = new Message(true, "钱包信息修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			msg = new Message(false, "钱包信息修改失败"+e.getMessage());
		}
		return msg;
	}

	@RequestMapping("findBankcardByWalletid")
	public String findBankcardByWalletid(ModelMap map,Integer walletid) {
		System.out.println(walletid);
		Bankcard bankcard=walletServiceImpl.findBankcardByWalletid(walletid);
		System.out.println(bankcard.toString()+"--------------------");
		map.put("bankcard",bankcard);
		return "/userinfo/wallet/bankcard/index";
		
	}
}

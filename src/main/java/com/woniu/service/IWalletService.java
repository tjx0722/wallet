package com.woniu.service;

import java.util.List;

import com.woniu.domain.Bankcard;
import com.woniu.domain.PageBean;
import com.woniu.domain.Wallet;


public interface IWalletService {
	    public List findAll(PageBean pagebean);
	    public int delete(Integer walletid);
		public void deleteBatch(Integer[] walletid);
		public void save(Wallet wallet);
		public void update(Wallet wallet);
		public Wallet findById(Integer walletid);
		public Bankcard findBankcardByWalletid(Integer walletid);
}

package com.woniu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.domain.Loandisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;

public interface IUserinfoService {
    public List findAll(PageBean pagebean);
    public int delete(Integer userinfoid);
	public void deleteBatch(Integer[] userinfoid);
	public void save(Userinfo userinfo);
	public void update(Userinfo userinfo);
	public Userinfo findById(Integer userinfoid);
	public Wallet findWalletByUserinfoid(Integer userinfoid);
	boolean findPwdByUid(Integer userinfoid, String payPassword_rsainput);
	
}

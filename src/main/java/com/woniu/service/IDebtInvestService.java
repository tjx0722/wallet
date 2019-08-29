package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;

public interface IDebtInvestService {
	List<Debtinvest> findAll(PageBean page);
	List<Debtinvest> findByUserinfo(PageBean page,Userinfo userinfo);
	List<Debttransferdisplay> findUndead(PageBean page);
	Debttransferdisplay findById(Integer debttransferdisplay);
	void save(Debtinvest debtinvest);
//	通过债权转让用户查询	
	List<Debtinvest> findByDebttransfer(PageBean page,Userinfo userinfo);
//	通过借款人查询	
	List<Debtinvest> findByLoanapply(PageBean page, Userinfo userinfo);
	
}

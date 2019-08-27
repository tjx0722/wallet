package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;

public interface IDebtInvestService {
	List<Debtinvest> findAll(PageBean page,Userinfo userinfo,Debtinvest debtinvest);
	List<Debttransferdisplay> findUndead(PageBean page);
	Debttransferdisplay findById(Integer debttransferdisplay);
	void save(Debtinvest debtinvest);
}

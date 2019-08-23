package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;

public interface IDebtInvestService {
	List<Debtinvest> findAll(PageBean page);
	List<Debttransferdisplay> findUndead();
	Debttransferdisplay findById(Integer debttransferdisplay);
	void save(Debtinvest debtinvest);
}

package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;

public interface IDebtInvestService {
	List<Debttransferdisplay> findAll();
	List<Debttransferdisplay> findUndead();
	Debttransferdisplay findById(Integer debttransferdisplay);
	void save(Debtinvest debtinvest);
}

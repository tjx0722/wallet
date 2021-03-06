package com.woniu.service;

import java.util.List;

import com.woniu.domain.Loanapply;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.domain.PageBean;

public interface IDebitService {
	void save(Loanapply loanapply);
	void update(Loanapply loanapply);
	List<Loanapply> findAllLoanapply(PageBean pagebean);
	List<Loantime> findAllLoantime();
	List<Loanrate> findAllLoanrate();
	Loanapply findLoanapplybyLoanapplyid(int loanapplyid);
	Loantime findLoantimeByLoantimeid(int loantimeid);
	Loanrate findLoanrateByservicechargeid(int servicechargeid);
}

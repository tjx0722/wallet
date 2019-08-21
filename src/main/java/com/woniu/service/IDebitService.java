package com.woniu.service;

import java.util.List;

import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;

public interface IDebitService {
	List<Loantime> findAllLoantime();
	List<Loanrate> findAllLoanrate();
	Loantime findLoantimeByLoantimeid(int loantimeid);
	Loanrate findLoanrateByservicechargeid(int servicechargeid);
}

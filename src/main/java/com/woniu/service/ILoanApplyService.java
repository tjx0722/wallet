package com.woniu.service;

import java.util.List;

import com.woniu.domain.Loanapply;

public interface ILoanApplyService {
	List<Loanapply> findByUser(Integer userinfoid);
}

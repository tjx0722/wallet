package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.LoanrateMapper;
import com.woniu.dao.LoantimeMapper;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.service.IDebitService;
@Service
public class DebitServiceImpl implements IDebitService {
	
	@Resource
	private LoantimeMapper  loantimeMapper;
	
	@Resource
	private LoanrateMapper loanrateMapper;
	
	@Override
	public List<Loantime> findAllLoantime() {
		// TODO Auto-generated method stub
		List<Loantime> times = loantimeMapper.selectByExample(null);
		return times;
	}
	@Override
	public List<Loanrate> findAllLoanrate() {
		// TODO Auto-generated method stub
		List<Loanrate> rates = loanrateMapper.selectByExample(null);
		return rates;
	}
}

package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.LoanapplyMapper;
import com.woniu.dao.LoanrateMapper;
import com.woniu.dao.LoantimeMapper;
import com.woniu.domain.Loanapply;
import com.woniu.domain.Loanrate;
import com.woniu.domain.Loantime;
import com.woniu.service.IDebitService;
@Service
@Transactional
public class DebitServiceImpl implements IDebitService {
	@Resource
	private LoanapplyMapper loanapplyMapper;
	
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
	@Override
	public Loantime findLoantimeByLoantimeid(int loantimeid) {
		// TODO Auto-generated method stub
		return loantimeMapper.selectByPrimaryKey(loantimeid);
	}
	@Override
	public Loanrate findLoanrateByservicechargeid(int servicechargeid) {
		// TODO Auto-generated method stub
		return loanrateMapper.selectByPrimaryKey(servicechargeid);
	}
	@Override
	public List<Loanapply> findAllLoanapply() {
		// TODO Auto-generated method stub
		List<Loanapply> list = loanapplyMapper.selectByExampleWithBLOBs(null);
		return list;
	}
	@Override
	public Loanapply findLoanapplybyLoanapplyid(int loanapplyid) {
		// TODO Auto-generated method stub
		return loanapplyMapper.selectByPrimaryKey(loanapplyid);
	}
	@Override
	public void update(Loanapply loanapply) {
		// TODO Auto-generated method stub
		loanapplyMapper.updateByPrimaryKey(loanapply);
	}
	@Override
	public void save(Loanapply loanapply) {
		// TODO Auto-generated method stub
		loanapplyMapper.insert(loanapply);
	}
}

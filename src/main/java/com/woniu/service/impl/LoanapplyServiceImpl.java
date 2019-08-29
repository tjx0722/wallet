package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.LoanapplyMapper;
import com.woniu.dao.RepayMapper;
import com.woniu.domain.Loanapply;
import com.woniu.domain.LoanapplyExample;
import com.woniu.domain.Repay;
import com.woniu.domain.RepayExample;
import com.woniu.service.ILoanApplyService;
import com.woniu.service.IRepayService;
@Service
public class LoanapplyServiceImpl implements ILoanApplyService {
	@Resource
	private LoanapplyMapper loanapplyMapper;
	
//	根据用户id查出所有借款记录
	@Override
	public List<Loanapply> findByUser(Integer userinfoid) {
		// TODO Auto-generated method stub
		LoanapplyExample example =new LoanapplyExample();
		example.createCriteria().andUserinfoidEqualTo(userinfoid);
		return loanapplyMapper.selectByExampleWithBLOBs(example);
	}

}

package com.woniu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.RepayMapper;
import com.woniu.domain.Repay;
import com.woniu.domain.RepayExample;
import com.woniu.service.IRepayService;
@Service
public class RepayServiceImpl implements IRepayService {
	@Resource
	private RepayMapper repayMapper;
	
//	根据用户id把其所有还款记录查找出来
	@Override
	public List<Repay> findByUser(Integer userinfoid) {
		// TODO Auto-generated method stub
		RepayExample example=new RepayExample();
		example.createCriteria().andUserinfoidEqualTo(userinfoid);	
		example.createCriteria().andIsfinishedEqualTo(true);
		return repayMapper.selectByExample(example);
	}

	@Override
	public void save(Repay repay) {
		// TODO Auto-generated method stub
		repayMapper.insert(repay);
	}

}

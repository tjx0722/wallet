package com.woniu.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.InvestMapper;
import com.woniu.dao.LoandisplayMapper;
import com.woniu.domain.Invest;
import com.woniu.domain.Loandisplay;
import com.woniu.service.IInvestService;

@Service
public class InvestServiceImpl implements IInvestService {

	@Resource
	private LoandisplayMapper loandisplayMapper;
	@Resource
	private InvestMapper investMapper;
	
	@Override
	public List<Loandisplay> findAllLoadDisplay() {
		
		return loandisplayMapper.selectByExample(null);
	}

	@Override
	public List findAllInvest() {
		// TODO Auto-generated method stub
		return investMapper.selectByExample(null);
	}

	@Override
	public Invest findOneInvest(int investId) {
		// TODO Auto-generated method stub
		return investMapper.selectByPrimaryKey(investId);
	}
	
	
	@Override
	public Loandisplay findLoandisplayById(Integer loandisplayid) {
		return loandisplayMapper.selectByPrimaryKey(loandisplayid);
	}

	@Override
	public void transfer(int investId) {
		// TODO Auto-generated method stub
		Invest invest=new Invest();
		invest.setInvestid(investId);
		invest.setIstransfer(true);
		investMapper.updateByPrimaryKeySelective(invest);
	}
	
}

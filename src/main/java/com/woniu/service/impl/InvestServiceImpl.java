package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.LoandisplayMapper;
import com.woniu.domain.Loandisplay;
import com.woniu.service.IInvestService;

@Service
public class InvestServiceImpl implements IInvestService {

	@Resource
	private LoandisplayMapper loandisplayMapper;
	
	@Override
	public List<Loandisplay> findAllLoadDisplay() {
		// TODO Auto-generated method stub
		return loandisplayMapper.selectByExample(null);
	}

}

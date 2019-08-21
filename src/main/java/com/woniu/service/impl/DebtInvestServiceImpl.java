package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.service.IDebtInvestService;
@Service
@Transactional
public class DebtInvestServiceImpl implements IDebtInvestService {
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	
	@Override
	public List<Debttransferdisplay> findUndead() {
		// TODO Auto-generated method stub
		List<Debttransferdisplay> list = debttransferdisplayMapper.findUndead();
		
		return list;
	}
	@Override
	public List<Debttransferdisplay> findAll() {
		// TODO Auto-generated method stub
		List<Debttransferdisplay> list = debttransferdisplayMapper.selectByExample(null);
		return list;
	}

}

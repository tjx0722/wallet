package com.woniu.service.impl;

import javax.annotation.Resource;

import com.woniu.dao.LoandisplayMapper;
import com.woniu.domain.Loandisplay;
import com.woniu.service.IloandisplayService;
public class LoandisplayServiceImpl implements IloandisplayService{

	@Resource
	private LoandisplayMapper loandisplayMapper;
	
	@Override
	public void save(Loandisplay loandisplay) {
		// TODO Auto-generated method stub
		loandisplayMapper.insert(loandisplay);
	}

}

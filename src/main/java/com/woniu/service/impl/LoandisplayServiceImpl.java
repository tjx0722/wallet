package com.woniu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.LoandisplayMapper;
import com.woniu.domain.Loandisplay;
import com.woniu.service.IloandisplayService;
@Service
public class LoandisplayServiceImpl implements IloandisplayService{

	@Resource
	private LoandisplayMapper loandisplayMapper;
	
	@Override
	public void save(Loandisplay loandisplay) {
		// TODO Auto-generated method stub
		loandisplayMapper.insert(loandisplay);
	}

}

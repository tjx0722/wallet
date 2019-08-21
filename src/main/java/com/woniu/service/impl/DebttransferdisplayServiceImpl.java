package com.woniu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.DebttransferdisplayExample;
import com.woniu.service.IDebttransferdisplayService;

@Service
@Transactional
public class DebttransferdisplayServiceImpl implements IDebttransferdisplayService {
	
	private DebttransferdisplayMapper debttransferdisplayMapper;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return debttransferdisplayMapper.selectByExample(null);
	}

	
}

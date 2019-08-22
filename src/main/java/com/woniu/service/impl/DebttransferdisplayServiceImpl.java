package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.service.IDebttransferdisplayService;

@Service
@Transactional
public class DebttransferdisplayServiceImpl implements IDebttransferdisplayService {
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return debttransferdisplayMapper.selectByExample(null);
	}

	@Override
	public void update(Debttransferdisplay debttransferdisplay) {
		// TODO Auto-generated method stub
		debttransferdisplayMapper.updateByPrimaryKeySelective(debttransferdisplay);
	}

	
}

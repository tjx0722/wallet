package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferapplyMapper;
import com.woniu.service.IDebttransferapplyService;

@Service
@Transactional
public class DebttransferapplyServiceImpl implements IDebttransferapplyService {
	@Resource
	private DebttransferapplyMapper debttransferapplyMapper;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return debttransferapplyMapper.selectByExample(null);
	}
}

package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.TreeMapper;
import com.woniu.service.ITreeService;

@Service
public class TreeService implements ITreeService{

	@Resource
	private TreeMapper treeMapper;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return treeMapper.selectByExample(null);
	}

	
}

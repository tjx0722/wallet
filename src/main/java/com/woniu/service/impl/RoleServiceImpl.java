package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dao.RoleMapper;
import com.woniu.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return roleMapper.selectByExample(null);
	}

}

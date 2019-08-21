package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.ServicechargeMapper;
import com.woniu.domain.Servicecharge;
import com.woniu.service.IServicechargeService;
@Service
@Transactional
public class ServicechargeServiceImpl implements IServicechargeService {
	
	@Resource
	private ServicechargeMapper servicechargeMapper;
	
	@Override
	public List<Servicecharge> findAll() {
		// TODO Auto-generated method stub
		return servicechargeMapper.selectByExample(null);
	}

}

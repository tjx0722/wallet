package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.BankcardMapper;
import com.woniu.domain.Bankcard;
import com.woniu.domain.PageBean;
import com.woniu.service.IBankcardService;
@Service
public class BankcardServiceImpl implements IBankcardService {
	@Resource
	private BankcardMapper bankcardMapper;
	@Override
	public List findAll(PageBean pagebean) {
		// TODO Auto-generated method stub
		List list=bankcardMapper.selectByExample(null,new RowBounds(pagebean.getOffset(), pagebean.getLimit()));
		int count=bankcardMapper.countByExample(null);
		pagebean.setCount(count);	
		return list;
	}

	@Override
	public int delete(Integer bankcardid) {
		// TODO Auto-generated method stub
		return bankcardMapper.deleteByPrimaryKey(bankcardid);
	}

	@Override
	public void deleteBatch(Integer[] bankcardid) {
		// TODO Auto-generated method stub
		bankcardMapper.deleteBatch(bankcardid);
	}

	@Override
	public void save(Bankcard bankcard) {
		// TODO Auto-generated method stub
		bankcardMapper.insert(bankcard);
	}

	@Override
	public void update(Bankcard bankcard) {
		// TODO Auto-generated method stub
		bankcardMapper.updateByPrimaryKey(bankcard);
	}

	@Override
	public Bankcard findById(Integer bankcardid) {
		// TODO Auto-generated method stub
		return bankcardMapper.selectByPrimaryKey(bankcardid);
	}

}

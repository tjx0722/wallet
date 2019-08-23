package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.WalletMapper;
import com.woniu.domain.PageBean;
import com.woniu.domain.Wallet;
import com.woniu.domain.WalletExample;
import com.woniu.service.IWalletService;
@Service
public class WalletServiceImpl implements IWalletService {
    @Resource
	private WalletMapper walletMapper;
	@Override
	public List findAll(PageBean pagebean) {
		// TODO Auto-generated method stub
		List list=walletMapper.selectByExample(null, new RowBounds(pagebean.getOffset(), pagebean.getLimit()));
		int count=walletMapper.countByExample(null);
		pagebean.setCount(count);	
		return list;
	}

	@Override
	public int delete(Integer walletid) {
		// TODO Auto-generated method stub
		return walletMapper.deleteByPrimaryKey(walletid);
	}

	@Override
	public void deleteBatch(Integer[] walletid) {
		// TODO Auto-generated method stub
		walletMapper.deleteBatch(walletid);
	}

	@Override
	public void save(Wallet wallet) {
		// TODO Auto-generated method stub
		walletMapper.insert(wallet);
	}

	@Override
	public void update(Wallet wallet) {
		// TODO Auto-generated method stub
		walletMapper.updateByPrimaryKey(wallet);
	}

	@Override
	public Wallet findById(Integer walletid) {
		// TODO Auto-generated method stub
		return walletMapper.selectByPrimaryKey(walletid);
	}

	@Override
	public Wallet findByUserinfo(Integer userinfoid) {
		// TODO Auto-generated method stub
		WalletExample example=new WalletExample();
		example.createCriteria().andUserinfoidEqualTo(userinfoid);
		List<Wallet> list = walletMapper.selectByExample(example);
		return list.get(0);
	}

}

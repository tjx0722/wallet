package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.UserinfoMapper;
import com.woniu.dao.WalletMapper;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.Wallet;
import com.woniu.service.IUserinfoService;
@Service
public class UserinfoServiceImpl implements IUserinfoService {
@Resource
private UserinfoMapper userinfoMapper;
@Resource
private WalletMapper walletMapper;
	@Override
	public List findAll(PageBean pagebean) {
		// TODO Auto-generated method stub
		List list=userinfoMapper.selectByExample(null,new RowBounds(pagebean.getOffset(), pagebean.getLimit()));
		int count=userinfoMapper.countByExample(null);
		pagebean.setCount(count);	
		return list;
	}
	@Override
	public int delete(Integer userinfoid) {
		// TODO Auto-generated method stub
		return userinfoMapper.deleteByPrimaryKey(userinfoid);
	}
	@Override
	public void deleteBatch(Integer[] userinfoid) {
		// TODO Auto-generated method stub
		userinfoMapper.deleteBatch(userinfoid);
	}
	@Override
	public void save(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userinfoMapper.insert(userinfo);
	}
	@Override
	public void update(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userinfoMapper.updateByPrimaryKey(userinfo);
	}
	@Override
	public Userinfo findById(Integer userinfoid) {
		// TODO Auto-generated method stub
		return userinfoMapper.selectByPrimaryKey(userinfoid);
	}
	@Override
	public Wallet findWalletByUserinfoid(Integer userinfoid) {
		// TODO Auto-generated method stub
		return walletMapper.selectByPrimaryKey(userinfoid);
	}

}

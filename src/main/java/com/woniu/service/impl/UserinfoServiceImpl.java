package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.UserinfoMapper;
import com.woniu.dao.WalletMapper;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.UserinfoExample;
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
		userinfoMapper.insertSelective(userinfo);
		// TODO Auto-generated method stub
		
		Wallet wallet=new Wallet();

		wallet.setUserinfoid(userinfo.getUserinfoid());
		wallet.setBalance(0.0);
		wallet.setDebt(0.0);
		walletMapper.insert(wallet);

		
		
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
		return walletMapper.selectByPrimaryKey1(userinfoid);
	}

	@Override
	public boolean findPwdByUid(Integer userinfoid, String payPassword_rsainput) {
		// TODO Auto-generated method stub
		Userinfo userinfo=userinfoMapper.selectByPrimaryKey(userinfoid);
		String pwd=userinfo.getApplypass();
		if (pwd.equals(payPassword_rsainput)) {
			return true;
		}else {
			return false;
		}
	}
	public List<Userinfo> findByName(String name){
		UserinfoExample example= new UserinfoExample();
		example.createCriteria().andUsernameEqualTo(name);
		return userinfoMapper.selectByExample(example);
		
	}
	@Override
	public List<Userinfo> findUserByChar(String username) {
		// TODO Auto-generated method stub
		List<Userinfo> userinfos = userinfoMapper.findUserByChar(username);
		
		return userinfos;
	}
	
}

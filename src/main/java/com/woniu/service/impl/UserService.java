package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.UserMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;
import com.woniu.service.IUserService;

@Service
public class UserService implements IUserService {
	@Resource 
	private UserMapper userMapper;
	@Resource 
	private UserinfoMapper userinfoMapper;
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userMapper.insertSelective(user);
	}

	@Override
	public void delete(Integer userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	public List findAll(PageBean pb) {
		// TODO Auto-generated method stub
		int count = userMapper.countByExample(null);
		pb.setCount(count);
		return userMapper.selectByExample(null,new RowBounds(pb.getOffset(),pb.getLimit()));
	}

	@Override
	@Transactional(readOnly = true)
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public Userinfo findUserinfoByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return userinfoMapper.selectByPrimaryKey(userid);
	}

}

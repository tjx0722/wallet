package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.UserMapper;
import com.woniu.domain.User;
import com.woniu.service.IUserService;

@Service
public class UserService implements IUserService {
	@Resource 
	private UserMapper userMapper;
	 
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

	}

	@Override
	public User findByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	@Transactional(readOnly = true)
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

}

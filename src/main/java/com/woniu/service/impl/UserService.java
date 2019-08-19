package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.woniu.dao.UserMapper;
import com.woniu.domain.User;
import com.woniu.service.IUserService;

@Controller
public class UserService implements IUserService {
	@Resource 
	private UserMapper userMapper;
	 
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
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

}

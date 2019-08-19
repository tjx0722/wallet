package com.woniu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.woniu.dao.UserMapper;
import com.woniu.domain.User;

public interface IUserService {
	public void save(User user);
	public void delete(Integer userid) ;
	public void update(User user);
	public User findByUserid(Integer userid);
	public List findAll();
}

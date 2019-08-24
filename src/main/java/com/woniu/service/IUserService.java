package com.woniu.service;

import java.util.List;

import com.woniu.domain.PageBean;
import com.woniu.domain.User;
import com.woniu.domain.Userinfo;

public interface IUserService {
	public void save(User user);
	public void delete(Integer userid) ;
	public void update(User user);
	public User findByUserid(Integer userid);
	public List findAll(PageBean pb);
	public User  login(User user);
	public void revoke(Integer userid);
	public Userinfo findUserinfoByUserid(Integer userid);
}

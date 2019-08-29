package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debttransferapply;
import com.woniu.domain.PageBean;

public interface IDebttransferapplyService {
	void add(int investId, int userinfoid);

	Debttransferapply get(int investId, int userinfoid);

	List findAll(PageBean pageBean);

	void check(int debttransferapplyid);

	void pass(int debttransferapplyid);

	List findAllByUname(PageBean pageBean, String username);
}

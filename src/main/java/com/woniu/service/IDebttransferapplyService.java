package com.woniu.service;

import java.util.List;

import com.woniu.domain.Debttransferapply;

public interface IDebttransferapplyService {
	List findAll();

	void add(int investId, int userinfoid);

	Debttransferapply get(int investId, int userinfoid);
}

package com.woniu.service;

import java.util.List;

public interface IDebttransferapplyService {
	List findAll();

	void add(int investId, int userinfoid);
}

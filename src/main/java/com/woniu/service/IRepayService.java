package com.woniu.service;

import java.util.List;

import com.woniu.domain.Repay;

public interface IRepayService {
	List<Repay> findByUser(Integer userinfoid);
	void save(Repay repay);
}

package com.woniu.service;

import java.util.List;

import com.woniu.domain.Servicecharge;

public interface IServicechargeService {
	List<Servicecharge> findAll();
	Servicecharge findByServicechargeid(int servicechargeid);
}

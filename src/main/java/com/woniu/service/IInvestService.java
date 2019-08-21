package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.woniu.domain.Invest;
import com.woniu.domain.Loandisplay;

public interface IInvestService {

	List<Loandisplay> findAllLoadDisplay();
	List findAllInvest();
	Invest findOneInvest(int investId);
	Loandisplay findLoandisplayById(Integer loandisplayid);
	
}

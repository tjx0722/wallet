package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.woniu.domain.Invest;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.PageBean;

public interface IInvestService {

	List<Loandisplay> findAllLoadDisplay();
	List findAllInvest(PageBean pageBean, int userinfoid);
	Invest findOneInvest(int investId);
	Loandisplay findLoandisplayById(Integer loandisplayid);
	void transfer(int investId);
	
}

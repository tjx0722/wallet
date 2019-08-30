package com.woniu.service;

import java.util.Date;
import java.util.List;

import com.woniu.domain.Invest;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.PageBean;

public interface IInvestService {

	List<Loandisplay> findAllLoadDisplay(PageBean pb);
	void insert(Invest invest);
	List<Invest> findAllInvest(PageBean pageBean, int userinfoid);
	Invest findOneInvest(int investId);
	Loandisplay findLoandisplayById(Integer loandisplayid);
	void transfer(int investId);
	void update(Invest invest);
	List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb);
	List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb, String name, String value);
	List<Loandisplay> findAllLoadDisplay(PageBean pb, String name, String value);
	List<Invest> findInvested(Integer userinfoid, PageBean pb);
	List<Invest> findInvested(Integer userinfoid, PageBean pb, String name, String value);
	List<Invest> findAllInvested(PageBean pb);
	List<Invest> findAllInvested(PageBean pb, String name, String value);
	List<Invest> findAllByUname(PageBean pageBean, String username, int userinfoid);
	List<Invest> findAllByDate(PageBean pageBean, Date begin, Date end, int userinfoid);
}

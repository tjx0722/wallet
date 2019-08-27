package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.InvestMapper;
import com.woniu.dao.LoandisplayMapper;
import com.woniu.domain.Invest;
import com.woniu.domain.InvestExample;
import com.woniu.domain.InvestExample.Criteria;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.LoandisplayExample;
import com.woniu.domain.PageBean;
import com.woniu.service.IInvestService;

@Service
public class InvestServiceImpl implements IInvestService {

	@Resource
	private LoandisplayMapper loandisplayMapper;
	@Resource
	private InvestMapper investMapper;
	
	@Override
	public List<Loandisplay> findAllLoadDisplay(PageBean pb) {
		LoandisplayExample example=new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria criteria = example.createCriteria();
		criteria.andIsfinishedEqualTo(false);
		criteria.andIsdeadEqualTo(false);
		pb.setCount(loandisplayMapper.countByExample(null));
		return loandisplayMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}
	
	@Override
	public void insert(Invest invest) {
		investMapper.insert(invest);
	}

	@Override
	public List<Loandisplay> findAllLoadDisplay(PageBean pb, String sort, String order) {
		LoandisplayExample example=new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria criteria = example.createCriteria();
		criteria.andIsfinishedEqualTo(false);
		criteria.andIsdeadEqualTo(false);
		pb.setCount(loandisplayMapper.countByExample(example));
		switch(sort) {
			case "deadtime":
				example.setOrderByClause("deadtime "+order.toUpperCase());
				break;
		}
		return loandisplayMapper.selectByExample(example, new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public Invest findOneInvest(int investId) {
		// TODO Auto-generated method stub
		return investMapper.selectByPrimaryKey(investId);
	}
	
	
	@Override
	public Loandisplay findLoandisplayById(Integer loandisplayid) {
		return loandisplayMapper.findInvestBydisplay(loandisplayid);
	}

	@Override
	public void transfer(int investId) {
		// TODO Auto-generated method stub
		Invest invest=new Invest();
		invest.setInvestid(investId);
		invest.setIstransfer(true);
		investMapper.updateByPrimaryKeySelective(invest);
	}

	@Override
	public void update(Invest invest) {
		// TODO Auto-generated method stub
		investMapper.updateByPrimaryKey(invest);
	}
	@Override
	public List findAllInvest(PageBean pageBean, int userinfoid) {
		// TODO Auto-generated method stub
		InvestExample example=new InvestExample();
		example.setOrderByClause("investid DESC");
		Criteria criteria=example.createCriteria();
		/* criteria.andIstransferEqualTo(false); */
		criteria.andUserinfoidEqualTo(userinfoid);
		pageBean.setCount((int)investMapper.countByExample(example));
		return investMapper.selectByExample(example, new RowBounds(pageBean.getOffset(), pageBean.getLimit()));
	}
	
	//admin

	@Override
	public List<Loandisplay> findAllLoanDisplayByadmin(PageBean pb) {
		pb.setCount(loandisplayMapper.countByExample(null));
		return loandisplayMapper.selectByExample(null,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

}

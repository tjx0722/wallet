package com.woniu.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.InvestMapper;
import com.woniu.dao.LoandisplayMapper;
import com.woniu.dao.RepayMapper;
import com.woniu.domain.Invest;
import com.woniu.domain.InvestExample;
import com.woniu.domain.InvestExample.Criteria;
import com.woniu.domain.Loandisplay;
import com.woniu.domain.LoandisplayExample;
import com.woniu.domain.Loantime;
import com.woniu.domain.PageBean;
import com.woniu.domain.Repay;
import com.woniu.service.IInvestService;

@Service
public class InvestServiceImpl implements IInvestService {

	@Resource
	private LoandisplayMapper loandisplayMapper;
	@Resource
	private InvestMapper investMapper;
	@Resource
	private RepayMapper repayMapper;
	
	@Override
	public List<Loandisplay> findAllLoadDisplay(PageBean pb) {
		LoandisplayExample example=new LoandisplayExample();
		com.woniu.domain.LoandisplayExample.Criteria criteria = example.createCriteria();
		criteria.andIsfinishedEqualTo(false);
		criteria.andIsdeadEqualTo(false);
		pb.setCount(loandisplayMapper.countByExample(example));
		return loandisplayMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
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
	public List<Invest> findInvested(Integer userinfoid, PageBean pb) {
		InvestExample example = new InvestExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserinfoidEqualTo(userinfoid);
		criteria.andIstransferEqualTo(false);
		pb.setCount(investMapper.countByExample(example));
		return investMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public List<Invest> findAllLoadDisplay(Integer userinfoid, PageBean pb, String sort, String order) {
		InvestExample example = new InvestExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserinfoidEqualTo(userinfoid);
		criteria.andIstransferEqualTo(false);
		pb.setCount(investMapper.countByExample(example));
		switch(sort) {
			case "paytime":
				example.setOrderByClause("deadtime "+order.toUpperCase());
				break;
			case "investamount":
				example.setOrderByClause("investamount "+order.toUpperCase());
				break;
		}
		return investMapper.selectByExample(example,new RowBounds(pb.getOffset(), pb.getLimit()));
	}

	@Override
	public void insert(Invest invest) {
		investMapper.insert(invest);
		Integer loandisplayid = invest.getLoandisplayid();
		Loandisplay loandisplay = loandisplayMapper.selectByPrimaryKey(loandisplayid);
		//先获取期数
		int loantime = loandisplay.getLoanapply().getLoantime().getLoantime();
		double investcount = loandisplay.getInvestcount();
		double loanamount = loandisplay.getLoanapply().getLoanamount();
		
		//判断是否募集够资金
		if(investcount==loanamount) {
			//设置loandisplay为已完成
			loandisplay.setIsfinished(true);
			loandisplayMapper.updateByPrimaryKey(loandisplay);
			
			//获取利率
			double loanrate = loandisplay.getLoanapply().getLoanrate().getLoanrate();
			
			//根据期数生成多个偿还表
			int loanapplyid=loandisplay.getLoanapplyid();
			int userinfoid = loandisplay.getLoanapply().getUserinfoid();
			double restamount=loanamount*(1.0+loanrate)/loantime;
			restamount = (double) Math.round(restamount * 100) / 100;
			Repay repay = new Repay();
			for (int i = 1; i <= loantime; i++) {
				repay.setLoanapplyid(loanapplyid);
				repay.setUserinfoid(userinfoid);
				repay.setRestamount(restamount);
				repay.setIsfinished(false);
				
				//设置以后每隔一月的还款期
				Calendar c = Calendar.getInstance();  
		        c.setTime(new Date());   //设置时间
		        c.add(Calendar.MONTH, i); //月份加1,Calendar.DATE(天),Calendar.HOUR(小时)  
		        Date date = c.getTime(); //结果  
				repay.setRepaytime(date);
				repay.setIsovertime(false);
				repayMapper.insert(repay);
			}
		}
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

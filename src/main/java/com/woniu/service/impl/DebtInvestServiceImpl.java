package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebtinvestMapper;
import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.domain.Debtinvest;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;
import com.woniu.service.IDebtInvestService;
@Service
@Transactional
public class DebtInvestServiceImpl implements IDebtInvestService {
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	@Resource
	private DebtinvestMapper debtinvestMapper;
	
	@Override
	public List<Debttransferdisplay> findUndead() {
		// TODO Auto-generated method stub
		List<Debttransferdisplay> list = debttransferdisplayMapper.findUndead();
		
		return list;
	}
	@Override
	public List<Debtinvest> findAll(PageBean page) {
		// TODO Auto-generated method stub
		List<Debtinvest> list = debtinvestMapper.selectByExample(null,new RowBounds(page.getOffset(),page.getLimit()));
		page.setCount(list.size());
		return list;
	}
	@Override
	public Debttransferdisplay findById(Integer debttransferdisplay) {
		// TODO Auto-generated method stub
		
		return debttransferdisplayMapper.findById(debttransferdisplay);
	}
	@Override
	public void save(Debtinvest debtinvest) {
		// TODO Auto-generated method stub
		debtinvestMapper.insertSelective(debtinvest);
	}

}

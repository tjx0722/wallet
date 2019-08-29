package com.woniu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebtinvestMapper;
import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.Debtinvest;
import com.woniu.domain.DebtinvestExample;
import com.woniu.domain.DebtinvestExample.Criteria;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.Userinfo;
import com.woniu.domain.UserinfoExample;
import com.woniu.service.IDebtInvestService;
@Service
@Transactional
public class DebtInvestServiceImpl implements IDebtInvestService {
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	@Resource
	private DebtinvestMapper debtinvestMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	
	@Override
	public List<Debttransferdisplay> findUndead(PageBean page) {
		// TODO Auto-generated method stub
		List<Debttransferdisplay> list = debttransferdisplayMapper.findUndead(new RowBounds(page.getOffset(),page.getLimit()));
		page.setCount(list.size());
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
//	根据买进用户查询
	@Override
	public List<Debtinvest> findByUserinfo(PageBean page, Userinfo userinfo,Date begin,Date end) {
		// TODO Auto-generated method stub
		DebtinvestExample example=new DebtinvestExample();;
		List<Debtinvest> list =null;
		Criteria criteria = example.createCriteria();
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			UserinfoExample userinfoexample=new UserinfoExample();
			userinfoexample.createCriteria().andUsernameEqualTo(userinfo.getUsername());
			List<Userinfo> users=userinfoMapper.selectByExample(userinfoexample);
			List<Integer> ids=new ArrayList<Integer>();
			if(users.size()!=0) {
				for (Userinfo userinfoSelect : users) {
					ids.add(userinfoSelect.getUserinfoid());
				}
				criteria.andUserinfoidIn(ids);
				
			}
		}
		if(!begin.equals(new Date(0))&&!end.equals(new Date(0))) {
			criteria.andPaytimeBetween(begin,end);
			
		}else if(begin.equals(new Date(0))&&!end.equals(new Date(0))) {
			criteria.andPaytimeLessThanOrEqualTo(end);
		}else if(!begin.equals(new Date(0))&&end.equals(new Date(0))) {
			criteria.andPaytimeGreaterThanOrEqualTo(begin);
		}
		list = debtinvestMapper.selectByExample(example,new RowBounds(page.getOffset(),page.getLimit()));
		page.setCount(list.size());
		return list;
	}
//	通过债权转让用户查询
	@Override
	public List<Debtinvest> findByDebttransfer(PageBean page, Userinfo userinfo,Date begin,Date end) {
		// TODO Auto-generated method stub
		Map map = getMap(userinfo,begin,end);
		List<Debtinvest> debtinvests = debtinvestMapper.findByDebttransfer(map);
		page.setCount(debtinvests.size());
		return debtinvests;
	}
//	通过借款人查询
	@Override
	public List<Debtinvest> findByLoanapply(PageBean page, Userinfo userinfo,Date begin,Date end) {
		// TODO Auto-generated method stub
		Map map = getMap(userinfo,begin,end);
		List<Debtinvest> debtinvests = debtinvestMapper.findByLoanapply(map);
		page.setCount(debtinvests.size());
		return debtinvests;
		
	}
//	封装查询条件
	public Map getMap(Userinfo userinfo,Date begin,Date end) {
		Map map=new HashMap();
		List<Integer> ids=null;
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			UserinfoExample userinfoexample=new UserinfoExample();
			userinfoexample.createCriteria().andUsernameEqualTo(userinfo.getUsername());
			List<Userinfo> users=userinfoMapper.selectByExample(userinfoexample);
			if(users.size()!=0) {
				for (Userinfo userinfoSelect : users) {
					ids=new ArrayList<Integer>();
					ids.add(userinfoSelect.getUserinfoid());
				}
			}
			
		}
		map.put("ids",ids);
		if(!begin.equals(new Date(0))&&!end.equals(new Date(0))) {
			map.put("begin", begin);
			map.put("end", end);
			
			
		}else if(begin.equals(new Date(0))&&!end.equals(new Date(0))) {
			map.put("end", end);
		}else if(!begin.equals(new Date(0))&&end.equals(new Date(0))) {
			map.put("begin", begin);
		}
		return map;
	}
	
}

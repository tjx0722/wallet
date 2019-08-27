package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebtinvestMapper;
import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.Debtinvest;
import com.woniu.domain.DebtinvestExample;
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
	public List<Debtinvest> findAll(PageBean page,Userinfo userinfo,Debtinvest debtinvest) {
		// TODO Auto-generated method stub
		DebtinvestExample example=null;
		if(userinfo.getUsername()!=null&&!userinfo.getUsername().equals("")) {
			UserinfoExample userinfoexample=new UserinfoExample();
			userinfoexample.createCriteria().andUsernameEqualTo(userinfo.getUsername());
			List<Userinfo> users=userinfoMapper.selectByExample(userinfoexample);
			if(users.size()!=0) {
				Userinfo user=users.get(0);
				example=new DebtinvestExample();
				example.createCriteria().andUserinfoidEqualTo(user.getUserinfoid());
			}
		}
		
		List<Debtinvest> list = debtinvestMapper.selectByExample(example,new RowBounds(page.getOffset(),page.getLimit()));
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

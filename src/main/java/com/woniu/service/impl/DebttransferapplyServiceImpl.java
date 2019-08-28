package com.woniu.service.impl;

import java.util.Calendar;
import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferapplyMapper;
import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.dao.InvestMapper;
import com.woniu.dao.ServicechargeMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.Debttransferapply;
import com.woniu.domain.DebttransferapplyExample;
import com.woniu.domain.DebttransferapplyExample.Criteria;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.PageBean;
import com.woniu.domain.Servicecharge;
import com.woniu.domain.Userinfo;
import com.woniu.service.IDebttransferapplyService;

@Service
@Transactional
public class DebttransferapplyServiceImpl implements IDebttransferapplyService {
	@Resource
	private DebttransferapplyMapper debttransferapplyMapper;
	@Resource
	private ServicechargeMapper servicechargeMapper;
	@Resource
	private InvestMapper investMapper;
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	@Override
	public List findAll(PageBean pageBean) {
		// TODO Auto-generated method stub
		DebttransferapplyExample example=new DebttransferapplyExample();
		example.setOrderByClause("debttransferapplyid DESC");
		Criteria criteria=example.createCriteria();
		criteria.andCheckedEqualTo(false);
		criteria.andIspassEqualTo(false);
		pageBean.setCount((int)debttransferapplyMapper.countByExample(example));
		return debttransferapplyMapper.selectByExample(example, new RowBounds(pageBean.getOffset(), pageBean.getLimit()));
	}

	@Override
	public void add(int investId,int userinfoid) {
		// TODO Auto-generated method stub
		Debttransferapply debttransferapply=new Debttransferapply();
		debttransferapply.setInvestid(investId);
		debttransferapply.setApplytime(new Date());
		debttransferapply.setUserinfoid(userinfoid);
		debttransferapply.setChecked(false);
		
		double investamount=investMapper.selectByPrimaryKey(investId).getInvestamount();
		List<Servicecharge> list=servicechargeMapper.selectByExample(null);
		double servicecharge=0;
		int servicechargeid=0;
		for (Servicecharge s:list) {
			if (s.getServicetype().equals("债权转让")) {
				servicechargeid=s.getServicechargeid();
				servicecharge=(s.getChargerate())*investamount;
			}
		}
		debttransferapply.setServicecharge(servicecharge);
		debttransferapply.setServicechargeid(servicechargeid);
		debttransferapplyMapper.insert(debttransferapply);
	}

	@Override
	public Debttransferapply get(int investId, int userinfoid) {
		// TODO Auto-generated method stub
		Debttransferapply debttransferapply=new Debttransferapply();
		debttransferapply.setInvestid(investId);
		debttransferapply.setApplytime(new Date());
		debttransferapply.setUserinfoid(userinfoid);
		debttransferapply.setChecked(false);
		
		double investamount=investMapper.selectByPrimaryKey(investId).getInvestamount();
		Userinfo userinfo=userinfoMapper.selectByPrimaryKey(userinfoid);
		debttransferapply.setUserinfo(userinfo);
		List<Servicecharge> list=servicechargeMapper.selectByExample(null);
		double servicecharge=0;
		int servicechargeid=0;
		for (Servicecharge s:list) {
			if (s.getServicetype().equals("债权转让")) {
				servicechargeid=s.getServicechargeid();
				servicecharge=(s.getChargerate())*investamount;
			}
		}
		debttransferapply.setServicecharge(servicecharge);
		debttransferapply.setServicechargeid(servicechargeid);
		return debttransferapply;
	}

	@Override
	public void check(int debttransferapplyid) {
		// TODO Auto-generated method stub
		Debttransferapply debttransferapply=new Debttransferapply();
		debttransferapply.setDebttransferapplyid(debttransferapplyid);
		debttransferapply.setChecked(true);
		debttransferapplyMapper.updateByPrimaryKeySelective(debttransferapply);
		Debttransferdisplay debttransferdisplay=new Debttransferdisplay();
		Date date=new Date();
		debttransferdisplay.setDisplaytime(date);
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, 3);
		date=calendar.getTime();
		debttransferdisplay.setDeadtime(date);
		debttransferdisplay.setIsfinished(false);
		debttransferdisplay.setIsdead(false);
		debttransferdisplay.setDebttransferapplyid(debttransferapplyid);
		debttransferdisplayMapper.insert(debttransferdisplay);
	}

	@Override
	public void pass(int debttransferapplyid) {
		// TODO Auto-generated method stub
		Debttransferapply debttransferapply=debttransferapplyMapper.selectByPrimaryKey(debttransferapplyid);
		debttransferapply.setIspass(true);
		debttransferapplyMapper.updateByPrimaryKeySelective(debttransferapply);
	}
}

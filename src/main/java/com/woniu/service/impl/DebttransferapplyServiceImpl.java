package com.woniu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.dao.DebttransferapplyMapper;
import com.woniu.dao.InvestMapper;
import com.woniu.dao.ServicechargeMapper;
import com.woniu.domain.Debttransferapply;
import com.woniu.domain.Servicecharge;
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
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return debttransferapplyMapper.selectByExample(null);
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
}

package com.woniu.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.woniu.dao.DebttransferdisplayMapper;
import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.DebttransferapplyExample;
import com.woniu.domain.Debttransferdisplay;
import com.woniu.domain.DebttransferdisplayExample;
import com.woniu.domain.DebttransferdisplayExample.Criteria;
import com.woniu.domain.Userinfo;

//@Component
public class CheckService {
	@Resource
	private DebttransferdisplayMapper debttransferdisplayMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	@Scheduled(cron="0 1-59 * * * ? ")
	public void checkIsDead() {
		DebttransferdisplayExample example=new DebttransferdisplayExample();
		Criteria createCriteria = example.createCriteria(); 
		createCriteria.andIsdeadEqualTo(false);
		createCriteria.andIsfinishedEqualTo(false);
		List<Debttransferdisplay> list=debttransferdisplayMapper.selectByExample(example);
		for (Debttransferdisplay d:list) {
			Date date=d.getDeadtime();
			Date now=new Date();
			if (date.before(now)) {
				d.setIsdead(true);
				debttransferdisplayMapper.updateByPrimaryKey(d);
			}
		}
		
	}
	
	@Scheduled(cron="0 0 5/23 * * ? ")
	public void resetChance() {
		List<Userinfo> list=userinfoMapper.selectByExample(null);
		for (Userinfo userinfo:list) {
			userinfo.setChance(3);
			userinfoMapper.updateByPrimaryKeySelective(userinfo);
		}
	}
}

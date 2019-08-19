package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.dao.UserinfoMapper;
import com.woniu.domain.PageBean;
import com.woniu.service.IUserinfoService;
@Service
public class UserinfoServiceImpl implements IUserinfoService {
@Resource
private UserinfoMapper userinfoMapper;
	@Override
	public List findAll(PageBean pagebean) {
		// TODO Auto-generated method stub
		List list=userinfoMapper.selectByExample(null,new RowBounds(pagebean.getOffset(), pagebean.getLimit()));
		int count=userinfoMapper.countByExample(null);
		pagebean.setCount(count);	
		return list;
	}

}

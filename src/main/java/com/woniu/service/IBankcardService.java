package com.woniu.service;

import java.util.List;

import com.woniu.domain.Bankcard;
import com.woniu.domain.PageBean;


public interface IBankcardService {
	public List findAll(PageBean pagebean);
    public int delete(Integer bankcardid);
	public void deleteBatch(Integer[] bankcardid);
	public void save(Bankcard bankcard);
	public void update(Bankcard bankcard);
	public Bankcard findById(Integer bankcardid);
}

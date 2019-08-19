package com.woniu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.domain.PageBean;

public interface IUserinfoService {
    public List findAll(PageBean pagebean);
}

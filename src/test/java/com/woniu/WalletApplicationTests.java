package com.woniu;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.domain.User;
import com.woniu.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationTests {
	@Resource
	private IUserService service;
	
	@Test
	public void test1() {
		List<User> list = service.findAll();
		for (User u : list) {
			System.out.println(u);
		}
	}

}

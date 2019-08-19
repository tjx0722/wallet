package com.woniu;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.domain.Loantime;
import com.woniu.service.IDebitService;
import com.woniu.domain.User;
import com.woniu.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationTests {

	@Resource
	private IDebitService debitServiceImpl;
	@Resource
	private IUserService service;
	
	@Test
	public void test1() {
		List<User> list = service.findAll();
		for (User u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testName() throws Exception {
		List<Loantime> list = debitServiceImpl.findAllLoantime();
		for (Loantime loantime : list) {
			System.out.println(loantime.getLoantime());
		}
	}
}

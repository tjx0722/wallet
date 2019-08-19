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

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationTests {

	@Resource
	private IDebitService debitServiceImpl;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testName() throws Exception {
		List<Loantime> list = debitServiceImpl.findAllLoantime();
		for (Loantime loantime : list) {
			System.out.println(loantime.getLoantime());
		}
	}
}

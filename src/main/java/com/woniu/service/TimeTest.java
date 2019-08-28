package com.woniu.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTest {
	@Scheduled(cron="0/3 * * * * ?")
	public void sendSms() {
		System.out.println("给你发短信");
	}
}

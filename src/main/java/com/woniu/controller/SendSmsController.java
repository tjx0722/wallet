package com.woniu.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.util.Test;


@RestController
public class SendSmsController {
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	RedisAutoConfiguration d;
	
	@RequestMapping("/sendSms")
	public String sendSms(String phone,HttpSession session) {
		System.out.println("====="+redisTemplate);
		
		Random random = new Random();
		String number = random.nextInt(9999)+"";
		System.out.println("number is "+phone+"   "+number);
		String s =  Test.send(phone, number);
		// map.put("number", number);
		redisTemplate.opsForValue().set(phone, number);
		redisTemplate.expire(phone, 60, TimeUnit.SECONDS);
		return "您的短信已经发送成功，请到手机上查看";
	}
}

package com.woniu.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;

public class Test {
	public static String send(String phone,String number) {
	    String host = "https://dxyzm.market.alicloudapi.com";
	    String path = "/chuangxin/dxjk";
	    String method = "POST";
	    String appcode = "8b24147c27ca44f183ac3571ec758649";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
//	    Random random = new Random();
//		String number = random.nextInt(9999)+"";
		System.out.println(number);
	    querys.put("content", "【创信】你的验证码是："+number+"，3分钟内有效！");
            //测试可用短信模板：【创信】你的验证码是：#code#，3分钟内有效！，如需自定义短信内容或改动任意字符，请联系旺旺或QQ：726980650进行申请。
	    querys.put("mobile", phone);
	    Map<String, String> bodys = new HashMap<String, String>();


	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	   return number +"..."+phone;
	}
}

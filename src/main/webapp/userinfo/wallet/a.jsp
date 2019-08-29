<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="app" class="panel panel-default">
	  <div class="panel-heading">
	     <h3 class="panel-title" align="center">我的钱包</h3>
	  </div>
	
	   <div>
       	<table align="center">
       		<tr border="1">
       			<td >钱包id</td>
       			<td>${wallet.walletid }</td>
       		</tr>
       		<tr border="1" >
       			<td>余额</td>
       			<td>${wallet.balance }</td>
       		</tr>
       		<tr border="1">
       			<td>欠款</td>
       			<td>${wallet.debt }</td>
       		</tr>
    		
       	</table>
       <form action="/userinfo/wallet/bankcard/skip">
              <input  type="hidden" name="walletid" value="${wallet.walletid }"/>
             <button class="btn btn-default" type="submit" >我的银行卡</button>
       </form>
       </div>
	  </div>
 
</body>
  <script type="text/javascript">
	window.onload=function(){
		var vm=new Vue({
			el:"#app",
			data:{
				json:"",
				userinfoid:${wallet.userinfoid },
				investamount:"",
				restcount:${wallet },
				msg:""
			},
			methods:{
			}	
			
		});
	}
</script>  
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
<script>
	$(function(){
		$('#win').hide();
	})

	function register(){
		$('#win').show();
		$('#win').window({   
		    width:600,   
		    height:400,   
		    modal:true  
		}); 
	}

	function sendSms(){
		var mobile = $("input[name=phone]").val();
		$.get("sendSms",{mobile:mobile},function(json){
			console.log(json);
			$("#sp").html(json);
		});
	}
</script>
</head>
<body>
	<div id="win" class="text-center" >
		<form action="/authorityModule/save" method="post" style="margin-top:60px">
		<table>
		<tr align-text="center">
			<td>账户</td>
			<td><input type="text" name="account" style="margin-top:10px"></td>
		</tr>
		<tr align-text="center">
			<td>密码：</td>
			<td><input type="text" name="password" style="margin-top:10px"></td>
		</tr>
		<tr align-text="center">
			<td>电话：</td>
			<td><span id="sp"></span>
			<input type="text" name="phone" style="margin-top:10px"></td>
		</tr>
		<tr align-text="center">
			<td colspan="2"><INPUT TYPE="button" onclick="sendSms()" value="发送验证码到手机"></td>
		</tr>
		<tr align-text="center">
			<td>确认验证码:</td>
			<td><INPUT TYPE="text" NAME="number" style="margin-top:10px"></td>
		</tr>
		<tr align-text="center">
			<td colspan="2">(此验证码60秒之内有效)</td>
		</tr>
		<tr align-text="center">
			<td>邮箱：</td>
			<td><input type="text" name="email" style="margin-top:10px"></td>
		</tr>
		<tr align-text="center">
			<td colspan="2"><button style="margin-top:10px">register</button></td>
		</tr>
		</table>
		</form>
	</div>  
	
	<div class="container">
	   <div class="jumbotron">
	        <h1>Wallet小额贷款系统！</h1>
	        <!-- <p><a class="btn btn-primary btn-lg" role="button">
	        注册</a>
	      </p> -->
	    <button onclick="location.href='/authorityModule/GLYlogin.jsp'">Login</button>
		|
		<button onclick="register()">register</button>
	   </div>
	</div>
	
	<!-- <div class="col-md-10 text-center" style="margin-top:10px">
		<span class="h2">Wallet小额贷款系统</span>
	</div> -->
	<!-- <div class="col-md-2 text-right"  style="margin-top:10px">
		<button onclick="location.href='/authorityModule/login.jsp'">login</button>
		|
		<button onclick="location.href='/authorityModule/GLYlogin.jsp'">Login</button>
		|
		<button onclick="register()">register</button>
	</div> -->
		<!-- <ul class="nav nav-tabs col-md-12" style="margin-top:30px">
	         <li class="col-md-2" style="text-align:center"><a href="http://www.baidu.com" target="iframe">个人中心</a></li>
	         <li class="col-md-2" style="text-align:center"><a href="/debit/findAllLoantimeAndLoanrate" target="iframe">借贷</a></li>
	         <li class="col-md-2" style="text-align:center"><a href="##">投资</a></li>
	         <li class="col-md-2" style="text-align:center"><a href="##">债权转让</a></li>
	         <li class="col-md-2" style="text-align:center"><a href="##">债权投资</a></li>
	     </ul> -->
	 
	<!-- <div>
		<iframe id="iframe" name="iframe" src="" width="100%" height="400px">
		  
		</iframe>
	</div> -->
	
	
</body>
</html>
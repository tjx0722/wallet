<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	/* $(function(){
		$.get("/authorityModule/findByUserid")
	}) */
</script>
</head>
<body>
	<TABLE border="1" width="100%">
<TR align="center">
	<TD>用户id</TD>
	<TD>账户</TD>
	<TD>密码</TD>
	<TD>电话</TD>
	<TD>邮箱</TD>
	<TD>修改</TD>
	<TD>完善个人资料</TD>
</TR>
<TR align="center">
	<TD>${user.userid}</TD>
	<TD>${user.account}</TD>
	<TD>${user.password}</TD>
	<TD>${user.phone}</TD>
	<TD>${user.email}</TD>
	<TD><button onclick="location.href='/authorityModule/editPage?userid=${user.userid}'">修改</button></TD>
	<TD><button onclick="location.href=''">完善资料</button></TD>
</TR>
</body>
</html>
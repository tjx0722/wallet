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
		$.get("/userinfo/findById")
	}) */
</script>
</head>
<body>
	<TABLE border="1" width="100%">
<TR align="center">
	
	<TD>用户详情表id</TD>
	<TD>用户id</TD>
	<TD>用户名</TD>
	<TD>住址</TD>
	<TD>籍贯</TD>
	<TD>头像</TD>
	<TD>昵称</TD>
	<TD>工作</TD>
	<TD>学历</TD>
	<TD>生日</TD>
	<TD>性别</TD>
	<TD>工资</TD>
	<TD>婚否</TD>
	<TD>审核是否通过</TD>
</TR>
<TR align="center">
	<TD>${userinfo.userinfoid}</TD>
	<TD>${userinfo.userid}</TD>
	<TD>${userinfo.password}</TD>
	<TD>${user.phone}</TD>
	<TD>${user.email}</TD>
	<TD><button onclick="location.href='/authorityModule/editPage?userid=${user.userid}'">修改</button></TD>
	<TD><button onclick="location.href='/userinfo/b.jsp?userid=${user.userid}'">完善资料</button></TD>
	<TD><button onclick="location.href='/userinfo/c.jsp?userid=${user.userid}'">完善资料</button></TD>
</TR>
</body>
</html>
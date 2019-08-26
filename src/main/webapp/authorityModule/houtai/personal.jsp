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

<TABLE border="0" width="100%" cellpadding="0" cellspacing="0" >
	<TR align="center" style="background-color:black;color:white">
		<TD style="border-top-left-radius:10px">用户id</TD>
		<TD>账户</TD>
		<TD>密码</TD>
		<TD>电话</TD>
		<TD>邮箱</TD>
		<TD>修改</TD>
		<TD style="border-top-right-radius:10px">完善个人资料</TD>
	</TR>
	<TR align="center" height="50px" style="background-color:grey;color:white">
		<TD>${user.userid}</TD>
		<TD>${user.account}</TD>
		<TD>${user.password}</TD>
		<TD>${user.phone}</TD>
		<TD>${user.email}</TD>
		<TD><button onclick="location.href='/authorityModule/editPage?userid=${user.userid}'">修改</button></TD>
		<TD><button onclick="location.href='/userinfo/b.jsp?userid=${user.userid}'">完善资料</button></TD>
	<TD><button onclick="location.href='/userinfo/skip?userid=${user.userid}'">查看个人资料</button></TD>
	</TR>
</TABLE>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>修改个人信息</h2>
	<form action="/authorityModule/updateUser" method="post" style="margin-top:60px">
		<table>
		<input type="hidden" name="userid" style="margin-top:10px" value="${user.userid}">
		<tr align-text="center">
			<td>账户</td>
			<td><input type="text" name="account" readonly="readonly" style="margin-top:10px" value="${user.account}"></td>
		</tr>
		<tr align-text="center">
			<td>密码：</td>
			<td><input type="text" name="password" style="margin-top:10px" value="${user.password}"></td>
		</tr>
		<tr align-text="center">
			<td>电话：</td>
			<td><span id="sp"></span>
			<input type="text" name="phone" style="margin-top:10px" value="${user.phone}"></td>
		</tr>
		<tr align-text="center">
			<td>邮箱：</td>
			<td><input type="text" name="email" style="margin-top:10px" value="${user.email}"></td>
		</tr>
		<tr align-text="center">
			<td colspan="2"><button style="margin-top:10px">go</button></td>
		</tr>
		</table>
	</form>
</body>
</html>
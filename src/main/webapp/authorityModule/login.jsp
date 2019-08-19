<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户登录界面！</h2>
	<form action="/authorityModule/login" method="post">
		<table>
			<tr>
				<td style="text-align:center">账户：</td>
				<td><input type="text" name="account"></td>
			</tr>
			<tr>
				<td style="text-align:center">密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<!-- <tr>
				<td style="text-align:center">确认密码：</td>
				<td><input type="password" name="password1"></td>
			</tr> -->
			<tr>
				<td colspan="2"><button>login</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script>
 $(function(){ 
	 /*$(function() {*/
	 	/* var aa = false; */
		$("input[name=account]").blur(function() {
			if($(this).val().length < 1) {
				$(this).next().html("<font color='red'>name不能为空</font>");
				/* aa = false; */
			} else {
				$(this).next().html("<font color='green'>√<font>");
				/* aa = true; */
			}
		});


		/* $("form:eq(0)").submit(function() {
			// 在事件处理函数中，如果返回false，则就当这件事没有发生过！
			alert("11111");
		});  */
	});
</script>
</head>
<body>
	<h2>管理员登录界面！</h2>
	<form action="/authorityModule/adminlogin" method="post">
		<table>
			<tr>
				<td style="text-align:center">账户：</td>
				<td><input type="text" name="account"><span></span></td>
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
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>借贷人信息</title>
</head>
<body>
	<div style="width: 100%;background-color:gray;height: 200px"></div>
	<div style="width: 500px;margin: auto;text-align: center;">
		借贷人名称：${invest.loandisplay.loanapply.userinfo.username }<br/>
		籍贯：${invest.loandisplay.loanapply.userinfo.nativeplace }<br/>
		工作：${invest.loandisplay.loanapply.userinfo.userjob }<br/>
		学历：${invest.loandisplay.loanapply.userinfo.degree }<br/>
		工资：${invest.loandisplay.loanapply.userinfo.salary }<br/>
		<input type="button" value="SALE" onclick="">
		
	</div>
</body>
</html>

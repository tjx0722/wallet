<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>账单信息</title>
</head>
<body>
	<div style="width: 100%;background-color:gray;height: 200px"></div>
	<div style="width: 500px;margin: auto;text-align: center;">
		贷款金额：${invest.loandisplay.loanapply.loanamount }<br/>
		申请时间：${invest.loandisplay.loanapply.applytime }<br/>
		申请原因：${invest.loandisplay.loanapply.reason }<br/>
		还款方式：${invest.loandisplay.loanapply.loantime.loantime }<br/>
		还款利率：${invest.loandisplay.loanapply.loanrate.loanrate }<br/>
		<input type="button" value="SALE" onclick="">
	</div>
</body>
</html>

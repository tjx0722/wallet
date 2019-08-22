<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>债权详情</title>
<script src="<%=basePath %>js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<div style="width:100%;height:100px;float:left;">
	债权总额：
		${invest.investamount }
	</div>
	<div style="width:100%;height:100px;float:left;">
	利率：
		${loanapply.servicecharge }
	</div>
	<div style="width:100%;height:100px;float:left;">
	借款开始时间：
		${loandispaly.displaytime }
	</div>
	<div style="width:100%;height:100px;float:left;">
	借款总期数：
		${loantime.loantime}
	</div>
	<div style="width:100%;height:100px;float:left;">
	借款人还款记录：
		<%-- <table class="table text-center">
			<tr>
				<td>还款日期</td>
			</tr>
			<c:forEach items="repays" var="repay">
				<tr>
					<td>${repay.actualrepaytime }</td>
				</tr>
			</c:forEach>
		</table> --%>
	</div>
	<div style="width:100%;height:100px;float:left;">
	借款人信息：
		姓名：${userinfo. username}
		工作：${userinfo. userjob}
		学历：${userinfo. degree}
	</div>
	<div style="width:100%;height:100px;float:left;">
	借款理由：
		${loanapply.reason }
	</div>
	<button>我要投资该笔债权</button>
</div>
</body>
</html>
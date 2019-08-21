<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	债权总额：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	利率：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	开始时间：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	总期数：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	剩余期数：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	借款人还款记录：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	借款人信息：
	</div>
	<div style="width:100%;height:100px;border:1px solid;float:left;">
	借款理由：
	</div>
	<button>我要投资该笔债权</button>
</div>
</body>
</html>
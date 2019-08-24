<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="app" class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">钱包详细信息</h3>
	  </div>
	  <div class="panel-body">
	   <div>
       	<table>

       	
       		<tr>
       			<th>银行卡表id卡</th>
       			<th>${bankcard.bankcardid }</th>
       		</tr>
       		<tr>
       			<th>银行卡号</th>
       			<th>${bankcard.bankcardnum }</th>
       		</tr>
       		<tr>
       			<th>银行名称</th>
       			<th>${bankcard.bankcardname }</th>
       		</tr>
       		
       		<tr>
       			<th>钱包id</th>
       			<th>${bankcard.walletid }</th>
       		</tr>
       		
       	</table>
       
       </div>
	  </div>
	</div>  
</body>
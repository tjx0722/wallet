<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$(document).ready(function() {
		$("#btn").click(function() {
			 location.href = "/debit/test2.jsp"
		})
	})
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="height: 100px; background-color: #ccffff" align="center">
		<h3>欢迎用户 ${userinfo.username }</h3>
		<h1>请 核 对 您 的 订 单</h1>
	</div>
	<div data-options="region:'center'"
		style="padding: 50px; background: #eee;">
		<table class="easyui-datagrid" data-options="fitColumns:true" style="align-self: center">
			<thead>
				<tr>
					<th data-options="field:'code'" width="100">数据类型</th>
					<th data-options="field:'name'" width="100">订单详情</th>
				</tr>
			</thead>
			<tbody>
				<tr >
					<td >申请时间</td>
					<td>${datetime}</td>
				</tr>
				<tr>
					<td>贷款人姓名</td>
					<td>${userinfo.username }</td>
				</tr>
				<tr>
					<td>贷款金额</td>
					<td>${loanapply.loanamount }</td>
				</tr>
				<tr>
					<td>申请原因</td>
					<td>${loanapply.reason}</td>
				</tr>
				<tr>
					<td>分期月数</td>
					<td>${loantime}</td>
				</tr>
				<tr>
					<td>手续费</td>
					<td>${loanapply.servicecharge}</td>
				</tr>
			</tbody>
		</table>
		<div align="right">
			<button id="btn" class="easyui-linkbutton"
				data-options="iconCls:'icon-add'">提交</button>
		</div>
	</div>

</body>
</html>


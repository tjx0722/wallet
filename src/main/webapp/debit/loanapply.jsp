<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
	$.ajaxSetup({
		global : true,
		cache : false,
		async : false
	});

	$(function() {
		$('#dg').datagrid({
			url : '',
			fitColumns : true,
			striped : true,
			title : '借款页面'
			onLoadSuccess : function(index, field, value) {
				$('.easyui-linkbutton').linkbutton({});
			}
		});
	})
	$('#cc').combo({
		required : true,
		multiple : true
	});
</script>
</head>
<body>
	<!-- <table id="dg"></table> -->
<body class="easyui-layout">
	<div data-options="region:'north',split:true"
		style="height: 100px; background-color: #ccffff" align="center">
		<h1>借 款 界 面</h1>
	</div>
	<div data-options="region:'center'"
		style="padding: 50px; background: #eee;">
		<form id="ff" method="post">
			<div style="height: 40px" align="center">
				<div style="width: 30%; float: left" align="center">
					<label for="name">贷款金额:</label>
				</div>
				<div style="width: 70%; float: left; text-align: 40px">
					<input class="easyui-slider" value="0" style="width: 300px"
						data-options="showTip:true,max:100000,rule:[0,'|',2500,'|',5000,'|',7500,'|',10000]" />
				</div>
			</div>
			<br>
			<div>
				<div style="width: 30%; float: left" align="center">
					<label for="email">贷款利率</label>
				</div>
				<div style="width: 70%; float: left" align="center">
					<select id="cc" class="easyui-combobox" name="dept"
						style="width: 200px;">
						<c:forEach items="${loanrates }" var="rate">
						<option value="aa">${rate.loanrate *100}%</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<br>
			<div style="text-align: center;">
				<div style="width: 30%; float: left" align="center">
					<label for="email">贷款 时间</label>
				</div>
				<div style="width: 70%; float: left" align="center">
					<select id="cc" class="easyui-combobox" name="dept"
						style="width: 200px;">
						<c:forEach items="${Loantimes}" var="time">
						<option value="aa">${time.loantime }个月</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div style="width: 100%; float: left" align="right">
				<a id="btn" href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">提交</a>
			</div>
		</form>
	</div>
</body>

</body>
</html>


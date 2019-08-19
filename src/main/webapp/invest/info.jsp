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
	})

</script>
</head>
<body class="easyui-layout">  
    <div data-options="region:'north'" style="height:100px"><h2 align="center" style="line-height: 60px">投资详细信息</h2></div>  
    <div data-options="region:'center'">  
        <div class="easyui-layout" data-options="fit:true">  
            <div data-options="region:'west',collapsed:true" style="width:180px"></div>  
            <div data-options="region:'center'">
            	<table>
            		<tr>
            			<th>借款人姓名</th>
            			<th>苗**</th>
            		</tr>
            		<tr>
            			<th>电话</th>
            			<th>188********</th>
            		</tr>
            		<tr>
            			<th>籍贯</th>
            			<th>中国内蒙古鄂尔多斯</th>
            		</tr>
            		<tr>
            			<th>工作</th>
            			<th>鼓励师</th>
            		</tr>
            		<tr>
            			<th>贷款原因</th>
            			<th>学习</th>
            		</tr>
            		<tr>
            			<th>贷款利率</th>
            			<th>10%</th>
            		</tr>
            		<tr>
            			<th>贷款金额</th>
            			<th>10000元</th>
            		</tr>
            		<tr>
            			<th>已募集金额</th>
            			<th>8000元</th>
            		</tr>
            		<tr>
            			<th>还款期限</th>
            			<th>12个月</th>
            		</tr>
            	</table>
            </div>
            <form action="">
            	投资金额<input name="" /><br>
            	<input type="submit" value="购买">
            </form>  
        </div>  
    </div>  
</body>  
</html>
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

</script>
</head>
<body class="easyui-layout">  
    <div data-options="region:'north'" style="height:100px"><h2 align="center" style="line-height: 60px">投资详细信息</h2></div>  
    <div data-options="region:'center'">  
        <div class="easyui-layout" data-options="fit:true">  
            <div data-options="region:'west',collapsed:true" style="width:180px"></div>  
            <div data-options="region:'center'">
            	<table  id="pg" class="easyui-propertygrid" style="width:800px"  
        data-options="url:'findOneApply',showGroup:true,scrollbarSize:0">
            	</table>
            </div>  
        </div>  
    </div>  
</body>  
</html>
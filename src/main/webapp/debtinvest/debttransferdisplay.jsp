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
<title>债权投资大厅</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
$(function(){
	$('#dg').datagrid({   
	    url:'findUndead', 
	    fitColumns:true,  
	    striped:true,
	    pagination:true,
	    title:'可投资债权',
	    toolbar: '#tb',  
	    columns:[[   
	        {field:'debttransferdisplay',title:'序号',width:100,align:'center'},   
	        {field:'invest',title:'债权金额',width:100,align:'center',formatter: function(value,row,index){
				return value.investamount;
			}},  
	        {field:'displaytime',title:'开始时间',width:100,align:'center'},
	        {field:'deadtime',title:'截止日期',width:100,align:'center'},
	        {field:'operate',title:'查询',width:100,align:'center',formatter: function(value,row,index){
				var btns="<a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">详情</a>";
	        	return btns;
				
			}
	        }   
	    ]]   
	});  
	
})

	

</script>
</head>
<body>
<div id="tb">
</div>
<table id="dg"></table>  
</body>
</html>
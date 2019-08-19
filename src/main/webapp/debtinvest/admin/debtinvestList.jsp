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
<title>债权买进</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
$(function(){
	$('#dg').datagrid({   
	    url:'findAll', 
	    fitColumns:true,  
	    striped:true,
	    pagination:true,
	    title:'债权买进列表',
	    toolbar: '#tb',  
	    columns:[[   
	        {field:'debtinvestid',title:'序号',width:100,align:'center'},   
	        {field:'userinfoid',title:'用户id',width:100,align:'center'},   
	        {field:'investamount',title:'投资金额',width:100,align:'center'},  
	        {field:'paytime',title:'投资金额',width:100,align:'center'},
	        {field:'istransfer',title:'是否转让给他人',width:100,align:'center',formatter: function(value,row,index){
				if (value){
					return '已转让';
				} else {
					return '未转让';
				}
			}}, 
	        {field:'servicecharge',title:'手续费',width:100,align:'center'}, 
	        {field:'servicechargeid',title:'手续费型号',width:100,align:'center'},  
	        {field:'debttransferdisplay',title:'债权转让大厅源',width:100,align:'center'},
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
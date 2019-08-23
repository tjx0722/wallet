<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<meta charset="utf-8">
<title>债权列表</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$.ajaxSetup({
		global:true,
		async:false,
		cache:false
	});
	$(function(){
		$('#dg').datagrid({   
		    url:'findAll', 
		    fitColumns:true,
		    striped:true,
		    pagination:true,
		    title:'待审核债权转让申请',
		    columns:[[   
		    	{field:'debttransferapplyid',checkbox:'checkbox',title:'编号',width:100},   
		        {field:'userinfoid',title:'借贷人',width:100,formatter:function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"/debttransferapply/admin/findOneUser/"+row.userinfoid+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详情</a>";
					return btns;
				 }}, 
				{field:'investid',title:'投资表',width:100,formatter:function(value,row,index){
			        	var btns = "<a id=\"btn\" href=\"/debttransferapply/admin/findOneInvest/"+row.investid+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详情</a>";
						return btns;
				}},    
		        {field:'applytime',title:'转让申请时间',width:100},   
		        {field:'servicecharge',title:'手续费',width:100},
		        {field:'servicechargeid',title:'手续费类型',width:100},
				{field:'operate',title:'是否通过',width:100,formatter: function(value,row,index){ 
		        	var btns = "<a id=\"btn\" href=\"javascript:ischeck("+row.debttransferapplyid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">通过审核</a>"; 
					return btns;
				}}
		    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}     
		});  
	});
	function ischeck(debttransferapplyid){
		$.messager.confirm('Confirm','确认通过该申请?',function(r){   
		    if (r){   
			    location.href="/debttransferapply/admin/check/"+debttransferapplyid;
			    alert("审核通过");
		    }
		});
	};
</script>
<body>
	<table id="dg"></table>  
</body>
</html>
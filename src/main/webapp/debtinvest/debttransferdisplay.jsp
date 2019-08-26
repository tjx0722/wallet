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
			{field:'loanrate',title:'利率',width:100,align:'center',formatter: function(value,row,index){
				return row.loanapply.loanrate.loanrate;
			}}, 
			{field:'loantime',title:'期数（月）',width:100,align:'center',formatter: function(value,row,index){
				return row.loanapply.loantime.loantime;
			}}, 
			{field:'loanreason',title:'借款理由',width:100,align:'center',formatter: function(value,row,index){
				return row.loanapply.reason;
			}}, 
	        {field:'displaytime',title:'开始筹标时间',width:100,align:'center',formatter: function (value) {
                var dateMat = new Date(value);
                var year = dateMat.getFullYear();
                var month = dateMat.getMonth()+1;
                var day = dateMat.getDate();
                return  year + "-" + month + "-" + day;
            }},
	        {field:'deadtime',title:'截止筹标日期',width:100,align:'center',formatter: function (value) {
                var dateMat = new Date(value);
                var year = dateMat.getFullYear();
                var month = dateMat.getMonth()+1;
                var day = dateMat.getDate();
                return  year + "-" + month + "-" + day;
            }},
	        {field:'operate',title:'查询',width:100,align:'center',formatter: function(value,row,index){
	        	var btns="<a id=\"btn\" href=\"findById?debttransferdisplay="+row.debttransferdisplay+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">详情</a>";
	        	return btns;
			}
	        }   
	    ]],
	    onLoadSuccess: function(index,field,value){
			$('.easyui-linkbutton').linkbutton({   
			});  
		}      
	});  
	
})

	

</script>
</head>
<body>
<div id="tb">
</div>
<table id="dg" height=750px"></table>  
</body>
</html>
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
		    url:'findAllInvest',  
		    fitColumns:true,
		    striped:true,
		    pagination:true,
		    title:'可转让账单',
		    toolbar: '#tb',
		    columns:[[   
		    	{field:'investid',checkbox:'checkbox',title:'编号',width:100},   
		        {field:'userinfoid',title:'借贷人',width:100},   
		        {field:'investamount',title:'投资金额',width:100},   
		        {field:'paytime',title:'付款时间',width:100},
		        {field:'loandisplayid',title:'具体账单',width:100,formatter:function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"javascript:findOneInvest("+row.loandisplayid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详情</a>";
					return btns;
				 }},
		        {field:'istransfer',title:'是否转让',width:100,formatter:function(value,row,index){
					if(!value){
						return "N";
					}else{
						return "Y";
					}
				}},
				{field:'operate',title:'操作',width:100,formatter: function(value,row,index){ 
		        	var btns = "<a id=\"btn\" href=\"javascript:transfer("+row.investid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">售出</a>"; 
					return btns;
				}}
		    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}     
		});  
	});
	function findOneInvest(loandisplayid){
		$('#win').window('open');
		$.getJSON("findOneInvest",{loandisplayid:loandisplayid},function(json){ 
			
		})
	}; 
</script>
<body>
	<table id="dg"></table>  
	<div id="tb">
		<a href="javascript:deleteBatch()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">转让</a>
	</div>
	<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true,closed:true">  
   	 	借贷账单详情
		<div>  
			<label>贷款金额:</label>  
			<input readonly="readonly" type="text" name="loanamount" id="loanamount" data-options="required:true" />  
		</div>  
		<div>  
			<label>还款方式:</label>  
			<input readonly="readonly" type="text" name="loantimeid" id="loantimeid" data-options="required:true" />  
		</div> 
		<div>  
			<label>贷款利率:</label>  
			<input readonly="readonly" type="text" name="loanrateid" id="loanrateid" data-options="required:true" />  
		</div>
		<div>  
			<label>通过时间:</label>  
			<input readonly="readonly" type="text" name="deadtime" id="deadtime" data-options="required:true" />  
		</div>
	</div>  
</body>
</html>
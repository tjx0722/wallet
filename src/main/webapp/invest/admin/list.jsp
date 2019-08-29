﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		$('#dg')
				.datagrid(
						{
							url : '/invest/admin/findAllLoanDisplay',
							fitColumns : true,
							toolbar : '#tb',
							pageSize : 20,
							striped : true,
							title : '可投资监管列表',
							pagination : true,
							columns : [ [
									{
										field : 'loanamount',
										title : '贷款金额',
										width : 100,
										formatter:function(value,row,index){
											return row.loanapply.loanamount;
										}
									},
									{
										field : 'displaytime',
										title : '审核通过日期',
										width : 100,
										formatter:function(value,row,index){
											var unixTimestamp = new Date(value);    
					                        return unixTimestamp.toLocaleString();
										}
									},
									{
										field : 'deadtime',
										title : '集资截至日期',
										width : 100,
										formatter:function(value,row,index){
											 var unixTimestamp = new Date(value);    
					                         return unixTimestamp.toLocaleString();
										}
									},
									{
										field : 'isfinished',
										title : '是否完成集资',
										width : 100,
										formatter:function(value,row,index){
											 var unixTimestamp = new Date(value);    
					                         return unixTimestamp.toLocaleString();
										}
									},
									{
										field : 'loanrate',
										title : '贷款利率',
										width : 100,
										formatter:function(value,row,index){
											return parseInt(row.loanapply.loanrate.loanrate*100)+"%";
										}
									},
									{
										field : 'investcount',
										title : '已投资金额',
										width : 100,
										formatter:function(value,row,index){
											return row.investcount;
										}
									} ,
									{
										field : 'loantime',
										title : '还款期限（/月）',
										width : 100,
										formatter:function(value,row,index){
											return row.loanapply.loantime.loantime+"个月";
										}
									} ,
									{
										field : 'operate',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"/invest/admin/findLoandisplayById/"
													+ row.loandisplayid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详细信息</a>";
											return btns;
										}
									} ] ],
							onLoadSuccess : function(index, field, value) {
								$('.easyui-linkbutton').linkbutton({});
							}
						});
	})

</script>
</head>
<body>
	<table id="dg"></table>
	${list }
	<div id="tb">
		<form action="">
			排序：
			<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">  
			    <option value="aa">按贷款金额</option>  
			    <option>按贷款利率</option>  
			    <option>按集资截至日期</option>  
			    <option>按已投资金额</option>
			    <option>按还款期限 </option>  
			</select>
			<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">  
			    <option value="aa">从大到小</option>  
			    <option>从小到大</option>  
			</select>
			大于<input type="text">
			小于<input type="text">
			<div class="easyui-linkbutton" data-options="iconCls:'icon-remove'">筛选</div>
		</form>  
	</div>

</body>
</html>
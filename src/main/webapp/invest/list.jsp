<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$(function() {
		$('#dg')
				.datagrid(
						{
							url : '/invest/findAllLoanDisplay',
							fitColumns : true,
							striped : true,
							pagination : true,
							title : '可投资列表',
							toolbar : '#tb',
							pageSize : 20,
							remoteSort:false,
							columns : [ [
									{
										field : 'loanamount',
										title : '贷款金额',
										width : 100,
										formatter:function(value,row,index){
											return row.loanapply.loanamount;
										},
										sortable :true,
										sorter:function (a,b) {
						                   return (a>b?1:-1);
						                }
									},
									{
										field : 'loanrate',
										title : '贷款利率',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return parseInt(row.loanapply.loanrate.loanrate*100)+"%";
										}
									},
									{
										field : 'deadtime',
										title : '集资截至日期',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											 var unixTimestamp = new Date(value);    
					                         return unixTimestamp.toLocaleString();
										}
									},
									{
										field : 'investcount',
										title : '已投资金额',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return row.investcount;
										}
									} ,
									{
										field : 'restcount',
										title : '剩余可投资金额',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return row.loanapply.loanamount-row.investcount;
										}
									} ,
									{
										field : 'loantime',
										title : '还款期限（/月）',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return row.loanapply.loantime.loantime+"个月";
										}
									} ,
									{
										field : 'operate',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"/invest/findLoandisplayById/"
													+ row.loandisplayid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">买买买</a>";
											return btns;
										}
									} ] ],
							onLoadSuccess : function(index, field, value) {
								$('.easyui-linkbutton').linkbutton({});
							}
						});
	});

    function qq(value,name){
        var path="/invest/setselect/"+name+"!"+value;
        $.ajax({url:path,async:false});
        location.reload();
    };
	function clear(){
        var path="/invest/setselect/invest!";
        $.ajax({url:path,async:false});
        location.reload();
    };   

</script>
</head>
<body>
	<input id="ss" class="easyui-searchbox" style="width:300px"  
	        data-options="searcher:qq,prompt:'请输入要筛选的条件',menu:'#mm'"></input>  
	           
	<div id="mm" style="width:120px">  
	    <div data-options="name:'loanrate',iconCls:'icon-ok'">贷款利率（%）</div>  
	    <div data-options="name:'restcount'">剩余可投资金额</div>  
	    <div data-options="name:'loanamount'">贷款金额</div>
	    <div data-options="name:'repaytime'">还款期限（/月）</div>  
	</div>
	<a href="javascript:clear()" class="easyui-linkbutton" data-options="iconCls: 'icon-reload'">清空查询条件</a>  

	<table id="dg"></table>

</body>
</html>
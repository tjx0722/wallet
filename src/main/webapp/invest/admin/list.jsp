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
							remoteSort:false,
							columns : [ [
									{
										field : 'username',
										title : '贷款人',
										width : 100,
										formatter:function(value,row,index){
											return row.loanapply.userinfo.username;
										}
									},
									{
										field : 'operate2',
										title : '查看借贷人详情',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"/invest/admin/findUserinfoById/"
													+ row.loanapply.userinfoid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">查看</a>";
											return btns;
										}
									},
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
					                         return value?'是':'否';
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
	});

    function qq(value,name){
        if(value==""){
			alert("条件不能为空，请重新输入");
        }else{
	        var path="/invest/setselect/"+name+"!"+value;
	        $.ajax({url:path,async:false});
	        location.reload();
        }
    };
	function clear(){
        var path="/invest/setselect/clear!";
        $.ajax({url:path,async:false});
        location.reload();
    };   

</script>
</head>
<body>
	<input id="ss" class="easyui-searchbox" style="width:300px"  
	        data-options="searcher:qq,prompt:'请输入要筛选的条件',menu:'#mm'"></input>  
	           
	<div id="mm" style="width:120px"> 
	    <div data-options="name:'apply',iconCls:'icon-ok'">贷款人</div>
	    <div data-options="name:'loanamount'">贷款金额</div>  
	    <div data-options="name:'loanrate'">贷款利率（%）</div> 
	    <div data-options="name:'loaninvest'">已投资金额</div>  
	    <div data-options="name:'restcount'">剩余可投资金额</div>  
	    <div data-options="name:'repaytime'">还款期限（/月）</div>  
	</div>
	<a href="javascript:clear()" class="easyui-linkbutton" data-options="iconCls: 'icon-reload'">清空查询条件</a>  

	<table id="dg"></table>

</body>
</html>
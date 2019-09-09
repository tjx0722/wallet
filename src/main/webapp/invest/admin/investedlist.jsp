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
	var path="/invest/admin/findAllInvested";
	$(function() {
		$('#dg')
				.datagrid(
						{
							url : path,
							fitColumns : true,
							toolbar : '#tb',
							pageSize : 20,
							striped : true,
							title : '已投资监管列表',
							pagination : true,
							remoteSort:false,
							columns : [ [
									{
										field : 'username',
										title : '投资人',
										width : 100,
										formatter:function(value,row,index){
											return row.userinfo.username;
										}
									},
									{
										field : 'operate1',
										title : '查看投资人详情',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"/invest/admin/findUserinfoById/"
													+ row.userinfoid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">查看</a>";
											return btns;
										}
									},
									{
										field : 'investamount',
										title : '投资金额',
										sortable :true,
										width : 100
									},
									{
										field : 'paytime',
										title : '付款时间',
										width : 100,
										sortable :true,
										formatter:function(value,row,index){
											 var unixTimestamp = new Date(value);    
					                         return unixTimestamp.toLocaleString();
										}
									},
									{
										field : 'loanappyname',
										title : '借贷人',
										width : 100,
										formatter:function(value,row,index){
					                         return row.loandisplay.loanapply.userinfo.username;
										}
									},
									{
										field : 'operate2',
										title : '查看借贷人详情',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"/invest/admin/findUserinfoById/"
													+ row.loandisplay.loanapply.userinfoid +"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">查看</a>";
											return btns;
										}
									},
									{
										field : 'loanrate',
										title : '借贷人贷款利率',
										width : 100,
										formatter:function(value,row,index){
											return parseInt(row.loandisplay.loanapply.loanrate.loanrate*100)+"%";
										}
									},
									{
										field : 'loantime',
										title : '还款期限（/月）',
										width : 100,
										formatter:function(value,row,index){
											return row.loandisplay.loanapply.loantime.loantime+"个月";
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
<<<<<<< HEAD
	
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
=======

    function qq(value,name){
        if(value==""){
			alert("条件不能为空，请重新输入");
        }else{
    		$('#dg').datagrid({
    			url:path,
        		queryParams: {
        			"name": name,
        			"value":value
        		}  
    		});
        }
    };
	function clear(){
		$('#dg').datagrid({
			url:path,
    		queryParams: {
    			"name": "clear"
    		}  
		});
>>>>>>> branch 'master' of git@github.com:tjx0722/wallet.git
    };    
    
</script>
</head>
<body>
	<input id="ss" class="easyui-searchbox" style="width:300px"  
	        data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input>  
	           
	<div id="mm" style="width:120px">  
	    <div data-options="name:'invest',iconCls:'icon-ok'">投资人</div>  
	    <div data-options="name:'apply'">借贷人</div>  
	    <div data-options="name:'investamount'">投资金额</div>
	    <div data-options="name:'loanrate'">贷款利率（%）</div>
	    <div data-options="name:'repaytime'">还款期限（/月）</div>  
	</div>
	<a href="javascript:clear()" class="easyui-linkbutton" data-options="iconCls: 'icon-reload'">清空查询条件</a>  

	<table id="dg"></table>
</body>
</html>
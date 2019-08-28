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
							url : '/invest/findInvested',
							fitColumns : true,
							striped : true,
							pagination : true,
							title : '可投资列表',
							toolbar : '#tb',
							pageSize : 20,
							remoteSort:false,
							columns : [ [
									{
										field : 'loanapply',
										title : '借款人',
										width : 100,
										formatter:function(value,row,index){
											return row.loandisplay.loanapply.userinfo.username.substr(0,1)+"**";
										},
										sortable :true,
										sorter:function (a,b) {
						                   return (a>b?1:-1);
						                }
									},
									{
										field : 'loantime',
										title : '还款周期（月）',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return row.loandisplay.loanapply.loantime.loantime+"个月";
										}
									},
									{
										field : 'paytime',
										title : '投资时间',
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
										field : 'servicecharge',
										title : '手续费',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                }
									},
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
	})

</script>
</head>
<body>
	<table id="dg"></table>
	<div id="tb">
	</div>

</body>
</html>
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
	$.ajaxSetup({
		global : true,
		cache : false,
		async : false
	});

	$(function() {
		$('#dg')
				.datagrid(
						{
							url : '/Loandisplay/findAllLoanapply',
							fitColumns : true,
							toolbar : '#tb',
							pageSize : 20,
							striped : true,
							title : '可投资列表',
							pagination : true,
							columns : [ [
									{
										field : 'username',
										title : '用户名',
										width : 60,
										formatter : function(value, row, index) {
											return row.userinfo.username;
										}
									},
									{
										field : 'loanamount',
										title : '贷款金额',
										width : 60,
										formatter : function(value, row, index) {
											return '￥' + row.loanamount;
										}
									},
									{
										field : 'loanrate',
										title : '贷款利率',
										width : 60,
										formatter : function(value, row, index) {
											return row.loanrate.loanrate * 100
													+ "%";
										}
									},
									{
										field : 'loantime',
										title : '分期期数',
										width : 60,
										formatter : function(value, row, index) {
											return row.loantime.loantime + "期";
										}
									},
									{
										field : 'reason',
										title : '借款原因',
										width : 100
									},
									{
										field : 'applytime',
										title : '交易时间',
										width : 100,
									},
									{
										field : 'servicecharge',
										title : '手续费',
										width : 60,
										formatter : function(value, row, index) {
											return '￥' + row.servicecharge;
										}
									},
									{
										field : 'checked',
										title : '是否通过审核',
										width : 60,
										formatter : function(value, row, index) {
											var d = row.checked;
											var c = d == 1 ? '已通过' : '未通过';
											return c;
										}
									},
									{
										field : 'operate',
										title : '操作',
										width : 60,
										formatter : function(value, row, index) {
											var loanapplyid=parseInt (row.loanapplyid);
											console.log(typeof loanapplyid);
											var btns="<a id=\"btn\" href=\"/debit/findLoanapplybyLoanapplyid?loanapplyid=" 
												+loanapplyid+"\"	class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\">变更状态</a>"
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
	<%--${list }
	<div id="tb">
		<form action="">
			排序： <select id="cc" class="easyui-combobox" name="dept"
				style="width: 200px;">
				<option value="aa">按贷款金额</option>
				<option>按贷款利率</option>
				<option>按集资截至日期</option>
				<option>按已投资金额</option>
				<option>按还款期限</option>
			</select> <select id="cc" class="easyui-combobox" name="dept"
				style="width: 200px;">
				<option value="aa">从大到小</option>
				<option>从小到大</option>
			</select> 大于<input type="text"> 小于<input type="text">
			<div class="easyui-linkbutton" data-options="iconCls:'icon-remove'">筛选</div>
		</form>
	</div> --%>

</body>
</html>
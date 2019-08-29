<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	var myid;

	$(function() {
		$('#dg')
				.datagrid(
						{
							url : 'findByIdss',
							fitColumns : true,
							toolbar : '#tb',
							pageSize : 20,
							striped : true,
							title : '我的银行卡',
							pagination : true,
							columns : [ [
									{
										field : 'bankcardnum',
										title : '银行卡号'
									},
									{
										field : 'bankcardname',
										title : '银行名称'
									},
									{
										field : 'walletid',
										title : '银行名称11',
										formatter : function(value, row, index) {
											myid=value;
											return value;
										}
										
									},
									{
										field : 'operate',
										title : '操作',
										width : 100,
										formatter : function(value, row, index) {
											var btns = "<a id=\"btn\" href=\"javascript:deleteItem("
													+ row.bankcardid
													+ ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
											btns += "<a id=\"btn\" href=\"javascript:findById("
													+ row.bankcardid
													+ ")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">修改</a>";
											return btns;
										}
									},

							] ],
							onLoadSuccess : function(index, field, value) {
								$('.easyui-linkbutton').linkbutton({});
							}
						});
	})

	function deleteItem(bankcardid) {
		$.messager.confirm('Confirm',
				'Are you sure you want to delete record?', function(r) {
					if (r) {
						$.getJSON("delete", {
							bankcardid : bankcardid
						}, function(json) {
							$.messager.show({
								title : 'My Title',
								msg : json.msg,
								timeout : 5000,
								showType : 'slide'
							});
							$('#dg').datagrid('reload'); // reload the current page data  
						});
					}
				});

	}

	function deleteBatch() {
		var bankcardidstring = "";
		var selections = $('#dg').datagrid('getSelections'); // fix the 'name' column size
		for (var i = 0; i < selections.length; i++) {
			bankcardidstring += selections[i].bankcardid;
			if (i < selections.length - 1)
				bankcardidstring += ",";
		}

		$.getJSON("deleteBatch", {
			bankcardidstring : bankcardidstring
		}, function(json) {
			$.messager.show({
				title : 'My Title',
				msg : json.msg,
				timeout : 5000,
				showType : 'slide'
			});
			$('#dg').datagrid('reload'); // reload the current page data  
		});
	}

	function findById(bankcardid) {
		$('#ff').form('clear'); // 从URL加载 		
		$('#win').window('open'); // open a window 
		$.getJSON("findById", {
			bankcardid : bankcardid
		}, function(json) {
			$('#ff').form('load', json); // 从URL加载

		});

	}

	function openForm() {
		$('#ff').form('clear'); // 从URL加载 
		$('#win').window('open'); // open a window 

	}

	function dosave() {

		var bankcardid = $("#bankcardid").val();
		var path = "save/"+myid;
		if (bankcardid != null && bankcardid != "" && bankcardid != undefined) {
			path = "update";
		}
		$('#ff').form('submit', {
			url : path,
			onSubmit : function() {
				// do some check   
				// return false to prevent submit;   
			},
			success : function(data) {
				var json = eval("(" + data + ")");
				$.messager.show({
					title : 'My Title',
					msg : json.msg,
					timeout : 5000,
					showType : 'slide'
				});
				$('#win').window('close'); // open a window 
				$('#dg').datagrid('reload'); // reload the current page data  
			}
		});
	}
</script>
</head>
<body>
	<table id="dg"></table>
	<input id="aaa">

	<div id="tb">
		<a href="javascript:deleteBatch()" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">批量删除</a> <a
			href="javascript:openForm()" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true">增加</a> 
	</div>
	<div id="win" class="easyui-window" title="My Window"
		style="width: 600px; height: 400px"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		银行详情管理
		<form id="ff" method="post">


			<input type="hidden" name="bankcardid" id="bankcardid">
			<table>
				<tr>
					<td>请输入银行卡号：</td>
					<td><input class="easyui-validatebox" type="text"
						name="bankcardnum" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>请输入银行名称：</td>
					<td><input class="easyui-validatebox" type="text"
						name="bankcardname" data-options="required:true" /></td>
				</tr>
				

				<tr>
					<td>确认添加:</td>
					<td><input type="button" onclick="dosave()" value="添加" /></td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
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
							title : '已投资列表',
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
										field : 'loanamount',
										title : '贷款金额',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
						                },
										formatter:function(value,row,index){
											return row.loandisplay.loanapply.loanamount;
										}
									},
									{
										field : 'investamount',
										title : '投资金额',
										width : 100,
										sortable :true,
										sorter:function (a,b) {
						                   return (a<b?1:-1);
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
											return parseInt(row.loandisplay.loanapply.loanrate.loanrate*1000)/10+"%";
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
	});

    var path="/invest/findInvested";
    
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
    };   

</script>
</head>
<body>
	<input id="ss" class="easyui-searchbox" style="width:300px"  
	        data-options="searcher:qq,prompt:'请输入要筛选的条件',menu:'#mm'"></input>  
	           
	<div id="mm" style="width:120px">  
	    <div data-options="name:'repaytime',iconCls:'icon-ok'">还款周期（/月）</div>  
	    <div data-options="name:'loanamount'">贷款金额</div>
	    <div data-options="name:'investamount'">投资金额</div>
	    <div data-options="name:'loanrate'">贷款利率</div>
	    <div data-options="name:'servicecharge'">手续费</div>    
	</div>
	<a href="javascript:clear()" class="easyui-linkbutton" data-options="iconCls: 'icon-reload'">清空查询条件</a>  
	<table id="dg"></table>
	<div id="tb">
	</div>

</body>
</html>
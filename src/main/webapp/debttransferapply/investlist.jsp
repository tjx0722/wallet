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
		    remoteSort:false,
		    columns:[[   
		    	{field:'user',title:'借贷人姓名',width:100,formatter:function(value,row,index){
			    	return row.loandisplay.loanapply.userinfo.username;
				 }}, 
		        {field:'userinfoid',title:'借贷人信息',width:100,formatter:function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"/debttransferapply/findOneUser/"+row.loandisplay.loanapply.userinfo.userinfoid+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详情</a>";
					return btns;
				 }},   
		        {field:'investamount',title:'投资金额',width:100,sortable:true,
				    sorter:function(a,b){
			        	return (a>b?1:-1);
			    	}
				},   
		        {field:'paytime',title:'付款时间',width:100,formatter:function(value,row,index){
					var date=new Date(value);
					return date.toLocaleString();
			    },sortable:true,
				    sorter:function(a,b){
			        	return (a>b?1:-1);
			    	}
			    },
		        {field:'loandisplayid',title:'具体账单',width:100,formatter:function(value,row,index){
		        	var btns = "<a id=\"btn\" href=\"/debttransferapply/findOneInvest/"+row.loandisplayid+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">查看详情</a>";
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
		        	var btns = "<a id=\"btn\" href=\"/debttransferapply/istransfer/"+row.investid+"\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">售出</a>"; 
					return btns;
				}}
		    ]],
		    onLoadSuccess: function(index,field,value){
				$('.easyui-linkbutton').linkbutton({   
				});  
			}     
		});  
	});
</script>
<body>
	<input id="ss" class="easyui-searchbox" style="width:300px"  
        data-options="searcher:qq,prompt:'请输入借贷人名称',menu:'#mm'"></input>  
           
	<div id="mm" style="width:120px">  
	    <div data-options="name:'username',iconCls:'icon-ok'">按用户名称筛选</div>  
	</div>  
	<input id="begin" type="text"></input>  
	<input id="end" type="text"></input>  
	<input id="btn" type="button" value="按日期筛选" onclick="dateScreen()"></input>  
	<button onclick="clearScreen()">清空筛选条件</button>
	<table id="dg"></table>  
</body>
<script type="text/javascript">  
	$('#begin').datebox({   
	    required:false  
	});
	$('#end').datebox({   
	    required:false  
	});
	function dateScreen(){
		var begin=$('#begin').datebox('getValue');
		var end=$('#end').datebox('getValue');
		if(begin==null||begin==""){
			begin=null;
		};
		if(end==null||end==""){
			end=null;
		};
		$('#dg').datagrid({
        	url:'findAllByDate',
        	queryParams:{
            	'begin':new Date(begin),
            	'end':new Date(end)
            }
        });
	};
    function qq(value,name){  
    	$('#dg').datagrid({
        	url:'findAllByUname',
        	queryParams:{
            	'username':value
            }
        });
    };
    function clearScreen(){ 
    	$('#dg').datagrid({
        	url:'findAllInvest'
        });
    }  
</script>
</html>
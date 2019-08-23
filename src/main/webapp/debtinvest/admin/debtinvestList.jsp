<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>债权交易历史</title>
<script src="<%=basePath %>js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
var data;
$(function(){
	$('#dg').datagrid({   
	    url:'findAll', 
	    fitColumns:true,  
	    striped:true,
	    pagination:true,
	    title:'债权交易历史',
	    toolbar: '#tb',  
	    columns:[[   
	        {field:'debtinvestid',title:'序号',width:100,align:'center'},   
	        {field:'userinfo',title:'买进用户',width:100,align:'center',formatter: function (value) {
                return  value.username;
            }}, 
            {field:'debttransferapply',title:'转出用户',width:100,align:'center',formatter: function (value,row,index) {
                return row.display.debttransferapply.userinfo.username;
            }},   
	        {field:'investamount',title:'总支付金额',width:100,align:'center'},  
	        {field:'paytime',title:'支付时间',width:100,align:'center',formatter: function (value) {
                var dateMat = new Date(value);
                return  dateMat.toLocaleString();
            }},
	        {field:'istransfer',title:'是否转让给他人',width:100,align:'center',formatter: function(value,row,index){
				if (value){
					return '已转让';
				} else {
					return '未转让';
				}
			}}, 
	        {field:'servicecharge',title:'手续费',width:100,align:'center'}, 
	        {field:'servicechargeid',title:'手续费型号',width:100,align:'center'},  
	        {field:'loanapply',title:'借款人',width:100,align:'center',formatter: function (value,row,index) {
                return row.display.loanapply.userinfo.username;
            }},
	        {field:'debttransferdisplay',title:'债权通过表序号',width:100,align:'center'},
	        {field:'operate',title:'查询',width:100,align:'center',formatter: function(value,row,index){
				var btns="<a id=\"btn\" href=\"javascript:openWin("+index+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">详情</a>";
	        	return btns;
				
			}
	        }   
	    ]],
	    onLoadSuccess: function(index,field,value){
			$('.easyui-linkbutton').linkbutton({   
			});  
		},       
	});  
	data=$('#dg').datagrid('getData');
	
});
	function openWin(index){
		$('#win').window('open'); 		
		var temp=data["rows"];
		var temp1=temp[index];
		alert(temp1);
		/* $("#amount").text(data.rows); */
	}

	

</script>
</head>
<body>
<div id="tb">
</div>
<div id="win" class="easyui-window" title="交易详情" style="width:800px;height:600px"  
        data-options="iconCls:'icon-man',modal:true,closed:true">  
    <div class="easyui-layout" data-options="fit:true">  
        <div data-options="region:'north',split:true" style="height:150px">
        	<h4>相关用户</h4>
        </div>  
        <div data-options="region:'center'">  
          
           	<div class="col-md-6" style="height: 100px">
           	<h4>债权总额</h4>
           		<span id="amount"></span>
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>利率</h4>
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>借款开始时间</h4>
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>借款总期数</h4>
           	</div>
           	<div class="col-md-12"style="height: 200px">
           	<h4>还款记录</h4>
           	</div>
            
        </div>  
    </div>  
</div>  

<table id="dg"></table>  
</body>
</html>
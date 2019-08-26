<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				var obj="'"+encodeURI(JSON.stringify(row))+"'";
				var btns='<a id="btn" href="javascript:openWin('+obj+')" class="easyui-linkbutton" data-options="iconCls:\'icon-search\'">详情</a>';
	        	return btns;
				
			}
	        }   
	    ]],
	    onLoadSuccess: function(index,field,value){
			$('.easyui-linkbutton').linkbutton({   
			});  
		},       
	});  
	
	
	
});

	function openWin(obj){
		var temp=decodeURI(obj);
		var data=JSON.parse(temp);
		$('#win').window('open'); 
		$("#userinfo").text(data.userinfo.username);
		$("#debttransfer").text(data.display.debttransferapply.userinfo.username);
		$("#loanapply").text(data.display.loanapply.userinfo.username);
		$("#amount").text(data.display.invest.investamount);
		$("#loanrate").text(data.display.loanapply.loanrate.loanrate);
		var temp=data.display.invest.loandisplay.displaytime;
		var dateMat = new Date(temp);
		var time=dateMat.toLocaleString();
		$("#start").text(time);
		$("#time").text(data.display.loanapply.loantime.loantime);
		$("#repaytb tr:not(:eq(0))").remove();
		$.each(data.display.loanapply.repays,function(index,obj){			
			var tr=$("<tr></tr)");
			var td1=$("<td></td>");
			var td2=$("<td></td>");
			td1.text(obj.payAmount);
			td2.text(new Date(obj.actualrepaytime).toLocaleString());
			tr.append(td1);
			tr.append(td2);
			$("#repaytb").append(tr);
		}); 
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
        	<div class="col-md-12">
        	<h4>相关用户</h4>
        	<div class="col-md-4 text-center" style="height: 100px">
        	<h5>债权买进用户</h5><button type="button" class="btn btn-primary btn-sm center-block" >
 				 		<span class="glyphicon glyphicon-user" id="userinfo"></span> 
					</button>
			</div>
			<div class="col-md-4 text-center" style="height: 100px">
			<h5>债权转出用户</h5><button type="button" class="btn btn-warning btn-sm center-block" >
 				 		<span class="glyphicon glyphicon-user" id="debttransfer"></span> 
					</button>
			</div>	
			<div class="col-md-4 text-center" style="height: 100px">
			<h5>借款人</h5><button type="button" class="btn btn-danger btn-sm center-block" >
 				 		<span class="glyphicon glyphicon-user" id="loanapply"></span> 
					</button>
			</div>
        	</div>
        </div>  
        <div data-options="region:'center'">  
          
           	<div class="col-md-6" style="height: 100px">
           	<h4>债权总额</h4>
           		<p class="text-muted text-center"><font id="amount" size="6px"></font></p> 
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>利率</h4>
           		<p class="text-muted text-center"><font id="loanrate" size="6px"></font></p> 
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>借款开始时间</h4>
           		<p class="text-muted text-center"><font id="start" size="5px"></font></p> 
           	</div>
           	<div class="col-md-6" style="height: 100px">
           	<h4>借款总期数</h4>
           		<p class="text-muted text-center"><font id="time" size="6px"></font></p> 
           	</div>
           	<div class="col-md-12"style="height: 200px">
           	<h4>该笔债权还款记录</h4>
           		<table class="table text-center" id="repaytb">
           			<tr>
           				<td>还款金额</td>
           				<td>还款时间</td>
					</tr>
           		</table>
           	</div>
        </div>  
    </div>  
</div>  
<table id="dg" height="800px"></table>  
</body>
</html>
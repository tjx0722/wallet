<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script
	src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="app" class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">投资详细信息</h3>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<th>借款人姓名</th>
						<th>${loandisplay.loanapply.userinfo.username }</th>
					</tr>
					<tr>
						<th>电话</th>
						<th>${loandisplay.loanapply.userinfo.user.phone }</th>
					</tr>
					<tr>
						<th>籍贯</th>
						<th>${loandisplay.loanapply.userinfo.nativeplace }</th>
					</tr>
					<tr>
						<th>工作</th>
						<th>${loandisplay.loanapply.userinfo.userjob }</th>
					</tr>
					<tr>
						<th>贷款原因</th>
						<th>${loandisplay.loanapply.reason }</th>
					</tr>
					<tr>
						<th>贷款利率</th>
						<th><fmt:formatNumber type="number" value="${loandisplay.loanapply.loanrate.loanrate*100 }" maxFractionDigits="0"/>%</th>
					</tr>
					<tr>
						<th>贷款金额</th>
						<th>${loandisplay.loanapply.loanamount }元</th>
					</tr>
					<tr class="warning">
						<th>已募集金额</th>
						<th>${loandisplay.investcount }元</th>
					</tr>
					<tr class="info">
						<th>可投资金额</th>
						<th>{{restcount}}元</th>
					</tr>
					<tr class="danger">
						<th>还款期限</th>
						<th>${loandisplay.loanapply.loantime.loantime }个月</th>
					</tr>
					<tr>
						<th>投资人列表</th>
						<th>。。。</th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	window.onload=function(){
		var vm=new Vue({
			el:"#app",
			data:{
				json:"",
				loandisplayid:${loandisplay.loandisplayid },
				investamount:"",
				restcount:${loandisplay.loanapply.loanamount-loandisplay.investcount },
				password:""
			},
			watch:{
				investamount(newValue,oldValue){
					this.investamount=this.investamount.replace(/[^\d]/g,"");
					if(this.investamount>this.restcount){
						this.investamount="";
						alert("投资金额输入有误");
					}
				}
			},
			methods:{
				purchase:function(){
					location.href="/invest/purchase/"+this.investamount+"!"+this.loandisplayid;
				}
			}
		});
	}
</script>
</html>
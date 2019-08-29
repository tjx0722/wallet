<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<h3 class="panel-title">用户详细信息</h3>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<th>姓名</th>
						<th>${userinfo.username }</th>
					</tr>
					<tr>
						<th>性别</th>
						<th>${userinfo.sex?'女':'男' }</th>
					</tr>
					<tr>
						<th>电话</th>
						<th>${userinfo.user.phone }</th>
					</tr>
					<tr>
						<th>籍贯</th>
						<th>${userinfo.nativeplace }</th>
					</tr>
					<tr>
						<th>工作</th>
						<th>${userinfo.userjob }</th>
					</tr>
					<tr>
						<th>学历</th>
						<th>${userinfo.degree }</th>
					</tr>
					<tr>
						<th>婚否</th>
						<th>${userinfo.ismarried?'是':'否' }</th>
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
				userinfo:${userinfo }
			},
			methods:{
				unknown:function(){
					location.href="/invest/purchase/"+this.investamount+"!"+this.loandisplayid;
				}
			}
		});
	}
</script>
</html>
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
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="app" class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">用户详细信息</h3>
	  </div>
	  <div class="panel-body">
	   <div>
       	<table>
       		<tr>
       			<th>用户详情表id</th>
       			<th>${userinfo.userinfoid }</th>
       		</tr>
       		<tr>
       			<th>用户id</th>
       			<th>${userinfo.userid }</th>
       		</tr>
       		<tr>
       			<th>用户名</th>
       			<th>${userinfo.username }</th>
       		</tr>
       		<tr>
       			<th>住址</th>
       			<th>${userinfo.currentaddress }</th>
       		</tr>
       		<tr>
       			<th>籍贯</th>
       			<th>${userinfo.nativeplace }</th>
       		</tr>
       		<tr>
       			<th>头像</th>
       			<th>${userinfo.usericon }</th>
       		</tr>
       		<tr>
       			<th>昵称</th>
       			<th>${userinfo.nickname }</th>
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
       			<th>生日</th>
       			<th>${userinfo.birthday }</th>
       		</tr>
       		<tr>
       			<th>性别</th>
       			<th>${userinfo.degree }</th>
       		</tr>
       		<tr>
       			<th>学历</th>
       			<th>${userinfo.sex }</th>
       		</tr>
       		<tr>
       			<th>工资</th>
       			<th>${userinfo.salary }</th>
       		</tr>
       		<tr>
       			<th>婚否</th>
       			<th>${userinfo.ismarried }</th>
       		</tr>
       		<tr>
       			<th>审核是否通过</th>
       			<th>${userinfo.infochecked }</th>
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
				userid:${userinfoid.userid },
				investamount:"",
				restcount:${userinfo },
				msg:""
			},
			
			
		});
	}
</script>  
</html>
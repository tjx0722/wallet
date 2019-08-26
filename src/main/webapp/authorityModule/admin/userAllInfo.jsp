<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${userinfo.username}详细信息</title>
<script src="<%=basePath %>js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">
            ${userinfo.username}基本资料
        </h3>
    </div>
    <div class="panel-body">
        <table class="table text-center">
        	<tr>
        		<td>用户名</td>
        		<td>${userinfo.username }</td>
        	</tr>
        	<tr>
        		<td>住址</td>
        		<td>${userinfo.currentaddress }</td>
        	</tr>
        	<tr>
        		<td>籍贯</td>
        		<td>${userinfo.nativeplace }</td>
        	</tr>
        	<tr>
        		<td>头像</td>
        		<td>${userinfo.usericon }</td>
        	</tr>
        	<tr>
        		<td>昵称</td>
        		<td>${userinfo.nickname }</td>
        	</tr>
        	<tr>
        		<td>工作</td>
        		<td>${userinfo.userjob }</td>
        	</tr>
        	<tr>
        		<td>学历</td>
        		<td>${userinfo.degree }</td>	
        	</tr>
        	<tr>
        		<td>生日</td>
        		<td>
        			<f:formatDate value="${userinfo.birthday }" pattern="yyyy年MM月dd日"/>
        		</td>
        	</tr>
        	<tr>
        		<td>性别</td>
        		<td>${userinfo.sex=='false'?'男':'女' }</td>
        	</tr>
        	<tr>
        		<td>工资</td>
        		<td>${userinfo.salary }</td>
        	</tr>
        	<tr>
        		<td>婚否</td>
        		<td>${userinfo.ismarried=='true'?'已婚':'未婚' }</td>
        	</tr>
        </table>
    </div>
	</div>
</div>
</body>
</html>
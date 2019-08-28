<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		<c:forEach items="${user.roles}" var="r">
		$("input[name=chk][value=${r.roleid}]").attr("checked","checked");
		</c:forEach>
	});
</script>
</head>
<body>
<form method="post" action="/authorityModule/updateAuthority">
	<input type="hidden" name="userid" value="${user.userid}"><br>
	<input type="text" name="account" value="${user.account }"><br>
	<c:forEach items="${roles}" var="role">
	<INPUT TYPE="checkbox" NAME="chk" value="${role.roleid }">${role.rolename }
	</c:forEach><br>
	<button>修改</button>
</form>
</body>
</html>
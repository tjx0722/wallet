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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<form action="/userinfo/save">
userinfoid<input type="text" name="userinfoid" id="userinfoid"><br>
userid<input  type="text" name="userid" value="${user.userid}" />  <br>
username <input  type="text" name="username"  />  <br>
currentaddress<input  type="text" name="currentaddress" />  <br>
nativeplace <input type="text" name="nativeplace"  />  <br>
usericon <input  type="text" name="usericon" />  <br>
userjob <input  type="text" name="userjob"  />    <br>
degree<input  type="text" name="degree"/>  <br>
birthday<input  type="date" name="birthday"  />  <br>
sex<input type="radio" name="sex" value="0">男<input type="radio" name="sex" value="1">女<br>
salary <input  type="text" name="salary"  />    <br>
ismarried <input  type="text" name="ismarried"  />      <br>
infochecked  <input  type="text" name="infochecked"  />    <br>
<button type="submit">go</button>

</form>





</body>
</html>
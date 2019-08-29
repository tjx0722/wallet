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

<style>
     body{
     background-image: url(/img/a.png);
     background-repeat: no-repeat;
     background-size:cover;
    
    
     }
</style>
</head>
<body>
<h1 style="color:red; text-align:center">用户详情添加</h1>
<form action="/userinfo/save" method="post" style="text-align:center" border="1px">
<table>
<div border="1px" >
userinfoid<input type="text" name="userinfoid" id="userinfoid"><br>
</div>
<div>
userid<input  type="text" name="userid" value="${user.userid}" />  <br>
</div>
<div>
username <input  type="text" name="username"  />  <br>
</div>
<div>
currentaddress<input  type="text" name="currentaddress" />  <br>
</div>
<div>
nativeplace <input type="text" name="nativeplace"  />  <br>
</div>
<div>
usericon <input  type="text" name="usericon" />  <br>
</div>
<div>
userjob <input  type="text" name="userjob"  />    <br>
</div>
<div>
degree<input  type="text" name="degree"/>  <br>
</div>
<div>
birthday<input  type="date" name="birthday"  />  <br>
</div>
<div>
sex<input type="radio" name="sex" value="0">男<input type="radio" name="sex" value="1">女<br>
</div>
<div>
salary <input  type="text" name="salary"  />    <br>
</div>
<div>
ismarried <input  type="text" name="ismarried"  />      <br>
</div>
<div>
infochecked  <input  type="text" name="infochecked"  />    <br>
</div>
<div>
applypass  <input  type="text" name="applypass"  />    <br>
</div>
<div>
<button type="submit">go</button>
</div>
</table>
</form>





</body>
</html>
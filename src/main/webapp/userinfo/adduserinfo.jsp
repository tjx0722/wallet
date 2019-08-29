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
     background-color:#D1D2D5;
     
    
    
     }
</style>
</head>
<body>
<h1 style="color:red; text-align:center">完善客户信息</h1>
<form action="/userinfo/save" method="post" style="text-align:center" border="1px">
<div style="text-align:center">

<table border="1px" style="margin:auto;" width="800px">
<tr >
   <td>请输入用户名</td>
   <td><input  type="text" name="username"  /> </td>
</tr>


<tr >
   <td >您的用户ID为(此项不可修改)</td>
   <td  ><input color="red" type="text" name="userid" readonly="readonly" value="${user.userid}" /> </td>
</tr>
<tr>
   <td>请输入住址</td>
   <td><input  type="text" name="currentaddress" />  </td>
</tr>
<tr>
   <td>请输入籍贯</td>
   <td><input type="text" name="nativeplace"  />  </td>
</tr>

<tr>
   <td>请输入昵称</td>
   <td><input  type="text" name="nickname"  />  </td>
</tr>
<tr>
   <td>请输入工作</td>
   <td><input  type="text" name="userjob"  />   </td>
</tr>
<tr>
   <td>请输入学历</td>
   <td><input  type="text" name="degree"/>   </td>
</tr>
<tr>
   <td>请输入生日</td>
   <td><input  type="date" name="birthday"  />   </td>
</tr>
<tr>
   <td>请选择性别</td>
   <td><input type="radio" name="sex" value="0">男<input type="radio" name="sex" value="1">女  </td>
</tr>
<tr>
   <td>请输入目前每月收入</td>
   <td><input  type="text" name="salary"  />   </td>
</tr>
<tr>
   <td>婚否</td>
   <td><input  type="radio" name="ismarried" value="0" />已婚  <input type="radio" name="ismarried" value="1">未婚 </td>
</tr>

<tr>
   <td>请输入支付密码</td>
   <td><input  type="text" name="applypass"  />   </td>
</tr>

<tr>
   <td>提交个人信息</td>
   <td><button type="submit">提交</button>   </td>
</tr>

</table>
</div>
</form>




</body>
</html>
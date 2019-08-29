<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function(){

	
	$("#ff").hide();
  
	$("#btn1").click(function(){
		$("#ff").hide();
	});
})
</script>
</head>
<body>


<h3 align="center" ><font color="red">我的银行卡</font></h3>


    <table border="1" width="1000" class="table" align="center">
       <tr align="center" >
         <td>银行卡号</td>
         <td>银行名称</td>
         
          <td>删除我的银行卡</td>
            <td>添加我的银行卡</td>
       </tr>
        <c:forEach items="${bankcard }" var="b" varStatus="a">
           <tr align="center">
          
           <td ><input  id="bankcardnum" type="text" style="border:none;width:200px" value="${b.bankcardnum }"></input></td>
           <td ><input id="bankcardname" type="text" style="border:none;width:100px" value="${b.bankcardname }"></input></td>
         <%--   <td ><input id="walletid" type="text" style="border:none;width:30px" value="${b.walletid }"></input></td> --%>
           
           <td><button onclick="location.href='/authorityModule/editPage?userid=${user.userid}'">删除我的银行卡</button></td>
           
           <td><button  onclick="fun1()">添加我的银行卡</button></td>
            </c:forEach>
       </tr>
           
       
       
     
       
    </table>

<form id="ff" method="post" action="/userinfo/wallet/bankcard/save">
       
			<table>
				<tr> 
					<td>请输入银行卡号：</td>
					<td><input  type="text"
						name="bankcardnum"  /></td>
				</tr>
				<tr>
					<td>请输入银行名称：</td>
					<td><input  type="text"
						name="bankcardname"  /></td>
				</tr>
				<tr>
				    <td>钱包id</td>
				    <td><input id="walletid1" name="walletid"></td>
				</tr>

				<tr>
					<td>确认添加:</td>
					<td><button type="submit" id="btn1">添加</button></td>
				</tr>
			</table>
		</form>




		

</body>
</html>

<script>
function fun1(){
	$("#ff").show();
   }
</script>
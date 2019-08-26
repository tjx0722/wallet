<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
 /* $(document).ready(function(){
    var x = $("#sel option:selected").val(); 如果你用的“变量”是input的话，这里就要写成.value了
     alert(x); 
    $("#up").val(x);  这句话设置select中value为x的项被选中,例如$("#slt").val(“本科”)就表示<option>本科</option>被选中 
});  */ 
</script>
</head>
<body>
<form method="post" action="findAll">
<!-- uname<INPUT TYPE="text" NAME="uname" value="${log.uname }">action<INPUT TYPE="text" value="${log.action }" NAME="action"><input type="submit" value="Query">
 -->
<TABLE border="1" width="100%">
<TR align="center">
	<TD>用户id</TD>
	<TD>账户</TD>
	<TD>密码</TD>
	<TD>电话</TD>
	<TD>邮箱</TD>
	<TD>状态</TD>
	<TD>操作</TD>
</TR>
<c:forEach items="${list}" var="user">
<TR align="center">
	<TD>${user.userid}</TD>
	<TD>${user.account}</TD>
	<TD>${user.password}</TD>
	<TD>${user.phone}</TD>
	<TD>${user.email}</TD>
	<TD>${user.isdelete?'已删除':'正常'}</TD>
	<TD>
		<a href="${!user.isdelete?'delete':'revoke'}?userid=${user.userid}">${!user.isdelete?'删除':'恢复'}</a> 
	</TD>
</TR>
</c:forEach>
</TABLE>
<TABLE border="1" width="100%">
<tr align="center">
	<td width="12.5%"><button onclick="go(1)">first</button></td>
	<td width="12.5%"><button onclick="go(${page.pageNow}==1?1:${page.pageNow-1 })">before</button></td>
	<td width="12.5%"><button onclick="go(${page.pageNow}==${page.pageCount }?${page.pageCount }:${page.pageNow+1 })">next</button></td>
	<td width="12.5%"><button onclick="go(${page.pageCount })">end</button></td>
	<td width="12.5%">
	第<input type="text" id="pageNow" name="pageNow" value="${page.pageNow }" size="1">页
	</td>
	<td width="12.5%">
	一页 <input type="text" name="limit" value="${page.limit }" id="up" size="1">行
	<!-- <select name="type" id="sel" required="true" >
		<option  value="5">5</option>
		<option value="10">10</option>
	</select> -->
	
	 <!-- <input type="hidden" name="limit" value="${page.limit }" id="up" size="1"> -->
	</td>
	<td width="12.5%">${page.pageNow }/${page.pageCount }</td>
	<td width="12.5%"><button>go</button></td>
</tr>
<tr align="center" >
	<td width="100%" colspan="8">共 ${page.count } 条记录</td>
</tr>
</TABLE>
</form>

</body>
</html>
<script>
	function go(pageNow){
		document.getElementById("pageNow").value= pageNow;
		document.forms[0].submit();
	}

	
</script>
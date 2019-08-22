<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="width: 500px;margin: auto;text-align: center;">
		<table class="table table-striped table-bordered table-hover ">
		    <thead>
		      <tr>
		        <th colspan="2">确认信息</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <th>名称</th>
		        <th>数据</th>
		      </tr>
		      <tr>
		        <td>用户详情id</td>
		        <td>${apply.userinfoid }</td>
		      </tr>
		      <tr>
		        <td>投资表id</td>
		        <td>${apply.investid }</td>
		      </tr>
		      <tr>
		        <td>转让申请时间</td>
		        <td>${apply.applytime }</td>
		      </tr>
		      <tr>
		        <td>手续费类型</td>
		        <td>${apply.servicechargeid }</td>
		      </tr>
		      <tr>
		        <td>手续费</td>
		        <td>${apply.servicecharge }</td>
		      </tr>
		    </tbody>
		</table>
		<input type="button" value="确认"  onclick="location.href='/debttransferapply/transfer/${apply.investid},${apply.userinfoid}'" >
		<input type="button" value="取消"  onclick="location.href='/debttransferapply/investlist.jsp'">
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>
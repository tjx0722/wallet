<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>借贷人信息</title>
</head>
<body>
	<div style="width: 500px;margin: auto;text-align: center;">
	<table class="table table-striped table-bordered table-hover ">
		    <thead>
		      <tr>
		        <th colspan="2">借贷人信息</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <th>名称</th>
		        <th>数据</th>
		      </tr>
		      <tr>
		        <td>借贷人名称</td>
		        <td>${invest.loandisplay.loanapply.userinfo.username }</td>
		      </tr>
		      <tr>
		        <td>籍贯</td>
		        <td>${invest.loandisplay.loanapply.userinfo.nativeplace }</td>
		      </tr>
		      <tr>
		        <td>工作</td>
		        <td>${invest.loandisplay.loanapply.userinfo.userjob }</td>
		      </tr>
		      <tr>
		        <td>学历</td>
		        <td>${invest.loandisplay.loanapply.userinfo.degree }</td>
		      </tr>
		      <tr>
		        <td>工资</td>
		        <td>${invest.loandisplay.loanapply.userinfo.salary }</td>
		      </tr>
		    </tbody>
		</table>
		<input type="button" class="btn btn-primary" value="返回"  onclick="location.href='/debttransferapply/admin/applylist.jsp'">
	</div>
</body>
</html>

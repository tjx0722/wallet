<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>账单信息</title>
</head>
<body>
	<div style="width: 500px;margin: auto;text-align: center;">
		<table class="table table-striped table-bordered table-hover ">
		    <thead>
		      <tr>
		        <th colspan="2">账单信息</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <th>名称</th>
		        <th>数据</th>
		      </tr>
		      <tr>
		        <td>贷款金额</td>
		        <td>${invest.loandisplay.loanapply.loanamount }</td>
		      </tr>
		      <tr>
		        <td>申请时间</td>
		        <td>${invest.loandisplay.loanapply.applytime }</td>
		      </tr>
		      <tr>
		        <td>申请原因</td>
		        <td>${invest.loandisplay.loanapply.reason }</td>
		      </tr>
		      <tr>
		        <td>还款方式</td>
		        <td>分期${invest.loandisplay.loanapply.loantime.loantime }月</td>
		      </tr>
		      <tr>
		        <td>还款利率</td>
		        <td>${invest.loandisplay.loanapply.loanrate.loanrate }%</td>
		      </tr>
		    </tbody>
		</table>
		<input type="button" class="btn btn-primary" value="返回"  onclick="location.href='/debttransferapply/admin/applylist.jsp'">
	</div>
</body>
</html>

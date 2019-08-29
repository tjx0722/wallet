<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="background-color: white;" align="center">
		<h3>感谢您进入还款页面</h3>
	</div>
	<br>
	<br>
	<div class="col-md-2" align="left">
		<img alt="" src="ziti.png">
	</div>
	<div class="panel panel-primary col-md-2"
		style="height: 250px; padding: 0px">
		<div class="panel-body" align="center">
			<p style="font-size: 22px">本 月 应 还 钱 数
			<p>
		</div>
		<div class="panel-footer"
			style="margin: 0px; height: 176px; line-height: 100px; background-color: aqua;"
			align="center">
			<p style="font-size: 30px; color: white; height: 50px">${restamount }
			<p>
				<button type="button" class="btn btn-success">去还款</button>
		</div>
	</div>
	<div class="col-md-1"></div>
	<div class="panel panel-primary col-md-2"
		style="height: 250px; padding: 0px">
		<div class="panel-body" align="center">
			<p style="font-size: 22px">逾 期 交 易 笔 数
			<p>
		</div>
		<div class="panel-footer"
			style="margin: 0px; height: 176px; line-height: 100px; background-color: #C69B88;"
			align="center">
			<p style="font-size: 30px; color: white; height: 50px">0笔
			<p>
				<button type="button" class="btn btn-danger">去了解</button>
		</div>
	</div>
	<div class="col-md-1"></div>
	<div class="panel panel-primary col-md-2"
		style="height: 250px; padding: 0px">
		<div class="panel-body" align="center">
			<p style="font-size: 22px">本 月 应 还 笔 数
			<p>
		</div>
		<div class="panel-footer"
			style="margin: 0px; height: 176px; line-height: 100px; background-color: #88B3A0;"
			align="center">
			<p style="font-size: 30px; color: white; height: 50px">${count }笔待还
			<p>
				<button type="button" class="btn btn-warning">去查看</button>
		</div>
	</div>
	<div class="col-md-2" align="right">
		<img alt="" src="ziti2.png">
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body >
	<div class="panel panel-default">
		<div class="panel-body">
			<ul class="nav nav-pills">
				<li><img alt="" src="logo.jpg"></li>
				<li style="float: right"><a href="#">个人</a></li>
				<li style="float: right" id="ball"><a onclick="fun2()">还款界面</a></li>
				<li style="float: right" id="" class="active"><a onclick="fun1()">历史交易</a></li>
			</ul>
		</div>
		<hr>
		<iframe src="/repayment/findRepaymentWithUser" height="530px"
			width="100%" name="demo" scrolling="auto" id="iframe"
			sandbox="allow-same-origin" style="border: 0"></iframe>

	</div>


</body>
</html>
<script>
	$(document).ready(function() {
		$('li').click(function(e) {
			e.preventDefault();
			$('li').removeClass('active');
			$(this).addClass('active');

		});

	});
	function fun1() {
		$('#iframe').attr('src', '/repayment/findRepaymentWithUser')
	}
	function fun2() {
		$('#iframe').attr('src', '/repayment/repay')
	}
</script>

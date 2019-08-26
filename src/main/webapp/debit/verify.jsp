<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn").click(function() {
			location.href = "verify"
		})
	})
</script>
<style type="text/css">
ul, li {
	list-style: none;
}

.password-div input {
	width: 1px;
	height: 1px;
	opacity: 0;
	border: 0;
}

.password-lable {
	height: 30px;
	clear: both;
}

.password-lable li {
	float: left;
	width: 30px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	border: 1px solid #dedede;
	margin-left: -1px;
}
</style>
</head>
<body class="easyui-layout">
	<div class="panel panel-default"  style="background: url('back.jpg'); height: 760px;width: 1089px">
		<div class="panel-heading">
			<h3 class="panel-title">订单确认</h3>
		</div>
		<div class="panel-body">
		请确认您的订单
	</div>
			<table class="table ">
				<thead>
					<tr>
						<th width="100">数据类型</th>
						<th width="100">订单详情</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>申请时间</td>
						<td>${datetime}</td>
					</tr>
					<tr>
						<td>贷款人姓名</td>
						<td>${userinfo.username }</td>
					</tr>
					<tr>
						<td>贷款金额</td>
						<td>${loanapply.loanamount }</td>
					</tr>
					<tr>
						<td>申请原因</td>
						<td>${loanapply.reason}</td>
					</tr>
					<tr>
						<td>分期月数</td>
						<td>${loantime}</td>
					</tr>
					<tr>
						<td>手续费</td>
						<td>${loanapply.servicecharge}</td>
					</tr>
				</tbody>
			</table>
			<div align="right" style="position: relative;right: 300px">
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal">我已确认</button>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">密 码 支 付</h4>
						</div>
						<div class="modal-body">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h3 class="panel-title">请输入您的6位支付密码</h3>
								</div>
								<div class="panel-body">

									<div class="password-div">
										<label for="password" class="password-lable">
											<ul>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
												<li></li>
											</ul> <input id="password" type="password" name="password"
											maxlength="6">
										</label>
									</div>

								</div>
							</div>


						</div>
						<div class="modal-footer">
							<button type="button" id="btn" class="btn btn-primary">确认</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(".password-div input").on("input", function(e) { //标签为password-div下的input添加oninput事件
		var number = 6; //定义输入最大值
		var pw = $("input[name = 'password']").val(); //定义pw为name是password的input框的输入值
		var list = $(".password-div ul li"); //定义list是li
		for (var i = 0; i < number; i++) { //for循环遍历将·放入li标签
			if (pw[i]) {
				$(list[i]).text("·");
			} else {
				$(list[i]).text("");
			}
			;
		}
		;
	});
	$(".password-div ul").click(function() {
		$("input[name = 'password']").val("");
		$("#password").focus();
		$(".password-div ul li").text("");
	});
</script>


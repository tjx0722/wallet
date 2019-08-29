<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<table class="table table-striped table-bordered table-hover table-condensed">
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
		        <td>用户名称</td>
		        <td>${apply.userinfo.username }</td>
		      </tr>
		      <tr>
		        <td>投资表id</td>
		        <td>${apply.investid }</td>
		      </tr>
		      <tr>
		        <td>转让申请时间</td>
		        <td><fmt:formatDate value="${apply.applytime }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
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
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">支付手续费</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/debttransferapply/investlist.jsp'">取消</button>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center" id="myModalLabel">请支付手续费</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				</div>
				<div class="modal-body">按下 Esc 按钮退出。</div>
				<div class="modal-body">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<tr>
							<th colspan="2">14期全体成员正在为您保驾护航，请确认支付信息</th>
						</tr>
						<tr>
							<th><font size="4">付款金额</font></th>
							<th><span class="glyphicon glyphicon-gbp"
								style="color: red">${apply.servicecharge }</span></th>
						</tr>
						<tr>
							<th>
								<div  align="center"><button  onclick="location.href='/debttransferapply/pay/${apply.investid},${apply.userinfoid}'" type="button" class="btn btn-primary">使用Wallet付款</button></div>
							</th>
							<th>
								<div  align="center"><button type="button" class="btn btn-info">使用支付宝付款</button></div>
							</th>
						</tr>
					</table>
					<div align="right"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
</script>
</html>
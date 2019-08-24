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
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//cdn.bootcss.com/bootstrap-slider/9.4.1/css/bootstrap-slider.css"
	rel="stylesheet">

<script src="//cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//cdn.bootcss.com/bootstrap-slider/9.4.1/bootstrap-slider.min.js"></script>
<style>
#ex1Slider .slider-selection {
	background: red;
}
</style>
</head>
<body class="easyui-layout">

	<div class="panel panel-default "
		style="background: url('back.jpg'); height: 960px">
		<div class="panel-heading" style="background-color: #99D9D9">
		
		</div>
		<div class="panel-body">${userinfo.username}，欢迎您使用借款功能。     请根据您的需要进行选择：</div>
		<form class="form-horizontal" role="form" action="excessive">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">贷款金额</label>
				<div class="col-sm-4">
					<input id="ex1" data-slider-id="ex1Slider" type	="text"
						data-slider-min="0" data-slider-max="100000"
						data-slider-step="100" data-slider-value="0" style="width: 500px;" name="loanamount" />
				</div>
				<span class=" col-sm-1" id="loanamount"
					style="width: 50px; height: 20px; text-align: center; line-height: 20px">
				</span>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">分期期数</label>
				<div class="col-sm-4">
					<select  class="form-control" name="loanrateid">
						<c:forEach items="${loanrates }" var="rate">
							<option value="${rate.loanrateid}">${(rate.loanrate)*1000/10}%</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">选择利率</label>
				<div class="col-sm-4">
					<select  class="form-control" name="loantimeid">
						<c:forEach items="${Loantimes}" var="time">
							<option value="${time.loantimeid }">${time.loantime }个月</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">借款用途</label>
				<div class="col-sm-4">
					<select  class="form-control" name="reason">
							<option value="运动健身">运动健身</option>
							<option value="电扇购物">电商购物</option>
							<option value="生活开销">生活开销</option>
							<option value="学习进修">学习进修</option>
							<option value="技能培训">技能培训</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">提交申请</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
<script>
	$('#ex1').slider(
			{
				formatter : function(value) {
					$("#loanamount").html(
							"<font size='10' face='楷体'>￥" + value + "</font>");
					$("input[ name='']").val(value);
					return '当前金额： ' + value;
				}
			}).on('slide', function(slideEvt) {
		//当滚动时触发
		//console.info(slideEvt);
		//获取当前滚动的值，可能有重复
		// console.info(slideEvt.value);
	}).on('change', function(e) {
		//当值发生改变的时候触发
		//console.info(e);
	});
</script>


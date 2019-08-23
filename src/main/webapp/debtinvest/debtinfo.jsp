<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>债权详情</title>
<script src="<%=basePath %>js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath %>bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
<nav class="navbar navbar-default"  style="margin-bottom: 2px;">
			<div class="container-fluid">			
				<div class="navbar-header">
					<b class="navbar-brand">债权详情</b>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${user==null }">
						<li><a href="<%=basePath %>index.jsp" id="login"><span class="glyphicon glyphicon-user"></span> 登录</a></li>
						<li><a href="<%=basePath %>index.jsp"><span class="glyphicon glyphicon-log-in"></span> 注册</a></li>
					</c:if>
					<c:if test="${user!=null }">
						<li><a href="<%=basePath %>authorityModule/findByUserid" id="login"><span class="glyphicon glyphicon-user"></span> ${user.account}</a></li>
						<li><a href="<%=basePath %>userinfo/wallet/index.jsp"><span class="glyphicon glyphicon-th"></span> 钱包</a></li>
					</c:if>
				</ul>
			</div>			
		</nav>
<div class="container">
	<div class="col-md-6" style="height:100px;float:left;padding: 15px ">
	<h4>债权总额</h4>
		<div style="text-align: center">
			<font class="text-danger" size="6px" id="investamount">${invest.investamount }</font> 
		</div>
	</div>
	<div class="col-md-6" style="height:100px;float:left;padding: 15px ">
	<h4>利率</h4>
		<div style="text-align: center">
			<font class="text-success" size="6px">${loanrate.loanrate }%</font> 
		</div>
	</div>
	<div class="col-md-6" style="height:100px;float:left;padding: 15px ">
	<h4>借款开始时间</h4>
		<div style="text-align: center">
		<font class="text-info" size="4px">
			<f:formatDate value="${loandispaly.displaytime }" pattern="yyyy年MM月dd日" />
		</font> 	
		</div>
	</div>
	<div class="col-md-6" style="height:100px;float:left;padding: 15px ">
	<h4>借款总期数</h4>
		<div style="text-align: center">
		<font class="text-warning" size="5px">
		<b>${loantime.loantime}</b>
		</font> 	
		</div>
	</div>
	<div class="col-md-12" style="float:left;padding: 15px ">
	<h4>借款人还款记录</h4>
		<table class="table text-center">
			<tr>
				<td>还款金额</td>
				<td>还款日期</td>
			</tr>
			<c:forEach items="${repays }" var="repay">
				
				<tr>
					<td><font class="text-danger"  >${repay.payAmount }</td>
					<td>
						<font class="text-danger"  >
							<f:formatDate value="${repay.actualrepaytime }" pattern="yyyy年MM月dd日" />
						</font>
					</td>
				</tr>
				
			</c:forEach>
		</table> 
	</div>
	<div class="col-md-6" style="height:100px;float:left;padding: 15px ">
	<h4>借款人信息</h4>
		<div style="text-align: center">
			<table width="100%">
				<tr>
					<td>姓名：${userinfo. username}</td>
				</tr>
				<tr>
					<td>工作：${userinfo. userjob} </td>
				</tr>
				<tr>
					<td>学历：${userinfo. degree} </td>
				</tr>
			</table>
		</div>
	</div>
	<div class="col-md-6" style="height:100px;float:left;padding: 15px  ">
	<h4>借款理由</h4>
		<div  class="col-md-offset-2" style="text-align: left">
			${loanapply.reason }
		</div>
	</div>
	<div class="col-md-12" style="margin-top:40px;">
		<button type="button" class="btn btn-warning col-md-12" data-toggle="modal" data-target="#myModal" >我要投资该笔债权</button>
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">
                <sapn >请支付￥<font class="text-info">${payment }</font> </span>  
                &nbsp;&nbsp;&nbsp;(手续费${realcharge}) 
              	 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;您的钱包余额：<font class="text-danger">${wallet.balance }</font>
                </h4>
            </div>
            <div class="modal-body">请选择支付方式</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="pay">确定支付</button>
            </div>
        </div>
    </div>
</div>
</div>
</body>
<script>
	$(function(){
		$("#pay").click(function(){
			$("#myModal").modal('hide');
			
			location.href="debtinvestPay/"+${payment}+"/"+${servicecharge.servicechargeid}+"/"+${debttransferdisplay};
		});

	});
</script>
</html>
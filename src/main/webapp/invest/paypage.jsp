<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-validate/1.19.1/jquery.validate.js"></script>

</head>
<body>
	<div id="app" class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title"></h3>
	  </div>
	  <div class="panel-body">
	   <div  class="col-md-12" >
       	<table class="table table-striped table-bordered table-hover table-condensed">
       		<tr>
       			<th colspan="2">14期全体组员正在为您保驾护航，请确认支付信息后输入支付密码</th>
       			<th>${loandisplay.loanapply.userinfo.username }</th>
       		</tr>
       		<tr>
       			<th>付款金额</th>
       			<th>${investamount }</th>
       		</tr>
       		<tr>
       			<th>请输入6位支付密码</th>
       			<th><input name="password" type="text" /></th>
       		</tr>
       		<tr>
       			<th colspan="2"><input type="button" @click="pay()" value="确认"></th>
       		</tr>
       	</table>
       </div>
	  </div>
	</div>  
</body>
<script type="text/javascript">
	window.onload=function(){
		var vm=new Vue({
			el:"#app",
			data:{
				json:"",
				loandisplayid:${loandisplayid },
				investamount:${investamount },
				password:""
			},
			methods:{
				pay:function(){
					this.$http({
	                	method:'post',
	                	url:'/invest/pay',
	                	emulateJSON:true, 
	                	params:{
	                		investamount:this.investamount,
	                		password:this.password,
	                		loandisplayid:this.loandisplayid
	                	},	
	                }).then(function(res){
	                	 this.json=res.body;
	                },function(){
	                    console.log('请求失败处理');
	                });
				}
			}
		});
	}
</script>
</html>
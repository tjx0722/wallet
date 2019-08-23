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
<script
	src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
<marquee behavior="scroll" direction="left" scrollamount="5">近期不法活动猖獗，请谨慎投资！！！</marquee>
	<div id="app" class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">投资详细信息</h3>
		</div>
		<div class="panel-body">
			<div class="col-md-12">
				<table
					class="table table-striped table-bordered table-hover table-condensed">
					<tr>
						<th>借款人姓名</th>
						<th>${loandisplay.loanapply.userinfo.username }</th>
					</tr>
					<tr>
						<th>电话</th>
						<th>${loandisplay.loanapply.userinfo.user.phone }</th>
					</tr>
					<tr>
						<th>籍贯</th>
						<th>${loandisplay.loanapply.userinfo.nativeplace }</th>
					</tr>
					<tr>
						<th>工作</th>
						<th>${loandisplay.loanapply.userinfo.userjob }</th>
					</tr>
					<tr>
						<th>贷款原因</th>
						<th>${loandisplay.loanapply.reason }</th>
					</tr>
					<tr>
						<th>贷款利率</th>
						<th>${loandisplay.loanapply.loanrate.loanrate*100 }%</th>
					</tr>
					<tr>
						<th>贷款金额</th>
						<th>${loandisplay.loanapply.loanamount }元</th>
					</tr>
					<tr class="warning">
						<th>已募集金额</th>
						<th>${loandisplay.investcount }元</th>
					</tr>
					<tr class="info">
						<th>可投资金额</th>
						<th>{{restcount}}元</th>
					</tr>
					<tr class="danger">
						<th>还款期限</th>
						<th>${loandisplay.loanapply.loantime.loantime }个月</th>
					</tr>
				</table>
			</div>
			<div class="input-group">
				<span class="input-group-addon">投资金额</span> <input
					name="investamount" v-model="investamount" type="text"
					class="form-control"
					placeholder="剩余可投资金额：${loandisplay.loanapply.loanamount-loandisplay.investcount }元,请输入投资金额">
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#myModal">确认购买</button>
			</div>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title text-center" id="myModalLabel">请确认订单信息</h4>
					</div>
					<div class="modal-body">按下 Esc 按钮退出。</div>
					<div class="modal-body">
						<table
							class="table table-striped table-bordered table-hover">
							<tr>
								<td colspan="2">
									<div><marquee behavior="scroll" direction="left" scrollamount="5">14期全体成员正在为您保驾护航，请确认支付信息</marquee></div>
								</td>
							</tr>
							<tr>
								<th style="text-align: center"><font color="blue" size="4">付款金额</font></th>
								<th><span class="glyphicon glyphicon-gbp"
									style="color: red">{{investamount}}</span></th>
							</tr>
							<tr>
								<th colspan="2">
									<div  align="center"><button @click="purchase()" type="button" class="btn btn-primary">确认付款</button></div>
								</th>
							</tr>
						</table>
						<div align="right"><button style="size: 2" type="button" class="btn btn-default" data-dismiss="modal">取消</button></div>
					</div>
				</div>
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
				loandisplayid:${loandisplay.loandisplayid },
				investamount:"",
				restcount:${loandisplay.loanapply.loanamount-loandisplay.investcount },
				password:""
			},
			watch:{
				investamount(newValue,oldValue){
					this.investamount=this.investamount.replace(/[^\d]/g,"");
					if(this.investamount>this.restcount){
						this.investamount="";
						alert("投资金额输入有误");
					}
				}
			},
			methods:{
				purchase:function(){
					this.$http({
	                	method:'post',
	                	url:'/invest/purchase',
	                	emulateJSON:true, 
	                	params:{
	                		investamount:this.investamount,
	                		loandisplayid:this.loandisplayid
	                	},	
	                }).then(function(res){
	                },function(){
	                    console.log('请求失败处理');
	                });
				}
			}
		});
	}
</script>
</html>
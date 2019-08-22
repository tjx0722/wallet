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
</head>
<body>
	<div id="app" class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">投资详细信息</h3>
	  </div>
	  <div class="panel-body">
	   <div>
       	<table>
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
       		<tr>
       			<th>已募集金额</th>
       			<th>${loandisplay.investcount }元 </th>
       		</tr>
       		<tr>
       			<th>可投资金额</th>
       			<th>{{restcount}}元 </th>
       		</tr>
       		<tr>
       			<th>还款期限</th>
       			<th>${loandisplay.loanapply.loantime.loantime }个月</th>
       		</tr>
       	</table>
       </div>
       <form action="">
            <div class="input-group">
			  <span class="input-group-addon">投资金额</span>
			  <span style="color: red" class="input-group-addon">{{msg}}</span>
			  <input name="investamount" v-model="investamount" type="text" class="form-control" placeholder="请输入投资金额">
			  <button class="btn btn-default" type="button" @click="purchase()">确认购买</button>
			</div>
       </form> 
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
				msg:""
			},
			watch:{
				investamount(newValue,oldValue){
					this.msg="";
					this.investamount=this.investamount.replace(/[^\d]/g,"");
					if(this.investamount>this.restcount){
						this.investamount="";
						this.msg="投资金额必须小于或等于剩余筹款金额！";
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
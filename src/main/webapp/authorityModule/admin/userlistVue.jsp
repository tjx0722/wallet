<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
<div id="app">
<TABLE border="1" width="100%">
<TR align="center">
	<TD>用户id</TD>
	<TD>账户</TD>
	<TD>密码</TD>
	<TD>电话</TD>
	<TD>邮箱</TD>
	<TD>状态</TD>
	<TD>操作</TD>
	<TD>修改权限</TD>
</TR>
<TR align="center" v-for="user in json.list">
	<TD>{{user.userid}}</TD>
	<TD>{{user.account}}</TD>
	<TD>{{user.password}}</TD>
	<TD>{{user.phone}}</TD>
	<TD>{{user.email}}</TD>
	<TD>{{user.isdelete?'已删除':'正常'}}</TD>
	<TD>
		<%-- <a href="${!user.isdelete?'/authorityModule/delete':'/authorityModule/revoke'}?userid=${user.userid}">{{!user.isdelete?'删除':'恢复'}}</a>  --%>
		<button  @click="!user.isdelete?deleted(user.userid):revoke(user.userid)">{{!user.isdelete?'删除':'恢复'}}</button>
	</TD>
	<TD>
		<%-- <a href="goupdate?userid=${user.userid}">update</a>  --%>
		<button  @click="goupdate(user.userid)">update</button>
	</TD>
</TR>
</TABLE>
<TABLE border="1" width="100%">
<tr align="center">
	<td width="12.5%"><button @click="first()">first</button></td>
	<td width="12.5%"><button @click="before()">before</button></td>
	<td width="12.5%"><button @click="next()">next</button></td>
	<td width="12.5%"><button @click="end()">end</button></td>
	<td width="12.5%">
	第<input type="text" id="pageNow" name="pageNow" v-model="pageNow" size="1">页
	</td>
	<td width="12.5%">
	一页 <input type="text" name="limit" v-model="limit" id="up" size="1">行
	</td>
	<td width="12.5%">{{json.page.pageNow }}/{{json.page.pageCount }}</td>
	<td width="12.5%"><button @click="get()">go</button></td>
</tr>
<tr align="center" >
	<td width="100%" colspan="8">共 {{json.page.count }} 条记录</td>
</tr>
</TABLE>

</div>
</body>
</html>
<script>
	window.onload = function(){
	    var vm = new Vue({
	        el:'#app',
	        data:{
	            json:'',
	           	pageNow:1,
	            limit:10
	        },
	        mounted:function(){
	        	this.get();
	        },
	        methods:{
	            get:function(){
	            	
	            	this.$http({
	                	method:'post',
	                	url:'/authorityModule/findJson',
	                	emulateJSON:true, 
	                	params:{
	                		pageNow:this.pageNow,
	                		limit:this.limit,
	                	},	
	                }).then(function(res){
	                	 this.json=res.body;
	                	console.log(res);
	                },function(){
	                    console.log('请求失败处理');
	                });
	            } ,
	            first:function(){
	            	this.pageNow = 1;
	            	this.get();
	            },
	            next:function(){
	            	this.pageNow = parseInt(this.pageNow)==this.json.page.pageCount?this.json.page.pageCount:parseInt(this.pageNow)+1;
	            	this.get();
	            },
	            before:function(){
	            	this.pageNow = parseInt(this.pageNow)==1?1:parseInt(this.pageNow)-1;
	            	this.get();
	            },
	            end:function(){
	            	this.pageNow = this.json.page.pageCount;
	            	this.get();
	            },
				deleted:function(userid){
	            	this.$http({
	                	method:'post',
	                	url:'/authorityModule/delete',
	                	emulateJSON:true, 
	                	params:{
	                		userid:userid,
	                		pageNow:this.pageNow,
	                		limit:this.limit,
	                	},	
	                }).then(function(res){
	                	  this.json=res.body;
	                	 	this.get();
	                	 console.log(userid)
	                },function(){
	                    console.log('请求失败处理');
	                });
	            },
	            revoke:function(userid){
	            	this.$http({
	                	method:'post',
	                	url:'/authorityModule/revoke',
	                	emulateJSON:true, 
	                	params:{
	                		userid:userid,
	                		pageNow:this.pageNow,
	                		limit:this.limit,
	                	},	
	                }).then(function(res){
	                	  this.json=res.body;
	                	  this.get();
	                	 console.log(userid)
	                },function(){
	                    console.log('请求失败处理');
	                });
	            },
	            goupdate:function(userid){
	            	location.href="/authorityModule/goupdate/"+userid;
		        }
	        }
	    });
	}
</script>
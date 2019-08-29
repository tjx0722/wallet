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
	     <h3 class="panel-title" align="center">我的钱包</h3>
	  </div>
	   <div>
       	<table align="center" font-size="100">
       		
       		<tr align="center" >
       			<td  width="200" height="100">余额</td>
       			<td  width="200">${wallet.balance }</td>
       		</tr>
       		<tr align="center" >
       			<td>欠款</td>
       			<td>${wallet.debt }</td>
       		</tr>
    		</div>
       	</table>
       <form action="/userinfo/wallet/bankcard/findByIdss">
             <table width="1150px">
              <input  type="hidden" name="walletid" value="${wallet.walletid }"/>
              <tr height="50px" align="center">
            <td width="500"> 
           		<button class="btn btn-default" type="submit" style="width:1120px">我的银行卡</button> 
             </td>
             </tr>
           </table>
       </form>
       <form action="/userinfo/wallet/walletCZ">
       <table  width="1150px">
      
              <input  type="hidden" name="walletid" value="${wallet.walletid }"/>
              <tr height="50px" align="center">
              <td>
             <button class="btn btn-default" type="submit" style="width:1120px">充值</button>
               </td>
               </tr>
      </table>
       </form>
       <form action="/userinfo/wallet/walletTX">
       <table width="1150px">
              <input  type="hidden" name="walletid" value="${wallet.walletid }"/>
            <tr height="50px" align="center"> 
            <td>
             <button class="btn btn-default" type="submit" style="width:1120px">提现</button>
            </td>
            </tr>
       </table>
       </form>
	  </div>
  
</body>
  <script type="text/javascript">
	window.onload=function(){
		var vm=new Vue({
			el:"#app",
			data:{
				json:"",
				userinfoid:${wallet.userinfoid },
				investamount:"",
				restcount:${wallet },
				msg:""
			},
			methods:{
			}	
			
		});
	}
</script>  
</html>
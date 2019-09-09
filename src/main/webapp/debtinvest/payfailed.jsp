<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var SysSecond;
	var InterValObj;

	$(document).ready(function() {
		SysSecond = parseInt($("#remainSeconds").html()); //这里获取倒计时的起始时间
		InterValObj = window.setInterval(SetRemainTime, 1000); //间隔函数，1秒执行
	});

	//将时间减去1秒，计算天、时、分、秒
	function SetRemainTime() {
		if (SysSecond > 0) {
			SysSecond = SysSecond - 1;
			var second = Math.floor(SysSecond % 60); // 计算秒     
			var back ="";
			if(${chance==0}){
				back = "/debtinvest/debttransferdisplay.jsp";
			}else{
				back = "repay/${payment}/${debttransferdisplay}/${servicechargeid}";
				if(!${isrestAmount}){
					back="/debtinvest/debttransferdisplay.jsp";
				}
				
			}
			$("#remainTime").html("<h1><font color='black' face='楷体'>${msg}<br><br>" + second + "秒后为您<a href="+back+">返回</a><font></h1>");

			if (second === 0) {
				window.clearInterval(InterValObj);
				window.location.href = back;
			}
		}
	}
</script>
</head>

<body>
	<div class="panel panel-default"style="background: url('back.jpg'); height: 760px;width: 1089px" align="center">
		<div class="panel-heading" style="background-color: #9CD9DA">
		 <h2>支付失败</h2>
		</div>
		<div class="panel-body">
				<div id="remainTime"
					style="font-size: 20px; font-weight: 800; color: white; position: relative;top:200px"></div>
			</div>
	</div>
	<div id="remainSeconds" style="display: none">5</div>
</body>
</html>
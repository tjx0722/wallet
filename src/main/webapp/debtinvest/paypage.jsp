﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<script type="text/javascript" src="<%=basePath%>js/jquery-2.0.3.min.js"></script>
<script src="<%=basePath%>js/jquery-validate.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap-3.3.7-dist/css/bootstrap.css">
<script type="text/javascript"
	src="<%=basePath%>bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<style>
.clearfix:after {
    clear: both;
}
.clearfix:before, .clearfix:after {
    content: " ";
    display: table;
}
 .alieditContainer{
        position: relative;
    } 
    
.sixDigitPassword {
    position: absolute;
    left: -122px;
    top: 0;   
    width: 1000px;
    height: 26px;  
    color: #fff;
    font-size: 12px;
    -webkit-box-sizing: content-box;
    box-sizing: content-box;
    -webkit-user-select: initial;
    outline: 'none';
    z-index: 999;
    opacity:0;
    filter:alpha(opacity=0);
  }

  .sixDigitPassword-box {
      
        cursor:text;
        background: #fff;
        outline: none;
        position: relative;
        padding: 8px 0;
        height: 30px;
        border: 1px solid #cccccc;
        border-radius: 2px;
  }
  .sixDigitPassword-box i {
        float: left;
        display: block;
        padding: 4px 0;
        height: 7px;
        border-left: 1px solid #cccccc;
    }
   .sixDigitPassword-box .active {
        background: url('<%=basePath%>img/password-blink.gif') no-repeat center center;        
    }
   .sixDigitPassword-box b {
        display: block;
        margin: 0 auto;
        width: 7px;
        height: 7px;
        overflow: hidden;
        visibility:hidden;
        background: url('<%=basePath%>img/passeord-dot.png') no-repeat;
    }
  .sixDigitPassword-box span {
        position: absolute;
        display: block;
        left: 0px;
        top: 0px;
        height: 30px;
        border: 1px solid rgba(82, 168, 236, .8);
        border: 1px solid #00ffff\9;
        border-radius: 2px;
        visibility: hidden;
        -webkit-box-shadow: inset 0px 2px 2px rgba(0, 0, 0, 0.75), 0 0 8px rgba(82, 168, 236, 0.6);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6);
    }
    .ui-securitycore  .ui-form-item .ui-form-explain{
		margin-top: 8px; 
	}
  .i-block{
	display:inline-block;
  }
 .six-password{
    position: relative;
    height:33px;
    width:182px;
    overflow: hidden;
    vertical-align: middle;
    
}
</style>
</head>
<body>
<div style="margin:0 auto;width:500px;">
<br><br><br>
<form action="/debtinvest/pay" method="post" id="form_paypsw">
<div id="payPassword_container" class="alieditContainer clearfix well well-lg" data-busy="0">
	<label for="i_payPassword" class="i-block">支付密码：</label>
	<div class="i-block" data-error="i_error">
		<div class="i-block six-password">
			<input type="hidden" name="payment" value="${payment }">
			<input type="hidden" name="debttransferdisplay" value="${debttransferdisplay }">
			<input type="hidden" name="servicechargeid" value="${servicechargeid }">
			<input class="i-text sixDigitPassword" id="payPassword_rsainput" type="password" autocomplete="off" required="required" value="" name="payPassword_rsainput" data-role="sixDigitPassword" tabindex="" maxlength="6" minlength="6" aria-required="true">
			<div tabindex="0" class="sixDigitPassword-box" style="width: 180px;">
				<i style="width: 29px; border-color: transparent;" class=""><b style="visibility: hidden;"></b></i>
				<i style="width: 29px;"><b style="visibility: hidden;"></b></i>
				<i style="width: 29px;"><b style="visibility: hidden;"></b></i>
				<i style="width: 29px;"><b style="visibility: hidden;"></b></i>
				<i style="width: 29px;"><b style="visibility: hidden;"></b></i>
				<i style="width: 29px;"><b style="visibility: hidden;"></b></i>
				<span style="width: 29px; left: 0px; visibility: hidden;" id="cardwrap" data-role="cardwrap"></span>
			</div>
		</div>
		<span>请输入6位支付密码( 数字！)</span>
	</div>
</div>
<div class="col-md-10 col-md-offset-5">
	<button class="btn btn-info">确认密码</button>
</div>
</form>
</div>
<script type="text/javascript">
var _formPay = $('#form_paypsw');
				
			_formPay.validate({
					rules : {
						'payPassword_rsainput':{
							'minlength':6,
							'maxlength':6,
							required:true,
							digits : true,
							numPassword : true,
							echoNum :true
						}
					},
					
					messages:{
						'payPassword_rsainput':{
							'required' : '<i class="icon icon-attention icon-lg"></i>&nbsp;请填写支付密码',
							'maxlength' : '<i class="icon icon-attention icon-lg"></i>&nbsp;密码最多为{0}个字符',
							'minlength' : '<i class="icon icon-attention icon-lg"></i>&nbsp;密码最少为{0}个字符',
							'digits':'<i class="icon icon-attention icon-lg"></i>&nbsp;密码只能为数字',
							'numPassword' : '<i class="icon icon-attention icon-lg"></i>&nbsp;连号不可用，相同数字不可用（如：123456，11111）',
							'echoNum' :'<i class="icon icon-attention icon-lg"></i>&nbsp;连号不可用，相同数字不可用（如：123456，11111）'		
						}
					},
					errorPlacement : function(error, element) {
						element.closest('div[data-error="i_error"]').append(error);
					},	
					submitHandler : function(form){
						var _form = $(form);
						form.submit();

					}
				});
				
var payPassword = $("#payPassword_container"),
    _this = payPassword.find('i'),	
	k=0,j=0,
	password = '' ,
	_cardwrap = $('#cardwrap');
	//点击隐藏的input密码框,在6个显示的密码框的第一个框显示光标
	payPassword.on('focus',"input[name='payPassword_rsainput']",function(){
	
		var _this = payPassword.find('i');
		if(payPassword.attr('data-busy') === '0'){ 
		//在第一个密码框中添加光标样式
		   _this.eq(k).addClass("active");
		   _cardwrap.css('visibility','visible');
		   payPassword.attr('data-busy','1');
		}
		
	});	
	//change时去除输入框的高亮，用户再次输入密码时需再次点击
	payPassword.on('change',"input[name='payPassword_rsainput']",function(){
		_cardwrap.css('visibility','hidden');
		_this.eq(k).removeClass("active");
		payPassword.attr('data-busy','0');
	}).on('blur',"input[name='payPassword_rsainput']",function(){
		
		_cardwrap.css('visibility','hidden');
		_this.eq(k).removeClass("active");					
		payPassword.attr('data-busy','0');
		
	});
	
	//使用keyup事件，绑定键盘上的数字按键和backspace按键
	payPassword.on('keyup',"input[name='payPassword_rsainput']",function(e){
	
	var  e = (e) ? e : window.event;
	
	//键盘上的数字键按下才可以输入
	if(e.keyCode == 8 || (e.keyCode >= 48 && e.keyCode <= 57) || (e.keyCode >= 96 && e.keyCode <= 105)){
			k = this.value.length;//输入框里面的密码长度
			l = _this.size();//6
			
			for(;l--;){
			
			//输入到第几个密码框，第几个密码框就显示高亮和光标（在输入框内有2个数字密码，第三个密码框要显示高亮和光标，之前的显示黑点后面的显示空白，输入和删除都一样）
				if(l === k){
					_this.eq(l).addClass("active");
					_this.eq(l).find('b').css('visibility','hidden');
					
				}else{
					_this.eq(l).removeClass("active");
					_this.eq(l).find('b').css('visibility', l < k ? 'visible' : 'hidden');
					
				}				
			
			if(k === 6){
				j = 5;
			}else{
				j = k;
			}
			$('#cardwrap').css('left',j*30+'px');
		
			}
		}else{
		//输入其他字符，直接清空
			var _val = this.value;
			this.value = _val.replace(/\D/g,'');
		}
	});	
	
</script>  
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
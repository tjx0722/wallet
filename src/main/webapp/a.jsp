<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>JS实现button点击之后60秒后才可以再次点击</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <style type="text/css">
    .cen {
     text-align: center
    }
    </style>
</head>
<body>
<div class="cen">
<button id='test'>免费获取验证码</button>
</div>
<script type="text/javascript">
   var waitTime = 60;
    document.getElementById("test").onclick = function() {
        time(this);
    }
    function time(ele) {
        if (waitTime == 0) {
            ele.disabled=false;
            ele.innerHTML = "免费获取验证码";
            waitTime = 60;// 恢复计时
        } else {
            ele.disabled=true;
            ele.innerHTML = waitTime + "秒后可以重新发送";
            waitTime--;
            setTimeout(function() {
                time(ele)// 关键处-定时循环调用
            }, 1000)
        }
    }
</script>
<input type="txt" id="in">
</body>
</html>

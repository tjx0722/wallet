<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
$(function() {
	$(".btn").click(function(){
		return confirm("你确定要删除吗？");
    })
});
</script>
</head>
<body>
	<button class="btn">button</button>
</body>
</html>
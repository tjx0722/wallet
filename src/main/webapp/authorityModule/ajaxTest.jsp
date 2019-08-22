<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "POST",
			   url: "/authorityModule/findAll",
			   //data: "name=John&location=Boston",
			   success: function(data){
			     
			   }
			});
	})
</script>
</head>
<body>
	
</body>
</html>
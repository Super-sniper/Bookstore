<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
	body{
		text-align:center;
		
	}
	#container{
		margin-top:30px;
	}
	
	input{
		width:250px;
		height:30px;
		font-size:20px;
	}
	
</style>

<body >
	<div id="head">
		<h1>用户登录</h1>
		<hr>
	</div>
	<div id="container">
		<form  action="${pageContext.request.contextPath }/ClientLoginServlet?method=login" method="post">
			<input type="text" name="username" placeholder="请输入您的账号"/><br/><br>
			<input type="password" name="password" placeholder="请输入您的密码"/><br/><br>
			<input type="submit" value="立即登录" /><br/><br>
			<a href="${pageContext.request.contextPath }/jsp/register.jsp" style="color:blue;font-size:15px;text-align:right">还没有账号？注册一个吧！</a><br><br>
		</form>
	</div>
</body>
</html>
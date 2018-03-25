<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
    
    <style type="text/css">
    	input{
    		font-size:18px;
    	}
    </style>
    
  </head>
  
  <body style="text-align: center;font-size:20px">
    <h1>用户注册</h1>
    <hr>
    <form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
    	<center>
	    	<table width="300px"style="font-size:20px" >
	    
	    	<tr>
	    		<th>用户名</th>
	    		<td><input type="text" name="username" placeholder="请输入用户名" style="width: 200px;height:30px"></td>
	    	<tr>
	    	<tr>
	    		<th>密码</th>
	    		<td><input type="password" name="password" placeholder="请输入密码" style="width: 200px;height:30px"></td>
	    	</tr>
	    	<tr>
	    		<th>电话</th>
	    		<td><input type="text" name="phone" placeholder="请输入电话号码"style="width: 200px;height:30px"></td>
	    	</tr>
	    	<tr>
	    		<th>手机</th>
	    		<td><input type="text" name="cellphone" placeholder="请输入手机号码"style="width: 200px;height:30px"></td>
	    	</tr>
	    	<tr>
	    		<th>住址</th>
	    		<td><input type="text" name="address" placeholder="请输入住址"style="width: 200px;height:30px"></td>
	    	</tr>
	    	<tr>
	    		<th>邮箱</th>
	    		<td>
	    			<input type="text" name="email" placeholder="请输入邮箱" style="width: 200px;height:30px">
	    		</td>
	    	</tr>
	    	<tr>
	    		<td></td><td><input type="submit" value="注册"></td>
	    	</tr>
	    	</table>
    	</center>
    </form>
    
    
  </body>
</html>

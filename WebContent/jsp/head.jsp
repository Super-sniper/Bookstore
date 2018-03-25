<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页头</title>
   <style>
	    body{
			text-align:center;
			font-size:20px
			margin:0px;
			padding:0px;
		}
		
		a{
			text-decoration:none;
		}
		
		#login-out{
			text-align:right;
		}
		
    </style>
</head>
<body style="text-align:center">
	<div id="head">
		<h1>木叶图书商城</h1>
		<a href="${pageContext.request.contextPath }/Index">首页</a>
		<a href="${pageContext.request.contextPath }/jsp/listcar.jsp">查看购物车</a>
		<a href="${pageContext.request.contextPath }/MyOrderServlet?method=listorder">查看订单</a>
		<div id="login-out">
			<c:if test="${user==null }">
					<a href="${pageContext.request.contextPath }/ClientLoginUI">登录</a>
			</c:if>
			<c:if test="${user!=null }">
				欢迎：${user.username} &nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/ClientLoginServlet?method=logout">注销</a>
			</c:if>
		</div>
		<hr/>
	</div>
</body>
</html>
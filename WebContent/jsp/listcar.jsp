<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
    
 
  </head>
  
   <body style="text-align: center">
	   <div>
	   		<%@include file="/jsp/head.jsp" %>
	   </div>
   	<br/>
   	<center>
   	<table border="1" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>购物车页面</h2></caption>
   		<tr>
   			<th>书名</th>
   			<th>售价</th>
   			<th>数量</th>
   			<th>小计</th>
   		</tr>
   		
   		<c:forEach var="entry" items="${car.map}">
   			<tr>
	   			<td>${entry.value.book.name }</td>
	   			<td>${entry.value.book.price }</td>
	   			<td>${entry.value.quantity }</td>
	   			<td>${entry.value.price }元</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">合计</td>
   			<td colspan="2">${car.price }元</td>
   		</tr>
   	</table>
    <br>
    <a href="${pageContext.request.contextPath }/OrderServlet?method=buy" style="font-size:20px;font-color:blue">生成订单</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath }/OrderServlet?method=cancel" style="font-size:20px;font-color:blue">取消订单</a>
    </center>
  </body>
</html>

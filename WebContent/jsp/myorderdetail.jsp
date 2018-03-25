<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单明细</title>
  </head>
  
  <body style="text-align:center">
  	<h1>订单明细</h1>
    <table border="1" cellpadding="0" cellspacing="0" width="90%">
   		
   		<tr>
   			<th>书名</th>
   			<th>售价</th>
   			<th>数量</th>
   			<th>应收货款</th>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${order.orderItems}">
   			<tr>
	   			<td>${orderitem.book.name }</td>
	   			<td>${orderitem.book.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }元</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">总计应收货款</td>
   			<td colspan="2">${order.price }元</td>
   		</tr>
   	</table>
   	<br/>
  </body>
</html>

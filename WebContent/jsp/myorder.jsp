<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>我的订单</title>
  </head>
  
  <body style="text-align: center">
	<h1>订单信息</h1>
   	<table border="1" cellpadding="0" cellspacing="0" width="90%"  style="text-align: center">
   		
   		<tr>
   			<th>订单人</th>
   			<th>下单时间</th>
   			<th>订单状态</th>
 			<th>订单总价</th>
 			<th>操作</th>
   		</tr>

			<c:forEach var="order" items="${list}">
				<tr>
					<td>
						${order.user.username }
					</td>
					<td>
						${order.ordertime }
					</td>
					<td>
						${order.state==false?'未发货':'已发货' }
					</td>
					<td>
						${order.price }
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/MyOrderServlet?method=find&id=${order.id }">查看明细</a>	
					</td>
				</tr>
			</c:forEach>
		</table>
  </body>
</html>

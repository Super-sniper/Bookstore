<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台书籍列表</title>
  </head>
	<body style="text-align: center">
   	<br/><br/>
   	<center>
   	<table border="1" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>图书信息</h2></caption>
   		<tr>
   			<th>书名</th>
   			<th>作者</th>
   			<th>描述</th>
   			<th>图片</th>
 			<th>操作</th>
   		</tr>
   		
   		<c:forEach var="book" items="${list}">
   			<tr>
   				<td>${book.name }</td>
   				<td>${book.author }</td>
   				<td>${book.description }</td>
   				<td><a href="/upload/${book.image }">查看图片</a></td>
	   			<td>
	   				<a href="#">修改</a>
	   				<a href="#">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	</center>
   	<br/><br/>
 
    
  </body>
</html>


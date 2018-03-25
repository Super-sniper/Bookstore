<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>添加分类页面</title>
  </head>
  
  <body>
    <br/><br/>
    <form action="${pageContext.request.contextPath}/ManagerCategoryServlet?method=add" method="post">
    	<table width="500px;">
    	
    	<tr>
    		<th>分类名称：</th>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<th>分类描述：</th>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="添加分类"></td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
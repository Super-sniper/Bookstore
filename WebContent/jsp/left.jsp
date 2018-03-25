<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>后台左侧导航页面</title>
    
    <style type="text/css">
      .dc { 
      		display: block; 
      		margin-left: 10px;
      	  }
      	  
      body{
      	font-size:20px;
      }
      
      a{
      	text-decoration:none;
      }
	</style>
	
	<script language="javascript">
	      function test(e) {
	            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;       
	      }
	</script>
  </head>
  
  <body>
    <ul>
    	<li>
    		<a href="#" onclick="test(children[0])">分类管理
    			<div class="dc">
	    			<a href="${pageContext.request.contextPath }/jsp/addCategory.jsp"  target="main">添加分类</a><br/>
	    			<a href="${pageContext.request.contextPath }/ManagerCategoryServlet?method=getAll"  target="main">查看分类</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">图书管理
    			<div class="dc">
	    				<a href="${pageContext.request.contextPath }/BookServlet?method=addBookUI"  target="main">添加图书</a><br/>
	    				<a href="${pageContext.request.contextPath }/BookServlet?method=getAll"  target="main">查看图书</a>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test(children[0])">订单管理
	    		<div class="dc">
	    			<a href="${pageContext.request.contextPath}/ManagerOrderServlet?method=getAll&state=false"  target="main">待处理订单</a><br/>
	    			<a href="${pageContext.request.contextPath}/ManagerOrderServlet?method=getAll&state=true"  target="main">已发货订单</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    </ul>
  </body>
</html>

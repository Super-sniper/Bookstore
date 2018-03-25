<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>木叶图书商城</title>
</head>

<script type="text/javascript">
	
</script>

<style>

	body{
		text-align:center;
		font-size:20px
		margin:0px;
		padding:0px;
	}
	
	#main{
		margin-top:30px;
		margin-left:50px;
	}
	
	#login-out{
		text-align:right;
		margin-right:20px;
	}
	
	a{
		text-decoration:none;
	}
	#categories{
		width:250px;
		border-style:solid;
		border-color:pink;
		float:left;
	}
	
	#books{
		float:left;
		margin-left:80px;
	}
	
	#image{
		float:left;
	}
	
	#info{
		float:left;
	}
	#book{
		float:left;
		margin-bottom:15px;
		width:300px;
	}

</style>


	

<body>
	<div id="head">
		<%@include file="/jsp/head.jsp"%>
	</div>
	
	<div id="main">
		<div id="categories">
			<div style="text-align:left">
				<h3>书籍列表：</h3>
			</div>
			<div style="margin-left:50px;text-align:left">
				<ul>
					<c:forEach var="c" items="${categories }">
						<li><a href="${pageContext.request.contextPath }/Index?category_id=${c.id}">${c.name }</a></li><br/><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
		
		<div id="books">
			<c:forEach var="book" items="${pagebean.list }" varStatus="status">
				<div id="book">
					<div id="image">
						<img src="/upload/${book.image }"/>
					</div>
					<div id="info" style="text-align:left">
						<ul>
							<li>${book.name }</li>
							<li>${book.author }</li>
							<li>${book.price }</li>
							<li>
								<a href="${pageContext.request.contextPath }/BuyServlet?id=${book.id}">购买</a>
							</li>
						</ul>
					</div>
					
					<div style="clear:both"></div>
				</div>
				
				<c:if test="${ status.count%3==0}">
						<div style="clear:both"></div>
				</c:if>
			</c:forEach>
			<div style="clear:both"></div>
			<br/>
			<div id="pagebean">
				总共[${pagebean.totalPage }]页 &nbsp;
				当前第[${pagebean.currentPage }]页 &nbsp;
				<c:forEach var="pagenum" items="${pagebean.pageBar }">
					<c:if test="${pagenum==pagebean.currentPage}">
						<front style="background-color:yellow">
							<a href="${pageContext.request.contextPath }/Index?currentPage=${pagenum}&category_id=${param.category_id}" >${pagenum}</a>
						</front>
					</c:if>
					<c:if test="${pagenum!=pagebean.currentPage}">
						<a href="${pageContext.request.contextPath }/Index?currentPage=${pagenum}&category_id=${param.category_id}">${pagenum}</a>
					</c:if>
				</c:forEach>
				
			</div>
		</div>
	</div>
</body>
</html>
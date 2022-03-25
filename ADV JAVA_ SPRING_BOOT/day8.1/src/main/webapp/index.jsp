<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="centre">
		Session ID :
		<%=session.getId()%>
	</h5>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scriptlets, Expressions, EL Syntax</a>
	</h5>
	<h5>
		<a href="login.jsp">Test JSP Declaration</a>
	</h5>
	<h5>
		<a href="login1.jsp">User Login</a>
	</h5>
	<h5>
		<a href="test2.jsp">Error Handling in JSP</a>
	</h5>
	<h5>
		<a href="test6.jsp">Include Directive</a>
	</h5>
	<h5>
		<a href="test8.jsp?name=Rama&age=26">JSP Forward Action</a>
	</h5>
	<h5>
		<a href="test10.jsp?name=Rama&age=26">JSP Include Action</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Spring MVC Web App up n running!</h4>
	<h5>
		<a href="test">Test MVC Flow</a>
	</h5>
	<h5>
		<a href="basic/test1">Test Model n View</a>
	</h5>
	<h5>
		<a href="basic/test2">Test Model Map</a>
	</h5>
	<h5>
	
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h5>
</body>
</html>
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
	<h5>Hello Spring Boot @ ${requestScope.time_stamp}</h5>
	<h5>		
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h5>
	<h5>		
		<a href="<spring:url value='/user/findName'/>">Find by name</a>
	</h5>
</body>
</html>
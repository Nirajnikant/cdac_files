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
	<h5>Tut Details : ${requestScope.tut_details}</h5>
	<h5>
		<a
			href="<spring:url value='/customer/tutorials?topicId=${requestScope.tut_details.topic.id}'/>">Back</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Out</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h5 style="color: green;">${requestScope.message}</h5>
	<%--add welcome mesg , as per the role --%>
	<h5>Hello , ${requestScope.user_details.name}</h5>
	<h5>You have logged in under ${requestScope.user_details.role}</h5>
</body>
</html>
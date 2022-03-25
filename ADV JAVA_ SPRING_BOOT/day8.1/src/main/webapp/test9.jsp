<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 2nd Page</h5>
	<%--Display name and age of the user w/o scripltlet--%>
	<h5>Name : ${param.name }</h5>
	<h5>Age : ${param.age }</h5>
	<h5>Designation : ${param.designation}</h5>
	<h5>Page Scoped Attribute : ${pageScope.attr1 }</h5>
	<h5>Request Scoped Attribute : ${requestScope.attr2 }</h5>
</body>
</html>
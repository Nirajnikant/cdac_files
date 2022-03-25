<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From First Page</h5>
	<%--Display name and age of the user w/o scripltlet--%>
	<h5>Name : ${param.name }</h5>
	<h5>Age : ${param.age }</h5>
	<%
	pageContext.setAttribute("attr1", 1234);
	request.setAttribute("attr2", 2235);
	%>
	<jsp:forward page="test9.jsp">
		<jsp:param value="SD" name="designation" />
	</jsp:forward>
</body>
</html>
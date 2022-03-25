<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
String mesg = "some messg....";// instance variable
%>
<body>
<h5>From the First page...</h5>
<%
	int counter = 100;// method local veriable :: within _jspService
	// create a page scope attribute
	pageContext.setAttribute("name", 12345); // page scoped attribute

%>
<%@ include file="test7.jsp" %>
</body>
</html>
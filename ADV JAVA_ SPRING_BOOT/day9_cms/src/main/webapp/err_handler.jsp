<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 style="color: red;">Exception Message : <%= exception.getMessage() %></h5>
<h5 style="color: red;">Exception Message via EL Syntax: ${pageContext.exception.message}</h5>
<h5 style="color: red;">URI of the JSP causing Error : ${pageContext.errorData.requestURI}</h5>
<h5 style="color: red;">Status Code : ${pageCOntext.errorData.statusCode}</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>From the included page...</h5>
<%-- Try to access instance var, method local var and page scope sttribute --%>
<h5>Instance Var : <%= mesg %></h5>
<h5>Method local variables : <%= counter %></h5>
<h5>Page Scoped Attribute : ${pageScope.name} </h5>
</body>
</html>
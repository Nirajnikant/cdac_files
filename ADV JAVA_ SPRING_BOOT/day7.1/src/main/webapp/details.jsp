<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>
		Session ID from details page :
		<%=session.getId()%></h5>
	<h5>Validate User Details : ${sessionScope.clnt_details }</h5>
	<% 
	// url : method local var -- local within _jspService
	String url = response.encodeURL("logout.jsp");
	%>
	
	<h5>
		<a href="<%= url%>">Log Me Out</a>
	</h5>
</body>
</html>
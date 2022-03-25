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
		Session ID from logout page :
		<%=session.getId()%></h5>
	<%-- session.getAttribute("clnt_details").getName() --%>
	<h5> Hello ,${sessionScope.clnt_details.name}</h5>
	<%
	session.invalidate();
	%>
	<h5> You Have Logged out</h5>
	<h5>
		<a href="login1.jsp">Visit again</a>
	</h5>
</body>
</html>
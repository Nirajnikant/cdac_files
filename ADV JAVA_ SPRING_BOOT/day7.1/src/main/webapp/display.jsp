<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="centre">
		Session ID :
		<%=session.getId()%>
	</h5>

	<%
	// JSP scriptlet
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	out.print("<h5> " + email + " " + password + " </h5>");
	%>
	<hr/>
	<%-- Display email and password using JSP expression --%>
	<h5>Email : <%= request.getParameter("em") %></h5>
	<h5>Password : <%= request.getParameter("pass") %></h5>
	<h5>Session Expiration Timeout Using JSP Expression</h5>
	<h5><%= session.getMaxInactiveInterval()%></h5>
	<hr/>
	<h5>EL Syntax</h5>
	<h5> param : ${param}</h5>
	<h5> Email : ${param.em}</h5>
	<h5> Password : ${param.pass}</h5>
	<h5>Session Expiration Timeout Using JSP Expression</h5>
	<%--pageContext.getSession().getMaxInactiveInterval() --%>
	${pageContext.session.maxInactiveInterval}
	<h5>Value of JSESSIONID using EL syntax : ${pageContext.session.id}</h5>
	<%-- cookie.get("JSESSIONID").getValue() -- sent to client --%>
	<h5>Value of JSESSIONID using EL syntax and cookie : ${cookie.JSESSIONID.value}</h5>
</body>
</html>
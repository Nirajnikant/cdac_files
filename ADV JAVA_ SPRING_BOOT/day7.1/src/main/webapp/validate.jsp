<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!// JSP declaration block
	HashMap<String, User> users; //instance variable
	// jspInit

	public void jspInit() {
		users = new HashMap<>();
		users.put("Rama", new User("Rama", "1234", 25));
		users.put("Anish", new User("Anish", "2234", 35));
	}%>
<body>
<h5>Session ID from validation page : <%= session.getId() %></h5>
	<%
	// get request params
	String nm = request.getParameter("name");
	String pwd = request.getParameter("pass");
	User user = users.get(nm);
	if (user != null) {
		if (user.getPassword().equals(pwd)) {
			// login success --> store validated user details, under session scope
			session.setAttribute("clnt_details", user);
			//redirect CP II : With URL encoding
			//API : HttpServletResponse : public String encodeRedirectURL(String location)
			response.sendRedirect(response.encodeRedirectURL("details.jsp"));
		} else {
	%>
	<h5>
		Invalid Password, Please <a href="login1.jsp">Retry</a>
	</h5>
	<%
	}
	} else {
	%>
	<h5>
		New User, Please <a href="register.jsp">Register</a>
	</h5>
	<%
	}
	%>
</body>
<%!//
	public void jspDestroy() {
		users = null;
	}%>
</html>
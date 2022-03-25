<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello, ${sessionScope.user.validatedUserDetails.name}</h5>
	<h4 style="color:greeb;">Last Action : ${sessionScope.tut.message}</h4>
	<%-- cleanup of all dao --%>
	${sessionScope.user.userDao.cleanUp()}
	${sessionScope.topic.topicDao.cleanUp()} 
	${sessionScope.tut.tutDao.cleanUp()}  
	<%-- invalidate session --%>
	${pageContext.session.invalidate()}
	<h5> You have been logged out</h5>
	<h5>
		<a href="login.jsp"> Visit again</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <h5> All tut names ${requestScope.tut_names}</h5> --%>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Tutorials Under Topic ID : ${param.topicId}</caption>
		<c:forEach var="nm" items="${requestScope.tut_names}">
		<tr>
			<td><a href="<spring:url value='/customer/tutorial_details?tut_name=${nm}'/>">${nm}</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h5>List : ${requestScope.projectList}</h5> --%>
	<form action="/students/details">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Project Titles</caption>
			<tr>
				<td>Topic</td>
				<td><select name="titleName">
						<c:forEach var="title" items="${requestScope.projectList}">
							<option value="${title}">${title}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add New Tutorial" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
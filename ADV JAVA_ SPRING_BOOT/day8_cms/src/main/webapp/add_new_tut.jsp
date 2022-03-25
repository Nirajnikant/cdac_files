<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="topic" class="beans.TopicBean" scope="session" />
<body>
	<%--add welcome mesg , as per the role --%>
	<h5 style="color: green;">${sessionScope.user.message}</h5>
	<h5>Hello , ${sessionScope.user.validatedUserDetails.name}</h5>
	<h5>You have logged in under
		${sessionScope.user.validatedUserDetails.role}</h5>
	<%--After bean instanc , can JSP  call B.L method of JB --%>
	<h5>Topics : ${sessionScope.topic.topics}</h5>
	<form action="process_form.jsp">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Add New Tutorial Form</caption>
			<tr>
				<td>Topic</td>
				<td><select name="topic_id">
						<c:forEach var="t" items="${sessionScope.topic.topics}">
							<option value="${t.topicId}">${t.topicName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="tutName" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" /></td>
			</tr>
			<tr>
				<td>Publication Date</td>
				<td><input type="date" name="pubDate" /></td>
			</tr>
			<tr>
				<td>Contents</td>
				<td><textarea name="contents"></textarea>
			</tr>
			<tr>
				<td><input type="submit" value="Add New Tutorial" /></td>
			</tr>

		</table>
	</form>
</body>
</html>
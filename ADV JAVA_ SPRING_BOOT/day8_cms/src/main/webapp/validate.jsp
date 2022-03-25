<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--Instantiate JB w/o java code , using JSP std action --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<%--invoke JB' setters  setEmail n setPassword --%>
<%--For coreect working , MUST MATCH req param names with JB property setters --%>
<jsp:setProperty property="*" name="user"/>
<body>
<%--invoke B.L method of JB w/o scriptlet EL --%>
<%--session.getAttribute("user").validateUser()--%>
<%-- <h5>Outcome : ${sessionScope.user.validateUser()}</h5> --%>
<%-- <jsp:forward page="${sessionScope.user.validateUser()}.jsp"/> --%>
<%--WC invokes : response.sendRedirect(response.encodeRedirectURL(session.getAttribute("user").validateUser()).concat(".jsp") --%>
<c:redirect url="${sessionScope.user.validateUser()}.jsp"/>


</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--Instantiate JB w/o java code , using JSP std action --%>
<%--invoke JB' setters  setEmail n setPassword --%>
<%--For coreect working , MUST MATCH req param names with JB property setters --%>
<jsp:setProperty property="*" name="user"/>
<%--invoke B.L method of JB w/o scriptlet EL --%>
<%--session.getAttribute("user").validateUser()--%>
<%-- <h5>Outcome : ${sessionScope.user.validateUser()}</h5> --%>
<%-- <jsp:forward page="${sessionScope.user.validateUser()}.jsp"/> --%>
<%--WC invokes : response.sendRedirect(response.encodeRedirectURL(session.getAttribute("user").validateUser()).concat(".jsp") --%>
<c:redirect url="${sessionScope.user.validateUser()}.jsp"/>

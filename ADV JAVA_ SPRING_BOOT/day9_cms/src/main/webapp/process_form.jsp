<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- invoke tutorial bean's setter to pass the state --%>
<jsp:setProperty property="*" name="tut" />
<!-- invoke B.L. method of a tutorial bean and accordingly redirect the client -->
<c:redirect url="${sessionScope.tut.validateAddTutorial()}.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp"/>
<section class="main-content">
<h3>Thank you for your submission</h3>

<c:forEach var="survey" items="${surveys}">
	<p><c:out value="${survey.votes} ${survey.parkName}"/></p>	
</c:forEach>
</section>
<c:import url="footer.jsp"/>
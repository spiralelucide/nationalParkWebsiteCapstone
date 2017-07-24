<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp" />

<section class="main-content">
	<h1>National Parks</h1>

	<c:forEach var="park" items="${parkList}">
		<c:url var="parkLink" value="/detailpage">
		<c:param name="parkCode" value="${park.parkCode}" />
		</c:url>
		<a href="${parkLink}">
		<img class="parkimg" src="img/parks/${park.parkCode.toLowerCase()}.jpg"></a>
		<c:url value="img/parks/${park.parkCode}.jpg" var="parkImageURL">
		</c:url>
		<div id="location">
			<h4>${park.parkName}</h4>
			<p>${park.state}</p>
		</div>
		<p>${park.parkDescription}</p>
		<hr>
	</c:forEach>
</section>

<c:import url="footer.jsp"/>
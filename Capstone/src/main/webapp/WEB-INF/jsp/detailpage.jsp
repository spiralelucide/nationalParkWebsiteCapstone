<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="header.jsp" />

<!DOCTYPE html>
<html>
<section class="main-content">
	<h2>
		<c:out value="${park.parkName}: ${park.state}" />
	</h2>
	<p><span class="italicize"><c:out value="${park.inspirationalQuote}"/></span><c:out value=" -${park.quoteSource}" /></p>
	<img id="picture" src="img/parks/${park.parkCode.toLowerCase()}.jpg"><br/><br/>
	<p><c:out value="${park.parkDescription}" /></p>
	<p><span class="specs">Acreage: </span><fmt:formatNumber value="${park.acreage}" /></p>
	<p><span class="specs">Elevation: </span><fmt:formatNumber value="${park.elevationInFeet}" /> feet</p>
	<p><span class="specs">Miles of Trail: </span><fmt:formatNumber value="${park.milesOfTrail}" /> miles</p>
	<p><span class="specs">Campsites: </span><fmt:formatNumber value="${park.numberOfCampsites}" /></p>
	<p><span class="specs">Climate: </span><c:out value="${park.climate}" /></p>
	<p><span class="specs">Year Founded: </span><c:out value="${park.yearFounded}" /></p>
	<p><span class="specs">Annual Visitors: </span><fmt:formatNumber value="${park.annualVisitorCount}" /></p>
	<p><span class="specs">Entry Fee: </span><c:out value="${park.entryFee}" /></p>
	<p><span class="specs">Number of Animal Species: </span><fmt:formatNumber value="${park.numberOfAnimalSpecies}" /></p>
	<hr>
	<div id="weatherdiv">
		<h2 id="forecastheader">Five Day Forecast</h2>
		<form method="POST" action="detailpage" id="unitsForm">
			<select name="units" required>
				<option selected hidden>Select Temperature Units</option>
				<option value="F">Fahrenheit</option>
				<option value="C">Celsius</option>
			</select>
			<input id="loophole" TYPE="text" name="code" value="${park.parkCode}"/> 
			<input TYPE="submit" VALUE="Save" />
		</form>
			<c:if test="${!message.equals(\"\")}">
			<div id="advisoryDiv">
			<h4 id="advisory">Weather Advisory</h4>
			<p>-- ${message} --</p>
			</div>
			</c:if>
		<div id="todaysforecast">
			<h3>Today</h3>
			<img id="todaysimg" src="img/weather/${forecast.get(0).forecast }.png" /><br>
			<c:choose>
			<c:when test = "${units.equals('C')}"> 
				<c:out value="Today's Low: ${forecast.get(0).lowC} C" /><br>
				<c:out value="Today's High: ${forecast.get(0).highC} C" />
			</c:when>
			<c:otherwise>
				<c:out value="Today's Low: ${forecast.get(0).low} F" /><br>
				<c:out value="Today's High: ${forecast.get(0).high} F" />
			</c:otherwise>
			</c:choose>
		</div>
		
		<c:forEach var="forecast" items="${forecast}" varStatus="state">
			<c:if test="${not state.first}">
			<div class="forecast">
				<img id="weatherimg" src="img/weather/${forecast.forecast}.png" /><br>
				<c:choose>
			<c:when test = "${units.equals('C')}"> 
				<c:out value="Low: ${forecast.lowC} C" /><br>
				<c:out value="High: ${forecast.highC} C" />
			</c:when>
			<c:otherwise>
				<c:out value="Low: ${forecast.low} F" /><br>
				<c:out value="High: ${forecast.high} F" />
			</c:otherwise>
			</c:choose>
			</div>
			</c:if>
		</c:forEach>
	</div>
	</section>
<c:import url="footer.jsp" />
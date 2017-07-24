<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>National Park Geek</title>
    <c:url value="/css/npgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
 	<link rel="icon" type="image/png" href="webapp/img/favicon.png">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <header>
    	<c:url value="/" var="homePageHref" />
    	<c:url value="/img/logo.png" var="logoSrc" />
        <a id="img-ref" href="${homePageHref}">
        		<img class="headerimg" src="${logoSrc}" alt="MP Geek logo" />
        </a>
    <nav>
        <ul>
            <li id="nav"><a href="${homePageHref}">Home</a></li>
            <li id="nav"><a href="surveypage">Survey</a></li>    
        </ul>
    </nav>
    </header>
    <div id="sidebar">
    <ul>
    <c:forEach var="park" items="${parkList}">
    <c:url var="parkLink" value="/detailpage">
		<c:param name="parkCode" value="${park.parkCode}" />
	</c:url>
    <li><a class="sideNav" id="${park.parkCode}nav" href="${parkLink}">${park.parkName}</a></li>
    </c:forEach>
    </ul>
    </div>
    
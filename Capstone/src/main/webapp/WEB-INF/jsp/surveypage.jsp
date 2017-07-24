<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp"/>

<body>
<section class="main-content">
<h3>Have a moment, take our survey!</h3>

<form:form action="" method="POST" modelAttribute="surveyValidation">
	<label>What is your favorite park?</label>
	<form:select path="parkCode" name="parkCode">
			<option selected hidden value="">Parks</option>
		<c:forEach var="park" items="${parks}">
			<form:option path="parkCode" value="${park.parkCode}"><c:out value="${park.parkName}"/></form:option>
		</c:forEach>
	</form:select>
	<form:errors path="parkCode" cssClass="error"/>
	<br/><br/>
	<label>Email</label>
	<form:input path="emailAddress"/>
	<form:errors path="emailAddress" cssClass="error"/><br/>
	<label>State of Residence</label>
	<form:select path="state" name="state">
		<option selected hidden value="">State</option>
		<form:option path="state" value="AL">Alabama</form:option>
		<form:option path="state" value="AK">Alaska</form:option>
		<form:option path="state" value="AZ">Arizona</form:option>
		<form:option path="state" value="AR">Arkansas</form:option>
		<form:option path="state" value="CA">California</form:option>
		<form:option path="state" value="CO">Colorado</form:option>
		<form:option path="state" value="CT">Connecticut</form:option>
		<form:option path="state" value="DE">Delaware</form:option>
		<form:option path="state" value="DC">District Of Columbia</form:option>
		<form:option path="state" value="FL">Florida</form:option>
		<form:option path="state" value="GA">Georgia</form:option>
		<form:option path="state" value="HI">Hawaii</form:option>
		<form:option path="state" value="ID">Idaho</form:option>
		<form:option path="state" value="IL">Illinois</form:option>
		<form:option path="state" value="IN">Indiana</form:option>
		<form:option path="state" value="IA">Iowa</form:option>
		<form:option path="state" value="KS">Kansas</form:option>
		<form:option path="state" value="KY">Kentucky</form:option>
		<form:option path="state" value="LA">Louisiana</form:option>
		<form:option path="state" value="ME">Maine</form:option>
		<form:option path="state" value="MD">Maryland</form:option>
		<form:option path="state" value="MA">Massachusetts</form:option>
		<form:option path="state" value="MI">Michigan</form:option>
		<form:option path="state" value="MN">Minnesota</form:option>
		<form:option path="state" value="MS">Mississippi</form:option>
		<form:option path="state" value="MO">Missouri</form:option>
		<form:option path="state" value="MT">Montana</form:option>
		<form:option path="state" value="NE">Nebraska</form:option>
		<form:option path="state" value="NV">Nevada</form:option>
		<form:option path="state" value="NH">New Hampshire</form:option>
		<form:option path="state" value="NJ">New Jersey</form:option>
		<form:option path="state" value="NM">New Mexico</form:option>
		<form:option path="state" value="NY">New York</form:option>
		<form:option path="state" value="NC">North Carolina</form:option>
		<form:option path="state" value="ND">North Dakota</form:option>
		<form:option path="state" value="OH">Ohio</form:option>
		<form:option path="state" value="OK">Oklahoma</form:option>
		<form:option path="state" value="OR">Oregon</form:option>
		<form:option path="state" value="PA">Pennsylvania</form:option>
		<form:option path="state" value="RI">Rhode Island</form:option>
		<form:option path="state" value="SC">South Carolina</form:option>
		<form:option path="state" value="SD">South Dakota</form:option>
		<form:option path="state" value="TN">Tennessee</form:option>
		<form:option path="state" value="TX">Texas</form:option>
		<form:option path="state" value="UT">Utah</form:option>
		<form:option path="state" value="VT">Vermont</form:option>
		<form:option path="state" value="VA">Virginia</form:option>
		<form:option path="state" value="WA">Washington</form:option>
		<form:option path="state" value="WV">West Virginia</form:option>
		<form:option path="state" value="WI">Wisconsin</form:option>
		<form:option path="state" value="WY">Wyoming</form:option>
	</form:select>
	<form:errors path="state" cssClass="error"/><br/>		
	<label>Activity Level</label>
	<form:radiobutton path="activityLevel" name="activityLevel" value="inactive" checked="checked"/>Inactive
	<form:radiobutton path="activityLevel" name="activityLevel" value="sedentary"/>Sedentary
	<form:radiobutton path="activityLevel" name="activityLevel" value="active"/>Active
	<form:radiobutton path="activityLevel" name="activityLevel" value="extremelyActive"/>Extremely Active<br/><br/>
	<input type="submit" value="Submit"/>
</form:form>
</section>
</body>
<c:import url="footer.jsp"/>
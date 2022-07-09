<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Listing</title>
</head>
<body>
	<div>
		<a href="/host/dashboard">Dashboard</a>
		<form method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Logout!" />
		</form>
		<div>
			<h3><c:out value="${currListing.address}"></c:out></h3>
			<p><form:errors path="listing.*"/></p>
		    <form:form method="POST" action="/host/listing/${currListing.id}/edit" modelAttribute="listing">
		        <p>
		            <form:label path="description">Description:</form:label>
		            <form:input path="description" value="${currListing.description}" style="height:20px; width:500px;"/>
		            <form:errors path="description" />
		        </p>
		        <p>
		            <form:label path="price">Cost per night ($):</form:label>
		            <form:input type="number" path="price" value="${currListing.price}"/>
		            <form:errors path="price" />
		        </p>
		        <p>
		            <form:label path="pool">Pool Size:</form:label>
		            <form:select path="pool" value="${currListing.pool}">
		              <form:option value="Small" label="Small"/>
					  <form:option value="Medium" label="Medium"/>
					  <form:option value="Large" label="Large"/>
		            </form:select>
		            <form:errors path="pool" />
		        </p>
		        <input type="submit" value="Save Changes"/>
		    </form:form>
		</div>
		<div>
			<h4>Reviews: <c:out value="${currListing.averageRating()}"></c:out> / 5.0</h4>
			<div>
				<c:forEach items="${currListing.getReviews()}" var="review">
					<p><c:out value="${review.getReviewName()}"></c:out>@<c:out value="${review.createdAt}"></c:out>:</p>
					<p>Rating: <c:out value="${review.rate}"></c:out>></p>
					<textarea rows="6" cols="35"><c:out value="${review.content}"></c:out></textarea>
					<hr/>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
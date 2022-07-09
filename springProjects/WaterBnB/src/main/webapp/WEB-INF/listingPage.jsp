<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Individual Listing</title>
</head>
<body>
	<div>
		<div >
			<c:choose>
				<c:when test="${user != null}">
					<a href="/search">Search</a>
					<form method="POST" action="/logout">
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				        <input type="submit" value="Logout!" />
				    </form>
				    <c:if test="${user.getRole() == \"HOST\"}">
				    	<a href="/host/dashboard">Host Dashboard</a>
				    </c:if>
				</c:when>
				<c:otherwise>
					<a href="/home">Home</a>
					<a href="/registlogin">Register or Login</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<p><c:out value="${currListing.address}"></c:out></p>
			<textarea name="description" rows="6" cols="35"><c:out value="${currListing.description}"></c:out></textarea>
		</div>
		<div>
			<p>Email: <c:out value="${currListing.getUser().username}"></c:out></p>
			<p>Name of Contact: <c:out value="${currListing.getUser().firstName}"></c:out> <c:out value="${currListing.getUser().lastName}"></c:out></p>
			<p>Pool: <c:out value="${currListing.pool}"></c:out></p>
			<p>Cost: $<c:out value="${currListing.price}"></c:out></p>
		</div>
		<div>
			<h4>Reviews: <c:out value="${currListing.averageRating()}"></c:out> / 5.0</h4>
			<c:if test="${user != null}">
				<a href="/listings/addreview/${currListing.getId()}">Leave a Review</a>
			</c:if>
			<div>
				<c:forEach items="${currListing.getReviews()}" var="review">
					<p><c:out value="${review.getReviewName()}"></c:out>@<c:out value="${review.createdAt}"></c:out>:</p>
					<p>Rating: <c:out value="${review.rate}"></c:out></p>
					<textarea rows="6" cols="35"><c:out value="${review.content}"></c:out></textarea>
					<hr/>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Review</title>
</head>
<body>
	<div>
		<div>
			<a href="/listings/view/${currListing.id}">Back</a>
			<form method="POST" action="/logout">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="submit" value="Logout!" />
			</form>
		</div>
		<div>
			<h4><c:out value="${currListing.address}"></c:out></h4>
			<p><form:errors path="review.*"/></p>
		    <form:form method="POST" action="/listings/addreview/${currListing.id}" modelAttribute="review">
		        <p>
		            <form:label path="content">Review:</form:label>
		            <form:textarea text="text" path="content" rows="5" cols="60"/>
		            <form:errors path="content" />
		        </p>
		        <p>
		            <form:label path="rate">Rate:</form:label>
		            <form:select path="rate">
		              <form:option value="1" label="1"/>
					  <form:option value="2" label="2"/>
					  <form:option value="3" label="3"/>
					  <form:option value="4" label="4"/>
					  <form:option value="5" label="5"/>
		            </form:select>
		            <form:errors path="rate" />
		        </p>
		        <input type="submit" value="Submit Review"/>
		    </form:form>
		</div>
	</div>
</body>
</html>
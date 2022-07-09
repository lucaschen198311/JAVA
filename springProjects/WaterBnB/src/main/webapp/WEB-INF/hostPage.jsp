<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Host Dashboard</title>
</head>
<body>
	<div>
		<h2>Welcome <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></h2>
		<form method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Logout!" />
		</form>
		<c:if test="${user.getListings().size() > 0}">
			<div>
				<h4>Here is the current listings:</h4>
				<table>
					<thead>
						<tr>
							<th>Address</th>
							<th>Pool Size</th>
							<th>Cost / night ($)</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${user.getListings()}" var="listing">
							<tr>
								<td><a href="/listings/view/${listing.id}">${listing.address}</a></td>
								<td>${listing.pool}</td>
								<td>${listing.price}</td>
								<td>
									<span>${listing.averageRating()} / 5.0</span> | 
									<a href="/host/listing/${listing.id}/edit">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr/>
			</div>
		</c:if>
		<h3>Add New Listing</h3>
			<p><form:errors path="listing.*"/></p>
		    <form:form method="POST" action="/host/dashboard/addlisting" modelAttribute="listing">
		        <p>
		            <form:label path="address">Address:</form:label>
		            <form:input type="text" path="address"/>
		            <form:errors path="address" />
		        </p>
		        <p>
		            <form:label path="description">Description:</form:label>
		            <form:textarea path="description" rows="5" cols="40"></form:textarea>
		            <form:errors path="description" />
		        </p>
		        <p>
		            <form:label path="price">Cost per night ($):</form:label>
		            <form:input type="number" path="price"/>
		            <form:errors path="price" />
		        </p>
		        <p>
		            <form:label path="pool">Pool Size:</form:label>
		            <form:select path="pool">
		              <form:option value="Small" label="Small"/>
					  <form:option value="Medium" label="Medium"/>
					  <form:option value="Large" label="Large"/>
		            </form:select>
		            <form:errors path="pool" />
		        </p>
		        <input type="submit" value="Add Listing!"/>
		    </form:form>
	</div>
</body>
</html>
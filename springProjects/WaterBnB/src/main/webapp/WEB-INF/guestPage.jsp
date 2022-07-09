<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<div>
	<h2>Welcome to WaterBnb <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out></h2>
		<div>
			<c:choose>
				<c:when test="${user != null}">
					<form method="POST" action="/logout">
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				        <input type="submit" value="Logout!" />
				    </form>
				    <c:if test="${user.role == \"HOST\"}">
				    	<a href="/host/dashboard">Host Admin Dashboard</a>
				    </c:if>
				</c:when>
				<c:otherwise>
					<a href="/home">Home</a>
					<a href="/registlogin">Register or Login</a>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<form action="/search" method="POST">
				<input type = "text" name="search" placeholder="Enter location" />
				<input type="submit" value="Search" />
			</form>
			<hr/>
			<c:if test="${results.size() > 0}">
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
						<c:forEach items="${results}" var="res">
							<tr>
								<td>${res.address}</td>
								<td>${res.pool}</td>
								<td>${res.price}</td>
								<td>
									<span>${res.averageRating()} / 5.0</span> | 
									<a href="/listings/view/${res.getId()}">See Details</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>
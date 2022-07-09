<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DMV</title>
</head>
<body>
	<div>
		<nav>
			<h2><a href="/new">Add Person</a> | <a href="/licenses/new">Add License</a></h2>
		</nav>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>State</th>
					<th>Expiration Date</th>
					<th>License #</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td><a href="/${person.id}">${person.firstName} ${person.lastName}</a></td>
					<td>${person.license.getState()}</td>
					<td>${person.license.getExpirationDateFormatted()}</td>
					<td>${person.license.getNumberAsString()}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Students</title>
</head>
<body>
	<div>
		<nav>
			<h1>All Students</h1>
			<p><a href="/students/new">Add Student</a> | <a href="/contacts/new">Add Contact Info</a></p>
		</nav>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName} ${student.lastName}</td>
					<td>${student.age}</td>
					<td>${student.contact.address}</td>
					<td>${student.contact.city}</td>
					<td>${student.contact.state}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>
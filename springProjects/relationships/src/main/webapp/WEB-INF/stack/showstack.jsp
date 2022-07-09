<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stack With Student Registered</title>
</head>
<body>
	<div>
		<h2>${stack.name}</h2>
		<a href="/stackhome">Back To Home</a>
		<h3>Students Registered this stack</h3>
		<hr/>
		<table>
			<thead>
				<tr>
					<th>Student Name</th>
					<th>Student Age</th>
					<th>Student Address</th>
					<th>Student Dorm</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName} ${student.lastName}</td>
					<td>${student.age}</td>
					<td>${student.contact.address}, ${student.contact.city}, ${student.contact.state}</td>
					<td>${student.dorm.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Ninjas</title>
</head>
<body>
	<div>
		<h2>All Ninjas</h2>
		<a href="/dojos">Dojos</a>
		<a href="/ninjas/new">Add Ninja</a>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Dojo</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td>${ninja.firstName} ${ninja.lastName}</td>
					<td>${ninja.age}</td>
					<td>${ninja.dojo.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
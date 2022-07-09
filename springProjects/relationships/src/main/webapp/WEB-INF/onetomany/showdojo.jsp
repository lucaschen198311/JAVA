<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
</head>
<body>
	<div>
		<h2>${dojo.name} Area Ninjas</h2>
		<a href="/dojos">Dojos</a>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dojo.ninjas}" var="ninja">
				<tr>
					<td>${ninja.firstName} ${ninja.lastName}</td>
					<td>${ninja.age}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
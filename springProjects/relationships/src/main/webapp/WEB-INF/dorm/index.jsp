<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Dorms</title>
</head>
<body>
	<div>
		<h2>Student Dorms</h2>
		<p><a href="/dorms">All Dorms</a></p>
		<a href="/dorms/new">Add Dorm</a>
		<hr />
		<ul>
			<c:forEach items="${dorms}" var="dorm">
				<li><a href="/dorms/${dorm.id}">${dorm.name}</a></li>
			</c:forEach>
		</ul>	
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students with Stacks</title>
</head>
<body>
	<div>
		<h1>Students with Stacks</h1>
		<a href="/stacks/new">Add Stack</a>
		<hr />
		<h2>Student Rosters</h2>
		<ul>
			<c:forEach items="${students}" var="student">
				<li><a href="/students/${student.id}/stack">${student.firstName} ${student.lastName}</a></li>
			</c:forEach>
		</ul>
		<hr />
		<h2>Stack List</h2>
		<ul>
			<c:forEach items="${stacks}" var="stack">
				<li><a href="/stacks/${stack.id}">${stack.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
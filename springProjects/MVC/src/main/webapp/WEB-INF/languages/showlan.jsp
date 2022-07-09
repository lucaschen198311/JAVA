<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Language</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<div>
		<p><c:out value="${lan.name}"/></p>
		<p><c:out value="${lan.creator}"/></p>
		<p><c:out value="${lan.currentVersion}"/></p>
		<a href="/languages/${lan.id}/edit">Edit</a>
		<form action="/languages/${lan.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
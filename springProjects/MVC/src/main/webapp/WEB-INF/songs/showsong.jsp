<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show song</title>
</head>
<body>
	<a href="/songs/dashboard">Dashboard</a>
	<div>
		<p>Title: <c:out value="${song.title}"/></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating(1-10): <c:out value="${song.rating}"/></p>
		<form action="/songs/${song.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number Game</title>
</head>
<body>
	<div>
		<h1>Welcome to the Great NUmber Game!</h1>
		<p>I am think of a number between 1-100.</p>
		<p>Take a guess!</p>
		<div>
			<p><c:out value="${message}" /></p>
		</div>
		<form action="/GreatNumber" method="POST">
			<input name="guess"/>
			<input type="submit" value="submit">
		</form>
	</div>
</body>
</html>
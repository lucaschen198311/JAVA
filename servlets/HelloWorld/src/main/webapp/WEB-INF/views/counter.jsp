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
		<h1>Welcome to The Great Number Game!</h1>
		<p>I am thinking of a number between 1 and 100</p>
		<p>Take a guess!</p>
		<div class="${messages}">
			<p>${message}</p>
			<form action="/ResetGame" method="post" class="${win}">
				<input type="submit" value="play again">
			</form>
		</div>
		<form action="/GuessNumber" method="post" class="${play}">
			<input type="text" name="guess">
			<input type="submit" value="submit">
		</form>
	</div>
</body>
</html>
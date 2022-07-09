<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Page</title>
</head>
<body>
	<p><c:out value="${error}"/></p>
	<div>
		<form action="/attempt" method="POST">
			<p><label>What is the code?</label></p>
			<input type="text" name="guess">
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>
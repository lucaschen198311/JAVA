<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Main Page</title>
</head>
<body>
	<div>
		<h1>Water BnB</h1>
		<a href="/registlogin">Register or Login</a>
		<form action="/search" method="POST">
			<input type = "text" name="search" placeholder="Enter location" />
			<input type="submit" value="Search" />
		</form>
	</div>
</body>
</html>
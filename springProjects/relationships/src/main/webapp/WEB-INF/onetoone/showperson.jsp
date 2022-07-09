<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Person</title>
</head>
<body>
	<div>
		<h1>${person.firstName} ${person.lastName}</h1>
		<p><strong>License Number: </strong> ${person.license.getNumberAsString()}</p>
		<p><strong>Expiration Date: </strong> ${person.license.getExpirationDateFormatted()}</p>
		<a href="/">Main Page</a>
	</div>
</body>
</html>
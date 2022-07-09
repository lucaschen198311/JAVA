<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page Count</title>
</head>
<body>
	<div>
		<p>You have visited http://localhost:8080/server <c:out value="${showCount}"/> times</p>
		<p><a href="/server">Test another visit?</a></p>
	</div>
</body>
</html>
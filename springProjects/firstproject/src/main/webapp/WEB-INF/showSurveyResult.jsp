<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey Result</title>
</head>
<body>
	<div>
		<h1>Submitted Info:</h1>
		<p>Name : <c:out value="${name}"/></p>
		<p>Dojo Location : <c:out value="${location}"/></p>
		<p>Program Languag : <c:out value="${language}"/></p>
		<p>Comment : <c:out value="${comment}"/></p>
	</div>
</body>
</html>
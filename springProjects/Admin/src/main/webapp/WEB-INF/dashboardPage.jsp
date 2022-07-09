<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dabshboard</title>
</head>
<body>
	<div>
		<h1><c:out value="${currentUser.firstName}" /></h1>
		<p><a href="/admin">Admin Page</a></p>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
		<hr/>
		<p>First Name: <c:out value="${currentUser.firstName}" /></p>
		<p>Last Name: <c:out value="${currentUser.lastName}" /></p>
		<p>Email: <c:out value="${currentUser.username}" /></p>
		<p>Sign up date: <c:out value="${currentUser.getLastLogin()}" /></p>
		<p>Last sign in: <c:out value="${lastLoginTime}" /></p>
	</div>
</body>
</html>
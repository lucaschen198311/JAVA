<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div>
		<h1>Register!</h1>
	    <p><form:errors path="user.*"/></p>
	    <form:form method="POST" action="/registration" modelAttribute="user">
	        <p>
	            <form:label path="username">Username:</form:label>
	            <form:input path="username"/>
	            <form:errors path="username" />
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label>
	            <form:password path="password"/>
	            <form:errors path="password" />
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
	            <form:password path="passwordConfirmation"/>
	            <form:errors path="passwordConfirmation" />
	        </p>
	        <input type="submit" value="Register!"/>
	    </form:form>
	</div>
</body>
</html>
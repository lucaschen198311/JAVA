<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
</head>
<body>
	<div>
		<h2>New Person</h2>
		<form:form action="/" method="POST" modelAttribute="person">
			<div>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input  path="firstName"/>
		    </div>
		    <div>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input  path="lastName"/>
		    </div>
		    <button>Add Person</button>
		</form:form>
	</div>
</body>
</html>
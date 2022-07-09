<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add License</title>
</head>
<body>
	<div>
		<h2>New License</h2>
		<a href="/">Main Page</a>
		<form:form action="/licenses" method="POST" modelAttribute="license">
			<div>
		        <form:label path="person">Person</form:label>
		        <form:errors path="person"/>
		        <form:select path="person">
		        <c:forEach items="${persons}" var="p">
		        	<form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
		        </c:forEach>
		        </form:select>
		    </div>
			<div>
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
		    </div>
			<div>
		        <form:label path="expirationDate">Expiration Date</form:label>
		        <form:errors path="expirationDate"/>
		        <form:input type="date" path="expirationDate"/>
		    </div>
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>
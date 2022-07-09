<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<div>
		<h2>Add Contact</h2>
		<a href="/students">Main Page</a>
		<form:form action="/contacts" method="POST" modelAttribute="contact">
			<div>
		        <form:label path="student">Student</form:label>
		        <form:errors path="student"/>
		        <form:select path="student">
		        <c:forEach items="${students}" var="stu">
		        	<form:option value="${stu.id}">${stu.firstName} ${stu.lastName}</form:option>
		        </c:forEach>
		        </form:select>
		    </div>
			<div>
		        <form:label path="address">Address</form:label>
		        <form:errors path="address"/>
		        <form:input type="text" path="address"/>
		    </div>
			<div>
		        <form:label path="city">City</form:label>
		        <form:errors path="city"/>
		        <form:input type="text" path="city"/>
		    </div>
		    <div>
		        <form:label path="state">State</form:label>
		        <form:errors path="state"/>
		        <form:input type="text" path="state"/>
		    </div>
		    <input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>
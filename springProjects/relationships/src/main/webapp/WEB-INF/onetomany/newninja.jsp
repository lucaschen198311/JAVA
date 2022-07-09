<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ninja</title>
</head>
<body>
	<div>
		<h2>Add a Ninja</h2>
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
			<div>
		        <form:label path="dojo">Dojo Name</form:label>
		        <form:errors path="dojo"/>
		        <form:select path="dojo">
		        <c:forEach items="${dojos}" var="doj">
		        	<option value="${doj.id }">${doj.name}</option>
		        </c:forEach>
		        </form:select>
		    </div>
		    <div>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </div>
		    <div>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </div>
		    <div>
		        <form:label path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input path="age"/>
		    </div>
		    <button>Add Ninja</button>
		</form:form>
	</div>
</body>
</html>
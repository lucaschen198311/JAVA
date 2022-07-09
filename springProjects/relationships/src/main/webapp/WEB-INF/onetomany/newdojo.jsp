<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Dojo</title>
</head>
<body>
	<div>
		<h2>Add a Dojo</h2>
		<form:form action="/dojos" method="post" modelAttribute="dojo">
			<div>
		        <form:label path="name">Dojo Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <button>Add Dojo</button>
		</form:form>
	</div>
</body>
</html>
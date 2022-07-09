<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Stack</title>
</head>
<body>
	<div>
		<h2>Add Stack</h2>
		<form:form action="/stacks" method="post" modelAttribute="stack">
			<div>
		        <form:label path="name">Stack Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <div>
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea path="description" rows="10" cols="20"/>
		    </div>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>
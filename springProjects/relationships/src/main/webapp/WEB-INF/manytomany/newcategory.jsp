<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
	<div>
		<h2>Add Category</h2>
		<form:form action="/categories" method="post" modelAttribute="category">
			<div>
		        <form:label path="name">Category Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>
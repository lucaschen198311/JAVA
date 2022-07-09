<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Prod</title>
</head>
<body>
	<div>
		<h2>Add Product</h2>
		<form:form action="/products" method="post" modelAttribute="product">
			<div>
		        <form:label path="name">Product Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <div>
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea  path="description" rows="10" cols="20"/>
		    </div>
		    <div>
		        <form:label path="price">Product Price</form:label>
		        <form:errors path="price"/>
		        <form:input path="price"/>
		    </div>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>
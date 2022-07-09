<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Category</title>
</head>
<body>
	<div>
		<h1><c:out value="${category.name}"/></h1>
		<h3>Products: </h3>
		<a href="/inventory">Back to Home</a>
		<ul>
			<c:forEach items="${currProds}" var="currProd">
				<li><a href="/products/${currProd.id}">${currProd.name}</a></li>
			</c:forEach>
		</ul>
		<form method="POST" action="/categories/${category.id}">
			<label>Add Product: </label>
			<select name="prodId">
				<c:forEach items="${otherProds}" var="otherProd">
					<option value="${otherProd.id}">${otherProd.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>
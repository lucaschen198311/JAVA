<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Prod</title>
</head>
<body>
	<div>
		<h1><c:out value="${product.name}"/></h1>
		<h3>Categories: </h3>
		<a href="/inventory">Back to Home</a>
		<ul>
			<c:forEach items="${currCategories}" var="currCate">
				<li><a href="/categories/${currCate.id}">${currCate.name}</a></li>
			</c:forEach>
		</ul>
		<form method="POST" action="/products/${product.id}">
			<label>Add Category: </label>
			<select name="cateId">
				<c:forEach items="${otherCategories}" var="otherCate">
					<option value="${otherCate.id}">${otherCate.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>
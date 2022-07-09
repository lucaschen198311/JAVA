<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<div>
		<h1>Products and Categories</h1>
		<p><a href="/products/new">Add Product</a> | <a href="/categories/new">Add Category</a><p>
		<h2>All Products</h2>
		<ul>
			<c:forEach items="${products}" var="product">
				<li><a href="/products/${product.id}">${product.name}</a></li>
			</c:forEach>
		</ul>
		<h2>All Categories</h2>
		<ul>
			<c:forEach items="${categories}" var="category">
				<li><a href="/categories/${category.id}">${category.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<body>
	<div>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${languages}" var="language">
			        <tr>
			        	<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
			            <td><c:out value="${language.creator}"/></td>
			            <td><c:out value="${language.currentVersion}"/></td>
			            <td>
			            	<form action="/languages/${language.id}" method="post">
		    					<input type="hidden" name="_method" value="delete">
		    					<input type="submit" value="Delete">
							</form>
			            	<a href="/languages/${language.id}/edit">Edit</a>
			            </td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/languages/new">Add New Language</a>
	</div>
</body>
</html>
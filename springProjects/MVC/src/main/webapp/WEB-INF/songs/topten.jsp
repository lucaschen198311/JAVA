<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>top 10</title>
</head>
<body>
	<div>
		<h3>Top 10 songs by rating</h3>
		<a href="/songs/dashboard">Dashboard</a>
		<table>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
			        <tr>
			        	<td><c:out value="${song.rating}"/></td>
			        	<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			          	<td><c:out value="${song.artist}"/></td>
			        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>
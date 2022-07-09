<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	    <h1>Ninjas per Page</h1>
	    <c:forEach begin="1" end="${totalPages}" var="index">
	        <a href="/ninjas/pages/${index}">${index}</a>
	    </c:forEach>
	    <table>
	        <thead>
	        	<tr>
		            <th>Dojo Name</th>
		            <th>Ninja First Name</th>
		            <th>Ninja Last Name</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="ninja" items="${ninjas.content}">                 
	            <tr>
	                <td><c:out value="${ninja[0]}"></c:out></td>
	                <td><c:out value="${ninja[1]}"></c:out></td>
	                <td><c:out value="${ninja[2]}"></c:out></td>
	            </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	</div>
</body>
</html>
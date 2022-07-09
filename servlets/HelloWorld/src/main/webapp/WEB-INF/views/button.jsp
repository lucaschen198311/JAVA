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
		<form action="/ButtonClick">
			<input type="hidden" name="click"/>
			<button>Click!</button>
		</form>
		<p>You have clicked <c:out value="${currTimes}" /> times.</p>
	</div>
</body>
</html>
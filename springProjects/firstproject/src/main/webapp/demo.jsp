<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP DEMO</title>
</head>
<body>
	<% String req = request.getParameter("name"); %>
	<h1>First JSP DEMO!</h1>
	<h2><%= req %></h2>
	<% for(int i=0; i<5; i++) { %>
		<p><%= i %></p>
	<% } %>
	<p>The date is : <%= new Date() %></p>
</body>
</html>
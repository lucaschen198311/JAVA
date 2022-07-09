<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
</head>
<body>
	<div>
		<form action="/languages/${lan.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		<a href="/languages">Dashboard</a>
	</div>
	<div>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    <input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:input path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentVersion">Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </p>  
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>
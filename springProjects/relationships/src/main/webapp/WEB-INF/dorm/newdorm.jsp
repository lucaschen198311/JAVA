<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Dorm</title>
</head>
<body>
	<div>
		<h2>Add a Dorm</h2>
		<form:form action="/dorms" method="post" modelAttribute="dorm">
			<div>
		        <form:label path="name">Dorm Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>
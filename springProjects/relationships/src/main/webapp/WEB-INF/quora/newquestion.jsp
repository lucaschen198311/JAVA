<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
	<div>
		<h2>What is your question?</h2>
		<a href="/questions">Back to Dashboard</a>
		<form:form action="/questions" method="post" modelAttribute="questionwithtag">
			<div>
		        <form:label path="question">Question: </form:label>
		        <form:errors path="question"/>
		        <form:input path="question"/>
		    </div>
		    <div>
		        <form:label path="tags">Tags: </form:label>
		        <form:errors path="tags"/>
		        <form:input type="text"  path="tags"/>
		    </div>
		    <button>Submit</button>
		</form:form>
	</div>
</body>
</html>
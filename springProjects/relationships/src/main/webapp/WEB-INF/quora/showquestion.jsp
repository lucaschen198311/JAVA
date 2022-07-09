<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Question</title>
</head>
<body>
	<div>
		<h2>${question.content}</h2>
		<h3>Tags: </h3>
		<a href="/questions">Back to Dashboard</a>
		<ul>
			<c:forEach items="${question.tags}" var="tag">
				<li>${tag.subject}</li>
			</c:forEach>
		</ul>
		<hr/>
		<table>
			<thead>
				<tr>
					<th>Answer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${question.answers}" var="answer">
					<tr>
						<td>${answer.content}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/questions/${question.id}/addanswer" method="post" modelAttribute="answer">
			 <div>
		        <form:label path="content">Answer</form:label>
		        <form:errors path="content"/>
		        <form:input path="content" />
		    </div>
		    <form:hidden path="question" value="${question.id}"/>
		    <button>Answer it!</button>
		</form:form>
	</div>
</body>
</html>
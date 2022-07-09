<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student with Stacks</title>
</head>
<body>
	<div>
		<h2>${student.firstName} ${student.lastName}</h2>
		<a href="/stackhome">Back to Home</a>
		<form method="POST" action="/students/${student.id}/stack">
			<label>Add Stack: </label>
			<select name="stackId">
				<c:forEach items="${otherStacks}" var="other">
					<option value="${other.id}">${other.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
		<h3>Your Schedule</h3>
		<table>
			<thead>
				<tr>
					<th>Stack Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${currStacks}" var="curr">
					<tr>
						<td>${curr.name}</td>
						<td>
							<form method="POST" action="/students/${student.id}/stack/remove">
								<input type="hidden" name="stackId" value="${curr.id}"/>
								<input type="submit" value="Drop">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
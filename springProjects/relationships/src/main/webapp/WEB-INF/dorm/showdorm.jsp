<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Dorm</title>
</head>
<body>
	<div>
		<h2>${dorm.name}</h2>
		<a href="/dorms">All Dorms</a>
		<form method="POST" action="/dorms/${dorm.id}">
			<label>Students: </label>
			<select name="studentId">
				<c:forEach items="${freeStudents}" var="free">
					<option value="${free.id}">${free.firstName} ${free.lastName}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Add">
		</form>
		<table>
			<thead>
				<tr>
					<th>Student Name</th>
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${occupyStudents}" var="occupy">
				<tr>
					<td>${occupy.firstName} ${occupy.lastName}</td>
					<td>
						<form method="POST" action="/dorms/${dorm.id}/students/remove">
							<input type="hidden" name="studentId" value="${occupy.id}"/>
							<input type="submit" value="Remove">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
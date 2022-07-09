<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Page</title>
</head>
<body>
	<div>
		<div>
			<h1><c:out value="${event.name}"></c:out></h1>
			<a href="/events">Go Back</a>
			<p>Host: ${event.hostName}</p>
			<p>Date: ${event.hostDate}</p>
			<p>Location: ${event.location}, ${event.state}</p>
			<p>Total number of people who are going to attend this event: ${count}</p>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attendees}" var="attendee">
						<tr>
							<td>${attendee.firstName} ${attendee.lastName}</td>
							<td>${attendee.location}, ${attendee.state}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<h3>Messages</h3>
			<div>
				<c:forEach items="${comments}" var="comment">
					<p>${comment.commentName} says : ${comment.content} @${comment.getCreatedAt()}</p>
				</c:forEach>
			</div>
			<form:form method="POST" action="/events/${event.id}/addcomment" modelAttribute="comment">
				<p>
			    	<form:label path="content">Add comment:</form:label>
			        <form:textarea path = "content" rows = "5" cols = "20" />
			        <form:errors path="content" />
		   		</p>
		   		<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>
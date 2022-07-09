<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Dashboard</title>
</head>
<body>
	<div>
		<h1>Question DashBoard</h1>
		<hr/>
		<table>
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="question">
					<tr>
						<td><a href="/questions/${question.id}">${question.content}</a></td>
						<td>
							<c:forEach items="${ question.tags }" var="tag">
								<span>${tag.subject}<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1 }">, </c:if></span>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/questions/new">New Question</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div>
		<h1>Welcome <c:out value="${currentUser.firstName}"/>!</h1>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.firstName} ${user.lastName}</td>
						<td>${user.username}</td>
						<c:choose>
							<c:when test="${user.getRoles().get(0).getName().equals(\"ROLE_ADMIN\")}">
								<td>Admin</td>
							</c:when>
							<c:otherwise>
								<td>
									<form method="POST" action="/admin/${user.id}/delete">
	        							<input type="hidden" />
	        							<input type="submit" value="delete" />
	    							</form>
									<form method="POST" action="/admin/${user.id}">
										<input type="hidden" />
	        							<input type="submit" value="make-admin" />
									</form>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
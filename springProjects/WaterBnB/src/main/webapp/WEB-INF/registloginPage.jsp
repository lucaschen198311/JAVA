<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register or Login</title>
</head>
<body>
	<div>
		<a href="/home">Home</a>
		<div>
			<c:if test="${logoutMessage != null}">
				<c:out value="${logoutMessage}"></c:out>
			</c:if>
			<h1>Login</h1>
			<c:if test="${errorMessage != null}">
	        	<c:out value="${errorMessage}"></c:out>
	    	</c:if>
		    <form method="POST" action="/login">
		        <p>
		            <label for="username">Email: </label>
		            <input type="text" name="username"/>
		        </p>
		        <p>
		            <label for="password">Password</label>
		            <input type="password"  name="password"/>
		        </p>
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Login!"/>
		    </form>
		</div>
		<div>
			<h1>Register</h1>
			<p><form:errors path="user.*"/></p>
		    <form:form method="POST" action="/registlogin" modelAttribute="user">
		        <p>
		            <form:label path="firstName">First Name:</form:label>
		            <form:input type="text" path="firstName"/>
		            <form:errors path="firstName" />
		        </p>
		        <p>
		            <form:label path="lastName">Last Name:</form:label>
		            <form:input type="text" path="lastName"/>
		            <form:errors path="lastName" />
		        </p>
		        <p>
		            <form:label path="username">Email:</form:label>
		            <form:input type="text" path="username"/>
		            <form:errors path="username" />
		        </p>
		        <p>
		            <form:label path="password">Password:</form:label>
		            <form:password path="password"/>
		            <form:errors path="password" />
		        </p>
		        <p>
		            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		            <form:password path="passwordConfirmation"/>
		            <form:errors path="passwordConfirmation" />
		        </p>
		        <p>
		            <form:label path="role">User Role:</form:label>
		            <form:select path="role">
		              <form:option value="HOST" label="HOST"/>
					  <form:option value="GUEST" label="GUEST"/>
		            </form:select>
		            <form:errors path="role" />
		        </p>
		        <input type="submit" value="Register!"/>
		    </form:form>
		</div>
	</div>
</body>
</html>
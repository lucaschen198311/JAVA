<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register and Login</title>
</head>
<body>
	<div>
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
		            <form:label path="username">Email:</form:label>
		            <form:input type="text" path="username"/>
		            <form:errors path="username" />
		        </p>
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
		            <form:label path="location">Location:</form:label>
		            <form:input type="text" path="location"/>
		            <form:errors path="location" />
		        </p>
		        <p>
		            <form:label path="state">State:</form:label>
		            <form:select path="state">
		              <form:option value="AK" label="AK"/>
					  <form:option value="AL" label="AL"/>
					  <form:option value="AR" label="AR"/>
					  <form:option value="AZ" label="AZ"/>
					  <form:option value="CA" label="CA"/>
					  <form:option value="CO" label="CO"/>
					  <form:option value="CT" label="CT"/>
					  <form:option value="DC" label="DC"/>
					  <form:option value="DE" label="DE"/>
					  <form:option value="FL" label="FL"/>
					  <form:option value="GA" label="GA"/>
					  <form:option value="HI" label="HI"/>
					  <form:option value="IA" label="IA"/>
					  <form:option value="ID" label="ID"/>
					  <form:option value="IL" label="IL"/>
					  <form:option value="IN" label="IN"/>
					  <form:option value="KS" label="KS"/>
					  <form:option value="KY" label="KY"/>
					  <form:option value="LA" label="LA"/>
					  <form:option value="MA" label="MA"/>
					  <form:option value="MD" label="MD"/>
					  <form:option value="ME" label="ME"/>
					  <form:option value="MI" label="MI"/>
					  <form:option value="MN" label="MN"/>
					  <form:option value="MO" label="MO"/>
					  <form:option value="MS" label="MS"/>
					  <form:option value="MT" label="MT"/>
					  <form:option value="NC" label="NC"/>
					  <form:option value="ND" label="ND"/>
					  <form:option value="NE" label="NE"/>
					  <form:option value="NH" label="NH"/>
					  <form:option value="NJ" label="NJ"/>
					  <form:option value="NM" label="NM"/>
					  <form:option value="NV" label="NV"/>
					  <form:option value="NY" label="NY"/>
					  <form:option value="OH" label="OH"/>
					  <form:option value="OK" label="OK"/>
					  <form:option value="OR" label="OR"/>
					  <form:option value="PA" label="PA"/>
					  <form:option value="RI" label="RI"/>
					  <form:option value="SC" label="SC"/>
					  <form:option value="SD" label="SD"/>
					  <form:option value="TN" label="TN"/>
					  <form:option value="TX" label="TX"/>
					  <form:option value="UT" label="UT"/>
					  <form:option value="VA" label="VA"/>
					  <form:option value="VT" label="VT"/>
					  <form:option value="WA" label="WA"/>
					  <form:option value="WI" label="WI"/>
					  <form:option value="WV" label="WV"/>
					  <form:option value="WY" label="WY"/>
		            </form:select>
		            <form:errors path="state" />
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
		        <input type="submit" value="Register!"/>
		    </form:form>
		</div>
	</div>
</body>
</html>
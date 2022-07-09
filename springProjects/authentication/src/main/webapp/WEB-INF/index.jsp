<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register and Login</title>
</head>
<body>
    
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div>
            <label>User Name:</label>
            <form:input path="username" />
            <form:errors path="username" />
        </div>
        <div>
            <label>Email:</label>
            <form:input path="email" />
            <form:errors path="email" />
        </div>
        <div>
            <label>Password:</label>
            <form:password path="password" />
            <form:errors path="password" />
        </div>
        <div>
            <label>Confirm Password:</label>
            <form:password path="passwordConfirmation" />
            <form:errors path="passwordConfirmation" />
        </div>
        <input type="submit" value="Register" />
    </form:form>
    
    <form:form action="/login" method="post" modelAttribute="newLogin">
        <div>
            <label>Email:</label>
            <form:input path="email" />
            <form:errors path="email" />
        </div>
        <div>
            <label>Password:</label>
            <form:password path="password" />
            <form:errors path="password" />
        </div>
        <input type="submit" value="Login" />
    </form:form>
</body>
</html>
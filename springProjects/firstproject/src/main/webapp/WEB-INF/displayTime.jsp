<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Time</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/displaytime.js"></script>
</head>
<body>
	<h1 class="time"><c:out value="${timeStr}"/></h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
	<div>
		<h1><c:out value="${event.name}"></c:out></h1>
		<h2>Edit Event</h2>
		<a href="/events">Back to Dashboard</a>
	   	<form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
			<p>
		    	<form:label path="name">Event Name:</form:label>
		        <form:input type="text" value="${event.name}" path="name"/>
		        <form:errors path="name" />
		   	</p>
		   	<p>
		    	<form:label path="hostDate">Date:</form:label>
		        <fmt:formatDate value="${event.hostDate}" pattern="yyyy-MM-dd" var="formattedDate"></fmt:formatDate>
				<form:input path="hostDate" value ="${formattedDate}" type="date"></form:input>
		        <form:errors path="hostDate" />
		   	</p>
		    <p>
		        <form:label path="location">Location:</form:label>
		        <form:input type="text" value="${event.location}" path="location"/>
		        <form:errors path="location" />
		    </p>
		    <p>
		            <form:label path="state">State:</form:label>
		            <form:select value="${event.state}" path="state">
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
		 	<input type="submit" value="Edit"/>
		 </form:form>
	</div>
</body>
</html>
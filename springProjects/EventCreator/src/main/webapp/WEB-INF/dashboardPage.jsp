<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Welcome <c:out value="${currUser.firstName}"/> <c:out value="${currUser.lastName}"/></h1>
		<form method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
	    <p>Here are the events in your state:</p>
	    <table>
	    	<thead>
	    		<tr>
	    			<th>Name</th>
	    			<th>Date</th>
	    			<th>Location</th>
	    			<th>Host</th>
	    			<th>Action</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${eventsInState}" var="ei">
	    			<tr>
	    				<td><a href="/events/${ei.id}">${ei.name}</a></td>
	    				<td>${ei.hostDate}</td>
	    				<td>${ei.location}</td>
	    				<td>${ei.hostName}</td>
	    				<c:choose>
	    					<c:when test="${currUser.id == ei.hostBy}">
	    						<td>
	    							<a href = "/events/${ei.id}/edit">Edit</a>
	    							<form action="/events/${ei.id}/delete" method="POST">
	    								<input name ="delete" type="hidden" />
	    								<input type ="submit" value="Delete" />
	    							</form>
	    						</td>
	    					</c:when>
	    					<c:when test="${ei.getUsers().contains(currUser)}">
	    						<td>
		    						<span>Joining</span>
		    						<form action="/events/${ei.id}/cancel" method="POST">
		    							<input name ="cancel" type="hidden" />
		    							<input type ="submit" value="Cancel" />
		    						</form>
	    						</td>
	    					</c:when>
	    					<c:otherwise>
	    						<td>
	    							<form action="/events/${ei.id}/join" method="POST">
	    								<input name ="join" type="hidden" />
	    								<input type ="submit" value="Join" />
	    							</form>
	    						</td>
	    					</c:otherwise>
	    				</c:choose>
	    			</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
	   	<hr/>
	   	<p>Here are events out of your state / in other states:</p>
	   	<table>
	   		<thead>
	    		<tr>
	    			<th>Name</th>
	    			<th>Date</th>
	    			<th>Location</th>
	    			<th>State</th>
	    			<th>Host</th>
	    			<th>Action</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<c:forEach items="${eventsOutState}" var="eo">
	    			<tr>
	    				<td><a href="/events/${eo.id}">${eo.name}</a></td>
	    				<td>${eo.hostDate}</td>
	    				<td>${eo.location}</td>
	    				<td>${eo.state}</td>
	    				<td>${eo.hostName}</td>
	    				<c:choose>
	    					<c:when test="${currUser.id == eo.hostBy}">
	    						<td>
	    							<a href = "/events/${eo.id}/edit">Edit</a>
	    							<form action="/events/${eo.id}/delete" method="POST">
	    								<input name ="delete" type="hidden" />
	    								<input type ="submit" value="Delete" />
	    							</form>
	    						</td>
	    					</c:when>
	    					<c:when test="${eo.getUsers().contains(currUser)}">
	    						<td>
	    							<span>Joining</span>
		    						<form action="/events/${eo.id}/cancel" method="POST">
		    							<input name ="cancel" type="hidden" />
		    							<input type ="submit" value="Cancel" />
		    						</form>
		    					</td>
	    					</c:when>
	    					<c:otherwise>
	    						<td>
	    							<form action="/events/${eo.id}/join" method="POST">
	    								<input name ="join" type="hidden" />
	    								<input type ="submit" value="Join" />
	    							</form>
	    						</td>
	    					</c:otherwise>
	    				</c:choose>
	    			</tr>
	    		</c:forEach>
	    	</tbody>
	   	</table>
	   	<hr/>
	   	<h3>Create an event:</h3>
	   	<form:form method="POST" action="/events" modelAttribute="event">
			<p>
		    	<form:label path="name">Event Name:</form:label>
		        <form:input type="text" path="name"/>
		        <form:errors path="name" />
		   	</p>
		   	<p>
		    	<form:label path="hostDate">Date:</form:label>
		        <form:input type="date" path="hostDate"/>
		        <form:errors path="hostDate" />
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
		 	<input type="submit" value="Create"/>
		 </form:form>
	</div>
</body>
</html>
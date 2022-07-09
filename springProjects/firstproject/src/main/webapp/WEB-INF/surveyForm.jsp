<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey Form</title>
</head>
<body>
	<div>
		<form method="POST" action="/fillsurvey">
			<p><label>Name: </label><input type ="text" name="name"/></p>
			<div>
				<label>Dojo Location: </label>
				<select name="location" id="location">
					<option value="San Jose">San Jose</option>
					<option value="Burbank">Burbank</option>
					<option value="Dallas">Dallas</option>
				</select>
			</div>
			<div>
				<label>Program Language: </label>
				<select name="lan" id="lan">
					<option value="JAVA">JAVA</option>
					<option value="JavaScript">JavaScript</option>
					<option value="Python">Python</option>
				</select>
			</div>
			<div>
				<label>Comment(optional)</label>
				<textarea name="comment" rows="3" cols="5"></textarea>
			</div>
			<button>Submit</button>
		</form>
	</div>
</body>
</html>
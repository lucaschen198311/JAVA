<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h1>Total Gold: <c:out value="${totalCount}"/></h1>
		</div>
		<div class="forms">
			<form class="farm" method="POST" action="/farm">
				<h3>Farm</h3>
				<label>(earns 10-20 gold)</label>
				<input type="hidden" id="farm" name="farm" />
				<button>Find Gold</button>
			</form>
			<form class="cave" method="POST" action="/cave">
				<h3>Cave</h3>
				<label>(earns 5-10 gold)</label>
				<input type="hidden" id="cave" name="cave" />
				<button>Find Gold</button>
			</form>
			<form class="house" method="POST" action="/house">
				<h3>House</h3>
				<label>(earns 2-5 gold)</label>
				<input type="hidden" id="house" name="house" />
				<button>Find Gold</button>
			</form>
			<form class="casino" method="POST" action="/casino">
				<h3>Casino!</h3>
				<label>(earns/loses 0-50 gold)</label>
				<input type="hidden" id="casino" name="casino" />
				<button>Find Gold</button>
			</form>
		</div>
		<div class="activities">
			<h2>Activities: </h2>
			<c:forEach var="activity" items="${list}">
				<p><c:out value="${activity}"></c:out></p>
			</c:forEach>
		</div>
	</div>
</body>
</html>
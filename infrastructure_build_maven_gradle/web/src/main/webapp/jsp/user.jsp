<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>User</title>
	</head> 
	<body>
		<c:choose>
			<c:when test="${not empty user }">
				<div>
					<p>Welcome ${user.name }</p>
					<c:url value="/booking" var="bookingUrl" />
					<a href="${bookingUrl}">Booking</a>
				</div>
			</c:when>
			<c:otherwise>
				<p>Enter your name:</p>
				<div>
					<c:url value="/user" var="userUrl" />
					<form action="${userUrl }" method="post">
						<input type="text" name="userName">
						<input type="submit">
					</form>
				</div>
			</c:otherwise>
		</c:choose>
		<br>
		<footer>
			<c:url value="/home" var="homeUrl" />
			<a href="${homeUrl}">Home</a>
		</footer>
	</body>
</html>
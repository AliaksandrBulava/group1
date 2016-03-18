<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>Booking</title>
</head>
<body>
	<c:if test="${not empty tickets }">
		<p>Booked Tickets</p>
		<table>
			<tr>
				<th>Number</th>
				<th>Event</th>
			</tr>
			<c:forEach var="ticket" items="${tickets }">
				<tr>
					<td>${ticket.id }</td>
					<td>${ticket.event.name }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>

	<c:if test="${not empty events }">
		<p>Select event</p>
		<c:url value="/booking" var="bookingUrl" />
		<form action="${bookingUrl }" method="post">
			<select name="bookEvent">
				<c:forEach var="event" items="${events }">
					<option value="${event.id }">${event.name }</option>
				</c:forEach>
			</select> <input type="submit">
		</form>
	</c:if>

	<br>
	<footer>
		<c:url value="/home" var="homeUrl" />
		<a href="${homeUrl}">Home</a>
	</footer>
</body>
</html>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Admin</title>
	</head> 
	<body>
		<c:if test="${not empty events}">
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Auditorium</th>
						<th>Date</th>
						<th>Start Time</th>
						<th>End Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="event" items="events">
						<tr>
							<td>event.name</td>
							<td>event.auditorium.name</td>
							<td>event.date</td>
							<td>event.startTime</td>
							<td>event.endTime</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		
		<c:url value="/admin/event" var="eventUrl" />
		<a href="${eventUrl}">Add Event</a>
		<br>
		<c:url value="/admin/auditorium" var="auditoriumUrl" />
		<a href="${auditoriumUrl}">Add Auditorium</a>
	</body>
</html>
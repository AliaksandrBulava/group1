<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Event</title>
	</head> 
	<body>
		<c:choose>
			<c:when test="${empty auditoriums}">
				<div>There are not configured Auditoriums</div>
				<c:url value="/admin/auditorium" var="auditoriumUrl" />
				<a href="${auditoriumUrl}">Add Auditorium</a>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty message}">
					<div>
						<p>Result:</p>
						<p>${message }</p>
					</div>
					<br>					
				</c:if>
				<p>Enter data</p>
				<c:url value="/admin/event" var="eventUrl" />
				<form action="${eventUrl }" method="post">
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="eventName" required="required"/>
							</td>
						</tr>
						<tr>
							<td>Auditorium</td>
							<td>
								<select name="eventAuiditorium" required="required">
									<c:forEach var="auditorium" items="${auditoriums}">
										<option value="${auditorium.id}">${auditorium.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>Date</td>
							<td>
								<input type="date" name="eventDate" required="required"/>
							</td>
						</tr>
						<tr>
							<td>Start Time</td>
							<td>
								<input type="time" name="eventStartTime" required="required"/>
							</td>
						</tr>
						<tr>
							<td>End Time</td>
							<td>
								<input type="time" name="eventEndTime" required="required"/>
							</td>
						</tr>
					</table>
					<input type="submit">
				</form>
			</c:otherwise>
		</c:choose>
		<footer>
			<c:url value="/home" var="homeUrl" />
			<a href="${homeUrl}">Home</a>
		</footer>
	</body>
</html>
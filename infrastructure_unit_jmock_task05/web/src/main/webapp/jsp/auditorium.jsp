<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Auditorium</title>
	</head> 
	<body>
		<p>Enter requested data</p>
		<c:url value="/admin/auditorium" var="auditoriumUrl" />
		<form action="${auditoriumUrl }" method="post">
			<div>
				<span>Name</span>
				<input type="text" name="auditoriumName" required="required">
			</div>
			<br>
			<input type="submit">
		</form>
		<footer>
			<c:url value="/home" var="homeUrl" />
			<a href="${homeUrl}">Home</a>
		</footer>
	</body>
</html>
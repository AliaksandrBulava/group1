<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h1>Welcome to conference</h1>
		<h3>If you are organizer, please continue with following link</h3>
		<c:url value="/admin" var="adminUrl" />
		<a href="${adminUrl}">Click to enter</a>
		<h3>If you are guest, welcome to guest page</h3>
		<c:url value="/user" var="userUrl" />
		<a href="${userUrl}">Click to enter</a>
	</body>
</html>

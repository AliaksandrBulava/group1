<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<c:url var="employeeUrl" value="/employee"></c:url>
	<p><a href="${employeeUrl }">Employee page</a></p>
</body>
</html>

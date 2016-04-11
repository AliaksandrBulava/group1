<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h3>
		Select file
	</h3>
	<c:url var="uploadUrl" value="/files/upload"></c:url>
	<form action="${uploadUrl }" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit">
	</form>
	</body>
	
	<c:if test="${filename != null }">
		${filename} uploaded
		<c:url var="downloadUrl" value="/files/download"></c:url>
		<form action="${downloadUrl }" method="get">
			<input type="hidden" name="filename" value="${filename}">
			<input type="submit">
		</form>
	</c:if>
</html>

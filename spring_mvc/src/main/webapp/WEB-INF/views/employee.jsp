<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee</title>
</head>
<body>
	<h3>Create Employee</h3>
	<c:url var="employeeUrl" value="/employee"></c:url>
	<form action="${employeeUrl }" method="post">
		<div>Personal info:</div>
		<table>
			<tr>
				<td>First Name*:</td>
				<td><input type="text" name="firstName" required="required"></td>
			</tr>
			<tr>
				<td>Last Name*:</td>
				<td><input type="text" name="lastName" required="required"></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" name="birthday" required="required"></td>
			</tr>
		</table>
		<div>Address:</div>
		<table>
			<tr>
				<td>Country*:</td>
				<td><input type="text" name="country" required="required"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>City*:</td>
				<td><input type="text" name="city" required="required"></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><input type="text" name="street"></td>
			</tr>
			<tr>
				<td>Home:</td>
				<td><input type="text" name="home"></td>
			</tr>
		</table>
		<input type="submit">
	</form>
	<h3>Find Employee</h3>
	<form action="${employeeUrl }" method="get">
		<div>
			<label>id:</label> <input type="number" required="required" name="id">
		</div>
		<input type="submit">
	</form>
	<c:if test="${employee != null }">
		<h3>Update Employee</h3>
		<form action="${employeeUrl }" method="post">
			<input type="hidden" name="_method" value="put" />
			<div>Personal info:</div>
			<table>
				<tr>
					<td>First Name*:</td>
					<td><input type="text" name="firstName" required="required"
						value="${employee.personalInfo.firstName }"></td>
				</tr>
				<tr>
					<td>Last Name*:</td>
					<td><input type="text" name="lastName" required="required"
						value="${employee.personalInfo.lastName }"></td>
				</tr>
			</table>
			<div>Address:</div>
			<table>
				<tr>
					<td>Country*:</td>
					<td><input type="text" name="country" required="required"
						value="${employee.address.country }"></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="state"
						value="${employee.address.state }"></td>
				</tr>
				<tr>
					<td>City*:</td>
					<td><input type="text" name="city" required="required"
						value="${employee.address.city }"></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><input type="text" name="street"
						value="${employee.address.street }"></td>
				</tr>
				<tr>
					<td>Home:</td>
					<td><input type="text" name="home"
						value="${employee.address.home }"></td>
				</tr>
			</table>
			<input type="submit">
		</form>
		<h3>Delete Employee</h3>
		<form action="${employeeUrl }" method="post">
			<input type="hidden" name="_method" value="delete" />
			<input type="submit">
		</form>
	</c:if>

</body>
</html>

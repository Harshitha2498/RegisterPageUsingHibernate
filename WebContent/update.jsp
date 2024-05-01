<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update user</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- User u = ((User) request.getAttribute("user")); -->
	</head>
<body>
	<div class="card container mt-5 ">
		<form method="post" action="updateUser" id="userRegister">
			<div class="text-center" style="background-color: green;">
				<h3 class="card-header">Update Registration</h3>
			</div>
			<div style="text-align: Right;">
				<a href="index.jsp">Back</a>
			</div>
			<div class="card-body ">
				<div class="col-md-6">
					<%-- Hidden input field for the record ID --%>
					<input type="hidden" name="id"
						value="${user.id}"> <label
						for="name" class="col-md-3">First name:</label> <input type="text"
						value="${user.firstName}" id="firstName"
						name="firstName">
				</div>
				<div class="col-md-6">
					<label for="name" class="col-md-3">Last name:</label> <input
						type="text" value="${user.lastName}"
						id="lastName" name="lastName">
				</div>
				<div class="col-md-6">
					<label for="name" class="col-md-3">Gender:</label> <select
						name="gender" style="width: 188px">
						<option value="${user.gender}" autofocus="autofocus">all</option>
						<option value="${user.gender}">Male</option>
						<option value="${user.gender}">Female</option>
					</select>
				</div>
				<div class="col-md-6">
					<label for="email" class="col-md-3">Email:</label> <input
						type="email" value="${user.email}" id="email"
						name="email">
				</div>
				<div class="col-md-6">
					<label for="mobile" class="col-md-3">Mobile:</label> <input
						type="tel" value="${user.mobile}" id="mobile"
						name="mobile">
				</div>
				<div class="col-md-6">
					<label for="file" class="col-md-3">File:</label> <input type="file"
						id="file" name="file">
				</div>
				<div class="col-md-6">
					<label for="filepath" class="col-md-3">FilePath:</label> <input
						type="text" id="filepath" name="filepath">
				</div>
				<input type="hidden" name="id"
					value="${user.id}"> <input
					type="submit" onClick="submitForm()" class="btn btn-primary"
					value="Submit"> <input type="reset"
					class="btn btn-secondary" value="reset">
			</div>
		</form>
	</div>
	<!-- Bootstrap JS (Optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		function validate(firstName, lastName, email, mobile) {
			var namePattern = /^[a-zA-Z\s-]+$/;
			var emailPattern = /^[\w\.-]+@[a-zA-Z\d\.-]+\.[a-zA-Z]{2,}$/;
			var mobilePattern = /^[6-9]{1}[0-9]{9}$/;
			if (!firstName) {
				return "First name is required.";
			}
			if (!lastName) {
				return "Last name is required.";
			}
			if (!namePattern.test(firstName) || !namePattern.test(lastName)) {
				return "Invalid first name or last name.";
			}
			if (!email) {
				return "email is required.";
			}
			if (!emailPattern.test(email)) {
				return "email is invalid:";
			}
			if (!mobile) {
				return "mobile number is required.";
			}
			if (!mobilePattern.test(mobile)) {
				return "mobile number  is invalid:";
			}
			document.getElementById("userRegister").submit();
		}
		function submitForm() {
			var firstName = document.getElementById("firstName").value;
			var lastName = document.getElementById("lastName").value;
			var email = document.getElementById("email").value;
			var mobile = document.getElementById("mobile").value;
			var validationMessage = validate(firstName, lastName, email, mobile);
			if (validationMessage != undefined) {
				alert(validationMessage);
			}
		}
	</script>
</body>
</html>
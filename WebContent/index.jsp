<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Registers</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.card {
	width: 50%;
	margin: 0 auto;
	float: none;
	margin-bottom: 10px;
	font-size: 1em;
}
</style>
</head>
<body>
	<div class="card mt-5">
		<h3 class="card-header text-center" style="background-color: green;">Search
			Page</h3>
		<div class="navbar">
			<div class="navbar-left">
				<a href="update.jsp">Add Register</a>
			</div>
			<div class="navbar-right">
				<a href="dashboard.jsp">DashBoard</a>
			</div>
		</div>
		<form class=" card-body" action="search" method="post">
			<div class="col-md-6">
				<label for="name" style="width: 80px">First name:</label> <input
					type="text" id="fname" name="firstName">
			</div>
			<div class="col-md-6">
				<label for="name" style="width: 80px">Gender:</label> <select
					name="gender" style="width: 188px">
					<option value="all" autofocus="autofocus">all</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
			</div>
			<div class="col-md-6">
				<label for="email" style="width: 80px">Email:</label> <input
					type="email" id="mail" name="email">
			</div>
			<input class="btn btn-primary text-center" type="submit"
				value="Search"> <input class="btn btn-secondary text-center"
				type="reset" value="reset">
		</form>
	</div>
	<!-- Bootstrap JS (Optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
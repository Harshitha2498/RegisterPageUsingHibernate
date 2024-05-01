<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap JS (Optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid black;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #04AA6D;
	color: white;
}

.navbar {
	display: flex;
	justify-content: space-between;
	background-color: #333;
	color: white;
	padding: 10px;
}

.navbar-left, .navbar-right {
	display: flex;
}

.navbar a {
	color: white;
	text-decoration: none;
	padding: 10px;
}

.table .rows:nth-child(even) {
	background-color: lightgreen;
}
</style>
</head>
<body>
	<h3 style="text-align: center">Welcome to DashBoard</h3>
	<div class="navbar">
		<div class="navbar-left">
			<a href="update.jsp">Add Register</a>
		</div>
		<div class="navbar-right">
			<a href="index.jsp">Back</a>
		</div>
	</div>
	<table class="table">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			List<User> userList = (List<User>) session.getAttribute("USERS");
		for (User u : userList) {
		%>
		<tr class="rows">
			<td><a href="getUser?id=<%=u.getId()%>"><%=u.getFirstName()%></a></td>
			<td><%=u.getLastName()%></td>
			<td><%=u.getEmail()%></td>
			<td><a href="updateUser?id=<%=u.getId()%>">Edit</a></td>
			<td><a href="deleteUser?id=<%=u.getId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<!-- <script>
		var table = document.getElementsByClassName("table");
		for (i = 0; i < table.length; i++) {
			var table = table[i];
			var rows = table.getElementsByClassName("rows");
			for (j = 0; j < rows.length; j++) {
				if (j % 2 == 0) {
					rows[j].style.backgroundColor = 'lightgreen';
				} 
			}
		}
	</script> -->
	<!-- 	<script>
		var tr = document.getElementsByTagName('tr');
		for (i = 0; i < tr.length; i++) {
			if (i % 2 == 0) {
			} else
				tr[i].style.backgroundColor = 'lightgreen';
		}
	</script> -->
</body>
</html>
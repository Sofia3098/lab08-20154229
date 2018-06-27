<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.*"%>
<%@page import="model.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
	TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
	SimpleDateFormat sdf = new SimpleDateFormat();
%>
<%
	Access role = (Access) request.getAttribute("access");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="../style.css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div id="navbar" class="navbar-collapse collapse"
					style="background-color: #A3E4D7; font-weight: bold;">
					<ul class="nav navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link" href="../roles">Roles</a></li>
						<li class="nav-item"><a class="nav-link" href="../users">Users</a></li>
						<li class="nav-item"><a class="nav-link" href="../resources">Resources</a></li>
						<li class="nav-item"><a class="nav-link" href="/access">Access</a></li>
						<li class="nav-item"><a class="nav-link" href="/courses">Courses</a></li>
						<li class="nav-item"><a class="nav-link" href="/users/login">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="/users/logout">Logout</a></li>
					</ul>
				</div>

				<%
					if (request.getAttribute("condicion") != null) {
				%>
				<div class="row">
					<br> <br>
					<div class="col-md-2">
						<h1>Action</h1>
						<li><a href="/access">List Access</a>
					</div>
					<br>

					<div class="col-md-10">
						<h1>Access existente</h1>
					</div>
				</div>
				<%
					} else if (role != null) {
				%>
				<div class="row">
					<br>
					<div class="col-md-2">
						<h1>Action</h1>
						<li><a href="/access">List Access</a>
					</div>
					<br>
					<div class="col-md-4">
						<table class="table">
							<tr>
								<td>ID</td>
								<td><%=role.getId() %></td>
							</tr>

							<tr>
								<td>Role</td>
								<td><%=role.getName() %></td>
							</tr>
							<tr>
								<td>Resource</td>
								<td><%=role.getNameR() %></td>
							</tr>

							<tr>
								<td>Status</td>
								<td><%=role.isStatus() %></td>
							</tr>
							<tr>
								<td>Created</td>
								<td><%=role.getDate()%></td>
							</tr>
						</table>
					</div>
				</div>
				<%
					}
				%>
			</div>
			</nav>
		</div>
	</div>
</body>
</html>
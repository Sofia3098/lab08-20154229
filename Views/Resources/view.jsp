<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controller.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.entity.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
	TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
	SimpleDateFormat sdf = new SimpleDateFormat();
%>
<%
	List<Resource> resources = (List<Resource>) request.getAttribute("viewResource");
%>
<%
	Resource resource = (Resource) request.getAttribute("resource");
%>
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
<title>View Resource</title>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div id="navbar" class="navbar-collapse collapse" style="background-color: #A3E4D7; font-weight: bold;">
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
				<br>
				<br>
					<div class="col-md-2">
						<h1>Action</h1>
						<li><a href="/resources">List Resources</a>
					</div>
					<br>
				
					<div class="col-md-10">
						<h1>Resource exist</h1>
					</div>
				</div>
				<%
					} else if (resource != null) {
				%>
				<div class="row">
				<br>
					<div class="col-md-2">
						<h1>Action</h1>
						<li><a href="/resources">List Resources</a>
					</div>
					<br>
					<div class="col-md-4">
						<table class="table">
							<tr>
								<td>ID</td>
								<td><%=resource.getId() %></td>
							</tr>
							<tr>
								<td>Name</td>
								<td><%=resource.getName() %></td>
							</tr>
							<tr>
								<td>Status</td>
								<td><%=resource.isStatus() %></td>
							</tr>
							<tr>
								<td>Created</td>
								<td><%=resource.getDate() %></td>
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

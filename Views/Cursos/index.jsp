<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.*"%>
<%@page import="model.entity.Course"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<% 
List<Course> courses= (List<Course>) request.getAttribute("todosCursos");
%>
<%
	TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
	SimpleDateFormat sdf = new SimpleDateFormat();
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
<title>Cursos</title>
</head>
<body>
<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
			<div class="container">
				<div id="navbar" class="navbar-collapse collapse" style="background-color: #A3E4D7;  font-weight: bold;">
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
				<div class="row">
					<br>
					<div class="col-md-2">
						<h1>Action</h1>
						<li><a href="/courses/add">New Course</a>
					</div>
					<br>
					<div class="col-md-10">
						<table class="table">
							<tr>
								<th>ID</th>
								<th>Nombre del Curso</th>
								<th>Departamento </th>
								<th>Nivel</th>
								<th>Profesor</th>
								<th>Habilitado</th>
								<th>Create</th>
								<th>Actions</th>
							</tr>
							<%
								for (int idx = 0; idx < courses.size(); idx++) {
							%>
							<%
								Course r = (Course) courses.get(idx);
							%>
							<tr>
								<th><%=r.getId()%></th>
								<th><%=r.getName()%></th>
								<th><%=r.getDepa()%></th>
								<th><%=r.getNivel()%></th>
								<th><%=r.getProfe()%></th>
								<th><%=r.getHab()%></th>
								<th><%=sdf.format(r.getDate())%></th>
								<th><a
									href="../courses/view?action=courses&ID=<%=r.getId()%>">View</a>
									<a href="/courses/edit?ID=<%=r.getId()%>">Edit</a> <a
									href="/courses/delete?ID=<%=r.getId()%>">Delete</a></th>
							</tr>
							<%
								}
							%>
						</table>
					</div>
				</div>
			</div>
			</nav>
		</div>
	</div>
</body>
</html>

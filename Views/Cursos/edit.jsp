<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controller.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.entity.*"%>
<%
	Course curso = (Course) request.getAttribute("course");
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
<title>Editar Curso</title>
</head>
<body>
	<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
				<div class="container">
					<div id="navbar" class="navbar-collapse collapse"
						style="background-color: #A3E4D7;  font-weight: bold;">
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
							<li><a href="/courses">List Students</a>
						</div>
						<br>
						<div class="col-md-3">
							<form action="../courses/edit" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">ID</label> <input type="text"
										class="form-control" id="name" aria-describedby="emailHelp"
										name="id" requerid="requerid" value="<%=curso.getId()%>"
										readonly>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Nombre del curso: </label> <input
										type="text" class="form-control" id="name"
										aria-describedby="emailHelp" name="name"
										placeholder="Enter mane" requerid="requerid"
										value="<%=curso.getName()%>">
								</div>
								<div class="form-group">
									<td style="color: B441C8; font-weight: bold;">Departamento
										al que pertenece:</td>
									<td><select name="depa" style="width: 150px"
										value="<%=curso.getDepa()%>">
											<%
												if (curso.getDepa().equals("letras")) {
											%>
											<option selected="selected">Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>

											<%
												} else if (curso.getDepa().equals("Matematica")) {
											%>
											<option>Letras</option>
											<option selected="selected">Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Sociales")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option selected="selected">Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Psicomotriz")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option selected="selected">Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Ciencia Tecnologia y Ambiente")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option selected="selected">Ciencia Tecnologia y
												Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Artes")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option selected="selected">Artes</option>
											<option>Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Psicologia")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option selected="selected">Psicologia</option>
											<option>Religion</option>
											<%
												} else if (curso.getDepa().equals("Religion")) {
											%>
											<option>Letras</option>
											<option>Matematica</option>
											<option>Sociales</option>
											<option>Psicomotriz</option>
											<option>Ciencia Tecnologia y Ambiente</option>
											<option>Artes</option>
											<option>Psicologia</option>
											<option selected="selected">Religion</option>
											<%
												}
											%>
									</select></td>
								</div>
								<div class="form-group">
									<td style="color: B441C8; font-weight: bold;">Nivel en el
										que se enseñara:</td>
									<td><select name="nivel" style="width: 150px"
										value="<%=curso.getNivel()%>">
											<%
												if (curso.getNivel().equals("Inicial")) {
											%>
											<option selected="selected">Inicial</option>
											<option>Primaria</option>
											<option>Secundaria</option>
											<%
												} else if (curso.getNivel().equals("Primaria")) {
											%>
											<option>Inicial</option>
											<option selected="selected">Primaria</option>
											<option>Secundaria</option>
											<%
												} else if (curso.getNivel().equals("Secundaria")) {
											%>
											<option>Inicial</option>
											<option>Primaria</option>
											<option selected="selected">Secundaria</option>
											<%
												}
											%>
									</select></td>
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Profesor que imparte el
										curso:</label> <input type="text" class="form-control" id="name"
										aria-describedby="emailHelp" name="profe"
										placeholder="Enter mane" requerid="requerid"
										value="<%=curso.getName()%>">
								</div>
								<%
									if (curso.getHab().equalsIgnoreCase("si")) {
								%>
								<div class="form-group">
									<label for="exampleInputEmail1">Habilitado</label>
									<div class="radio">
										<label><input type="radio" value="si"
											name="hab" checked>si</label>
									</div>
									<div class="radio">
										<label><input type="radio" value="no" name="hab">no</label>
									</div>
								</div>
								<%
									} else {
								%>
								<div class="form-group">
									<label for="exampleInputEmail1">Hablitado</label>
									<div class="radio">
										<label><input type="radio" value="si"
											name="hab">Si</label>
									</div>
									<div class="radio">
										<label><input type="radio" value="no" name="hab"
											checked>No</label>
									</div>
								</div>
								<%
									}
								%>

								<input type="hidden" name="action" value="edit" />
								<button type="submit" class="btn btn-primary">Enviar</button>
							</form>
						</div>
					</div>

				</div>
			</nav>
		</div>
	</div>

</body>
</html>
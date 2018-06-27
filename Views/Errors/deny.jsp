<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<title>Hello App Engine</title>
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
					<div class="col-md-2"></div>
					<br>
					<div class="col-md-10">
						<%if(request.getAttribute("error").equals("login")){ %>
							<li>Es necesario Logearse</li>
						<%}else if(request.getAttribute("error").equals("noExiste")){ %>
							<li>Usted no esta dentro de Users</li>
							<li>El administrador solo puede crear Users</li>
						<%}else if(request.getAttribute("error").equals("sinPermiso")){ %>
							<li>No existen Roles</li>
							<li>Solo el Administrador puede crear roles</li>
						<%}else if(request.getAttribute("error").equals("sinAcceso")){ %>
							<li>Usted no tiene un Aceso</li>
							<li>El Administardor solo puede crear accesos</li>
						<%}else if(request.getAttribute("error").equals("sinPermisoEdit")){%>
							<li>No hay un Rol que editar</li>
						<%}else if(request.getAttribute("error").equals("sinAccesoEdit")){%>
							<li>Usted no tiene acceso a editar</li>
						<%}else if(request.getAttribute("error").equals("sinPermisoDelete")){%>
							<li>No existe el rol que desa eliminar</li>
						<%}else if(request.getAttribute("error").equals("sinAccesoDelete")){%>
							<li>Usted no tiene acceso a eliminar</li>
						<%}else if(request.getAttribute("error").equals("deleteA")){%>
							<li>El administrador no se puede eliminar</li>
						<%}else if(request.getAttribute("error").equals("errorA")){%>
							<li>Usted no es administrador</li>
						<%}else if(request.getAttribute("error").equals("adminP")){%>
							<li>Usted no es administrador</li>
						<%}else if(request.getAttribute("error").equals("sinAccesoAdd")){%>
							<li>Usted no tiene acceso a añadir</li>
						<%} %>
						
					</div>
				</div>
			</div>
			</nav>
		</div>
	</div>
</body>
</html>
</html>
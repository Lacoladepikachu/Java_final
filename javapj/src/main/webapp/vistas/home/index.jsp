<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Mi Sitio</title>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

	<style>
		.navbar-brand img {
			max-height: 50px;
		}
		.user-profile {
			display: inline-flex;
			align-items: center;
			cursor: pointer;
		}
		.user-profile img {
			height: 30px;
			border-radius: 50%;
			margin-right: 10px;
		}
	</style>
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	  <a class="navbar-brand" href="#">Mi Sitio</a>

	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	        <a class="nav-link" href="#">Inicio</a>
	      </li>
	      <li class="nav-item">
	        <form action="home" method="POST">
	          <input type="hidden" name="action" value="productos">
	          <button type="submit" class="btn btn-link nav-link">Productos</button>
	        </form>
	      </li>
	      <li class="nav-item">
	        <form action="home" method="POST">
	          <input type="hidden" name="action" value="usuarios">
	          <button type="submit" class="btn btn-link nav-link">Usuarios</button>
	        </form>
	      </li>
	      <li class="nav-item">
	        <form action="home" method="POST">
	          <input type="hidden" name="action" value="carrito">
	          <button type="submit" class="btn btn-link nav-link">carrito</button>
	        </form>
	      </li>
	      <form action="home" method="POST">
	          <input type="hidden" name="action" value="transferir">
	          <button type="submit" class="btn btn-link nav-link">transferir</button>
	        </form>
	    </ul>

	    <div class="user-profile dropdown">
    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <img src="https://via.placeholder.com/30" alt="Foto de Perfil">
        <c:out value="${usuario.nick}" />
    </a>
    <div class="dropdown-menu dropdown-menu-right">
        <a class="dropdown-item" href="#">Editar Perfil</a>
        <a class="dropdown-item" href="#">Cambiar Contraseña</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#">Cerrar Sesión</a>
    </div>
</div>

	  </div>
	</nav>

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Bootstrap JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

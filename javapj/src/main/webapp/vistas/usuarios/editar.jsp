<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar Producto</title>
	<!-- Agregamos los links de los archivos de Bootstrap -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<style>
		body {
			background-color: #F9F9F9; /* Fondo blanco perla */
		}
		.container {
			margin-top: 50px; /* Centramos el contenido */
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>Editar usuario</h1>
		<form action="aduserC" method="POST">
			<input type="hidden" name="accion" value="update" />
			<input type="hidden" name="id" value="${usuario.id}" />
			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="nombre" value="${usuario.nombre}" class="form-control" />
			</div>
			<div class="form-group">
				<label>nick:</label>
				<input type="text" name="nick" value="${usuario.nick}" class="form-control" />
			</div>
			<div class="form-group">
				<label>clave:</label>
				<input type="text" name="clave" value="${usuario.clave}" class="form-control" />
			</div>
			<div class="form-group">
				<label>dinero:</label>
				<input type="text" name="dinero" value="${usuario.dinero}" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a href="aduserC" class="btn btn-default">Cancelar</a>
		</form>
	</div>
	<!-- Agregamos los scripts de Bootstrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

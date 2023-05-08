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
		<h1>Editar Producto</h1>
		<form action="productosC" method="POST">
			<input type="hidden" name="accion" value="update" />
			<input type="hidden" name="id" value="${producto.id}" />
			<div class="form-group">
				<label>Nombre:</label>
				<input type="text" name="nombre" value="${producto.nombre}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Descripción:</label>
				<input type="text" name="descripcion" value="${producto.descripcion}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Precio:</label>
				<input type="text" name="precio" value="${producto.precio}" class="form-control" />
			</div>
			<div class="form-group">
				<label>Stock:</label>
				<input type="text" name="stock" value="${producto.stock}" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a href="productosC" class="btn btn-default">Cancelar</a>
		</form>
	</div>
	<!-- Agregamos los scripts de Bootstrap -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

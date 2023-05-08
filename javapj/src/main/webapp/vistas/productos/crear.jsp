<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Agregamos los estilos de Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Crear Producto</h1>
        <form class="form-horizontal" action="productosC" method="post">

            <!-- Agregamos el campo oculto para la acción -->
            <input type="hidden" value="insert" name="accion">

            <!-- Campo nombre -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="nombre">Nombre:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nombre" name="nombre">
                </div>
            </div>

            <!-- Campo precio -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="precio">Precio:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="precio" name="precio">
                </div>
            </div>

            <!-- Campo descripción -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="descripcion">Descripción:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="descripcion" name="descripcion"></textarea>
                </div>
            </div>

            <!-- Campo stock -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="stock">Stock:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="stock" name="stock">
                </div>
            </div>

            <!-- Botón enviar -->
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Crear</button>
                </div>
            </div>

        </form>
    </div>

    <!-- Agregamos los scripts de Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

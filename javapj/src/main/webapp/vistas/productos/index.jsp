<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Productos</title>
    <!-- Agregamos los links de los archivos de Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f3f3f3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Productos</h1>

        <a href="productosC?accion=crear" class="btn btn-primary">Crear producto</a>
        <br />
        <br />

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>descripcion</th>
                    <th>precio</th>
                    <th>stock</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${productos}">
                    <tr>
                        <td><c:out value="${producto.id}" /></td>
                        <td><c:out value="${producto.nombre}" /></td>
                        <td><c:out value="${producto.descripcion}" /></td>
                        <td><c:out value="${producto.precio}" /></td>
                        <td><c:out value="${producto.stock}" /></td>
                        <td>
                            <div>
                                <a href="productosC?accion=editar&id=${producto.id}" class="btn btn-warning btn-block btn-sm">Editar</a>
                                <form method="post" action="productosC">
                                    <input type="hidden" name="accion" value="delete">
                                    <input type="hidden" name="id" value="${producto.id}">
                                    <button type="submit" class="btn btn-danger btn-block btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este producto?')">Eliminar</button>
                                </form>
                            </div>
                            <div>
                                <form method="post" action="carritoC">
                                    <input type="hidden" name="accion" value="agregar">
                                    <input type="hidden" name="idProducto" value="${producto.id}">
                                    <div class="form-group">
                                        <label for="cantidad${producto.id}">Cantidad:</label>
                                        <input type="number" id="cantidad${producto.id}" name="cantidad" class="form-control" value="1" min="1">
                                    </div>
                                    <button type="submit" class="btn btn-success btn-block btn-sm">Agregar al carrito</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Agregamos los scripts de Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

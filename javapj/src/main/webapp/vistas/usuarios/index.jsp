<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

    <div class="container">
        <h1 class="mt-4">Usuarios</h1>

        <a class="btn btn-primary mt-2 mb-2" href="aduserC?accion=crear">Crear Producto</a>

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>id</th>
                    <th>nombre</th>	
                    <th>nick</th>
                    <th>pass</th>
                    <th>acceso</th>
                    <th>dinero</th>
                    <th>acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios }">
                    <tr>
                        <td><c:out value="${usuario.id }" /></td>
                        <td><c:out value="${usuario.nombre }" /></td>
                        <td><c:out value="${usuario.nick }" /></td>
                        <td><c:out value="${usuario.clave }" /></td>
                        <td><c:out value="${usuario.acceso }" /></td>
                        <td><c:out value="${usuario.dinero }" /></td>
                        <td>
                            <div class="d-flex">
                                <a href="aduserC?accion=editar&id=${usuario.id}" class="btn btn-primary btn-sm">Editar</a>
                                <form method="post" action="aduserC">
                                    <input type="hidden" name="accion" value="delete">
                                    <input type="hidden" name="id" value="${usuario.id}">
                                    <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que deseas eliminar este producto?')">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>

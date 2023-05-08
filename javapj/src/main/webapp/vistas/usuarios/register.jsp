<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h1>Registro</h1>
		
<form action='<c:url value="/ingreso/register" />' method="post">
  <p>
    Nombre: <input name="nombre" />
  </p>
  <p>
    Clave: <input name="clave" />
  </p>
  <p>
    Nick: <input name="nick" />
  </p>
  <p>
    Tipo de usuario:
    <select name="clave_acceso">
      <option value="2">Cliente</option>
      <option value="1">Empleado</option>
    </select>
  </p>
  <p>
    Cantidad de dinero: <input name="dinero" />
  </p>
  <p>
    <input value="Registrar" type="submit" class="btn btn-primary"/>
  </p>
</form>

		<a href="ingreso">Volver</a>.


</body>
</html>
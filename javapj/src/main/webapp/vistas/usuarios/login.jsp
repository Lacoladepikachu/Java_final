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
<title>Login</title>
</head>
<body>
<h1>Ingresar</h1>
		<form action='<c:url value="/ingreso/login" />' method="post">

			<p>
				Nombre: <input name="nombre" />
			</p>
			<p>
				Clave: <input name="clave" type="password" />
			</p>
			<p>
				<input value="Ingresar" type="submit" class="btn btn-primary"/>
			</p>
		</form>
		¿No tenes cuenta? Podes registrarte <a href='<c:url value="/ingreso/register" />'>aquí</a>.


</body>
</html>
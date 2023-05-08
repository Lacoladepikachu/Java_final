<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transferencia de dinero</title>
</head>
<body>
<form action="aduserC" method="POST">
    <input type="hidden" name="accion" value="transferencia" />
    <p>
        Tu ID: <input name="nom_user1" />
    </p>
    <p>
        ID de destino: <input name="nom_user2" />
    </p>
    <p>
        Cantidad: <input name="dinero" />
    </p>
  
    <p>
        <input value="Enviar" type="submit" class="btn btn-primary"/>
    </p>
</form>
</body>
</html>
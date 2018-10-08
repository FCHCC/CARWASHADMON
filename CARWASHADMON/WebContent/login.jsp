<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<form action='LoginRegister' method="post">
	 	<div class="form-group">
	 		<label>${message}</label>
	 		
	 		 <label for="Usuario">Usuario</label>
	 		 <input class="form-control" type="text" name="Username" placeholder="Ingresa Username">	
		</div>
		
		<div class="form-group">
				<label for="Contraseña">Contraseña</label>
				<input class="form-control" type="password" name="password">
		</div>
		
		<button type="submit" class="btn btn-primary" name="submit" value="Login">LOGIN</button>
	
	</form>
	
	</div>
</body>
</html>
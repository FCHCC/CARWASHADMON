<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESERVAS</title>
</head>
<body>
	<div>
	
		<img src="${pageContext.request.contextPath}/img/LOGOCARWASH.jpg" alt="logo carwash" width="200" height="200" class="rounded float-right" />
		<a href="#" class="nav-link"><h6>CERRAR SESION</h2></a>
		<h1 class="text-center">REAL CARWASH RESERVAS</h1>
		
	</div>
	
	
	<nav class="nav nav-pills nav-justified">
	<a class="nav-item nav-link" href="/carwashadmin/enroll">NUEVA RESERVA</a> 
	 <a class="nav-item nav-link" href="#">REPORTE</a>
	</nav>
	
			
	
	<form:form>
		<table class="table table-striped"" id="t01" border="2" width="100%">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">SERVICIO</th>
				<th scope="col">FECHA</th>
				<th scope="col">HORA</th>
			</tr>
		</thead>
		
			<c:forEach var="reserva" items="${list}">
				
				<tr>
					<th scope="row">${reserva.id}</th>
					<td>${reserva.serviceName}</td>
					<td>${reserva.fecha}</td>
					<td>${reserva.hora}</td>
					<td><a href="/carwashadmin/editreserva/${reserva.id}">EDITAR</a></td>
					<td><a href="/carwashadmin/deletereserva/${reserva.id}">BORRAR</a></td>
				</tr>
			
			</c:forEach>
		</table>
	</form:form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/bootstrap/bootstrap.min.css' />" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESERVAS</title>
</head>
<body>

	<h1>RESERVAS</h1>
	
	<table cellpadding="2">
		<tr>
			<th>
				<a href="/carwashadmin/enroll"><h2>HOME PAGE: Nueva Reserva</h2></a> 
			</th>
			
			<th>
				<a align="right" href="/delete"><h2>Borrar TODO</h2></a>
			</th>
		</tr>
	</table>
	
	<form:form>
		<table id="t01" border="2" width="70%" cellpadding="2">
			<tr><th>Id</th></tr>
			<tr><th>SERVICIO</th></tr>
			<tr><th>FECHA</th></tr>
			<tr><th>HRA</th></tr>
			
			<c:forEach var="reserva" items="${list}">
				
				<tr>
					<td>${reserva.id}</td>
					<td>${reserva.serviceName}</td>
					<td>${reserva.fecha}</td>
					<td>${reserva.hora}</td>
					<td><a href="/carwashadmin/editreserva/${reserva.id}">EDITAR</a></td>
					<td><a href="/carwashadmin/deletereserva/${reserva.id}">BORRAR</a></td>
				</tr>
			
			</c:forEach>
		</table>
	</form:form>

</body>
</html>
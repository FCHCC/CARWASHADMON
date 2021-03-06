<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EDITAR RESERVA</title>
</head>
<body>
	<div class="form-container">
		<div>
			<img src="img/LOGOCARWASH.jpg" alt="logo carwash" width="100" height="100" class="rounded float-right" />
			<h6><a href="j_spring_security_logout" class="nav-link">CERRAR SESION</a></h6>
			<h1 class="text-center">REAL CARWASH RESERVAS</h1>		
		</div>
		
		<form:form method="POST" modelAttribute="reserva" class="form-horizontal" action="/carwashadmin/editsave">
			
			<div>
				<div class="form-group">
					<div class="col-md-7">
						<form:hidden path="id"  class="form-control"/>
						<div class="has-error">
						</div>
					</div>
				</div>
		
				<div class="mx-auto" style="width: 600px;">
					<div class="form-group">	
						<label for="serviceName">SERVICIO</label>
						<form:input type="text" path="serviceName" id="serviceName" class="form-control"/>
						<div class="has-error">
							<form:errors path="serviceName" class="help-inline"/>
						</div>		
					</div>
		
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="fecha">FECHA</label>
						<form:input type="date" path="Fecha" id="fecha" class="form-control" placeholder="(YYYY-MM-DD)"/>
						<div class="has-error">
							<form:errors path="Fecha" class="help-inline"/>
						</div>
				</div>
		
			
					<div class="form-group col-md-6">
						<label for="hora">HORA</label>
						<form:input type="text" path="Hora" id="hora" class="form-control" placeholder="HH:mm:ss 24HR"/>
						<div class="has-error">
							<form:errors path="Hora" class="help-inline"/>
						</div>
					</div>
				</div>
		
				<div class="form-group text-center">
					<input type="submit" value="AGREGAR" class="btn btn-primary center-block">
				</div>
			</div>				
		</div>	
	 </form:form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
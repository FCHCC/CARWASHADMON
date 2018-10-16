<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/bootstrap/bootstrap.min.css' />" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESERVAS </title>
</head>
<body>
	<div class="form-container">
		<h1>FORMULARIO DE RESERVA</h1>
		
		<form:form method="POST" modelAttribute="reserva" class="form-horizontal" action="save">
		
		<div class="form-group">
			<div class="form-group col-md-12">
				<label for="serviceName">Servicio</label>
				<div class="form-control">
					<form:input type="text" path="serviceName" id="serviceName" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="serviceName" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="fecha">FECHA</label>
				<div class="form-control">
					<form:input type="text" path="fecha" id="fecha" class="form-control input-sm"/>(YYYY-MM-DD)
					<div class="has-error">
						<form:errors path="fecha" class="help-inline"/>
					</div>
				</div>
			</div>
	
		
		
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="hora">HORA</label>
				<div class="form-control">
					<form:input type="text" path="hora" id="hora" class="form-control input-sm"/>(HH:MM:SS)
					<div class="has-error">
						<form:errors path="hora" class="help-inline"/>
					</div>
				</div>
			</div>
	
		
		
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		
		
		</form:form>
	</div>
</body>
</html>
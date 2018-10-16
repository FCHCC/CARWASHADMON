<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/bootstrap/bootstrap.min.css' />" rel="stylesheet"></link>
<title>EDITAR RESERVA</title>
</head>
<body>
	<div class="form-container">
		<h1>EDITAR DETALLES DE LA RESERVA</h1>
		
		<form:form method="POST" modelAttribute="reserva" class="form-horizontal" action="/carwashadmin/editreserva">
			
			<div>
				<div class="form-group col-md-12">
					<div class="col-md-7">
						<form:hidden path="id"  class="form-control input-sm"/>
						<div class="has-error">
						</div>
					</div>
				</div>
		
				<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="serviceName">Servicio</label>
				<div class="col-md-7">
					<form:input type="text" path="serviceName" id="serviceName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="serviceName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
					
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="fecha">FECHA</label>
					<div class="col-md-7">
						<form:input type="text" path="fecha" id="fecha" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="fecha" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>	
					
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="hora">HORA</label>
					<div class="col-md-7">
						<form:input type="text" path="hora" id="hora" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="hora" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>	
			
			<div class="form-actions floatRight">
				<input type="submit" value="Edit" class="btn btn-primary btn-sm">
			</div>
					
			</div>
		
		</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMINISTRADOR REAL CAR WASH</title>
</head>
<body>
	<div class="text-center">

    	  <img src="<c:url value='source/img/LOGOCARWASH.jpg'/>" alt="logo carwash" />
 
				<div>
					<h1>BIENVENIDO</h1><br>
					<c:if test="${not empty error}">${error}</c:if>
					
				  <form method="POST"  action="<c:url value='j_spring_security_check'/>" name="LoginForm">
					<div class="form-group">
						<input type="text" name="userName" placeholder="Usuario"/>
						
					</div>
					
					<div class="form-group">
						<input type="password" name="password" placeholder="Contraseña"/>
						
					</div>
					
					<div class="form-group text-center">
						<input type="submit" name="login" class="btn btn-primary center-block" value="INICIAR SESION"/>
					</div>
				  </form>
				</div>
			
		  </div>
		  
		  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
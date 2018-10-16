<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESERVAS</title>
</head>
<body>

	<h1>WELCOME TO THE MAIN PAGE ${message}</h1>
	
	<div class="container">
	
	<div>
		<ul class="nav nav-pills">
  			<li class="nav-item">
   			 <a class="nav-link active" href="#">RESERVAS</a>
  			</li>
  			<li class="nav-item">
   			 <a class="nav-link" href="#">REPORTE</a>
  			</li>
		</ul>
	</div>


	<div>
		<ul class="nav nav-pills nav-fill">
  			<li class="nav-item">
    			<a class="nav-link active" href="#">SERVICIO</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="#">FECHA</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="#">HORA</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link disabled" href="#">AGREGAR</a>
  			</li>
		</ul>
	</div>
	
	<div>
		
		<form action="./Reservas" method="POST">
			<table>
				<tr>
					<td>TIPO DE SERVICIO</td>
					<td>FECHA</td>
					<td>HORA</td>
					
				</tr>
			</table>
		</form>
		
	</div>
	
	</div>
</body>
</html>
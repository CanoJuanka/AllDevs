<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Consulta Pico y Placa</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<%
		String message = request.getParameter("message");
		String licencePlate = "";
		String date = "";
		String time = "";
		String messageCode = "";
		if (message != null) {
			licencePlate = request.getParameter("licencePlate");
			date = request.getParameter("date");
			time = request.getParameter("time");
			messageCode = request.getParameter("code");
		}
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Consultas &gt; Pico y
					Placa</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h2>Ingrese la informacion a consultar...</h2>
			<form
				action="<%=request.getContextPath()%>/pages/controllers/picoPlacaController.jsp"
				method="POST" class="navbar-form navbar-right">
				<div class="form-group">
					<input type="text" placeholder="Placa ABC-1234"
						class="form-control" name="licencePlate" value=<%=licencePlate%>>
				</div>
				<div class="form-group">
					<input type="text" placeholder="Fecha 1989-01-01"
						class="form-control" name="date" value=<%=date%>>
				</div>
				<div class="form-group">
					<input type="text" placeholder="Hora 09:00" class="form-control"
						name="time" value=<%=time%>>
				</div>
				<button type="submit" class="btn btn-primary">Consultar
					&raquo;</button>
				<a href="index.jsp" class="btn btn-info" role="button">Limpiar</a>
			</form>
		</div>
		<%
			if (message != null) {
				if (messageCode.equals("0")) {
		%>
		<div class="alert alert-success" align="center">
			<%=message%>
		</div>
		<%
			}
				if (messageCode.equals("1")) {
		%>
		<div class="alert alert-info" align="center">
			<%=message%>
		</div>
		<%
			}
				if (messageCode.equals("2")) {
		%>
		<div class="alert alert-warning" align="center">
			<%=message%>
		</div>
		<%
			}
				if (messageCode.equals("3")) {
		%>
		<div class="alert alert-danger" align="center">
			<%=message%>
		</div>
		<%
			}
			}
		%>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>Ordenanza reformatoria 001 de la Ordenanza Metropolitana
					No. 305 Art. I. 473 (4) Implementación de pico y placa.</h2>
				<p>"Los propietarios de los vehículos que se encontraren
					circulando contraviniendo los planes de restricción y de regulación
					serán sancionados a través del órgano competente del Distrito
					Metropolitano, por la comisión de la infracción administrativa, con
					una multa equivalente al 15% de una remuneración básica unificada;
					en caso de reincidencia, por segunda ocasión, con una multa
					equivalente al 25% de una remuneración básica unificada y en caso
					de reincidencia, por tercera ocasión o más, con una multa
					equivalente al 50% de una remuneración básica unificada."</p>
				<p>
					<a class="btn btn-default"
						href="http://www.amt.gob.ec/index.php/pico-placa-homepage.html"
						role="button">M&aacute;s detalles &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Calendario de Pico y Placa</h2>
				<p>No podrán circular los automotores (automotores particulares
					y motos) cuyo último dígito de la placa termine en:</p>
				<ul>
					<li>Lunes : 1 y 2.</li>
					<li>Martes : 3 y 4.</li>
					<li>Mi&eacute;rcoles: 5 y 6.</li>
					<li>Jueves : 7 y 8.</li>
					<li>Viernes : 9 y 0.</li>
				</ul>
			</div>
			<div class="col-md-4">
				<h2>Horarios de restricci&oacute;n</h2>
				<ul>
					<li>En la mañana de 7:00 a las 9:30.</li>
					<li>En la tarde de 16:00 a 19:30.</li>
				</ul>
				<h2>Excepciones</h2>
				<ul>
					<li>Vehículos conducidos por personas de la
						tercera edad. (Para esto la persona de la tercera edad debe
						encontrarse conduciendo el vehículo y portar la cedula de
						ciudadanía.)</li>
					<li>Los salvoconductos se emiten para personas
						con discapacidad para lo cual se debe iniciar el trámite previa
						acreditación del Consejo Nacional de Discapacidades (CONADIS).</li>
				</ul>
			</div>
		</div>
		<hr>
		<footer>
			<p>&copy; 2017 JCA.</p>
		</footer>
	</div>
</body>
</html>

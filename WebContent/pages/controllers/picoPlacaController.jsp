<%@page import="Repository.PicoPlacaRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<body>
	<%
		String salida;
		String licencePlate = request.getParameter("licencePlate");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		PicoPlacaRepository PyP = new PicoPlacaRepository();
		salida = PyP.checkPicoPlaca(licencePlate, date, time);
		String url = "../index.jsp?message=" + salida+"&code="+ PyP.messageCode +"&licencePlate="+ licencePlate +"&date="+ date + "&time="+ time;
		response.sendRedirect(url);
	%>
</body>
<%@page import="model.Genero"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Genero" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gêneros</title>
</head>
<body>
<h1>Todos os Gêneros</h1>

<% ArrayList<Genero> generos = (ArrayList<Genero>) request.getAttribute("genero");  %>

<table border=1>
<tr><th>Generos</th></tr>

<%
	for (Genero genero : generos) {
		out.println("<tr><td><a href='/IMDb/detalharGenero?id_genero=" + genero.getId_genero() + "&mensagem='>"
	+ genero.getTipo() + "</a></td></tr>" );
	}
%>

</table>

<a href="/IMDb/index.html">Página Anterior</a>

</body>
</html>
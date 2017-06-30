<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Filme" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Filmes</title>
</head>
<body>
<h1>Todos os filmes</h1>

<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filme");  %>

<table border=1>
<tr><th>Filmes</th></tr>

<%
	for (Filme filme : filmes) {
		out.println("<tr><td><a href='/IMDb/detalharFilme?id_filme=" + filme.getId_filme() + "&mensagem='>"
	+ filme.getTitulo() + "</a></td></tr>" );
	}
%>

</table>

<a href="/IMDb/index.html">Página Anterior</a>

</body>
</html>
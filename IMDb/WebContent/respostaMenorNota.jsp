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


<a href="/IMDb/index.html">Início(index)</a>

<h1>Ordenado por nota - menor - maior</h1><br>

<h3><a href='/IMDb/listarPorNota?id_filme='>Ordenar por nota - maior - menor</a></h3>

<% ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filme");  %>

<table border=2>
<td>Nota</td><td>Filme</td>

<% for (Filme filme : filmes) { %>
		
		<tr><td><%=filme.getNota()%></td><td><a href="/IMDb/detalharFilme?id_filme=<%=filme.getId_filme()%>">
		<%=filme.getTitulo()%></a></td></tr>

<% }%>

</table>

<a href="/IMDb/listarFilmes">Voltar</a>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Diretor" %>
<%@ page import="model.Filme" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Detalhes do Diretor</title>
		<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
		<fieldset>
		<legend><h2><strong>Informações do Diretor</strong></h2></legend>
			<% Diretor diretor = (Diretor) request.getAttribute("diretor"); 
			ArrayList<Filme> filmes = (ArrayList<Filme>) request.getAttribute("filme");%>
			
			Nome: <%= diretor.getNome() %><br>
		    Ano: <%= diretor.getAno() %><br>
		    Cidade: <%= diretor.getCidade_nasc()%> <br>
		    
		    
		    <table border=1>
<tr><th>Filmes</th></tr>

<%
	for (Filme filme : filmes) {
		out.println("<tr><td><a href='/IMDb/detalharFilme?id_filme=" + filme.getId_filme() + "&mensagem='>"
	+ filme.getTitulo() + "</a></td></tr>" );
	}
%>

</table>

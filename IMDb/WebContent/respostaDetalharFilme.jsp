<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme" %>
<%@ page import="model.Ator" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Diretor" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do Filme</title>
</head>
<body>

<%
Filme filme = (Filme) request.getAttribute("filme");
ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("ator"); 
ArrayList<Genero> genero = (ArrayList<Genero>) request.getAttribute("genero");
ArrayList<Diretor> diretores = (ArrayList<Diretor>) request.getAttribute("diretor");
%>


			Nome: <%= filme.getTitulo() %><br>
		    Título Original: <%= filme.getTitulo_ingles() %><br>
		    Ano de lançamento: <%= filme.getAno() %> <br>
			Nota: <a href="/IMDb/listarPorNota"><%= filme.getNota() %></a><br>
			Duração: <%= filme.getDuracao() %><br>
			Sinopse: <%= filme.getSinopse() %><br>
			
<td>Gênero: </td>

<%
	for (Genero g : genero) {
		out.println("<td><a href='/IMDb/detalharGenero?id_genero=" + g.getId_genero() + "&mensagem='>"
				+ g.getTipo() + "</a></td>");
	}
%><br>

<td>Diretor:<td>
<%
	for (Diretor diretor : diretores) {
		out.println("<tr><td><a href='/IMDb/detalharDiretor?id_diretor=" + diretor.getId_diretor() + "&mensagem='>"
	+ diretor.getNome() + "</a></td></tr>" );
	}
%><br>



<table border=2>
<td>Personagem</td><td>Ator</td>

<%
	for (Ator ator : atores) {
		out.println("<tr><td>" + ator.getPersonagem() + "</td><td><a href='/IMDb/detalharAtor?id_ator=" + ator.getId_ator() + "&mensagem='>"
	+ ator.getNome() + "</a></td></tr>");
	}
%>

</table>

</body>
</html>
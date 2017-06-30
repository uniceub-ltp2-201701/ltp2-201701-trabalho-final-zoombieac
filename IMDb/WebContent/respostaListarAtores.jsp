<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Atores</title>
</head>
<body>
<h1>Todos os Atores</h1>

<% ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("ator");  %>

<table border=1>
<tr><th>Atores</th></tr>

<%
	for (Ator ator : atores) {
		out.println("<tr><td><a href='/IMDb/detalharAtor?id_ator=" + ator.getId_ator() + "&mensagem='>"
	+ ator.getNome() + "</a></td></tr>" );
	}
%>

</table>

<a href="/IMDb/index.html">Página Anterior</a>

</body>
</html>
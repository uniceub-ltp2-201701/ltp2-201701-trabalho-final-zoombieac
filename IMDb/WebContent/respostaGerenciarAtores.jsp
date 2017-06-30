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

<a href="/IMDb/index.html">Início</a>

<h1>Todos os Atores</h1>

<% ArrayList<Ator> atores = (ArrayList<Ator>) request.getAttribute("ator");  %>

<table border=1>
<tr><th>Atores</th></tr>

<%for(Ator ator: atores){%>
				<tr><td>
				<a href="detalharAtor?id_ator=<%=ator.getId_ator() %>"><%=ator.getNome()%></a></td>
				<td><a href="excluirAtor?id_ator=<%=ator.getId_ator() %>">Excluir ator</a></form></tr>
				
			<% }%>


</table>

<a href="/IMDb/paginaIncluirAtor">Adicionar Ator(+)</a>

</body>
</html>
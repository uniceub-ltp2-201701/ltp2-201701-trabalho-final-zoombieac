<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Diretor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Diretores</title>
</head>
<body>

<a href="/IMDb/index.html">Início</a>

<h1>Todos os Diretores</h1>

<% ArrayList<Diretor> diretores = (ArrayList<Diretor>) request.getAttribute("diretor");  %>

<table border=1>
<td>Diretores</td>

		<%for(Diretor diretor: diretores){%>
				<tr><td>
				<a href="detalharDiretor?id_diretor=<%=diretor.getId_diretor() %>"><%=diretor.getNome()%></a></td>
				<td><a href="excluirDiretor?id_diretor=<%=diretor.getId_diretor() %>">Excluir diretor</a></form></tr>
				
			<% }%>

</table>

<a href="/IMDb/paginaIncluirDiretor">Adicionar Diretor(+)</a>

</body>
</html>
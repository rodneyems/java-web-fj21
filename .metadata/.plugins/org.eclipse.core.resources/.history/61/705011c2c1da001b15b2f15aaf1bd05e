<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List,
						br.com.caelum.agenda.dao.ContatoDao,
						br.com.caelum.agenda.modelo.Contato" %>
						
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

	<table>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
		
		<% 
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
		%>
		
		<% for(Contato contato : contatos) { %>
			<tr>
				<td><%= contato.getId() %></td>
				<td><%= contato.getNome() %></td>
				<td><%= contato.getEmail() %></td>
				<td><%= contato.getEndereco() %></td>
				<td><%= contato.getDataNascimento().getTime() %></td>
			</tr>
			
		<% } %>
	</table>

</body>
</html>
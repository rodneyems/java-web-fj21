<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
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
		
			<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"></jsp:useBean>
			
			<c:forEach	var="contato" items="${dao.lista}">
				<tr>
					<td>${ contato.id }</td>
					<td>${ contato.nome }</td>
					<td>${ contato.email }</td>
					<td>${ contato.endereco }</td>
					<td>${ contato.dataNascimento.time }</td>
				</tr>
			</c:forEach>

			
	</table>

</body>
</html>
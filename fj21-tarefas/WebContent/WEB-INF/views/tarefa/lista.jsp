<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Status</th>
			<th>Data de finalização</th>
			<th>Remover</th>
			<th>Editar</th>
		</tr>
		<c:forEach items="${ tarefas }" var="tarefa">
			<tr>
				<td>${ tarefa.id }</td>
				<td>${ tarefa.descricao }</td>

				<c:if test="${ tarefa.finalizado eq true }">
					<td>Finalizado</td>
				</c:if>

				<c:if test="${tarefa.finalizado	eq	false}">
					<td id="tarefa_${tarefa.id}"><a href="#"
						onClick="finalizaAgora(${tarefa.id})"> Finaliza agora! </a></td>
				</c:if>


				<td><fmt:formatDate value="${ tarefa.dataFinalizacao.time }"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
			</tr>
		</c:forEach>

	</table>
	<a	href="novaTarefa">Criar	nova tarefa</a>
	<a	href="logout">Sair	do	sistema</a>
	<script type="text/javascript">
		function finalizaAgora(id) {
					$.post("finalizaTarefa",	{'id'	:	id},	function() {
							//	selecionando	o	elemento	html	através	da
							//	ID	e	alterando	o	HTML	dele
							$("#tarefa_"+id).html("Finalizado");
					});
			}
	</script>
</body>
</html>
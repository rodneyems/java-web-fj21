<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="rodney" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
	<c:import url="../../cabecalho.jsp"></c:import>

	<table style="margin: auto;">
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
					<c:if test="${not empty contato.email }">
						<td> <a href="mailto:${ contato.email }">${ contato.email }</a></td>
					</c:if>
					<c:if test="${empty contato.email }">
						<td> Email não informado </td>
					</c:if>
					
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${not empty contato.email }"> --%>
<%-- 							<td> <a href="mailto:${ contato.email }">${ contato.email }</a></td> --%>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<!-- 							<td> Email não informado </td> -->
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
					<td>${ contato.endereco }</td>
					<td>
						<fmt:formatDate value="${ contato.dataNascimento.time }" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>

			
	</table>
	<rodney:minhaTag texto="qwe" id="qwe"></rodney:minhaTag>
	
	<c:import url="../../rodape.jsp"></c:import>
</body>
</html>
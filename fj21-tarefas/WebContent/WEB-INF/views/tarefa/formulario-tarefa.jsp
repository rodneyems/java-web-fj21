<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="adicionaTarefa">
		<input type="text" name="descricao" placeholder="Descri��o">
		<br/>
		<form:errors	path="tarefa.descricao" cssStyle="color:red"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>
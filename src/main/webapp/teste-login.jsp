 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Taglib necessária para acessar as funções de formatação -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Variável criada para auxiliar na identificação do locale -->
<c:set var="lang" scope="session" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>

<!-- Necessário para utilizar o i18N, informar o locale e o bundle -->
<fmt:setLocale value="${ lang }"/>
<fmt:setBundle basename="Messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>WebDep</title>
		<jsp:include page="head.jspf"/>
  	</head>
	<body>
		<h2>WebDep</h2>
		<jsp:include page="scripts.jspf"/>
		
		<h4> ${ msg } <br/></h4>
		<form action="FrontControllerServlet" method="POST">
			<fieldset>
				<legend>Autenticação</legend>
				Login: <input type="text" name="login" value="${ param.login }" /><br/>
				Senha: <input type="password" name="senha" value="${ param.senha }" /><br/>
				<input type="submit" value="Entrar" />
			</fieldset>
		</form>
	</body>
</html>
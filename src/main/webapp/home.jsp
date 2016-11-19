<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Variável criada para auxiliar na identificação do locale -->
<c:set var="lang" scope="session" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>

<!-- Necessário para utilizar o i18N, informar o locale e o bundle -->
<fmt:setLocale value="${ lang }"/>
<fmt:setBundle basename="Messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="head.jspf"/>
</head>
<body>
	<%@include file="navbar.jspf"%>
	
	Vamos começar?<br/>
	<br/>
	1 - Inicie cadastrando um sistema a monitorar - Clique aqui para cadastrar<br/>
	2 - Selecione um sistema para trabalhar<br/>
	3 - Registre uma versão do sistema<br/>
	4 - Importe manualmente os dados de logs históricos<br/>
	5 - Emita Relatórios de Perfil de Acesso e Analise os Erros no Sistema (Código HTTP)<br/>
	<br/>
	Outras ações que você pode querer realizar<br/>
	  . Cadastre usuários e atribua permissões a eles<br/>
	  . Selecione exclua dados históricos de logs<br/>	
	
	<jsp:include page="scripts.jspf"/>	
</body>
</html>
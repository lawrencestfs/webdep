<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="lang" scope="session" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}"/>
<fmt:setLocale value="${ lang }"/>
<fmt:setBundle basename="Messages" />

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="head.jspf"/>
	<title><fmt:message key="br.cefetrj.psw.user.titulo"/></title>
</head>
<body>
	<div style="padding: 5%">
		<div class="panel panel-default">
		  <div class="panel-heading"><fmt:message key="br.cefetrj.psw.user.panel" /></div>
		  <div class="panel-body">
			<div class="form-group" >
				<label><fmt:message key="br.cefetrj.psw.user.label.delete"/></label> 
				<p>${ usuario.nome }</p>
			</div>
			<form action="DeleteUser" method="POST" />
				<a href="ListUser" class="btn btn btn-default" style="margin-left: 5px;"><fmt:message key="br.cefetrj.psw.user.bt_delete_nao"/></a>
				<input type="hidden" name="id" value="${ usuario.id }">
				<input type="submit" class="btn btn btn-default" value="<fmt:message key="br.cefetrj.psw.user.bt_delete_sim"/>">
			</form>
		  </div>
		</div>
	</div>
	<jsp:include page="scripts.jspf"/>
</body>
</html>
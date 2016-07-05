<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Inicio de Sesión</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/signin.css" />" />
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-primary">
				ICAE - ERP · <i class="fa fa-file-code-o text-warning"></i> ·
			</h2>
			<hr>
			<c:if test="${error}">
				<div class="col-md-offset-3 col-md-6">
					<div class="alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
						<spring:message code="messages.login.failed" />
						<br>
						<br> <strong><spring:message
								code="messages.login.cause"/>:</strong>
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" default="messages.login.required" />
					</div>
				</div>
			</c:if>
			<div class="well col-md-offset-3 col-md-6">
				<form id="loginForm" method="post" action="j_spring_security_check"
					role="form" class="form-signin">
					<h2 class="form-signin-heading">Iniciar sesión</h2>
					<input id="j_username" name="j_username" type="text"
						class="form-control input-sm user-input" placeholder="Usuario"/>
					<input id="j_password" name="j_password" type="password"
						class="form-control input-sm password-input" placeholder="Contraseña"/>
					<div class="pull-right row link">
						<a id="resetPassword" href="<c:url value="/resetPassword/resetForm"/>" class="btn btn-link"><small>Restablecer
							contraseña</small></a>
					</div>
					<button id="buttonLogin" type="submit" class="btn btn-lg btn-primary btn-block">
						Ingresar <i class="fa fa-sign-in"></i>
					</button>
				</form>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/login/login.js" />"></script>
</body>
</html>
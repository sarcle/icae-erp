<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/signin.css" rel="stylesheet">
<!-- <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet"> -->
</head>
<body>
	<div class="container">
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
		<form class="form-signin">
			<h2 class="form-signin-heading">SISTEMA ICAE-ERP</h2>
			<label for="inputUser" class="sr-only">Usuario: </label> <input
				type="text" id="inputUser" class="form-control"
				placeholder="Usuario" required autofocus> <label
				for="inputPassword" class="sr-only">Contraseña: </label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Contraseña" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
		</form>

	</div>
	<script src="<c:url value="/resources/js/login/login.js" />"></script>
	<!-- /container -->
</body>
</html>

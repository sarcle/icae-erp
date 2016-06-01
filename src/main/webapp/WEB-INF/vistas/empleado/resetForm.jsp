<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Restablecer Contraseña</title>
<script src="<c:url value="/resources/js/empleado/empleado.js"/>"></script>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">Restablecer Contraseña <i class="fa fa-lock text-info"></i></h2>
			<blockquote>
				<p class="text-primary">Ingresa tu nombre de usuario y el correo registrado en el sistema. 
				Al presionar el botón <strong class="text-success">"Restablecer"</strong> se enviará un mensaje al correo registrado 
				con las instrucciones para restablecer la contraseña. 
				</p>
			</blockquote>
			<hr>
			<pnw:successMessage/>
			<pnw:errorMessage/>
			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<c:url var="restUrl" value="/resetPassword/sendPassword"/>
						<form:form id="resetForm" action="${restUrl}" method="post" modelAttribute="empleado" cssClass="form-horizontal" role="form">
							<div class="form-group">
								<label for="rfc" class="control-label col-lg-4 col-md-4">*Usuario: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="rfc" cssClass="form-control input-sm validate[required]" id="rfc" />
								</div>
							</div>
							<div class="form-group">
								<label for="mail" class="control-label col-lg-4 col-md-4">*E-mail: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" />
								</div>
							</div>
							<hr>
							<p class="text-center">
								<button id="send" type="submit" class="btn btn-primary">Restablecer <i class="fa fa-exchange"></i></button>
								<a id="volver" href="<c:url value="/login"/>" class="btn btn-danger">Volver <i class="fa fa-times"></i></a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
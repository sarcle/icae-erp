<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Actualizar Contraseña</title>

<script src="<c:url value="/resources/js/empleado/empleado.js"/>"></script>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">Actualiza tu Contraseña
			<span class="text-info"> - ${fn:toUpperCase(sessionScope.usuario.empleado.nombre)}</span> <i class="fa fa-user text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Es necesario actualizar la contraseña.</p>
			</blockquote>
			<hr>
			<pnw:errorMessage/>
			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
				<sec:authorize access="hasRole('ROLE_USER')">
					<c:url var="changePasswordUrl" value="/nomina/employee/changePassword"/>
						</sec:authorize>
						<form:form id="usuarioForm" action="${changePasswordUrl}" method="post" modelAttribute="usuarioForm" cssClass="form-horizontal" role="form">
							<form:hidden path="id" id="${sessionScope.usuario.id}"/>
							<div class="content">
								<h4><span class="label label-info">Cambio de Contraseña</span></h4>
							</div>
							<div class="form-group">
								<label for="txtPassword" class="control-label col-lg-4 col-md-4">Contraseña: </label>
								<div class="col-lg-7 col-md-7 has-feedback">
									<form:password path="password" cssClass="form-control input-sm validate[equals[txtConfirmarPassword]] noUpper equalsTo" id="txtPassword" />
								</div>
							</div>
							<div class="form-group">
								<label for="txtConfirmarPassword" class="control-label col-lg-4 col-md-4">Confirmar Contraseña: </label>
								<div class="col-lg-7 col-md-7 has-feedback">
									<form:password path="" cssClass="form-control input-sm validate[equals[txtPassword]] noUpper equalsTo" id="txtConfirmarPassword" />
								</div>
							</div>
							<hr>
							<p class="text-center">
								<button id="modify" type="submit" class="btn btn-primary">Actualizar <i class="fa fa-arrow-right"></i></button>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
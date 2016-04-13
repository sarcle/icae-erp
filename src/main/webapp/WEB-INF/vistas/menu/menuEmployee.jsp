<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>

<html>
<head>
<title>Menu ${applicationScope.appTitle}</title>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<sec:authorize access="hasRole('ROLE_USER')">
				<c:url var="urlpayslips" value="/nomina/employee/paySlips"/>
				<c:url var="urlupdateinfo" value="/nomina/employee/updateInfoForm"/>
			</sec:authorize>
			<h2>
				<span class="text-warning">${applicationScope.appTitle}</span>
				<span class="text-info"> - ${fn:toUpperCase(sessionScope.usuario.empleado.nombre)}</span> <i class="fa fa-user text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Seleccione una opción.</p>
			</blockquote>
			<hr>
			<pnw:successMessage/>
			<sec:authorize access="hasRole('ROLE_USER')">
				<div class="white-panel col-md-10 col-md-offset-1 text-center">
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">${applicationScope.appTitle}</h2>
							<p>
								En esta opción podrás consultar el XML y PDF de tus recibos registrados.
							</p>
							<hr>
							<p>
								<a href="${urlpayslips}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Consultar</span>
									<i class="fa fa-search text-muted"></i>
								</a>
							</p>
						</div>
					</div>
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Actualizar Datos</h2>
							<p>
								En esta opción podrás actualizar tu contraseña y dirección de correo electrónico.
							</p>
							<hr>
							<p>
								<a href="${urlupdateinfo}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Actualizar</span>
									<i class="fa fa-gears text-warning"></i>
								</a>
							</p>
						</div>
					</div>
				</div>
			</sec:authorize>
		</div>
	</div>
</body>
</html>

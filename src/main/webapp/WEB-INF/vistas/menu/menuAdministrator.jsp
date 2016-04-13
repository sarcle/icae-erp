<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Menu ${applicationScope.appTitle}</title>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<c:url var="urlpayslips" value="/nomina/admin/searchPaySlips"/>
				<c:url var="urlupload" value="/nomina/admin/uploadPaySlipsForm"/>
				<c:url var="urlemployees" value="/nomina/admin/employees"/>
				<c:url var="urlupdateinfo" value="/nomina/admin/updateInfo"/>
			</sec:authorize>
			<h2>
				<span class="text-warning">${applicationScope.appTitle}</span>
				<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Seleccione una opción</p>
			</blockquote>
			<hr>
			<pnw:successMessage/>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<div class="white-panel col-md-10 col-md-offset-1 text-center">
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Administración de Recibos</h2>
							<p>
								En esta opción podrás administrar los recibos de cada uno de los usuarios registrados.
							</p>
							<hr>
							<p>
								<a href="${urlpayslips}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Administrar</span>
									<i class="fa fa-search text-muted"></i>
								</a>
							</p>
						</div>
					</div>
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Carga de Recibos</h2>
							<p>
								En esta opción podrás cargar los recibos para cada uno de los usuarios registrados.
							</p>
							<hr>
							<p>
								<a href="${urlupload}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Cargar</span>
									<i class="fa fa-upload text-danger"></i>
								</a>
							</p>
						</div>
					</div>
				</div>
				<div class="white-panel col-md-10 col-md-offset-1 text-center">
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Módulo de Usuarios</h2>
							<p>
								En esta opción podrás dar de alta y modificar los usuarios que tendrán acceso al portal.
							</p>
							<hr>
							<p>
								<a href="${urlemployees}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Continuar</span>
									<i class="fa fa-users text-success"></i>
								</a>
							</p>
						</div>
					</div>
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Configuración del Sistema</h2>
							<p>
								En esta opción podrás modificar tu contraseña y la configuración del sistema.
							</p>
							<hr>
							<p>
								<a href="${urlupdateinfo}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Modificar</span>
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

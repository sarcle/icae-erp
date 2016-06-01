<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Módulo de Usuarios</title>
<script src="<c:url value="/resources/js/empleado/empleado.js"/>"></script>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">Alta de Usuarios
			<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Ingresa los datos del usuario a dar de alta, al registrar el usuario el RFC será dado de alta como nombre de usuario y password.</p>
			</blockquote>
			<hr>
			<pnw:errorMessage/>
			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<c:url var="saveUrl" value="/nomina/admin/saveEmployee"/>
						<form:form id="empleadoForm" action="${saveUrl}" method="post" modelAttribute="empleado" cssClass="form-horizontal" role="form">
							<form:hidden path="id"/>
							<div class="form-group">
								<label for="rfc" class="control-label col-lg-4 col-md-4">*RFC: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="rfc" cssClass="form-control input-sm validate[required, custom[rfcFisica]]" id="rfc" />
								</div>
							</div>
							<div class="form-group">
								<label for="nombre" class="control-label col-lg-4 col-md-4">*Nombre: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="nombre" cssClass="form-control input-sm validate[required]" id="nombre" />
								</div>
							</div>
							<div class="form-group">
								<label for="mail" class="control-label col-lg-4 col-md-4">*E-mail: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" />
								</div>
							</div>
							<div class="form-group">
								<label for="empresa" class="control-label col-lg-4 col-md-4">*Empresa: </label>
								<div class="col-lg-7 col-md-7">
									<form:select path="empresa.id" cssClass="validate[required] form-control input-sm" id="empresa">
										<form:option value="">- Seleccione una opción -</form:option>
										<c:forEach items="${empresas}" var="empresa">
											<form:option value="${empresa.id}">${empresa.nombre}</form:option>
								  		</c:forEach>
									</form:select>
								</div>
		  					</div>
		  					<div class="form-group">
								<label for="status" class="control-label col-lg-4 col-md-4">*Estado: </label>
								<div class="col-lg-7 col-md-7">
									<form:select path="usuario.enabled" cssClass="validate[required] form-control input-sm" id="status">
										<form:option value="">- Seleccione una opción -</form:option>
										<form:option value="true">ACTIVO</form:option>
										<form:option value="false">INACTIVO</form:option>
									</form:select>
								</div>
		  					</div>
							<hr>
							<p class="text-center">
								<button id="save" type="submit" class="btn btn-primary">Guardar <i class="fa fa-floppy-o"></i></button>
								<a id="cancelar" href="<c:url value="/nomina/admin/employees"/>" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags"%>

<html>
<head>
<title>Módulo de inventarios</title>
<script src="<c:url value="/resources/js/cliente/cliente.js"/>"></script>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">
				Alta de Clientes
				<!-- 			<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i> -->
			</h2>
			<blockquote>
				<p class="text-info">Ingresa los datos del cliente a dar de
					alta.</p>
			</blockquote>
			<blockquote>
				<p class="text-info">Ingrese los datos del nuevo cliente.</p>
			</blockquote>
			<hr>
			<pnw:errorMessage />

			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<c:url var="saveUrl" value="/facturacion/saveCliente" />
						<form:form id="clienteForm" action="${saveUrl}" method="post"
							modelAttribute="cliente" cssClass="form-horizontal" role="form">
							<form:hidden path="id" />
							<div class="form-group">
								<label for="clave" class="control-label col-lg-4 col-md-4">*Clave:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="clave"
										cssClass="form-control input-sm validate[required]" id="clave" />
								</div>
							</div>
							<div class="form-group">
								<label for="rfc" class="control-label col-lg-4 col-md-4">*RFC:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="rfc"
										cssClass="form-control input-sm validate[required, custom[rfcFisica]]"
										id="rfc" />
								</div>
							</div>
							<div class="form-group">
								<label for="nombre" class="control-label col-lg-4 col-md-4">*Nombre:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="nombre"
										cssClass="form-control input-sm validate[required] "
										id="nombre" />
								</div>
							</div>
							<div class="form-group">
								<label for="apellidoPaterno" class="control-label col-lg-4 col-md-4">*Apellido Paterno:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="apellidoPaterno"
										cssClass="form-control input-sm validate[required] "
										id="apellidoPaterno" />
								</div>
							</div>
							<div class="form-group">
								<label for="apellidoMaterno" class="control-label col-lg-4 col-md-4">*Apellido Materno:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="apellidoMaterno"
										cssClass="form-control input-sm validate[required] "
										id="apellidoMaterno" />
								</div>
							</div>
							<div class="form-group">
								<label for="calle" class="control-label col-lg-4 col-md-4">*Calle:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="calle"
										cssClass="form-control input-sm validate[required] "
										id="calle" />
								</div>
							</div>
							<div class="form-group">
								<label for="colonia" class="control-label col-lg-4 col-md-4">*Colonia:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="colonia"
										cssClass="form-control input-sm validate[required] "
										id="colonia" />
								</div>
							</div>
							<div class="form-group">
								<label for="codigoPostal"
									class="control-label col-lg-4 col-md-4">*Código Postal:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="codigoPostal"
										cssClass="form-control input-sm validate[required] "
										id="codigoPostal" />
								</div>
							</div>
							<div class="form-group">
								<label for="municipio" class="control-label col-lg-4 col-md-4">*Municipio:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="municipio"
										cssClass="form-control input-sm validate[required] "
										id="municipio" />
								</div>
							</div>
							<div class="form-group">
								<label for="estado" class="control-label col-lg-4 col-md-4">*Estado:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="estado"
										cssClass="form-control input-sm validate[required] "
										id="estado" />
								</div>
							</div>
							<div class="form-group">
								<label for="pais" class="control-label col-lg-4 col-md-4">*País:
								</label>
								<div class="col-lg-7 col-md-7">
									<form:input path="pais"
										cssClass="form-control input-sm validate[required] " id="pais" />
								</div>
							</div>
							<div class="form-group">
								<label for="pais" class="control-label col-lg-4 col-md-4">*Número
									Exterior: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="pais"
										cssClass="form-control input-sm validate[required] " id="pais" />
								</div>
							</div>
							<div class="form-group">
								<label for="pais" class="control-label col-lg-4 col-md-4">*Número
									Interior: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="pais"
										cssClass="form-control input-sm validate[required] " id="pais" />
								</div>
							</div>
							<hr>
							<p class="text-center">
								<button id="save" type="submit" class="btn btn-primary">
									Guardar <i class="fa fa-floppy-o"></i>
								</button>
								<a id="cancelar" href="<c:url value="/facturacion/clientes"/>"
									class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
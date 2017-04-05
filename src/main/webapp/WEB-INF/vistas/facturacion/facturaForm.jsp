<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags"%>
<html>
<head>
<title>Módulo de inventarios</title>
<script src="<c:url value="/resources/js/factura/factura.js"/>"></script>
<%-- <script src="<c:url value="/resources/js/hola.js"/>"></script> --%>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script
	src="<c:url value="/resources/vendor/bootstrap-confirmation.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery-1.10.2.min.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/resources/jquery/jquery.prettyLoader.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery.validationEngine.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery.validationEngine-es.js" />"></script>
<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
<script
	src="<c:url value="/resources/js/vendor/bootstrap-confirmation.js" />"></script>
<!-- Bootstrap core CSS -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/resources/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/resources/css/dashboard.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">
				Alta de Facturas
				<!-- 			<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i> -->
			</h2>
			<blockquote>
				<p class="text-info">Ingresa los datos de la factura a dar de alta.</p>
			</blockquote>
<!-- 			<blockquote> -->
<!-- 				<p class="text-info">Ingrese los datos del nuevo cliente.</p> -->
<!-- 			</blockquote> -->
			<hr>
			<pnw:errorMessage />

			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<c:url var="saveUrl" value="/facturacion/saveFactura" />
						<form:form id="facturaForm" action="${saveUrl}" method="post" modelAttribute="cliente" cssClass="form-horizontal" role="form">
							<form:hidden path="id" />
							<div class="form-group">
								<label for="clave" class="control-label col-lg-4 col-md-4">*Clave Cliente: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="factura.cliente.id" cssClass="form-control input-sm validate[required]" id="clave" />
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
								<button id="save" type="submit" class="btn btn-primary"> Guardar <i class="fa fa-floppy-o"></i>
								</button>
								<a id="cancelar" href="<c:url value="/facturacion/ventas"/>" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
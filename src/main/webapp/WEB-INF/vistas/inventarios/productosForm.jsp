<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Módulo de inventarios</title>
<%-- 	<script src="<c:url value="/resources/js/hola.js"/>"></script> --%>
	<script src="<c:url value="/resources/js/producto/producto.js"/>"></script>
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script	src="<c:url value="/resources/vendor/bootstrap-confirmation.js" />"></script>
	<script	src="<c:url value="/resources/jquery/jquery-1.10.2.min.js" />"></script>
	<script src="<c:url value="/resources/jquery/jquery.dataTables.min.js" />"></script>
	<script src="<c:url value="/resources/jquery/jquery.prettyLoader.js" />"></script>
    <script src="<c:url value="/resources/jquery/jquery.validationEngine.js" />"></script>
    <script src="<c:url value="/resources/jquery/jquery.validationEngine-es.js" />"></script>
	<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/vendor/bootstrap-confirmation.js" />"></script>
<!--  	Bootstrap core CSS  -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<!--     IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<!--     Custom styles for this template -->
    <link href="/resources/css/dashboard.css" rel="stylesheet">
<!--     Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--     [if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif] -->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<!--     HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--     [if lt IE 9]>
<!--       <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script> -->
<!--       <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> -->
<!--     <![endif]  -->
</head>
<body>

	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">Alta de Productos
<!-- 			<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i> -->
			</h2>
			<blockquote> 
			<p class="text-info">Ingresa los datos del producto a dar de alta.</p> 
		    </blockquote> 
			<blockquote>
				<p class="text-info">Ingrese los datos del nuevo producto.</p>
			</blockquote>
			<hr>
			<pnw:errorMessage/>
			
			<div class="col-md-offset-3 col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<c:url var="saveUrl" value="/inventarios/saveProducto"/>
						<form:form id="productoForm" action="${saveUrl}" method="post" modelAttribute="producto" cssClass="form-horizontal" role="form">
							<form:hidden path="id"/>
							<div class="form-group">
								<label for="clave" class="control-label col-lg-4 col-md-4">*Clave: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="clave" cssClass="form-control input-sm validate[required, maxSize[8]]" id="clave" />
								</div>
							</div>
							<div class="form-group">
								<label for="descripcion" class="control-label col-lg-4 col-md-4">*Descripción: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="descripcion" cssClass="form-control input-sm validate[required] " id="descripcion" />
								</div>
							</div>
							<div class="form-group">
								<label for="presentacion" class="control-label col-lg-4 col-md-4">*Presentación: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="presentacion" cssClass="form-control input-sm validate[required] " id="presentacion" />
								</div>
							</div>
<!-- 							<div class="form-group"> -->
<!-- 								<label for="mail" class="control-label col-lg-4 col-md-4">*Unidad: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
							<div class="form-group">
								<label for="precio" class="control-label col-lg-4 col-md-4">*Precio: </label>
								<div class="col-lg-7 col-md-7">
<%-- 								<fmt:formatNumber value="${concepto.valorUnitario}" type="currency" maxFractionDigits="6"/> --%>
									<form:input path="precio" type="currency" maxFractionDigits="2" cssClass="form-control input-sm validate[required,custom[number]] " id="precio" />
								</div>
							</div>
							<div class="form-group">
								<label for="cantMax" class="control-label col-lg-4 col-md-4">*Cantiad Máxima: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="cantMax" cssClass="form-control input-sm validate[required,custom[integer]] " id="cantMax" />
								</div>
							</div>
							<div class="form-group">
								<label for="cantMin" class="control-label col-lg-4 col-md-4">*Cantidad Mínima: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="cantMin" cssClass="form-control input-sm validate[required,custom[integer]] " id="cantMin" />
								</div>
							</div>
							<div class="form-group">
								<label for="noExistencias" class="control-label col-lg-4 col-md-4">*Existencia: </label>
								<div class="col-lg-7 col-md-7">
									<form:input path="noExistencias" cssClass="form-control input-sm validate[required,custom[integer]] " id="noExistencias" />
								</div>
							</div>
							<hr>
							<p class="text-center">
								<button id="save" type="submit" class="btn btn-primary">Guardar <i class="fa fa-floppy-o"></i></button>
								<a id="cancelar" href="<c:url value="/inventarios/productos"/>" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
							</p>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
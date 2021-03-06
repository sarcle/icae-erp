<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<link rel="shortcut icon" href="/favicon.ico">
<link rel="icon" sizes="16x16 32x32 64x64" href="/favicon.ico">
<link rel="icon" type="image/png" sizes="196x196" href="<c:url value="/resources/img/favicon/favicon-196.png"/>">
<link rel="icon" type="image/png" sizes="160x160" href="<c:url value="/resources/img/favicon/favicon-160.png"/>">
<link rel="icon" type="image/png" sizes="96x96" href="<c:url value="/resources/img/favicon/favicon-96.png"/>">
<link rel="icon" type="image/png" sizes="64x64" href="<c:url value="/resources/img/favicon/favicon-64.png"/>">
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/img/favicon/favicon-32.png"/>">
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/img/favicon/favicon-16.png"/>">
<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/img/favicon/favicon-152.png"/>">
<link rel="apple-touch-icon" sizes="144x144" href="<c:url value="/resources/img/favicon/favicon-144.png"/>">
<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/img/favicon/favicon-120.png"/>">
<link rel="apple-touch-icon" sizes="114x114" href="<c:url value="/resources/img/favicon/favicon-114.png"/>">
<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/favicon/favicon-76.png"/>">
<link rel="apple-touch-icon" sizes="72x72" href="<c:url value="/resources/img/favicon/favicon-72.png"/>">
<link rel="apple-touch-icon" href="<c:url value="/resources/img/favicon/favicon-57.png"/>">
<meta name="msapplication-TileColor" content="#FFFFFF">
<meta name="msapplication-TileImage" content="<c:url value="/resources/img/favicon/favicon-144.png"/>">
<meta name="msapplication-config" content="<c:url value="/resources/img/favicon/browserconfig.xml"/>">
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/signin.css" rel="stylesheet">
<script src="<c:url value="/resources/vendor/bootstrap.min.js" />"></script>
<%-- <script src="<c:url value="/resources/js/bootstrap.js" />"></script> --%>
<script	src="<c:url value="/resources/vendor/bootstrap-confirmation.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery-1.10.2.min.js" />"></script>
	<script
	src="<c:url value="/resources/jquery/jquery.dataTables.min.js" />"></script>

<%-- <script src="<c:url value="/resources/js/jquery/jquery.validate.js" />"></script> --%>
<script
	src="<c:url value="/resources/jquery/jquery.prettyLoader.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery.validationEngine.js" />"></script>
<script
	src="<c:url value="/resources/jquery/jquery.validationEngine-es.js" />"></script>
	
		<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/vendor/bootstrap-confirmation.js" />"></script>
<head>
<title>Usuarios Registrados</title>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2>
				<span class="text-warning">Módulo de Usuarios</span>
				<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Seleccione un usuario para editar o agrega uno nuevo.</p>
			</blockquote>
			<hr>
			<div class="row">
				<pnw:successMessage/>
			</div>
			<div class="text-center">
				<p>
					<a href="<c:url value="/nomina/admin/newEmployee"/>" class="btn btn-primary" > <i class="fa fa-plus"></i> Agregar Usuario </a>
					<a id="cancelar" href="<c:url value="/menuPage"/>" class="btn btn-danger">Volver <i class="fa fa-times"></i></a>
				</p>
			</div>
			<div class="col-md-offset-1 col-md-10">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<strong>Usuarios Registrados</strong>
					</div>
					<div class="table-responsive">
						<display:table htmlId="employees" id="employee" name="${employees}" 
 							class="table table-hover table-striped table-condensed table-search" requestURI="/nomina"> 
 							<display:column title="Id" property="id" headerClass="text-primary"/>
 							<display:column title="Id Usuario" property="usuario.id" headerClass="text-primary"/>
 							<display:column title="RFC" property="rfc" headerClass="text-primary"/>
 							<display:column title="Nombre" property="nombre" headerClass="text-primary"/>
 							<display:column title="E-mail" property="email" headerClass="text-primary"/>
 							<display:column title="Estatus" headerClass="text-primary text-center" class="text-center">
								<c:choose>
									<c:when test="${employee.usuario.enabled}">
								    	<i class="fa fa-check text-success"></i>  
								    </c:when>
									<c:otherwise>
										<i class="fa fa-times text-danger"></i>
									</c:otherwise>
								</c:choose>
 							</display:column>
 							<display:column title="Modificar" headerClass="text-primary text-center" class="text-center">
 								<a href="<c:url value="/nomina/admin/modifyEmployee/${employee.id}"/>" class="btn btn-xs btn-success"><i class="fa fa-edit"></i></a>
 							</display:column>
 						</display:table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
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
	
<!-- <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet"> -->
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
<%-- 			<sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
				<div class="white-panel col-md-10 col-md-offset-1 text-center">
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Facturación</h2>
							<p>
								En esta opción podrás consultar las ventas.
							</p>
							<hr>
							<p>
								<a href="${urlpayslips}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Ventas</span>
									<i class="fa fa-search text-muted"></i>
								</a>
							</p>
						</div>
					</div>
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Nómina</h2>
							<p>
								En esta opción podrás gestionar la nómina.
							</p>
							<hr>
							<p>
								<a href="${urlupload}" class="btn btn-default btn-lg" role="button">
									<span class="text-primary">Nomina</span>
									<i class="fa fa-upload text-danger"></i>
								</a>
							</p>
						</div>
					</div>
				</div>
				<div class="white-panel col-md-10 col-md-offset-1 text-center">
					<div class="col-md-6 text-center">
						<div class="well main-content col-md-12 text-center">
							<h2 class="text-info">Inventarios</h2>
							<p>
								En esta opción podrás llevar el control de el inventario
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
<!-- 					<div class="col-md-6 text-center"> -->
<!-- 						<div class="well main-content col-md-12 text-center"> -->
<!-- 							<h2 class="text-info">Configuración del Sistema</h2> -->
<!-- 							<p> -->
<!-- 								En esta opción podrás modificar tu contraseña y la configuración del sistema. -->
<!-- 							</p> -->
<!-- 							<hr> -->
<!-- 							<p> -->
<%-- 								<a href="${urlupdateinfo}" class="btn btn-default btn-lg" role="button"> --%>
<!-- 									<span class="text-primary">Modificar</span> -->
<!-- 									<i class="fa fa-gears text-warning"></i> -->
<!-- 								</a> -->
<!-- 							</p> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
<%-- 			</sec:authorize> --%>
		</div>
	</div>
</body>
</html>

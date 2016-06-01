<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Búsqueda de Recibos</title>
<script type="text/javascript" src="<c:url value="/resources/js/admin/empleado.js"/>"></script>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2>
				<span class="text-warning">${applicationScope.appTitle}</span>
				<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Ingresa los datos necesarios para filtrar la búsqueda.</p>
			</blockquote>
			<hr>
			<pnw:errorMessage/>
			<div class="col-md-12">
				<form:form id="recibosForm" action="#" method="GET" modelAttribute="recibo" cssClass="form-horizontal" role="form">
					<div class="form-group">
						<label for="rfc" class="col-lg-5 col-md-5 control-label">RFC: </label>
						<div class="col-lg-3 col-md-3">
							<form:input path="empleado.rfc" id="rfc" cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group">
						<label for="fechaEmision" class="col-lg-5 col-md-5 control-label">Fecha Emisión: </label>
						<div class="col-lg-3 col-md-3">
							<div class="input-group date" id="divFechaEmision" data-date="" data-date-format="dd-mm-yyyy">
								<form:input path="fechaEmision" id="fechaEmision" cssClass="form-control input-sm" />
							    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
						    </div>
						</div>
					</div>
					<div class="form-group">
						<label for="fechaPago" class="col-lg-5 col-md-5 control-label">Fecha Pago: </label>
						<div class="col-lg-3 col-md-3">
							<div class="input-group date" id="divFechaPago" data-date="" data-date-format="dd-mm-yyyy">
								<form:input path="fechaPago" id="fechaPago" cssClass="form-control input-sm" />
							    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
						    </div>
						</div>
					</div>
					<div class="form-group">
						<label for="fechaTimbrado" class="col-lg-5 col-md-5 control-label">Fecha Timbrado: </label>
						<div class="col-lg-3 col-md-3">
							<div class="input-group date" id="divFechaTimbrado" data-date="" data-date-format="dd-mm-yyyy">
								<form:input path="fechaTimbrado" id="fechaTimbrado" cssClass="form-control input-sm" />
							    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
						    </div>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<div class="centered">
							<button id="buscarRecibos" type="button" class="btn btn-primary">Buscar <i class="fa fa-search"></i></button>
							<button id="eliminarRecibos" type="button" class="btn btn-warning" data-toggle="modal" data-target="#confirmarModal" disabled="disabled">Eliminar <i class="fa fa-warning"></i></button>
							<a id="cancelar" href="<c:url value="/nomina/menuPage"/>" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
						</div>
					</div>
				</form:form>
				<div id="listPaySlipsPage">
					<jsp:include page="listPaySlipsAdmin.jsp" />
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="confirmarModal" tabindex="-1" role="dialog"
		aria-labelledby="confirmarLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span>
					</button>
					<h4 class="modal-title" id="confirmarLabel">Confirmación <i class="fa fa-warning text-warning"></i></h4>
				</div>
				<div class="modal-body">
					<p class="text-danger">
						Presione el botón <strong>Confirmar</strong> para eliminar los recibos seleccionados.
					</p>
					<p class="text-danger">
						Al confirmar no se podrá deshacer la operación.
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<button id="confirmarEliminarRecibos" type="button" class="btn btn-primary">Confirmar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
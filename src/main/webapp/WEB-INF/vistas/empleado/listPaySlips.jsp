<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html>
<head>
<title>${applicationScope.appTitle}</title>
</head>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2>
				<span class="text-warning">${applicationScope.appTitle}</span> 
				<span class="text-info"> - ${fn:toUpperCase(sessionScope.usuario.empleado.nombre)}</span> <i class="fa fa-user text-warning"></i>
			</h2>
			<blockquote>
				<p class="text-info">Selecciona un archivo para descargar el xml o pdf de tu Recibo.</p>
			</blockquote>
			<hr>
			<div class="text-center">
				<p>
					<a id="volver" href="<c:url value="/nomina/menuPage"/>" class="btn btn-danger">Volver <i class="fa fa-times"></i></a>
				</p>
			</div>
			<div class="col-md-offset-2 col-md-8">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<strong>${applicationScope.appTitle}</strong>
					</div>
					<div class="table-responsive">
						<display:table htmlId="recibos" id="recibo" name="${recibos}" 
 							class="table table-hover table-striped table-condensed table-search" requestURI="/nomina">
 							<display:column title="" headerClass="text-primary text-center" class="text-center">
 								<i class="fa fa-file-text-o"></i>
 							</display:column>
 							<display:column title="Fecha Inicial Pago" property="fechaInicialPago" headerClass="text-primary text-center" class="text-center"/>
 							<display:column title="Fecha Final Pago" property="fechaFinalPago" headerClass="text-primary text-center" class="text-center"/>
 							<display:column title="Fecha de Pago" property="fechaPago" headerClass="text-primary text-center" class="text-center"/>
 							<display:column title="XML" headerClass="text-primary text-center" class="text-center">
 								<a href="<c:url value="/nomina/employee/downloadFile/${recibo.id}/xml"/>" class="btn btn-xs btn-success" target="_blank">Descargar <i class="fa fa-file-code-o"></i></a>
 							</display:column>
 							<display:column title="PDF" headerClass="text-primary text-center" class="text-center">
 								<a href="<c:url value="/nomina/employee/downloadFile/${recibo.id}/pdf"/>" class="btn btn-xs btn-danger" target="_blank">Descargar <i class="fa fa-file-pdf-o"></i></a>
 							</display:column>
 						</display:table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
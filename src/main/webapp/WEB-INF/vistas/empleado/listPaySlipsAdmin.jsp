<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/resources/js/admin/tabla-recibos.js"/>"></script>
<c:url var="deleteRecibosUrl" value="/nomina/admin/deletePaySlips"/>
<div class="panel panel-info">
	<div class="panel-heading">
		<strong>${applicationScope.appTitle}</strong>
		<c:if test="${recibos.totalElements > 0}">
			<div class="pull-right">
				<strong class="small">Seleccionar Todos</strong> <input type="checkbox" id="selectAll">
			</div>
		</c:if>
	</div>
	<form id="formDelete" action="${deleteRecibosUrl}" method="post">
		<div class="table-responsive">
			<div class="dataTables_wrapper form-horizontal" role="grid">
				<c:if test="${recibos.totalElements > 0}">
					<div class="row">
						<div class="col-xs-5 col-sm-6">
							<div class="dataTables_length form-group">
								<div class="col-xs-12 col-sm-5 col-md-6">
									<form:select path="recibos.size" cssClass="form-control input-sm" id="recibos_length_select">
											<form:option value="5">5</form:option>
											<form:option value="10">10</form:option>
											<form:option value="25">25</form:option>
											<form:option value="50">50</form:option>
											<form:option value="100">100</form:option>
									</form:select>
								</div>
								<label class="control-label col-xs-12 col-sm-7 col-md-6" for="recibos_length_select" style="text-align: left;">Mostrar registros</label>
							</div>
						</div>
					</div>
				</c:if>
				<display:table htmlId="recibos" id="recibo" name="${recibos}"
					class="table table-hover table-striped table-condensed"
					requestURI="" >
					<display:column title="UUID" property="uuid" headerClass="text-primary text-center small" class="small" />
					<display:column title="RFC" property="empleado.rfc" headerClass="text-primary text-center small" class="text-center small" />
					<display:column title="Nombre" property="empleado.nombre" headerClass="text-primary text-center small" class="text-center small"/>
					<display:column title="Fecha Emisión" property="fechaEmision" headerClass="text-primary text-center small" class="text-center small"/>
					<display:column title="Fecha Pago" property="fechaPago" headerClass="text-primary text-center small" class="text-center small"/>
					<display:column title="Fecha Timbrado" property="fechaTimbrado"  format="{0,date,yyyy-MM-dd HH:mm:ss}" headerClass="text-primary text-center small" class="text-center small"/>
					<display:column title="XML" headerClass="text-primary text-center small" class="text-center">
						<a href="<c:url value="/nomina/admin/downloadFile/${recibo.id}/xml"/>" class="btn btn-xs btn-success" target="_blank">Descargar <i class="fa fa-file-code-o"></i></a>
					</display:column>
					<display:column title="PDF" headerClass="text-primary text-center small" class="text-center">
						<a href="<c:url value="/nomina/admin/downloadFile/${recibo.id}/pdf"/>" class="btn btn-xs btn-danger" target="_blank">Descargar <i class="fa fa-file-pdf-o"></i></a>
					</display:column>
					<display:column title="Eliminar" headerClass="text-primary text-center small" class="text-center">
						<input type="checkbox" name="reciboId" value="${recibo.id}">
					</display:column>
				</display:table>
				<c:if test="${recibos.totalElements > 0}">
					<div class="row">
						<div class="col-xs-3 col-sm-4 col-md-5">
							<div class="dataTables_info">Mostrando registros del ${(recibos.number * recibos.size) + 1} al ${(recibos.number * recibos.size) + recibos.numberOfElements} de un total de ${recibos.totalElements} registros</div>
						</div>
						<div class="col-xs-9 col-sm-8 col-md-7 text-right">
							<div class="dataTables_paginate paging_bootstrap">
								<c:if var="isFirstPage" test="${recibos.firstPage || recibos.totalPages < 2}">
								</c:if>
								<ul class="pagination pagination-sm" id="recibosPagination">
									<li class="first ${isFirstPage ? 'disabled' : ''}">
										<a href="0" title="Primero">&laquo;</a>
									</li>
									<li class="prev ${recibos.number > 0 ? '' : 'disabled' }">
										<a href="${recibos.number - 1}" title="Anterior">&lsaquo;</a>
									</li>
									<c:forEach begin="1" end="${recibos.totalPages}" var="page">
										<li class="${recibos.number + 1 == page ? 'active' : ''}">
											<a href="${page - 1}">${page}</a>
										</li>
									</c:forEach>
									<li class="next ${recibos.number + 1 < recibos.totalPages ? '' : 'disabled' }">
										<a href="${recibos.number + 1}" title="Siguiente">&rsaquo;</a>
									</li>
									<li class="last ${recibos.lastPage || recibos.totalPages < 2 ? 'disabled' : ''}">
										<a href="${recibos.totalPages - 1}" title="Último">&raquo;</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</form>
</div>

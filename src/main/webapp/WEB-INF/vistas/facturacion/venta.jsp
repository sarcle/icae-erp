<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Módulo de facturación</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<link href="/resources/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/validationEngine.jquery.css" />" />

<script src="<c:url value="/resources/js/jquery/jquery-1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.validationEngine.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.validationEngine-es.js" />"></script>



</head>
<body>

	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-warning">Alta de Facturas
			<span class="text-info"> - VENTAS	</span> <i class="fa fa-desktop text-success"></i>
			</h2>
<!-- 			<blockquote> -->
<!-- 				<p class="text-info">Ingresa los datos del usuario a dar de alta, al registrar el usuario el RFC será dado de alta como nombre de usuario y password.</p> -->
<!-- 			</blockquote> -->
			<hr>
<!-- 			<pnw:errorMessage/> -->
          <div class="col-md-offset-2 col-md-9">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="progress" id="progressBar">
				  		<div   class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
				  		</div>
					</div>
					<form id="ventasForm" role="form">
						<div class="form-group">
							<label for="cliente" class="">*Cliente: </label>
								<select data-bind="value: cliente" path="cliente.id" Class="validate[required] form-control" id="cliente">
									<option value="">- Seleccione una opción -</option>
									<c:forEach items="${clientes}" var="cliente">
										<option value="${cliente.id}">${cliente.nombre}  ${cliente.apellidoPaterno} ${cliente.apellidoMaterno} </option>
							  		</c:forEach>
								</select>
	  					</div>
						<div class="form-group">
							<label for="producto" class="">*Producto: </label>
								<select data-bind="value: producto" path="producto.id" Class="validate[required] form-control" id="producto">
									<option>- Seleccione una opción -</option>
									<c:forEach items="${productos}" var="producto">
										<option value="${producto.id}">${producto.descripcion} </option>
							  		</c:forEach>
								</select>
	  					</div>
	  					<input type="hidden" data-bind="value: descripcion">
						<div class="form-group">
							<label for="cantidad" class="control-label">*Cantidad: </label>
							<div class="">
								<input  data-bind="value: cantidad" id="cantidad" Class="validate[required,custom[onlyNumberSp],maxSize[8]] form-control"  />
							</div>
						</div>
						<div class="form-group">
							<label for="precio" class="control-label">*Precio: </label>
							<div class="">
								<input data-bind="value: precio" id="precio"  Class="validate[required, custom[number]] form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label for="subtotal" class="control-label">Subtotal </label>
							<div class="">
								<input data-bind="value: subtotal" id="subtotal" Class=" form-control" disabled/>
							</div>
						</div>
						<div class="form-group">
							<label for="iva" class="control-label">Iva </label>
							<div class="">
								<input data-bind="value: iva" id="iva" Class=" form-control" disabled/>
							</div>
						</div>
						<div class="form-group">
							<label for="total" class="control-label">Total </label>
							<div class="">
								<input data-bind="value: total" id="total" Class=" form-control" disabled/>
							</div>
						</div>
						<br>
						<button id="save" data-bind="click:agregarItem"class="btn btn-primary"> Agregar producto <i class="fa fa-floppy-o"></i>
							</button>
						<br>
						<br>
						
						<div>
							<table class="table table-responsive table-striped" id="tablaVenta">
							<thead>
							<tr>
								<th>Producto</th>
								<th>Descripción</th>
								<th>Cantidad</th>
								<th>Precio</th>
								<th>Importe</th>
								<th>Eliminar</th>									
								</tr>
							</thead> 
							<tbody data-bind="foreach: items">
								<tr class="success">
									<td data-bind="text:producto"></td>
									<td data-bind="text:descripcion"></td>
									<td data-bind="text:cantidad"></td>
									<td data-bind="text:precio"></td>
									<td data-bind="text:importe"></td>
									<td><a href="#" data-bind="click:$root.eliminarItem"><i class="fa fa-times"></i></a></td>
								</tr>
							</tbody>
							</table>
						</div>
						
						<hr>
						<p class="text-center">
						
							<button id="save"  type="submit" data-bind="click:guardar" class="btn btn-primary"> Guardar <i class="fa fa-floppy-o"></i> </button>
							<a id="cancelar" data-bind="click:cancelar" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a>
						</p>
					</form>
				</div>
			</div>
		</div>
		</div>
		</div>
			
		<script src="<c:url value="/resources/js/knockout-3.4.1.js" />"></script>
		<script src="<c:url value="/resources/js/ventas.js" />"></script>
	
</body>
</html>
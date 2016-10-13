<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="pnw" tagdir="/WEB-INF/tags" %>
<html>
<head>
<title>Módulo de facturación</title>
<script src="<c:url value="/resources/js/empleado/empleado.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
		    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

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

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">	
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td>ante</td>
                </tr>
                <tr>
                  <td>1,004</td>
                  <td>dapibus</td>
                  <td>diam</td>
                  <td>Sed</td>
                  <td>nisi</td>
                </tr>
                <tr>
                  <td>1,005</td>
                  <td>Nulla</td>
                  <td>quis</td>
                  <td>sem</td>
                  <td>at</td>
                </tr>
                <tr>
                  <td>1,006</td>
                  <td>nibh</td>
                  <td>elementum</td>
                  <td>imperdiet</td>
                  <td>Duis</td>
                </tr>
                <tr>
                  <td>1,007</td>
                  <td>sagittis</td>
                  <td>ipsum</td>
                  <td>Praesent</td>
                  <td>mauris</td>
                </tr>
                <tr>
                  <td>1,008</td>
                  <td>Fusce</td>
                  <td>nec</td>
                  <td>tellus</td>
                  <td>sed</td>
                </tr>
                <tr>
                  <td>1,009</td>
                  <td>augue</td>
                  <td>semper</td>
                  <td>porta</td>
                  <td>Mauris</td>
                </tr>
                <tr>
                  <td>1,010</td>
                  <td>massa</td>
                  <td>Vestibulum</td>
                  <td>lacinia</td>
                  <td>arcu</td>
                </tr>
                <tr>
                  <td>1,011</td>
                  <td>eget</td>
                  <td>nulla</td>
                  <td>Class</td>
                  <td>aptent</td>
                </tr>
                <tr>
                  <td>1,012</td>
                  <td>taciti</td>
                  <td>sociosqu</td>
                  <td>ad</td>
                  <td>litora</td>
                </tr>
                <tr>
                  <td>1,013</td>
                  <td>torquent</td>
                  <td>per</td>
                  <td>conubia</td>
                  <td>nostra</td>
                </tr>
                <tr>
                  <td>1,014</td>
                  <td>per</td>
                  <td>inceptos</td>
                  <td>himenaeos</td>
                  <td>Curabitur</td>
                </tr>
                <tr>
                  <td>1,015</td>
                  <td>sodales</td>
                  <td>ligula</td>
                  <td>in</td>
                  <td>libero</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!--     <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script> -->
<!--     <script src="../../dist/js/bootstrap.min.js"></script> -->
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="/resources/js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/resources/js/ie10-viewport-bug-workaround.js"></script>
<!--       <div class="row"> -->
<!--         <div class="col-sm-3 col-md-2 sidebar"> -->
<!--           <ul class="nav nav-sidebar"> -->
<!--             <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li> -->
<!--             <li><a href="#">Reports</a></li> -->
<!--             <li><a href="#">Analytics</a></li> -->
<!--             <li><a href="#">Export</a></li> -->
<!--           </ul> -->	
<!--           <ul class="nav nav-sidebar"> -->
<!--             <li><a href="">Nav item</a></li> -->
<!--             <li><a href="">Nav item again</a></li> -->
<!--             <li><a href="">One more nav</a></li> -->
<!--             <li><a href="">Another nav item</a></li> -->
<!--             <li><a href="">More navigation</a></li> -->
<!--           </ul> -->
<!--           <ul class="nav nav-sidebar"> -->
<!--             <li><a href="">Nav item again</a></li> -->
<!--             <li><a href="">One more nav</a></li> -->
<!--             <li><a href="">Another nav item</a></li> -->
<!--           </ul> -->
<!--         </div> -->
<!-- 	<div class="container main-content"> -->
<!-- 		<div class="white-panel row"> -->
<!-- 			<h2 class="text-warning">Alta de Productos -->
<!-- 			<span class="text-info"> - ADMINISTRADOR</span> <i class="fa fa-desktop text-warning"></i> -->
<!-- 			</h2> -->
<!-- <!-- 			<blockquote> --> 
<!-- <!-- 				<p class="text-info">Ingresa los datos del usuario a dar de alta, al registrar el usuario el RFC será dado de alta como nombre de usuario y password.</p> --> 
<!-- <!-- 			</blockquote> --> 
<!-- 			<blockquote> -->
<!-- 				<p class="text-info">Ingrese los datos del nuevo producto./p> -->
<!-- 			</blockquote> -->
<!-- 			<hr> -->
<%-- 			<pnw:errorMessage/> --%>
			
<!-- 			<div class="col-md-offset-3 col-md-6"> -->
<!-- 				<div class="panel panel-default"> -->
<!-- 					<div class="panel-body"> -->
<%-- 						<c:url var="saveUrl" value="/nomina/admin/saveEmployee"/> --%>
<%-- 						<form:form id="empleadoForm" action="${saveUrl}" method="post" modelAttribute="empleado" cssClass="form-horizontal" role="form"> --%>
<%-- 							<form:hidden path="id"/> --%>
<!-- 							<div class="form-group"> -->
<!-- 								<label for="rfc" class="control-label col-lg-4 col-md-4">*Clave: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="rfc" cssClass="form-control input-sm validate[required, custom[rfcFisica]]" id="rfc" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="nombre" class="control-label col-lg-4 col-md-4">*Descripción: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="nombre" cssClass="form-control input-sm validate[required]" id="nombre" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="mail" class="control-label col-lg-4 col-md-4">*Presentación: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="mail" class="control-label col-lg-4 col-md-4">*Unidad: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="mail" class="control-label col-lg-4 col-md-4">*Precio: </label> -->
<!-- 								<div class="col-lg-7 col-md-7"> -->
<%-- 									<form:input path="email" cssClass="form-control input-sm validate[required, custom[email]] noUpper" id="mail" /> --%>
<!-- 								</div> -->
<!-- 							</div> -->
							
<!-- 							<hr> -->
<!-- 							<p class="text-center"> -->
<!-- 								<button id="save" type="submit" class="btn btn-primary">Guardar <i class="fa fa-floppy-o"></i></button> -->
<%-- 								<a id="cancelar" href="<c:url value="/nomina/admin/employees"/>" class="btn btn-danger">Cancelar <i class="fa fa-times"></i></a> --%>
<!-- 							</p> -->
<%-- 						</form:form> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

</body>
</html>
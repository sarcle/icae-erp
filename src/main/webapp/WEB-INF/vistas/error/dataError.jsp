<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
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
<title>Ha ocurrido un error</title>
</head>
<body>
	<c:url var="urlMenu" value="/menuPage" />
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-danger">Ha ocurrido un error:</h2>
			<hr>
			<div class="well col-md-6 col-md-offset-3">
				<p><strong>Mensaje: </strong></p>
				<p class="text-danger wrapword">${errMsg}</p>
				<hr>
				<p class="text-center">
					<a href="${urlMenu}" class="btn btn-warning btn-lg" role="button">Regresar
						<i class="fa fa-arrow-left"></i>
					</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
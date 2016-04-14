<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<script type="text/javascript">
$(document).ready(function() {
window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(400, function(){
        $(this).remove(); 
    });
}, 4000);
});
</script>
</head>
<body>
	<div class="container">
		<c:if test="${error}">
			<div class="col-md-offset-3 col-md-6">
				<div class="alert alert-danger alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<spring:message code="messages.login.failed" />
					<br> <br> <strong><spring:message code="messages.login.cause" />:</strong>
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" default="messages.login.required" />
				</div>
			</div>
		</c:if>
		<form id="loginForm" method="post" action="j_spring_security_check"
			role="form" class="form-signin">
			<h2 class="form-signin-heading">SISTEMA ICAE-ERP</h2>
			<label for="j_username" class="sr-only">Usuario: </label> 
			<input id="j_username" name="j_username" type="text" class="form-control input-sm user-input" placeholder="Usuario" required autofocus>
		    <label for="j_password" class="sr-only">Contraseña: </label> 
		    <input id="j_password" name="j_password" type="password" class="form-control input-sm password-input" placeholder="Contraseña" required>
			<button id="buttonLogin" class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
		</form>

	</div>
	<script src="<c:url value="/resources/js/login/login.js" />"></script>
	<!-- /container -->
</body>
</html>

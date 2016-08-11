<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Fin de Sesión</title>
<body>
	<div class="container main-content">
		<div class="white-panel row">
			<h2 class="text-primary">Cierre de sesión exitoso.</h2>
			<hr>
			<div class="col-md-6 col-md-offset-3">
				<h3 class="alert alert-success text-center" role="alert">
					<i class="fa fa-check-circle-o"></i> Ha cerrado sesión correctamente.
				</h3>
				<hr>
				<br>
				<p class="text-center text-muted">
					De click <a href="<c:url value="/login" />">aquí</a> para iniciar sesión nuevamente 
					<a href="<c:url value="/login" />"><i class="fa fa-sign-in text-primary"></i></a>
				</p>
				
				<p class="text-center text-muted">
					ó
				</p>
				
				<p class="text-center text-muted">
					espere unos momentos y será redireccionado a la página de inicio.
				</p>
				<br>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			window.setTimeout(function() {
				url = "<c:url value='/login'/>";
				window.location.replace(url);
			}, 2000);
		});
	</script>
</body>
</html>
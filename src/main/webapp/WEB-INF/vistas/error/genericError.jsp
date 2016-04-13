<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>Ha ocurrido un error</title>
</head>
<body>
	<c:url var="urlMenu" value="/nomina/menuPage" />
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
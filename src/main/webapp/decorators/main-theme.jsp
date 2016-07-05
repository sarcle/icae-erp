<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>. : ICAE - <decorator:title default="Main" /> : .
</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font-awesome/css/font-awesome.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<c:url value="/resources/css/bootstrap-theme.min.css" />" /> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/portal-nomina-style.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-datatables.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/datepicker.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/validationEngine.jquery.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/prettyLoader.css" />" />

<link rel="shortcut icon" href="/favicon.ico">
<link rel="icon" sizes="16x16 32x32 64x64" href="/favicon.ico">
<link rel="icon" type="image/png" sizes="196x196" href="<c:url value="/resources/img/favicon/favicon-196.png"/>">
<link rel="icon" type="image/png" sizes="160x160" href="<c:url value="/resources/img/favicon/favicon-160.png"/>">
<link rel="icon" type="image/png" sizes="96x96" href="<c:url value="/resources/img/favicon/favicon-96.png"/>">
<link rel="icon" type="image/png" sizes="64x64" href="<c:url value="/resources/img/favicon/favicon-64.png"/>">
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/img/favicon/favicon-32.png"/>">
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/img/favicon/favicon-16.png"/>">
<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/img/favicon/favicon-152.png"/>">
<link rel="apple-touch-icon" sizes="144x144" href="<c:url value="/resources/img/favicon/favicon-144.png"/>">
<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/img/favicon/favicon-120.png"/>">
<link rel="apple-touch-icon" sizes="114x114" href="<c:url value="/resources/img/favicon/favicon-114.png"/>">
<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/img/favicon/favicon-76.png"/>">
<link rel="apple-touch-icon" sizes="72x72" href="<c:url value="/resources/img/favicon/favicon-72.png"/>">
<link rel="apple-touch-icon" href="<c:url value="/resources/img/favicon/favicon-57.png"/>">
<meta name="msapplication-TileColor" content="#FFFFFF">
<meta name="msapplication-TileImage" content="<c:url value="/resources/img/favicon/favicon-144.png"/>">
<meta name="msapplication-config" content="<c:url value="/resources/img/favicon/browserconfig.xml"/>">

<script
	src="<c:url value="/resources/js/jquery/jquery-1.10.2.min.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.dataTables.min.js" />"></script>

<%-- <script src="<c:url value="/resources/js/jquery/jquery.validate.js" />"></script> --%>
<script
	src="<c:url value="/resources/js/jquery/jquery.prettyLoader.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.validationEngine.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery/jquery.validationEngine-es.js" />"></script>

<script src="<c:url value="/resources/js/datatable/datatable.js" />"></script>

<script
	src="<c:url value="/resources/js/datepicker/bootstrap-datepicker.js" />"></script>
<script
	src="<c:url value="/resources/js/datepicker/bootstrap-datepicker.es.js" />"></script>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	
	function formatDateToString(dateToFormat) {
		var today = dateToFormat;
		var curr_date = today.getDate();
		var curr_month = today.getMonth() + 1;
		var curr_year = today.getFullYear();
		if (curr_date < 10) {
			curr_date = '0' + curr_date
		}
		if (curr_month < 10) {
			curr_month = '0' + curr_month
		}
		return curr_date + '-' + curr_month + '-' + curr_year;
	}

	function autoClosingAlert(selector, delay) {
		var alert = $(selector).alert();
		window.setTimeout(function() {
			alert.fadeOut("slow");
		}, delay);
	}

	$(function() {
		$.prettyLoader();
		autoClosingAlert("div.auto-close", 3500);

		$("a[href='#top']").click(function() {
			$("html, body").animate({
				scrollTop : 0
			}, "slow");
			return false;
		});
	});

	$(document).ready(function() {
		// fade in #back-top
		$(function() {
			$(window).scroll(function() {
				if ($(this).scrollTop() > 100) {
					$('#back-top').fadeIn();
				} else {
					$('#back-top').fadeOut();
				}
			});

			// scroll body to 0px on click
			$('#back-top a').click(function() {
				$('body,html').animate({
					scrollTop : 0
				}, 800);
				return false;
			});
		});
		
// 		var url = contextPath + "/nomina/admin/getLogoUrl?ajax=true";
// 		var isLoaded = localStorage.logoIsLoaded;
// 		if (typeof isLoaded === "undefined" || isLoaded === "false") {
// 			$.ajax({
// 				url: url,
// 				type: "GET",
// 				dataType: "json",
// 				success : function(response) {
// 					localStorage.logoIsLoaded = true;
// 					if(response.logoUrl != null && response.logoUrl !== "" ) {
// 						localStorage.logoUrl = response.logoUrl;
// 						$("#logoImg").attr('src', localStorage.logoUrl);
// 					} else  {		
// 						localStorage.logoUrl = contextPath + "/resources/img/logo_empresa.png";
// 						$("#logoImg").attr('src', localStorage.logoUrl);
// 					}
// 				},
// 				error : function() {
// 					localStorage.logoIsLoaded = true;
// 					localStorage.logoUrl = contextPath + "/resources/img/logo_empresa.png";
// 					$("#logoImg").attr('src', localStorage.logoUrl);
// 				}
// 			});
// 		}
		
// 		$("#logoImg").attr('src', localStorage.logoUrl);
	});
</script>
<script id="success-message" type="text/html">
	<div class="col-md-offset-3 col-md-6 alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
		<strong></strong> 
	</div>
</script>
<decorator:head />
</head>
<body>
	<div class="wrap">
		<!-- HEADER -->
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/nomina/menuPage" />">
						${applicationScope.appTitle} <i class="fa fa-users text-primary"></i>
					</a>
				</div>

				<c:url var="logoutUrl" value="/perform_logout" />

				<div class="collapse navbar-collapse">
					<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
						<c:set var="urlMenu" value="/nomina/menuPage" />
					</sec:authorize>
					<ul class="nav navbar-nav">
						<c:if test="${!isLoginPage}">
							<li><a href="<c:url value="${urlMenu}" />">Menú
									Principal <i class="fa fa-home"></i>
							</a></li>
						</c:if>
					</ul>
					<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
						<div class="navbar-right">
							<div class="btn-group">
								<button type="button"
									class="btn btn-warning btn-sm dropdown-toggle"
									data-toggle="dropdown">
									<i class="fa fa-user"></i> -
									<sec:authorize access="hasRole('ROLE_USER')">
										${fn:toUpperCase(sessionScope.usuario.empleado.nombre)}
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										${fn:toUpperCase(sessionScope.usuario.username)}
									</sec:authorize> 
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<c:url var="logoutUrl" value="/perform_logout" />
									<li><a href="${logoutUrl}"> <i class="fa fa-sign-out text-danger"></i>
											Cerrar sesión
									</a></li>
								</ul>
							</div>
						</div>
					</sec:authorize>
				</div>
			</div>
		</div>
		<div class="logo-header">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div id="logoDiv" class="logo">
							<a href="#">
								<c:choose>
									<c:when test="${not empty applicationScope.logoUrl}">
										<img id="logoImg" src='<c:out value="${applicationScope.logoUrl}"/>' alt="Logo">
									</c:when>
									<c:otherwise>
										<img id="logoImg" src='<c:url value="/resources/img/logo_empresa.png"/>' alt="Logo">
									</c:otherwise>
								</c:choose>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- CONTENT -->
		<div class="content">
			<decorator:body />
		</div>
	</div>
	<!-- FOOTER -->
	<div id="footer" class="footer">
		<div class="row">
			<p class="credit">
				&reg; <strong>2016 ICAE</strong>
			</p>
			<p class="credit">
				<a href="#top"><strong> Ir arriba </strong> <i
					class="fa fa-arrow-circle-o-up"></i></a>
			</p>
			<p class="credit">
				<small><strong>Creado por <em>ICAE</em></strong></small>
			</p>
		</div>
	</div>
	<p id="back-top">
		<a href="#top"><span></span>Ir arriba</a>
	</p>
	<div id="page_loader" class="page_loader"></div>
	<div id="page_loader_factura_content"
		class="page_loader_content text-center">
		<div class="row">
			<div class="panel col-md-4 col-md-offset-4">
				<h3>Generando Factura</h3>
				<p>
					Espere por favor...<i class="fa fa-clock-o"></i>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar" role="progressbar" aria-valuenow="100"
						aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>
	</div>
	<div id="page_loader_ticket_content"
		class="page_loader_content text-center">
		<div class="row">
			<div class="panel col-md-4 col-md-offset-4">
				<h3>Validando Ticket</h3>
				<p>
					Espere por favor...<i class="fa fa-clock-o"></i>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar" role="progressbar" aria-valuenow="100"
						aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/vendor/bootstrap-confirmation.js" />"></script>
	<script
		src="<c:url value="/resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js" />"></script>
	<script src="<c:url value="/resources/js/main/portal-nomina.js"/>"></script>
</body>
</html>

$(document).ready(function() {
	
	$("#recibosForm").validationEngine();
	
	var today = new Date(); 
	$("#divFechaEmision").datepicker({
		endDate: today,
		language: "es",
		todayHighlight: true,
		autoclose: true
	});

	$("#divFechaPago").datepicker({
		endDate: today,
		language: "es",
		todayHighlight: true,
		autoclose: true
	});	
	
	$("#divFechaTimbrado").datepicker({
		endDate: today,
		language: "es",
		todayHighlight: true,
		autoclose: true
	});
	
	$("#buscarRecibos").click(function() {
		$("#eliminarRecibos").attr("disabled", true);
		var rfcEmpleado = $("#rfc").val();
		var fechaEmision = $("#fechaEmision").val();
		var fechaPago = $("#fechaPago").val();
		var fechaTimbrado = $("#fechaTimbrado").val();
		
		$.ajax({
			url: contextPath + "/nomina/admin/filterPaySlips?ajax=true",
			data: {rfc: rfcEmpleado, fechaEmision: fechaEmision, fechaPago: fechaPago, fechaTimbrado: fechaTimbrado},
			type: "GET",
			success: function(response) {
				$("#listPaySlipsPage").html(response);
			}
		});
	});
});
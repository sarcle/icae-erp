$(document).ready(function() {
	//TODO OVP Terminar
//	$('#recibos').dataTable({
//		"sDom": "<'row'<'col-xs-5 col-sm-6'l><'col-xs-7 col-sm-6 text-right'f>r>t<'row'<'col-xs-3 col-sm-4 col-md-5'i><'col-xs-9 col-sm-8 col-md-7 text-right'p>>",
//		"sPaginationType" : "bootstrap",
//		"oLanguage" : {
//			"sProcessing":     "Procesando...",
//		    "sLengthMenu":     "Mostrar _MENU_ registros",
//		    "sZeroRecords":    "No se encontraron resultados",
//		    "sEmptyTable":     "Ningún dato disponible en esta tabla",
//		    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
//		    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
//		    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
//		    "sInfoPostFix":    "",
//		    "sSearch":         "Buscar:",
//		    "sUrl":            "",
//		    "sInfoThousands":  ",",
//		    "sLoadingRecords": "Cargando...",
//		    "oPaginate": {
//		        "sFirst":    "Primero",
//		        "sLast":     "Último",
//		        "sNext":     "Siguiente",
//		        "sPrevious": "Anterior"
//		    },
//		    "oAria": {
//		        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
//		        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
//		    }
//		}
//	});

	
	$("#confirmarEliminarRecibos").click(function() {
		$("#formDelete").submit();
	});

	var countChecked = function() {
		var count = $("input[name='reciboId']:checked").length;
		if (count) {
			$("#eliminarRecibos").attr("disabled", false);
		} else {
			$("#eliminarRecibos").attr("disabled", true);
		}
	};
	countChecked();

	$("input[name='reciboId']" ).on( "click", countChecked);
	
	
	$("#selectAll").on("click", function() {
		if ($(this).prop("checked")) {
			$("input[name='reciboId']" ).prop("checked", true);
		} else {
			$("input[name='reciboId']" ).prop("checked", false);
		}
		countChecked();
	});
	
	$('#recibosPagination > li.disabled > a').on('click', function(e) { 
		e.preventDefault(); 
	});
	
	$('#recibosPagination > li.active > a').on('click', function(e) { 
		e.preventDefault(); 
	});
	
	$('#recibos_length_select').change(function() {
		var sizeSelected = $('#recibos_length_select option:selected').val();
		var rfcEmpleado = $("#rfc").val();
		var fechaEmision = $("#fechaEmision").val();
		var fechaPago = $("#fechaPago").val();
		var fechaTimbrado = $("#fechaTimbrado").val();
		
		$.ajax({
			url: contextPath + "/nomina/admin/filterPaySlips?ajax=true",
			data: {page: 0, size: sizeSelected, rfc: rfcEmpleado, fechaEmision: fechaEmision, fechaPago: fechaPago, fechaTimbrado: fechaTimbrado},
			type: "GET",
			success: function(response) {
				$("#listPaySlipsPage").html(response);
			}
		});
	});
	
	$('#recibosPagination > li:not(".disabled"):not(".active") > a').on('click', function(e) {
		e.preventDefault();
		var sizeSelected = $('#recibos_length_select option:selected').val();
		var rfcEmpleado = $("#rfc").val();
		var fechaEmision = $("#fechaEmision").val();
		var fechaPago = $("#fechaPago").val();
		var fechaTimbrado = $("#fechaTimbrado").val();
		
		var pageSelected = $(this).attr("href");
		$.ajax({
			url: contextPath + "/nomina/admin/filterPaySlips?ajax=true",
			data: {page: pageSelected, size: sizeSelected, rfc: rfcEmpleado, fechaEmision: fechaEmision, fechaPago: fechaPago, fechaTimbrado: fechaTimbrado},
			type: "GET",
			success: function(response) {
				$("#listPaySlipsPage").html(response);
			}
		});
	});
});
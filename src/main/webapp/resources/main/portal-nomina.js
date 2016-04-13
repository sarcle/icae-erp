$(function() {
	function stripTrailingSlash(str) {
		if (str.substr(-1) == '/') {
			return str.substr(0, str.length - 1);
		}
		return str;
	}

	var url = window.location.pathname;
	var activePage = stripTrailingSlash(url);

	$('.nav li a').each(function() {
		var currentPage = stripTrailingSlash($(this).attr('href'));

		if (activePage == currentPage) {
			$(this).parent().addClass('active');
		}
	});
});

function removeClass(field, field2) {
	$(field).parent().removeClass("has-success has-error");
	field2.removeClass("has-success has-error");
}

function removeErrorAndAddSucces(field, field2) {
	field.removeClass("has-error");
	field.addClass("has-success");
	
	field2.removeClass("has-error");
	field2.addClass("has-success");
}

function removeSuccesAndAddError(field, field2) {
	field.removeClass("has-success");
	field.addClass("has-error");

	field2.removeClass("has-success");
	field2.addClass("has-error");
}

$(document).ready(function() {
	$(document.body).on('focusout',"input[type=text]",function(){
		if($(this).hasClass("toLower")) {
			$(this).val(function () {
				return this.value.toLowerCase();
			});
		} else if (!$(this).hasClass("noUpper")) {
			$(this).val(function () {
				return this.value.toUpperCase();
			});
		}
	});
	
	$('.table-search').dataTable({
		"sDom": "<'row'<'col-xs-5 col-sm-6'l><'col-xs-7 col-sm-6 text-right'f>r>t<'row'<'col-xs-3 col-sm-4 col-md-5'i><'col-xs-9 col-sm-8 col-md-7 text-right'p>>",
		"sPaginationType" : "bootstrap",
		"oLanguage" : {
			"sProcessing":     "Procesando...",
		    "sLengthMenu":     "Mostrar _MENU_ registros",
		    "sZeroRecords":    "No se encontraron resultados",
		    "sEmptyTable":     "Ningún dato disponible en esta tabla",
		    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
		    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
		    "sInfoPostFix":    "",
		    "sSearch":         "Buscar:",
		    "sUrl":            "",
		    "sInfoThousands":  ",",
		    "sLoadingRecords": "Cargando...",
		    "oPaginate": {
		        "sFirst":    "Primero",
		        "sLast":     "Último",
		        "sNext":     "Siguiente",
		        "sPrevious": "Anterior"
		    },
		    "oAria": {
		        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		    }
		}
	});
});
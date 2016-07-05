$(document).ready(function() {
	
	$("#clienteForm").validationEngine();
	$("#clienteCorregirForm").validationEngine();	
	
	if($("#pais option:selected").val() > 1){			
		$("#rfc").attr('readonly', true);		
	}
	
	if($("#pais0 option:selected").val() > 1){			
		$("#rfc").attr('readonly', true);		
	}
	
	$("#continuar").click(function() {
		$("#agregar").hide();
		$("input[type=text]").attr("readonly", true);
		$("input[type=radio]").attr("disabled", true);
		$("select").attr("disabled", true);
		$("#botones2").show();
		$("#botones1").hide();
		$("#tblDireccion tbody > tr").find("#delete").attr("disabled", true);
	});
	
	$("#corregir").click(function() {
		$("#agregar").show();
		$("input[type=text]").attr("readonly", false);
		$("input[type=radio]").attr("disabled", false);
		if($("#pais option:selected").val() > 1){			
			$("#rfc").attr('readonly', true);
		}
		$("select").attr("disabled", false);
		$("#botones1").show();
		$("#botones2").hide();
		$("#tblDireccion tbody > tr").find("#delete").attr("disabled", false);
		
		$(".formError").fadeOut(150, function() {
            $(this).parent('.formErrorOuter').remove();
            $(this).remove();
        });

	});
	
	$("#guardar").click(function() {
		$("select").removeAttr("disabled", false);
	});	
	
	aux = 1;
	
	/*Evento que elimina una dirección de la tabla tblDireccion para
	 * cliente corregir */
	$(document.body).on('click',"#deleteCorregir",function() {		
		$(this).parent().parent().remove();
		
		var trSize = $("#tblDireccion tbody > tr").size();
		
		$("#tblDireccion tbody > tr").each(function (index, item) {
			$(this).find("#id").attr("name", "domicilios["+ index +"].id");
			$(this).find(".calle").attr("name", "domicilios["+ index +"].calle");
			$(this).find(".calle").attr("id", "calle"+ index);
			
			$(this).find(".noExterior").attr("name", "domicilios["+ index +"].noExterior");
			$(this).find(".noExterior").attr("id", "noExterior"+ index);
			
			$(this).find(".noInterior").attr("name", "domicilios["+ index +"].noInterior");
			$(this).find(".noInterior").attr("id", "noInterior"+ index);
			
			$(this).find(".pais").attr("name", "domicilios["+ index +"].estado.pais.id");
			$(this).find(".pais").attr("id", "pais"+ index);
			$(this).find("#paisOculto").attr("name", "domicilios["+ index +"].estado.pais.id");
			
			$(this).find(".estado").attr("name", "domicilios["+ index +"].estado.id");
			$(this).find(".estado").attr("id", "estado"+ index);
			$(this).find("#estadoOculto").attr("name", "domicilios["+ index +"].estado.id");
			
			$(this).find(".municipio").attr("name", "domicilios["+ index +"].municipio");
			$(this).find(".municipio").attr("id", "municipio"+ index);
			
			$(this).find(".colonia").attr("name", "domicilios["+ index +"].colonia");
			$(this).find(".colonia").attr("id", "colonia"+ index);
			
			$(this).find(".codigoPostal").attr("name", "domicilios["+ index +"].codigoPostal");
			$(this).find(".codigoPostal").attr("id", "codigoPostal"+ index);
			
			$(this).find(".estatus").attr("name", "domicilios["+ index +"].estatus");
			$(this).find(".estatus").attr("id", "estatus"+ index);
		});
		
		if(trSize == 1) {
			$("#pais0").removeAttr("disabled");
		}
		aux --;		
	});
	
	$(document.body).on('click',"#delete",function() {		
		$(this).parent().parent().remove();
		
		var trSize = $("#tblDireccion tbody > tr").size();
		
		$("#tblDireccion tbody > tr").each(function (index, item) {
			$(this).find("#id").attr("name", "domicilios["+ index +"].id");
			$(this).find(".calle").attr("name", "domicilios["+ index +"].calle");
			$(this).find(".calle").attr("id", "calle"+ index);
			$(this).find(".noExterior").attr("name", "domicilios["+ index +"].noExterior");
			$(this).find(".noExterior").attr("id", "noExterior"+ index);
			
			$(this).find(".noInterior").attr("name", "domicilios["+ index +"].noInterior");
			$(this).find(".noInterior").attr("id", "noInterior"+ index);
			
			$(this).find(".pais").attr("name", "domicilios["+ index +"].estado.pais.id");
			$(this).find(".pais").attr("id", "pais"+ index);
			$(this).find("#paisOculto").attr("name", "domicilios["+ index +"].estado.pais.id");
			
			$(this).find(".estado").attr("name", "domicilios["+ index +"].estado.id");
			$(this).find(".estado").attr("id", "estado"+ index);
			$(this).find("#estadoOculto").attr("name", "domicilios["+ index +"].estado.id");
			
			$(this).find(".municipio").attr("name", "domicilios["+ index +"].municipio");
			$(this).find(".municipio").attr("id", "municipio"+ index);
			
			$(this).find(".colonia").attr("name", "domicilios["+ index +"].colonia");
			$(this).find(".colonia").attr("id", "colonia"+ index);
			
			$(this).find(".codigoPostal").attr("name", "domicilios["+ index +"].codigoPostal");
			$(this).find(".codigoPostal").attr("id", "codigoPostal"+ index);
			
			$(this).find(".estatus").attr("name", "domicilios["+ index +"].estatus");
			$(this).find(".estatus").attr("id", "estatus"+ index);
		});
		
		if(trSize == 1) {
			$("#pais0").removeAttr("disabled");
		}
		aux --;		
	});
	
	$(document.body).on("click", ".estatus", function() {
		
		tr = $(this).parent().parent();
		
		var chkHidden = "hdn_estatus";
		
		if($(this).is(":checked")) {
			$(tr).find('input:hidden[id='+ chkHidden + ']').val("ACTIVO");			
		} else {
			$(tr).find('input:hidden[id='+ chkHidden + ']').val("INACTIVO");
			$(this).removeAttr("checked");
		}
	});
	
	$("#agregar").click(function() {
		var opPais = "<option value=" +$("#pais0 option:selected").val()+ ">" 
			+ $("#pais0 option:selected").text() + "</option>" ;
		
		var opEstado = $("#estado0").html();
		
		if($("#clienteForm").validationEngine('validate')) {
			
			var trSize = $("#tblDireccion tbody > tr").size();						
			
			if(trSize >= 1) {
				$("#pais0").attr("disabled", true);
			}
			
			var tr = "<tr>"
			+ "<td width=\'100px\'><input id=\'calle"+ aux +"\' name=\'domicilios["+ aux +"].calle\' class=\'form-control input-xsm validate[required] calle\' type=\'text\'></td>"
			+ "<td width=\'65px\'><input id=\'noExterior"+ aux +"\' name=\'domicilios["+ aux +"].noExterior\' class=\'form-control input-xsm validate[required, integer, minSize[1]] noExterior\' type=\'text\'></td>"
			+ "<td width=\'65px\'><input id=\'noInterior"+ aux +"\' name=\'domicilios["+ aux +"].noInterior\' class=\'form-control input-xsm validate[integer] noInterior\' type=\'text\'></td>"		
			+ "<td width=\'100px\'>"
		  	+ "<select class=\'form-control-xsm validate[required] pais\' id=\'pais"+ aux +"\' name=\'domicilios["+ aux +"].estado.pais.id\'>"
	  		+ opPais
			+ "</select>"
			+ "</td>"
			+ "<td width=\'100px\'>"
//			+ "<input type=\'hidden\' name=\'domicilios["+ aux +"].estado.id\' id=\'estadoOculto\' value=\'\' class=\'estado\'/>"
		  	+ "<select class=\'form-control-xsm validate[required] estado\' id=\'estado"+ aux +"\' name=\'domicilios["+ aux +"].estado.id\'>"
	  		+ opEstado
			+ "</select>"
			+ "</td>"
			+ "<td><input id=\'municipio"+ aux +"\' name=\'domicilios["+ aux +"].municipio\' class=\'form-control input-xsm validate[required] municipio\' type=\'text\'></td>"
			+ "<td width=\'200px\'><input id=\'colonia"+ aux +"\' name=\'domicilios["+ aux +"].colonia\' class=\'form-control input-xsm validate[required] colonia\' type=\'text\'></td>"
			+ "<td width=\'70px\'><input id=\'codigoPostal"+ aux +"\' name=\'domicilios["+ aux +"].codigoPostal\' class=\'form-control input-xsm validate[required, custom[onlyNumberSp], maxSize[5], minSize[5]] codigoPostal\' type=\'text\'></td>"
	//		+ "<td><input id=\'referencia" + aux +"\' name=\'domicilios["+ aux +"].referencia\' class=\'form-control input-xsm\' type=\'text\'></td>"
	//		+ "<td><input id=\'localidad" + aux +"\' name=\'domicilios["+ aux +"].localidad\' class=\'form-control input-xsm\' type=\'text\'></td>"				
			+ "<td align=\'center\'>"
			+ "<input type=\'hidden\' value=\'ACTIVO\' name=\'domicilios[" + aux + "].estatus\' id=\'hdn_estatus\' class=\'estatus\'/>"
			+ "<input type=\'checkbox\' id=\'estatus"+ aux +"\' class=\'checkbox estatus\' checked=\'true\'/>" 
			+ "</td>"
			+ "<td><button id=\'delete\' type=\'button\' class=\'btn btn-danger btn-xs\'><i class=\'fa fa-trash-o\'></i></button></td>"
			+ "</tr>";
			
			$("#tblDireccion tbody").append(tr);
			$('option:selected', '#estado' + aux).removeAttr('selected');
			
			aux++;
		}
	});
	
$("#agregarCorregir").click(function() {
		
		var opPais = $("#pais0").html();
		var opEstado = $("#estado0").html();
		
		var idPais = $("#pais0 option:selected").val();
		
		if($("#clienteCorregirForm").validationEngine('validate')){
			
			var trSize = $("#tblDireccion tbody > tr").size();						
			
			if(trSize >= 1) {
				$("#pais0").attr("disabled", true);
				aux = trSize;
			} else {				
				aux = 0;
			}
			
			var tr = "<tr>"
			+ "<td width=\'100px\'>" 
			+ "<input id=\'calle"+ aux +"\' name=\'domicilios["+ aux +"].calle\' class=\'form-control input-xsm validate[required] calle\' type=\'text\'>"
			+ "<input id=\'id\' name=\'domicilios["+ aux +"].id\' type=\'hidden\'>"
			+ "</td>"
			+ "<td width=\'65px\'><input id=\'noExterior"+ aux +"\' name=\'domicilios["+ aux +"].noExterior\' class=\'form-control input-xsm validate[required, integer, minSize[1]] noExterior\' type=\'text\'></td>"
			+ "<td width=\'65px\'><input id=\'noInterior"+ aux +"\' name=\'domicilios["+ aux +"].noInterior\' class=\'form-control input-xsm validate[integer] noInterior\' type=\'text\'></td>"		
			+ "<td width=\'100px\'>"
			+ "<input type=\'hidden\' name=\'domicilios["+ aux +"].estado.pais.id\' id=\'paisOculto\' value=\'"+ idPais +"\'/>"
		  	+ "<select class=\'form-control-xsm validate[required] pais\' id=\'pais"+ aux +"\' name=\'domicilios["+ aux +"].estado.pais.id\'>"
	  		+ opPais
			+ "</select>"
			+ "</td>"
			+ "<td width=\'100px\'>"
			+ "<input type=\'hidden\' name=\'domicilios["+ aux +"].estado.id\' id=\'estadoOculto\' value=\'\' class=\'estado\'/>"
		  	+ "<select class=\'form-control-xsm validate[required] estado\' id=\'estado"+ aux +"\' name=\'domicilios["+ aux +"].estado.id\'>"
	  		+ opEstado
			+ "</select>"
			+ "</td>"
			+ "<td><input id=\'municipio"+ aux +"\' name=\'domicilios["+ aux +"].municipio\' class=\'form-control input-xsm validate[required] municipio\' type=\'text\'></td>"
			+ "<td width=\'200px\'><input id=\'colonia"+ aux +"\' name=\'domicilios["+ aux +"].colonia\' class=\'form-control input-xsm validate[required] colonia\' type=\'text\'></td>"
			+ "<td width=\'70px\'><input id=\'codigoPostal"+ aux +"\' name=\'domicilios["+ aux +"].codigoPostal\' class=\'form-control input-xsm validate[required, custom[onlyNumberSp], maxSize[5], minSize[5]] codigoPostal\' type=\'text\'></td>"
	//		+ "<td><input id=\'referencia\' name=\'domicilios["+ aux +"].referencia\' class=\'form-control input-xsm\' type=\'text\'></td>"
	//		+ "<td><i/resources/js/sucursal/clienteForm.jsnput id=\'localidad\' name=\'domicilios["+ aux +"].localidad\' class=\'form-control input-xsm\' type=\'text\'></td>"
			+ "<td align=\'center\'>"
			+ "<input type=\'hidden\' value=\'ACTIVO\' name=\'domicilios[" + aux + "].estatus\' id=\'hdn_estatus\' class=\'estatus\'/>"
			+ "<input type=\'checkbox\' id=\'estatus"+ aux +"\' class=\'checkbox estatus\' checked=\'true\'/>" 
			+ "</td>"
			+ "<td><button id=\'deleteCorregir\' type=\'button\' class=\'btn btn-danger btn-xs\'><i class=\'fa fa-trash-o\'></i></button></td>"
			+ "</tr>";
			
			$("#tblDireccion tbody").append(tr);
			$('option:selected', '#estado' + aux).removeAttr('selected');
			
			aux++;
		}
	});
	
	$(document.body).on("change", "#pais0", function() {
		var tr = $(this).parent().parent();
		$(this).loadEstados(this, $(tr).find("#estado0"));
	});
	
	$("#personaFisica").click(function() {
		$("input:hidden[id=tipoPersona]").val("1");
		if($("#personaMoral").is(":checked")) {
			$("#rfc").removeClass("validate[required, custom[rfcMoral]]");
			$("#personaMoral").prop('checked', false);
			$("#rfc").addClass("validate[required, custom[rfcFisica]]");
		}		
	});
	
	$("#personaMoral").click(function() {
		$("input:hidden[id=tipoPersona]").val("2");
		if($("#personaFisica").is(":checked")) {			
			$("#rfc").removeClass("validate[required, custom[rfcFisica]]");
			$("#personaFisica").prop('checked', false);
			$("#rfc").addClass("validate[required, custom[rfcMoral]]");
			var formName = $(this).closest("form").attr('id');
			if(formName === 'clienteForm') {
				$("#clienteForm").validate().element("#rfc");				
			} else {
				$("#clienteCorregirForm").validate().element("#rfc");
			}
		}
	});
	
	autoClosingAlert(".errorForm", 3500);
	autoClosingAlert("#errorMessage", 3500);	
	
});

jQuery(document).ready(function () {
	jQuery("#ventasForm").validationEngine();
	jQuery("#progressBar").hide();
	

 	jQuery("#producto").change(function () {
 		var idProducto = jQuery("#producto").val();
 		
 		$.ajax({
 			type: "POST",
 			url: "/facturacion/consultaPrecioProducto",
 			data: { id: idProducto },// parameters
			success:function(data){
				 window.vm.precio(data.precio);
				 window.vm.descripcion(data.descripcion);
			},
			error:function(jqXHR, textStatus, errorThrown){
				alert("ERROR AL BUSCAR EL PRECIO");
				console.log("error " + jqXHR + textStatus + errorThrown);
		}
 		
 		})
	});
});


function item (producto, descripcion, cantidad, precio, importe){
	var self = this;
	
	self.producto=producto;
	self.descripcion=descripcion;
	self.cantidad=cantidad;
	self.precio=precio;
	self.importe=importe;
	
}

function facturaViewModel (){
	var self = this;
	
	self.cliente=ko.observable();
	self.total=ko.observable();
	self.iva=ko.observable();
	self.subtotal=ko.observable();
	
	self.producto=ko.observable();
	self.descripcion=ko.observable();
	self.cantidad=ko.observable();
	self.precio=ko.observable();
	self.importe=ko.observable();

	
	self.items=ko.observableArray([]);
	self.agregarItem=function() { 
		if ($("#ventasForm").validationEngine('validate')) {
			self.importe(parseFloat(self.cantidad()) * parseFloat(self.precio()));
			var i=new item(self.producto(), self.descripcion(), self.cantidad(), self.precio(), self.importe());
			self.items.push(i);
			
			jQuery("#cantidad").val('');
			jQuery("#precio").val('');
			jQuery("#producto").val('');
			jQuery("#cliente").prop( "disabled", true );	
			
		}
	}
	self.guardar=function(){
		
		var tbody = $("#tablaVenta tbody");

		if (tbody.children().length == 0) {
		    alert("TABLA VACIA");
		} else {
			jQuery("#progressBar").show();
			var items=[];
			for(var item in self.items()){
				items.push({
					clave:self.items()[item].producto,
					precio:parseFloat(self.items()[item].precio),
					cantidad:parseFloat(self.items()[item].cantidad),
					importe:parseFloat(self.items()[item].importe)
				});
			}
			var venta={
					cliente:self.cliente(),
					subtotal:parseFloat(self.subtotal()),
					iva:parseFloat(self.iva()),
					total:parseFloat(self.total()),
					
					listProductos:items
			};
			console.log(venta);
			
			$.ajax({
				type:"post",
				url:"/facturacion/saveFactura",
				contentType:"application/json",
//			dataType:"json",
//			mimeType:"application/json",
				data:JSON.stringify(venta),
				xhr: function () {
	 			      var xhr = new window.XMLHttpRequest();
	 			      //Upload Progress
	 			      xhr.upload.addEventListener("progress", function (evt) {
	 			         if (evt.lengthComputable) {
	 			        var percentComplete = (evt.loaded / evt.total) * 100; $('div.progress > div.progress-bar').css({ "width": percentComplete + "%" }); } }, false);
	 			 
	 			//Download progress
	 			 xhr.addEventListener("progress", function (evt)
	 			 {
	 			 if (evt.lengthComputable)
	 			  { var percentComplete = (evt.loaded / evt.total) *100;
	 			 $("div.progress > div.progress-bar").css({ "width": percentComplete + "%" }); } },
	 			false);
	 			return xhr;
	 			},
				success:function(data){
					alert(data.codigo + " "  + data.mensaje);
					window.location="/facturacion/ventas"
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log("error " + jqXHR + textStatus + errorThrown);
				}
			});
		}
		
	}
	self.cancelar=function(){
		window.location="/facturacion/ventas"
	}
	self.eliminarItem=function(item){
		self.items.remove(item);
		if (self.items.length == 0) {
			jQuery("#cliente").prop( "disabled", false );
		}
	}
	
	self.calcularSubTotal=ko.computed(
			function(){
				var subtotal=0;
				for(var item in self.items()){
					subtotal += (parseFloat(self.items()[item].precio))*(parseFloat(self.items()[item].cantidad));
				}
				self.subtotal(subtotal);
			}
	);
	self.calcularIva=ko.computed(
			function(){
				var iva=0;
					iva = (parseFloat(self.subtotal() * 0.16));
				self.iva(iva);
			}
	);
	self.calcularTotal=ko.computed(
			function(){
				var total=0;
					total = (parseFloat(self.subtotal()) + parseFloat(self.iva()));
				self.total(total);
			}
	);
}
window.vm = new facturaViewModel();
ko.applyBindings(vm);

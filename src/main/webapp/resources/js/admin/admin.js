$(document).ready(function() {
	
	$("#usuarioForm").validationEngine();
	
	$("#configPortalForm").validationEngine();
	
	var url = contextPath + "/nomina/admin/saveConfig?ajax=true";
	
	
	$("#saveConfigBtn").on("click", function() {
		if($("#configPortalForm").validationEngine("validate")) {
			var messageSuccess = $("#success-message").html();
			$.ajax({
				url: url,
				data: {id: $("#idConfigPortal").val(), rutaCargaXml: $("#rutaCargaXml").val(), logoUrl: $("#logoUrl").val(), appTitle: $("#appTitle").val()},
				type: "post",
				dataType: "json",
				success : function(response) {
					localStorage.logoIsLoaded = false;
					$("#ajaxMessage").append(messageSuccess);
					$("#ajaxMessage strong").replaceWith("<strong>" + response.message + "</strong>");
				},
				error : function() {
					localStorage.logoIsLoaded = false;
				}
			});
		}
	});
});

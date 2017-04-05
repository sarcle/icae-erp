$(document).ready(function() {
//	alert("Cargo el alta de empleados");
	$("#empleadoForm").validationEngine();
	$("#usuarioForm").validationEngine();
	$("#resetForm").validationEngine();
	
	var passwordParent = $("#txtPassword").parent();
	var passwordConfirmParent = $("#txtConfirmarPassword").parent();

	$("#txtPassword").keyup(function() {
		if (!$(this).val() && !$("#txtConfirmarPassword").val()) {
			removeClass(this, passwordConfirmParent);
		} else if ($(this).val() === $("#txtConfirmarPassword").val()) {
			removeErrorAndAddSucces(passwordParent, passwordConfirmParent);
			$("#txtConfirmarPassword").validationEngine("hide");
		} else {
			removeSuccesAndAddError(passwordParent, passwordConfirmParent);
		}
	});

	$("#txtConfirmarPassword").keyup(function() {
		if (!$(this).val() && !$("#txtPassword").val()) {
			removeClass(this, passwordParent);
		} else if ($(this).val() === $("#txtPassword").val()) {
			removeErrorAndAddSucces(passwordParent, passwordConfirmParent);
			$("#txtPassword").validationEngine("hide");
		} else {
			removeSuccesAndAddError(passwordParent, passwordConfirmParent);
		}
	});
	
	var emailParent = $("#email").parent();
	var emailConfirmParent = $("#confirmarEmail").parent();

	$("#email").keyup(function() {
		if (!$(this).val() && !$("#confirmarEmail").val()) {
			removeClass(this, emailConfirmParent);
		} else if ($(this).val() === $("#confirmarEmail").val()) {
			removeErrorAndAddSucces(emailParent, emailConfirmParent);
			$("#confirmarEmail").validationEngine("hide");
		} else {
			removeSuccesAndAddError(emailParent, emailConfirmParent);
		}
	});

	$("#confirmarEmail").keyup(function() {
		if (!$(this).val() && !$("#email").val()) {
			removeClass(emailConfirmParent, emailParent);
		} else if ($(this).val() === $("#email").val()) {
			removeErrorAndAddSucces(emailParent, emailConfirmParent);
			$("#email").validationEngine("hide");
		} else {
			removeSuccesAndAddError(emailParent, emailConfirmParent);
		}
	});
	

});

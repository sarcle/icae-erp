<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:if test="${not empty messageError}">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3 alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<p>
				<i class="fa fa-times-circle"></i> <strong>Ha ocurrido un error:</strong>
			</p>
			<hr>
			<p>
				${messageError}
			</p>
		</div>
	</div>
</c:if>

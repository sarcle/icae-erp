<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:if test="${not empty messageSuccess}">
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3 alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<p>
				<i class="fa fa-check-circle"></i> <strong>Proceso exitoso:</strong>
			</p>
			<hr>
			<p>
				${messageSuccess}
			</p>
		</div>
	</div>
</c:if>
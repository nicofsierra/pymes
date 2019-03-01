<div class="form-group">
	<div class="col-sm-6">
		<c:if test="${not empty error}">
			<div style="margin-left: 35%;"
				class="alert alert-danger alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>${error}!</strong>
			</div>
		</c:if>
	</div>
</div>
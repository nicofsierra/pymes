<%@include file='../../includes/head.jsp'%>
<body>
	<%@include file='../../includes/header.jsp'%>
	</header>
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">Ingreso de Usuario</div>
			<div class="panel-body">
				<form:form modelAttribute="usuario" class="form-horizontal" action="login" method="POST">
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-4">
							<form:input type="email" class="form-control" id="email"
								placeholder="Enter email" name="email" path="email" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Password:</label>
						<div class="col-sm-4">
							<form:input type="password" class="form-control" id="pwd"
								placeholder="Enter password" name="pwd" path="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Enviar</button>
						</div>
					</div>
					<%@include file='../../includes/errorMensaje.jsp'%>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
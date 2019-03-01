<%@include file='../../includes/head.jsp'%>
<body>
	<header class='page-header'>
		<div class="container-fluid bg-1">
			<img src="img/logo.png" class="img-responsive"
				style="display: inline;" alt="Logo" width="80" height="80">
			<h1 class="margin" style="display: inline;">Gestion PyME</h1>
		</div>
		<nav class="navbar navbar-inverse bg-primary">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">GestionPyME</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="principal">Inicio</a></li>
					<li class="active"><a href="#">Clientes</a></li>
					<li><a href="#">Facturas</a></li>
					<li><a href="#">Salir</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">Clientes</div>
			<div class="panel-body">
				<form class="form-horizontal" action="carga-clientes" method="POST">
					<div class="form-group">
						<label class="control-label col-sm-2" for="email">Email:</label>
						<div class="col-sm-4">
							<input type="email" class="form-control" id="email"
								placeholder="Enter email" name="email">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">Password:</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="pwd"
								placeholder="Enter password" name="pwd">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Enviar</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-6">
							<c:if test="${not empty error}">
								<div style="margin-left: 35%;"
									class="alert alert-danger alert-dismissable">
									<a href="#" class="close" data-dismiss="alert"
										aria-label="close">&times;</a> <strong>${error}!</strong>
								</div>
							</c:if>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
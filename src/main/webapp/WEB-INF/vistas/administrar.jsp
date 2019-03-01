<%@include file='../../includes/head.jsp'%>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if test="${empty usuario}">
		<c:redirect url="index" />
	</c:if>
	<%@include file='../../includes/header.jsp'%>
	</header>
	<div class="panel-group">
		<nav>
			<div class="navbar navbar-default navbar-custom">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Administracion</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="logout">Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="panel panel-default">
			<div class="panel-heading">
				<p>Bienvenido, ${usuario.nombre }</p>
			</div>
			<div class="panel-body">
				<div class="row" style="margin-top: 10%;">
					<div class="col-lg-3">
						<div class="icon-center">
							<a href="productos"><span
								class="glyphicon glyphicon-download-alt" id="icono-grande"></span></a>
							<a href="productos"><span class="titulo"><h3>Productos</h3></span></a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="icon-center">
							<a href="empleados"><span class="glyphicon glyphicon-user"
								id="icono-grande"></span></a> <a href="empleados"><span
								class="titulo"><h3>Empleados</h3></span></a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="icon-center">
							<a href="direcciones"><span class="glyphicon glyphicon-road"
								id="icono-grande"></span></a> <a href="direcciones"><span
								class="titulo"><h3>Direcciones</h3></span></a>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="icon-center">
							<a href="datos-fiscales"><span
								class="glyphicon glyphicon-list-alt" id="icono-grande"></span></a> <a
								href="datos-fiscales"><span class="titulo"><h3>Datos
										Fiscales</h3></span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file='../../includes/errorMensaje.jsp'%>
	</div>
</body>
</html>


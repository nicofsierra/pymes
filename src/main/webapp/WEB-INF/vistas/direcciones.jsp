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
						<li><a href="administrar">Volver</a></li>
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
					<div class="col-lg-2">
						<div class="icon-center">
							<a href="calles"><span class="glyphicon glyphicon-road"
								id="icono-grande"></span></a> <a href="calles"><span
								class="titulo"><h3>Calles</h3></span></a>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="icon-center">
							<a href="localidades"><span
								class="glyphicon glyphicon-screenshot" id="icono-grande"></span></a>
							<a href="localidades"><span class="titulo"><h3>Localidades</h3></span></a>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="icon-center">
							<a href="partidos"><span class="glyphicon glyphicon-move"
								id="icono-grande"></span></a> <a href="partidos"><span
								class="titulo"><h3>Partidos</h3></span></a>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="icon-center">
							<a href="provincias"><span
								class="glyphicon glyphicon-picture" id="icono-grande"></span></a> <a
								href="provincias"><span class="titulo"><h3>Provincias</h3></span></a>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="icon-center">
							<a href="paises"><span class="glyphicon glyphicon-flag"
								id="icono-grande"></span></a> <a href="pais"><span
								class="titulo"><h3>Paises</h3></span></a>
						</div>
					</div>
				</div>

			</div>
		</div>
		<%@include file='../../includes/errorMensaje.jsp'%>
	</div>

</body>
</html>
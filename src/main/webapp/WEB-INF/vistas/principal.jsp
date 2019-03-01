<%@include file='../../includes/head.jsp'%>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<c:if test="${empty usuario}">
		<c:redirect url="index" />
	</c:if>
	<%@include file='../../includes/header.jsp'%>
		<br>
		<nav>
			<div class="navbar navbar-default navbar-custom">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">GestionPyME</a>
					</div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Inicio</a></li>
						<li><a href="clientes">Clientes</a></li>
						<li><a href="ventas">Ventas</a></li>
						<li><a href="facturas">Facturas</a></li>
						<li><a href="logout">Salir</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<div class="panel-group">
		<div class="panel panel-default">
			<div class="panel-heading">
				Bienvenido,
				<c:if test="${not empty usuario.nombre}"> ${usuario.nombre}.</c:if>
			</div>
		</div>
		<%@include file='../../includes/errorMensaje.jsp'%>
	</div>
</body>
</html>
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
			
			<form:form modelAtributte="localidad" method="POST" action="abm-localidades">
				<!-- HACER EL FORM  -->
				<div class="form-group">
						<label class="control-label col-sm-2" for="descripcion">Localidad: </label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="descripcion"
								placeholder="Nombre Calle" name="descripcion" path="descripcion" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="alturad">Altura desde:</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="alturad"
								placeholder="Altura desde" name="alturaDesde" path="AlturaDesde" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Enviar</button>
						</div>
					</div>
				
				</form:form>
			</div>
		</div>
		<%@include file='../../includes/errorMensaje.jsp'%>
	</div>

</body>
</html>
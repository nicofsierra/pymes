<%@include file='../../includes/head.jsp'%>
<body>
	<c:set var="usuario" value="${usuario}" scope="session" />
	<header class='page-header'>
		<div class="container-fluid bg-1">
			<img src="img/logo.png" class="img-responsive"
				style="display: inline;" alt="Logo" width="80" height="80">
			<h1 class="margin" style="display: inline;">Gestion PyME</h1>
		</div>
		<br>
		<nav>
			<div class="navbar navbar-default navbar-custom">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">GestionPyME</a>
					</div>
					<ul class="nav navbar-nav">
						<li><a href="principal">Inicio</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="clientes">Clientes<span
								class="caret"></span></a></li>
						<ul class="dropdown-menu">
							<li class="active"><a href="#">Alta Clientes</a></li>
							<li><a href="#">Modificar Clientes</a></li>
							<li><a href="#">Baja Clientes</a></li>
						</ul>
						<li><a href="#">Facturas</a></li>
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
			<div class="panel-body">
				<form:form class="form-horizontal" action="guardar-clientes"
					method="POST" modelAttribute="cliente">
					<div class="form-group">
						<label class="control-label col-sm-2" for="nombre">Nombre:</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="nombre"
								placeholder="Ingrese Nombre . . ." name="nombre" path="nombre" />
						</div>
						<label class="control-label col-sm-1" for="cuit">CUIT:</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="cuit"
								placeholder="Cuit" name="cuit" path="cuit" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="telefono">Telefono:</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="telefono"
								placeholder="Telefono" name="telefono" path="telefono" />
						</div> 
						<!-- <label class="control-label col-sm-1" for="situacion">Afip:</label>
						<div class="col-sm-4">
							<form:select class="form-control" id="situacion" name="situacion" path="situacion">
								
									<form:options items="${situacion}" itemValue="idSituacion" itemLabel="descripcion"></form:options>
							
							</form:select>
						</div>
					</div>
					<!-- <div class="form-group">
						<label class="control-label col-sm-2" for="calle">Calle:</label>
						<div class="col-sm-2">
							<select class="form-control" id="calle" name="calle">
								<c:forEach items="${calle}" var="calles">
									<option value="${calles.idCalle}"><c:out
											value="${calles.descripcion}" /></option>
								</c:forEach>
							</select>
						</div>
						<label class="control-label col-sm-1" for="altura">Altura:</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" id="altura"
								placeholder="Altura" name="altura" path="altura" />
						</div>
						<label class="control-label col-sm-1" for="localidad">Localidad:</label>
						<div class="col-sm-3">
							<select class="form-control" id="localidad" name="localidad">
								<c:forEach items="${localidad}" var="localidades">
									<option value="${localidades.idLocalidad}"><c:out
											value="${localidades.descripcion}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">CUIT:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="cuit"
								placeholder="Cuit" name="cuit" path="cuit">
						</div>-->
		
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Guardar</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
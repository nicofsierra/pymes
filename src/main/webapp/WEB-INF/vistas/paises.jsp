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

				<form:form modelAttribute="pais" method="POST" action="abm-pais">
					<div class="form-group">
						<label class="control-label col-sm-2" for="descripcion">Pais
						</label>
						<div class="col-sm-4">
							<form:input type="text" class="form-control" id="pais"
								placeholder="Nombre Pais" name="descripcion" path="descripcion" value="${pais.descripcion}"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-primary">Enviar</button>
						</div>
					</div>
				<input type="hidden" value="${pais.idPais }" name="idPais" />
				</form:form>
			</div>
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>Id</th>
							<th>Descripci&oacuten</th>
							<th>Acci&oacuten</th>
					</thead>
					<tbody>
						<c:forEach items="${paises}" var="pais">
							<tr>
								<td>${pais.idPais }</td>
								<td>${pais.descripcion }</td>
								<td>
									<a href="editar?id=${pais.idPais}&tabla=pais"><button class="btn btn-primary">Editar</button></a>
									<a href="eliminar?id=${pais.idPais}&tabla=pais"><button class="btn btn-primary">Eliminar</button></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		<%@include file='../../includes/errorMensaje.jsp'%>
		<%@include file='../../includes/ExitoMensaje.jsp'%>
	</div>


</body>
</html>
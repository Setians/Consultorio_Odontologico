<%@page import="com.sun.org.apache.xml.internal.utils.StringComparable"%>
<%@ page language="java" import="dominio.*, java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">

<link rel="stylesheet" href="css/proside-bar.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">


<link rel="stylesheet" type="text/css"
	href="DataTables/datatables.min.css" />

<link rel="stylesheet" href="css/tablaPersonalizada.css">


<!--Font-Awesome 5.0.6 -->
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css"
	rel="stylesheet">
<title>Consultorio-Obras_Sociales</title>
</head>
<body>

	<%
		String redirectURL = "./Home.jsp";
	if (session.getAttribute("Session_Ej2") == null) {

		response.sendRedirect(redirectURL);

	}

	else {
		clsUsuario User = (clsUsuario) session.getAttribute("Session_Ej2");

		if (User.getU_IdTipo() != 1) {
			response.sendRedirect(redirectURL);
		}
		if (request.getParameter("s") != null) {
			response.sendRedirect("ServletObraSocial");
		}
	%>





	<div class="page-wrapper chiller-theme toggled">
		<a id="show-sidebar" class="btn btn-sm btn-dark" href="#"
			style="z-index: 2"> <i class="fas fa-bars"></i>
		</a>
		<nav id="sidebar" class="sidebar-wrapper">
		<div class="sidebar-content">
			<div class="sidebar-brand">
				<a href="#">Menú</a>
				<div id="close-sidebar">
					<i class="fas fa-times"></i>
				</div>
			</div>
			<div class="sidebar-header">
				<div class="user-info">
					<span class="user-name"><%=User.getU_Nombre()%> <strong><%=User.getU_Apellido()%></strong>
					</span>
					<%
						clsUsuarioDao dao = new clsUsuarioDao();
					clsTipoUsuario tipo = dao.TipoUsuario_TraerPorID(User.getU_IdTipo());
					%>
					<span class="user-role"><%=tipo.getU_Detalle()%></span>
					<%
						}
					%>




					<span class="user-status"> <i class="fa fa-circle"></i> <span>Online</span>
					</span>
				</div>
			</div>
			<!-- sidebar-header  -->
			<!-- sidebar-search  -->
			<div class="sidebar-menu">
				<ul>
					<li class="header-menu"><span>General</span></li>
					<li class="sidebar"><a href="HomeAdministradorLogueado.jsp">
							<i class="far fa-address-book"></i> <span>Listar Pacientes</span>
					</a></li>
					<li class="sidebar"><a href="Consultorio-Turnos.jsp"> <i
							class="far fa-calendar-alt"></i> <span>Turnos</span>
					</a></li>
					<li class="sidebar"><a href="ServletObraSocial?"> <i
							class="fa fa-medkit"></i> <span>Obras Sociales</span>
					</a></li>
					<li class="sidebar"><a href="Consultorio-Reportes.jsp"> <i
							class="fa fa-exclamation-circle"></i> <span>Reportes</span>
					</a></li>
				</ul>
			</div>
			<!-- sidebar-menu  -->
		</div>
		<!-- sidebar-content  -->
		<div class="sidebar-footer">
			<a href="ServletUsuario?btnLogout=1" name="btnLogout"> <i
				class="fa fa-power-off"
				style="font-size: 27px; padding-top: 7px; color: #16c7ff"></i>
			</a>
		</div>
		</nav>


		<!-- sidebar-wrapper  -->
		<!--Contenido de la pagina-->
		<!--<main class="page-content">
    <!--<div class="container-fluid">-->


		<section class="home-slider owl-carousel">
		<div class="slider-item"
			style="background-image: url('images/bg_1.jpg');">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text align-items-center"
					data-scrollax-parent="true">
					<div class="col-md-6 col-sm-12 ftco-animate"
						data-scrollax=" properties: { translateY: '70%' }">
						<h1 class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
							Consultorio<span> Odontológico</span></a>
						</h1>
						<p class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">By
							Malvinas City.</p>
					</div>
				</div>
			</div>
		</div>

		<div class="slider-item"
			style="background-image: url('images/bg_2.jpg');">
			<div class="overlay"></div>
			<div class="container">
				<div class="row slider-text align-items-center"
					data-scrollax-parent="true">
					<div class="col-md-6 col-sm-12 ftco-animate"
						data-scrollax=" properties: { translateY: '70%' }">
						<h1 class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
							Consultorio<span> Odontológico</span></a>
						</h1>
						<p class="mb-4"
							data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">By
							Malvinas City.</p>
					</div>
				</div>
			</div>
		</div>
		</section>





		<section class="ftco-section ftco-services">
		<div class="container">
			<h1>Obras Sociales</h1>
			<div class="table-responsive">
				<table id="tblUsuarios"
					class="table TablaCstm  table-striped table-hover responsive ">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
							<th scope="col">Estado</th>
						</tr>
					</thead>
					<tbody>
						<%
							clsObraSocialDao ObraSocialDao = new clsObraSocialDao();
						ArrayList<clsObraSocial> ListaObras = ObraSocialDao.ObraSocial_TraerTodos();

						if (ListaObras != null) {
							for (clsObraSocial obra : ListaObras) {
								clsEstadoObraSocial EstadoObra = ObraSocialDao.EstadoObraSocial_TraerPorID(obra.getEstado());
								if (ListaObras.size()> 0){ if( obra.getId() != 1) {
						%>
						<tr>

							<td><%=obra.getId()%></td>
							<td><%=obra.getDetalle()%></td>
							<td><%=EstadoObra.getU_Detalle()%></td>

						</tr>
						<%
								}} else {
						%>
						<tr>

							<td><%=obra.getId()%></td>
							<td><%=obra.getDetalle()%></td>
							<td><%=EstadoObra.getU_Detalle()%></td>

						</tr>
						<%
							}

						}

						}
						%>

					</tbody>
				</table>
				<form method="post" action="ServletObraSocial">
					<div class="form-group">
						<a href="contact.html" class="btn btn-success" data-toggle="modal"
							data-target="#modalRequest"><span>Nueva Obra</span></a>
					</div>
				</form>


			</div>
		</div>
		</section>
		<!--</div>-->

		<!--</main>-->
		<!-- page-content" -->
	</div>
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px"> <circle
			class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4"
			stroke="#eeeeee" />
		
		<circle class="path" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="modalRequest" tabindex="-1" role="dialog"
		aria-labelledby="modalRequestLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalRequestLabel">Nueva Obra</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="ServletObraSocial">
						<div class="form-group">
							<!-- <label for="appointment_name" class="text-black">Full Name</label> -->
							<input type="text" class="form-control" name="txtNombre"
								id="appointment_name" placeholder="Nombre">
						</div>

						<div class="form-group">
							<input type="submit" value="Agregar Obra" name="btnAgregarObra"
								class="btn btn-success">
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>




	<div class="modal fade" id="ModalModificar" tabindex="-1" role="dialog"
		aria-labelledby="modalRequestLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalRequestLabel">Modificar Obra</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="ServletObraSocial" Method="post">
						<div class="form-group">
							<!-- <label for="appointment_email" class="text-black">Email</label> -->
							<input type="text" readonly class="form-control" id="txtID"
								name="txtidObra" placeholder="Contraseña">
						</div>
						<div class="form-group">
							<!-- <label for="appointment_name" class="text-black">Full Name</label> -->
							<input type="text" class="form-control" id="txtnombre"
								name="txtNombreObra" placeholder="Email">
						</div>
						<div class="form-group">
							<!-- <label for="appoin tment_name" class="text-black">Full Name</label> -->
							<select id="ddlEstado" name="ddlEstado" class="form-control">
								<%
									ArrayList<clsEstadoObraSocial> lst = ObraSocialDao.EstadoObraSocial_TraerTodos();
								for (clsEstadoObraSocial obrasocial : lst) {
								%>

								<option value="<%=obrasocial.getU_Id()%>">
									<%=obrasocial.getU_Detalle()%>
								</option>
								<%
									}
								%>

							</select>
						</div>

						<div class="form-group">
							<input type="submit" value="Aceptar" name="btnModificarObra"
								class="btn btn-primary">
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>



	<!-- page-wrapper -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/jquery.timepicker.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
	<script src="js/pro-sidebar.js"></script>

	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
	<script type="text/javascript">
		$('#tblUsuarios tbody').on('click', 'tr', function() {
			var name = $('td', this).eq(1).text();
			var id = $('td', this).eq(0).text();
			var Select = $('td', this).eq(2).text();
			$('#ModalModificar').modal("show");
			$('#txtnombre').val(name);
			$('#txtID').val(id);
			$("select#ddlEstado option").each(function() 
					{ 
						this.selected = (this.text == Select);
					});
		});

		$(document)
				.ready(
						function() {
							$('#tblUsuarios')
									.DataTable(
											{

												"language" : {
													"lengthMenu" : "Mostrar _MENU_ registros por pagina",
													"zeroRecords" : "No se encontraron registros",
													"info" : "Mostrando Pagina _PAGE_ de _PAGES_",
													"infoEmpty" : "No hay registros disponibles",
													"infoFiltered" : "(filtrado de un total de  _MAX_ registros)",
													"search" : "Buscar",
													"searchPlaceholder" : "Buscar registros",

												}

											});

							//$('#tblUsuarios_filter').addClass('input-group');
							//$('#tblUsuarios_filter').append('<div id="divIconSearch" class="input-group-append"></div>'); 
							//$('#divIconSearch').append('<span id="spanIconSearch" class="input-group-text"></span>');
							//$('#divIconSearch').append('<i class="fa fa-search aria-hidden="true"></i>'); 
						});
	</script>


</body>
</html>
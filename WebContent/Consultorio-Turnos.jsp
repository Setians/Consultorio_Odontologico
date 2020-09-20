<%@page import="com.sun.org.apache.xml.internal.utils.StringComparable"%>
<%@ page language="java" import="dominio.*, java.util.*, java.text.*,java.time.*,java.time.format.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Consultorio-Turnos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,500,600,700" rel="stylesheet">

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

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>

<link rel="stylesheet" href="css/tablaPersonalizada.css">


<!--Font-Awesome 5.0.6 -->    
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>

<% 
String	redirectURL = "./Home.jsp";
	if(session.getAttribute("Session_Ej2")== null){ 
		
			
    		response.sendRedirect(redirectURL);
	
  	}
	
    else{
    	clsUsuario User= (clsUsuario)session.getAttribute("Session_Ej2");

    	 if(User.getU_IdTipo()==3)
    	{
    		response.sendRedirect(redirectURL);
    	}
    if(request.getParameter("s")!=null)
    {
    	response.sendRedirect("ServletUsuario");
    }	  
	%>


    
  
    
    
    
    

<div class="page-wrapper chiller-theme toggled">
  <a id="show-sidebar" class="btn btn-sm btn-dark" href="#" style="z-index:2">
    <i class="fas fa-bars"></i>
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
          <span class="user-name"><%= User.getU_Nombre() %>
            <strong><%= User.getU_Apellido() %></strong>
          </span>
          <% clsUsuarioDao dao= new clsUsuarioDao(); 
           clsTipoUsuario tipo = dao.TipoUsuario_TraerPorID(User.getU_IdTipo());
          %>
          <span class="user-role"><%=tipo.getU_Detalle()%></span>
          <%} %>
          
          
          
          
          <span class="user-status">
            <i class="fa fa-circle"></i>
            <span>Online</span>
          </span>
        </div>
      </div>
      <!-- sidebar-header  -->
      <!-- sidebar-search  -->
       <div class="sidebar-menu">
        <ul>
          <li class="header-menu">
            <span>General</span>
          </li>
          <li class="sidebar">
            <a href="HomeAdministradorLogueado.jsp">
              <i class="far fa-address-book"></i>
              <span>Listar Pacientes</span>              
            </a>
          </li>
          <li class="sidebar">
            <a href="Consultorio-Turnos.jsp">
              <i class="far fa-calendar-alt"></i>
              <span>Turnos</span>
         	</a>
         	</li>
         	 <%
         	clsUsuario susuario= (clsUsuario)session.getAttribute("Session_Ej2");
         	 if(susuario.getU_IdTipo()==1)
		    	{
         		 %>
					<li class="sidebar">
		            <a href="ServletObraSocial?">
		              <i class="fa fa-medkit"></i>
		              <span>Obras Sociales</span>
		         	</a>
		         	</li>
		         	<%
		    	} %>
         	
        </ul>
      </div>
      <!-- sidebar-menu  -->
    </div>
    <!-- sidebar-content  -->
    <div class="sidebar-footer">
      <a href="ServletUsuario?btnLogout=1" name="btnLogout">
        <i class="fa fa-power-off" style="font-size:27px;padding-top: 7px;color: #16c7ff"></i>
      </a>
    </div>
  </nav>


  <!-- sidebar-wrapper  -->
  <!--Contenido de la pagina-->
  <!--<main class="page-content">
    <!--<div class="container-fluid">-->
        
        <section class="home-slider owl-carousel">
      <div class="slider-item" style="background-image: url('images/bg_1.jpg');">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center" data-scrollax-parent="true">
            <div class="col-md-6 col-sm-12 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
                <h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Consultorio<span> Odontológico</span></a></h1>
                <p class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">By Malvinas City.</p>
            </div>
          </div>
        </div>
      </div>

      <div class="slider-item" style="background-image: url('images/bg_2.jpg');">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center" data-scrollax-parent="true">
            <div class="col-md-6 col-sm-12 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
                <h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Consultorio<span> Odontológico</span></a></h1>
                <p class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">By Malvinas City.</p>
            </div>
          </div>
        </div>
      </div>
    </section>

	<%  
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	%>


      <section class="ftco-section ftco-services">
      <div class="container">
	   <h1>Turnos</h1>
        <div class="table-responsive">
          <table id="tblTurnos" class="table TablaCstm ">
            <thead>
              <tr>
                <th scope="col">turno</th>
                <th scope="col">Paciente</th>
                <th scope="col">Fecha</th>
                <th scope="col">Horario Inicio</th>
                <th scope="col">Horario Fin</th>
                <th scope="col">Diagnostico</th>
				<th scope="col">Estado</th>
              </tr>
            </thead>
            <tbody>
              <%
            clsTurnoDao TurnoDao = new clsTurnoDao();
    		ArrayList<clsTurno> ListaTurno=  TurnoDao.Turno_TraerTodos();
    		ArrayList<clsEstadoTurno> tiposTurno = TurnoDao.EstadoTurno_TraerTodos();
            	if(ListaTurno!=null)
            	{
            		for(clsTurno Usu : ListaTurno)
            		{
            			
            %>
             			 <tr> 
					
		       			<td><%= Usu.getT_Id() %></td>
		                <td><%= Usu.getT_DniUsuario() %></td>
		                <td><%= Usu.getT_fecha() %></td>
		                <td><%= Usu.getT_HoraInicio() %></td>
		                <td><%= Usu.getT_HoraFin() %></td>
		                <td><%= Usu.getT_Diagnostico() %> </td>
		                
		                <td>
		                     <%	
		                     			            			
		                    	if(tiposTurno != null) {
		            				for (clsEstadoTurno Tipo : tiposTurno){ 
		                    %> 
			            			<%
			            			if (Tipo.getU_Id()==Usu.getT_IdEstado())
			            			{
			            				%> <%=Tipo.getU_Detalle()%> <%
			            			}			            			
			            			%>
			            			
		        	    		<%
		        	            		
		            				
		                    	}
          		  				%>
                    
	                		</td>
	                			
	              		</tr>
	              <%	}
		                     }
            		
            		
            	}
            		
            	%>

            </tbody>
          </table>
          <form method="post" action="ServletTurno">
			<div class="form-group" >
				<a href="contact.html" class="btn btn-success" data-toggle="modal"
					data-target="#modalReserva"><span>Reservar Turno</span></a>
			</div>
	  		</form>
        </div>
      </div>
    </section>
    <!--</div>-->
    
    
    
    
    
    
    
    
    
    <div class="modal fade" id="modalReserva" tabindex="-1" role="dialog"
		aria-labelledby="modalRequestLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalRequestLabel">Reservar Turno</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="post" action="ServletTurno">
					
					
            <div class="form-group">
            	<select id="DNI" name="DNI" class="form-control" required>
        			<option value="" selected disabled hidden>-- Seleccione Cliente --</option>
        			<%  

        			clsUsuarioDao cliDao2 = new clsUsuarioDao();
              		ArrayList<clsUsuario> listaC2 = (ArrayList<clsUsuario>) cliDao2.Usuario_TraerClientes();
                	if(listaC2 != null) {
                    for (clsUsuario uscli : listaC2) { 
        						%> <option value="<%=uscli.getU_DNI()%>"><%=uscli.getU_DNI()+" - "+uscli.getU_Apellido()+", "+uscli.getU_Nombre() %></option> <%
        					}
                	}
					else{
   						
   							%> <option value="" selected disabled hidden>No hay usuarios cargados</option> <%
   						} %>
        
        			</select>
              		<span class="validity"></span> 
            </div>
           <div class="form-group">
	                	<div class="icon"><span class="ion-ios-calendar"></span></div>
	                  <input type="date" class="form-control" name="txtDia" id="txtDia" placeholder="Dia"  min="<%=dtf.format(localDate)%>" onchange="enable()" required>
	                  <span class="validity"></span> 
	       </div>
	       
	       
           <div class="form-group">
	                <div class="icon"><span class="ion-ios-clock"></span></div>
	                 <div class="fallbackTimePicker">
				    <div>
      				<span>
        			<select id="txtHoraInicio" name="txtHoraInicio" type="time" class="form-control" min="09:00" max="18:00" step="1200" required disabled>
        			
        			<option value="" selected disabled hidden>--:--</option>
        			<%  
        			//Element element = doc.getElementById(id);
        			//clsTurnoDao trDao = new clsTurnoDao();
        			int hr = 10;
        			for(int i=0; i<9; i++){
        				for(int j=0; j<2; j++){
        					if (j==0){

          						 // CONSULTAR SI EL HORARIO ESTA DISPONIBLE 
								String cadenaHora = Integer.toString(hr+i)+":00";
        						%> <option value="<%=cadenaHora%>"><%=cadenaHora%></option> <%
        					}
        					else{
        					
       						 // CONSULTAR SI EL HORARIO ESTA DISPONIBLE 
        						
        					%> <option value="<%=Integer.toString(hr+i)+":30"%>"><%=Integer.toString(hr+i)+":30" %></option> <%}
        				}
       				}	  %>
        
        			</select>
        			<span class="validity"></span>
      				</span>
    				</div>
  					</div>
  					</div>

						<div class="form-group">
							<input type="submit" value="Guardar Reserva" name="btnReservarDoctor"
								class="btn btn-success">
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
    
    
    
<div class="modal fade" id="ModalModificar" tabindex="-1" role="dialog" aria-labelledby="modalRegistroLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalRegistroLabel">Turno Usuario</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form action="ServletTurno" Method="post">           
          
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="hidden" class="form-control" id="Modificar_idTurno" readonly name="Modificar_idTurno" placeholder="DNI">
            </div>           
            
            <div class="form-group">
            <select id="Modificar_Paciente" name="Modificar_Paciente" class="form-control" required>
        			<option value="" selected disabled hidden>-- Seleccione Cliente --</option>
        			<%  

        			clsUsuarioDao cliDao = new clsUsuarioDao();
              		ArrayList<clsUsuario> listaC = (ArrayList<clsUsuario>) cliDao.Usuario_TraerClientes();
                	if(listaC != null) {
                    for (clsUsuario uscli : listaC) { 
        						
        						 // CONSULTAR SI EL HORARIO ESTA DISPONIBLE 
        						%> <option value="<%=uscli.getU_DNI()%>"><%=uscli.getU_DNI()+" - "+uscli.getU_Apellido()+", "+uscli.getU_Nombre() %></option> <%
        					}
                	}
					else{
   						
   					%> <option value="" selected disabled hidden>No hay turnos pendientes</option> <%
   				}
        					
       					  %>
        
        			</select>
            </div>

            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control"  id="Modificar_Fecha"   name="Modificar_Fecha" placeholder="Apellido">
            </div>
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="Modificar_Hinicio"  name="Modificar_Hinicio" placeholder="Telefono">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" id="Modificar_Diagnostico"  name="Modificar_Diagnostico" placeholder="Diagnostico">
            </div>            
            
            <% ArrayList<clsEstadoTurno> lst = TurnoDao.EstadoTurno_TraerTodos(); %>
			
			<div class="form-group">
			Estado &nbsp; &nbsp; &nbsp;
				
				<select id="Modificar_Estado" name="Modificar_Estado" class="form-control" required>
        				
        	     <% if(lst != null) {
                    for (clsEstadoTurno estado : lst) { %>
        						
        						<option id="selectEstado" value="<%=estado.getU_Id()%>" >	<%=estado.getU_Detalle()%>	</option>
        						 
        				<%	}
                	}%>
        		</select>
			</div>
                 
            <div class="form-group">
              <input type="submit" value="Guardar Cambios" name="btnModificarAdm" class="btn btn-primary">
            </div>
          </form>
        </div>
        
      </div>
    </div>
  </div>
  <!--</main>-->
  <!-- page-content" -->
</div>
      <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<!-- page-wrapper -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
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
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="js/google-map.js"></script>
    <script src="js/main.js"></script>
    <script src="js/pro-sidebar.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
        
    <script type="text/javascript">
    $('#tblTurnos tbody').on('click', 'tr', function () {
        var id = $('td', this).eq(0).text();
        var paciente = $('td', this).eq(1).text();
        var fecha = $('td', this).eq(2).text();
        var Hinicio = $('td', this).eq(3).text();
        var Hfin = $('td', this).eq(4).text();
        var diag = $('td', this).eq(5).text();
		var Select = $('td', this).eq(6).text();
		console.log(Select);
        $('#ModalModificar').modal("show");
        $('#Modificar_Paciente').val( paciente);
        $('#Modificar_idTurno').val( id);
        $('#Modificar_Fecha').val( fecha);
        $('#Modificar_Hinicio').val( Hinicio);
        $('#Modificar_Hfin').val( Hfin);
        $('#Modificar_Diagnostico').val( diag);
        $('#Modificar_Estado').filter(function() {
		    return this.text == Select; 
		}).attr('selected', true);

    });
      $(document).ready( function () {
          $('#tblTurnos').DataTable({
            "language": {
                  "lengthMenu": "Mostrar _MENU_ registros por pagina",
                  "zeroRecords": "No se encontraron registros",
                  "info": "Mostrando Pagina _PAGE_ de _PAGES_",
                  "infoEmpty": "No hay registros disponibles",
                  "infoFiltered": "(filtrado de un total de  _MAX_ registros)",
                  "search": "Buscar",
                  "searchPlaceholder" : "Buscar registros",

              } 

          });
      } );

    </script>    


<script>
function disable() {
document.getElementById("txtHoraInicio").disabled = true;
}
function enable() {
document.getElementById("txtHoraInicio").disabled = false;

request.setAttribute("ListaUsuarios", document.getElementById("txtDia").value);

}


</script>
    
</body>
</html>
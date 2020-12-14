<%@page import="com.sun.org.apache.xml.internal.utils.StringComparable"%>
<%@ page language="java" import="dominio.*, java.util.*, java.text.*,java.time.*,java.time.format.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultorio</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
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

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
  <% if(session.getAttribute("Session_Ej2")!= null){
		clsUsuario User= (clsUsuario)session.getAttribute("Session_Ej2");
		String redirectURL ="";
		if (User.getU_IdTipo()!=3)
		{

			redirectURL = "./Home.jsp";
			response.sendRedirect(redirectURL);    
		}
		else{
		
	%>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
          <a class="navbar-brand" href="HomeUsuarioLogueado.jsp">Con<span>sultorio</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        
	          <li class="nav-item cta"><a href="ServletUsuario?btnLogout=1" name="btnLogout" class="nav-link"><span>Salir</span></a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

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
  

    <section class="ftco-intro">
    	<div class="container" id="cont_us">
    		<div class="row no-gutters">
    			<div class="col-md-3 color-1 p-4" >
    				<h3 class="mb-4">Datos del Usuario</h3>
    				
    				
    				
    				
    				<form action="ServletUsuario" method="post" class="appointment-form">
            <div class="form-group">
              <input type="text" class="form-control" id="DNI" placeholder="DNI" value="<%=User.getU_DNI()%>" readonly>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" id="ApNom" value="<%= User.getU_Apellido()+", "+User.getU_Nombre()%> "placeholder="Apellido y Nombre" readonly>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" id="Telefono" value ="<%= User.getU_Telefono()%> "placeholder="Telefono" readonly>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" id="Email" value ="<%= User.getU_Email()%> "placeholder="Email" readonly>
            </div>
            <div class="form-group">
            <%
    			clsObraSocialDao os = new clsObraSocialDao(); 
            clsObraSocial estado= os.TraerObraSocial(User.getU_IdObraSocial());
            %>
              <input type="text" class="form-control" id="ObraSoc" value ="<%=estado.getDetalle()%>" placeholder="Obra Social" readonly>
            </div>
            <!--  
                <div class="form-group">
                  <div class="select-wrap">
                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                    <select id="Registro_obra" name="Registro_obra" class="form-control" > 
                     <%
            		 ArrayList<clsObraSocial> lista = (ArrayList<clsObraSocial>) os.ObraSocial_TraerTodos();
            		if(lista != null) 
            		for (clsObraSocial obrasocial : lista) { 
		            	%>
		            	<option value="<%=obrasocial.getId() %>"
			            			<%
			            			if (obrasocial.getId()==User.getU_IdObraSocial())
			            			{
			            				%> selected="selected" <%
			            			}			            			
			            			%>
			            			  style="color:black !important ;"> <%=obrasocial.getDetalle()%> </option> 
            	    	<%} 
            		else { %>
    	    		<option value="1" >Sin Obra social</option> 
    	    	<%}
          		  %>
                    
                    </select>
                  </div>
                </div> -->
            <div class="form-group">
              <a href="contact.html" class="btn btn-success" data-toggle="modal" data-target="#ModalModificar"><span>Modificar Datos</span></a> 
            </div>
          </form>
    			</div>
    			
    			
            <%
            }
		}
		%>
    			
    			
    			<div class="col-md-3 color-2 p-4">
    				<h3 class="mb-4">Horario de Apertura</h3>
    				<p class="openinghours d-flex">
    					<span>Lunes - Domingos</span>
    					<span>10:00 - 19:00</span>
    				</p>
            
            
            
            
            
            
            
            <h3 class="mb-4">Siguiente Turno</h3>

			<form action="ServletTurno" method="post" class="appointment-form">
    				
	            <div class="row">
	            </div>
	            <div class="row">
	              <div class="col-sm-10">   
	              
	                <div class="form-group">
	                <div class="icon"><span class="ion-ios-clock"></span></div>
	                 <div class="fallbackTimePicker">
				    <div>
      				<span>
        			<select id="txtIDTurno" name="txtIDTurno" class="form-control" min="09:00" max="18:00" step="1200" required>
        			<option value="" selected disabled hidden>-- Seleccione --</option>
        			<%  

        			clsUsuario usturno= (clsUsuario)session.getAttribute("Session_Ej2");
        			clsTurnoDao tDao = new clsTurnoDao();
        			boolean turnoPendiente = false;
              		ArrayList<clsTurno> listaT = (ArrayList<clsTurno>) tDao.Turno_TraerPorDNI_Pendientes(usturno.getU_DNI());
                	if(listaT != null) {
                    for (clsTurno turno : listaT) { 
        						
                    			turnoPendiente = true;
        						 // CONSULTAR SI EL HORARIO ESTA DISPONIBLE 
        						%> <option value="<%=turno.getT_Id()%>"><%=turno.getT_fecha()+" - "+turno.getT_HoraInicio()%></option> <%
        					}
                    
                	
                	}
					else{
   						
   					%> <option value="" selected disabled hidden>No hay turnos pendientes</option> <%
   				}
        					
       					  %>
        
        			</select>
        			<span class="validity"></span>
      				</span>
    				</div>
  					</div>
  					</div>
	              
	              </div>
	            </div>
	            
	            <div class="form-group">
	              <input type="submit" value="Cancelar Turno" name="btnCancelarTurno" class="btn btn-primary">
	            </div>
	          </form>
			
    			</div>
    			
    			
    			<%
			            			if (!turnoPendiente)
			            			{
			            				%>
    			
    			<div class="col-md-6 color-3 p-4" id = "reservaTurno">
    				<h3 class="mb-2">Reservar un Turno</h3>
    				<form action="ServletTurno" method="post" class="appointment-form">
    				
    				<% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate localDate = LocalDate.now();
						%>
    				
	            <div class="row">
	            </div>
	            <div class="row">
	              <div class="col-sm-6">
	                <div class="form-group">
	                	<div class="icon"><span class="ion-ios-calendar"></span></div>
	                	
	                  <input type="date" class="form-control" name="txtDia" id="txtDia" placeholder="Fecha"  min="<%=dtf.format(localDate)%>" onchange="enable()" required>
	                  <span class="validity"></span> 
	                </div>
	              </div>
	              <div class="col-sm-6">   
	              
	                <div class="form-group">
	                <div class="icon"><span class="ion-ios-clock"></span></div>
	                 <div class="fallbackTimePicker">
				    <div>
      				<span>
      				<div id="txtHoraInicio"><div>
        			
      				</span>
    				</div>
  					</div>
  					</div>
	              
	              </div>
	            </div>
	            
	            <div class="form-group">
	              <input type="submit" name="btnReservar" value="Reservar un Turno" class="btn btn-primary">
	            </div>
	          </form>
    			</div>
    			<% } %>
    		</div>
    	</div>
    </section>
  


    

    


    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <!-- Modal -->
<div class="modal fade" id="ModalModificar" tabindex="-1" role="dialog" aria-labelledby="modalRegistroLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalRegistroLabel">Modificar Usuario</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        <%
		clsUsuario User= (clsUsuario)session.getAttribute("Session_Ej2");
		String redirectURL ="";
		if (User.getU_IdTipo()!=3)
		{

			redirectURL = "./Home.jsp";
			response.sendRedirect(redirectURL);    
		} %>
         
          <form action="ServletUsuario" Method="post">
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="Modificar_DNI" value="<%=User.getU_DNI() %>" readonly name="Modificar_DNI" placeholder="DNI" required>
            <span class="validity"></span> 
            </div>            
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control"  id="Modificar_nombre" value="<%= User.getU_Nombre()%>" name="Modificar_nombre" placeholder="Nombre" required>
            <span class="validity"></span> 
            </div>

            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control"  id="Modificar_apellido"  value="<%= User.getU_Apellido() %>" name="Modificar_apellido" placeholder="Apellido" required>
            <span class="validity"></span> 
            </div>
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="Modificar_telefono" value ="<%= User.getU_Telefono()%>" name="Modificar_telefono" placeholder="Telefono"required >
           <span class="validity"></span> 
             </div>            
                <div class="form-group">
                  <div class="select-wrap">
                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                    <select id="Modificar_OS" name="Modificar_OS" class="form-control" > 
                     <%
             			clsObraSocialDao os = new clsObraSocialDao(); 
                     clsObraSocial estado= os.TraerObraSocial(User.getU_IdObraSocial());
                     
            		 ArrayList<clsObraSocial> listaOS = (ArrayList<clsObraSocial>) os.ObraSocial_TraerTodos();
            		if(listaOS != null) 
            		for (clsObraSocial obrasocial : listaOS) { 
		            	%>
		            	<option value="<%=obrasocial.getId() %>"
			            			<%
			            			if (obrasocial.getId()==User.getU_IdObraSocial())
			            			{
			            				%> selected="selected" <%
			            			}			            			
			            			%>
			            			  style="color:black !important ;"> <%=obrasocial.getDetalle()%> </option> 
            	    	<%} 
            		else { %>
    	    		<option value="1" >Sin Obra social</option> 
    	    	<%}
          		  %>
                    
                    </select>
                  </div>
                </div>
            
            <div class="form-group">
              <input type="submit" value="Aceptar" name="btnModificarCli" class="btn btn-primary">
            </div>
          </form>
        </div>
        
      </div>
    </div>
  </div>
 
<script>

function disable() {
document.getElementById("txtHoraInicio").disabled = true;
}
function enable() {
document.getElementById("txtHoraInicio").disabled = false;
request.setAttribute("ListaUsuarios", document.getElementById("txtDia").value);
}

</script>

<script type="text/javascript">

document.getElementById("txtDia").addEventListener("change",function()
{
	var fechaVar = $('#txtDia').val();
	$.post('ServletTurno', $('#txtDia').serialize(),
		function(responseText)
		{
			$('#txtHoraInicio').html(responseText);		
		}		
	)
},false);


</script>


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

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="js/pro-sidebar.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
    
  </body>
</html>
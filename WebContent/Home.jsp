<%@page import="com.sun.org.apache.xml.internal.utils.StringComparable"%>
<%@ page  language="java" import="dominio.*, java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
		
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
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
  
    

<title>Consultorio</title>
</head>
<body>

<% if(session.getAttribute("Session_Ej2")!= null){
	clsUsuario User= (clsUsuario)session.getAttribute("Session_Ej2");
	String redirectURL ="";
	if (User.getU_IdTipo()==1)
	{
		 redirectURL = "./HomeAdministradorLogueado.jsp";
	    
	}
	if (User.getU_IdTipo()==2)
	{
		 redirectURL = "./HomeDoctorLogueado.jsp";
	    
	}
	else if (User.getU_IdTipo()==3)
	{
		redirectURL = "./HomeUsuarioLogueado.jsp";
	}
	response.sendRedirect(redirectURL);
	
} 


%>





 



	 <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item cta"><a href="contact.html" class="nav-link" data-toggle="modal" data-target="#modalRequest"><span>Iniciar sesion</span></a></li>
            <li class="nav-item cta"><a href="contact.html" class="nav-link" data-toggle="modal" data-target="#modalRegistro"><span>Registrarse</span></a></li>
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
    	<div class="container">
    		<div class="row no-gutters">
    			<div class="col-md-3 color-1 p-4">
    				<h3 class="mb-4">Dirección</h3>
    				<p>Hipólito Yrigoyen 288</p>
    				<span class="phone-number">+ (123) 456 7890</span>
    			</div>
    			<div class="col-md-3 color-2 p-4">
    				<h3 class="mb-4">Horario de Apertura</h3>
    				<p class="openinghours d-flex">
    					<span>Lunes - Domingos</span>
    					<span>10:00 - 19:00</span>
    				</p>
    			</div>
    			<div class="col-md-6 color-3 p-4">
    				<h3 class="mb-2">Reservar un Turno</h3>
            <h3 class="mb-2" style="font-size: 15px">Para pedir un turno registrarse</h3>
    				
    			</div>
    		</div>
    	</div>
    </section>
  
    
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <!-- Modal -->
  <div class="modal fade" id="modalRequest" tabindex="-1" role="dialog" aria-labelledby="modalRequestLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalRequestLabel">Iniciar Sesion</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form action="ServletUsuario" Method="post">
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="appointment_name" name="txtEmail" placeholder="Email">
            </div>
            <div class="form-group">
              <!-- <label for="appointment_email" class="text-black">Email</label> -->
              <input type="password" class="form-control" id="appointment_email" name="txtContraseña" placeholder="Contraseña">
            </div>

            <div class="form-group">
              <input type="submit" value="Aceptar" name="btnLogin" class="btn btn-primary">
            </div>
          </form>
        </div>
        
      </div>
    </div>
  </div>


  <!-- Modal -->
  <div class="modal fade" id="modalRegistro" tabindex="-1" role="dialog" aria-labelledby="modalRegistroLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalRegistroLabel">Registrarse</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form action="ServletUsuario" Method="post">
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="Registro_DNI" name="Registro_DNI" placeholder="DNI" pattern="\d*" min="1" step="1" required>
            <span class="validity"></span>
            </div>            
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control"  id="Registro_nombre"  name="Registro_nombre" placeholder="Nombre" required>
            <span class="validity"></span>
             </div>

            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control"  id="Registro_apellido"  name="Registro_apellido" placeholder="Apellido" required>
            <span class="validity"></span>
             </div>
            <div class="form-group">
              <!-- <label for="appointment_name" class="text-black">Full Name</label> -->
              <input type="text" class="form-control" id="Registro_telefono"  name="Registro_telefono" placeholder="Telefono" required>
            <span class="validity"></span>
             </div>
            
                  <div class="form-group">
                  Obra Social &nbsp; &nbsp; &nbsp;
                    <select id="Registro_obra" name="Registro_obra" class="form-control" > 
                     <%clsObraSocialDao os = new clsObraSocialDao();
            		 ArrayList<clsObraSocial> lista = (ArrayList<clsObraSocial>) os.ObraSocial_TraerTodos();
            		if(lista != null) 
            		for (clsObraSocial obrasocial : lista) { 
		            	%> 
		            		<option value="<%=obrasocial.getId() %>"> <%=obrasocial.getDetalle()%> </option>
            	    	<%} 
            		else { %>
    	    		<option value="1">Sin Obra social</option> 
    	    	<%}
          		  %>
                    
                    </select>
                </div>
                
            <div class="form-group">
              <!-- <label for="appointment_email" class="text-black">Email</label> -->
              <input type="email" class="form-control" id="Registro_email"  name="Registro_email" placeholder="Email"required>
            <span class="validity"></span>
             </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <!-- <label for="appointment_date" class="text-black">Date</label> -->  
                  <input type="password" class="form-control " id="Registro_Contraseña"  name="Registro_Contraseña" placeholder="Contraseña"required>
               <span class="validity"></span>
              </div>    
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <!-- <label for="appointment_date" class="text-black">Date</label> -->  
                  <input type="password" class="form-control " id="Registro_ContraseñaVerificar"  name="Registro_ContraseñaVerificar" placeholder="Repetir Contraseña"required>
                <span class="validity"></span>
             </div>    
              </div>
            </div>
            
            <div class="form-group">
              <input type="submit" value="Registrarse" name="btnRegistro" class="btn btn-primary">
            </div>
          </form>
        </div>
        
      </div>
    </div>
  </div>



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
</body>
</html>
package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.clsTurno;
import dominio.clsTurnoDao;
import dominio.clsUsuario;
import dominio.clsUsuarioDao;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.clsEstadoObraSocial;
import dominio.clsObraSocial;
import dominio.clsObraSocialDao;
import dominio.clsUsuario;
import dominio.clsUsuarioDao;
import sun.awt.image.IntegerComponentRaster;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class ServletTurno
 */
@WebServlet("/ServletTurno")
public class ServletTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTurno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		


		RequestDispatcher miDispacher = null;
		if(request.getParameter("btnReservarDoctor")!=null)
		{

				String motivoError = "";
				boolean validacion = true;
				clsTurnoDao tdao = new clsTurnoDao();
				clsTurno turno = new clsTurno();
				Date dt= (Date) Date.valueOf(request.getParameter("txtDia"));

				turno.setT_fecha(dt);

				String hf="";
				try {
					String myTime = request.getParameter("txtHoraInicio");
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					java.util.Date utilStartDate = df.parse(myTime);
					java.sql.Date d = new java.sql.Date(utilStartDate.getTime());	
										
					Calendar cal = Calendar.getInstance();
					cal.setTime(d);
					cal.add(Calendar.MINUTE, 30);
					hf = df.format(cal.getTime());
				} 
				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				 
				 
				turno.setT_HoraFin(hf);
 				turno.setT_HoraInicio(request.getParameter("txtHoraInicio"));
				turno.setT_IdEstado(1);
				turno.setT_DniUsuario(Integer.parseInt(request.getParameter("DNI")));
				turno.setT_Id(1);
				turno.setT_Diagnostico("");
				
				ArrayList<clsTurno> turnosPendientes = tdao.Turno_TraerPorDNI_Pendientes(turno.getT_DniUsuario());
				for (clsTurno turnito : turnosPendientes) {
					validacion = false;
					motivoError = "Este usuario ya tiene un turno pendiente el dia " + turnito.getT_fecha().toString() + " a las " + turnito.getT_HoraInicio().toString() + "hs.";
					break;
				}
				if (validacion)
				{
					ArrayList<clsTurno> turnosPedientes_todos = tdao.Turno_TraerTodos_Pendientes();
					for (clsTurno turnito : turnosPedientes_todos) {
						
						if(turnito.getT_fecha().equals(turno.getT_fecha()))
						{
							if(turnito.getT_HoraInicio().equals(turno.getT_HoraInicio())) 
							{
								validacion = false;
								motivoError = "Este turno no esta disponible, seleccione otro horario.";
								break;
							}
						}
					}
				}
				
				
				
				if(validacion)
				{
					if(tdao.SP_Turno_Alta(turno))
					{
						
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
				        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				        out.println("<script>");
				        out.println("$(document).ready(function(){");
				        out.println("swal('Turno Guardado Correctamente','','success');");
				        out.println("});");
				        out.println("</script>");

				        
				        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				        miDispacher.include(request, response);
					}
					else
					{
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
				        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
				        out.println("<script>");
				        out.println("$(document).ready(function(){");
				        out.println("swal('Error al guardar obra social','Error de conexión','error');");
				        out.println("});");
				        out.println("</script>");
				        
				        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
				        miDispacher.include(request, response);
					}
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Error al guardar obra social', '" + motivoError + "','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.include(request, response);
				}
				
			
		}
		

		if(request.getParameter("btnModificarAdm")!=null)
		{
			if(request.getParameter("Modificar_Paciente")!="")
			{

				HttpSession session = request.getSession();
				
				clsTurno turno = new clsTurno();
				turno.setT_DniUsuario(Integer.parseInt(request.getParameter("Modificar_Paciente")));
				Date dt= (Date) Date.valueOf(request.getParameter("Modificar_Fecha").toString());
				turno.setT_fecha(dt);
				turno.setT_Id(Integer.parseInt(request.getParameter("Modificar_idTurno")));
				turno.setT_HoraInicio(request.getParameter("Modificar_Hinicio"));
				
				 String hf="";
				try {
					String myTime = request.getParameter("Modificar_Hinicio");
				 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				 java.util.Date utilStartDate = df.parse(myTime);
				 java.sql.Date d = new java.sql.Date(utilStartDate.getTime());	
					
					
					Calendar cal = Calendar.getInstance();
					 cal.setTime(d);
					 cal.add(Calendar.MINUTE, 30);
					 hf = df.format(cal.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				 
				 
				turno.setT_HoraFin(hf);
				turno.setT_IdEstado(Integer.parseInt(request.getParameter("Modificar_Estado")));
				turno.setT_Diagnostico(request.getParameter("Modificar_Diagnostico"));

				clsTurnoDao turnoDao= new clsTurnoDao();			
				
				if(turnoDao.SP_Turno_Modificacion(turno))
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Usuario Guardado Correctamente','','success');");
			        out.println("});");
			        out.println("</script>");

			        
			        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.include(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Error al guardar el usuario ','','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.include(request, response);
				}
				
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
		        out.println("<script>");
		        out.println("$(document).ready(function(){");
		        out.println("swal('Error al guardar el usuario','Fato agregar algun dato','error');");
		        out.println("});");
		        out.println("</script>");
		        
		        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
		}
		
		if(request.getParameter("btnReservar")!=null)
		{

			System.out.print("turno distinto de null");

				HttpSession session = request.getSession();
				clsUsuario Us= (clsUsuario)session.getAttribute("Session_Ej2");
				
				clsTurnoDao tdao = new clsTurnoDao();
				clsTurno turno = new clsTurno();
				/* String result = LocalTime.parse(request.getParameter("txtHoraInicio"),DateTimeFormatter.ofPattern("hh:mm a",Locale.US )).format( DateTimeFormatter.ofPattern("HH:mm"));
				// esto de arriba no funciona porque trae '12:00am' en vez de '12:00 am''
				LocalDateTime ti= (LocalDateTime) LocalDateTime.parse(result);
				LocalDateTime tf = ti.plusMinutes(30);
				
				*/
				System.out.println(request.getParameter("txtDia") + " /-/ ");
				System.out.println(request.getParameter("txtHoraInicio") + " /-/ ");
				
				Date dt= (Date) Date.valueOf(request.getParameter("txtDia").toString());

				turno.setT_fecha(dt);
				turno.setT_HoraInicio(request.getParameter("txtHoraInicio"));
				
				 String hf="";
				try {
					String myTime = request.getParameter("txtHoraInicio");
				 SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				 java.util.Date utilStartDate = df.parse(myTime);
				 java.sql.Date d = new java.sql.Date(utilStartDate.getTime());	
					
					
					Calendar cal = Calendar.getInstance();
					 cal.setTime(d);
					 cal.add(Calendar.MINUTE, 30);
					 hf = df.format(cal.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
				 
				 
				turno.setT_HoraFin(hf);
				turno.setT_IdEstado(1);
				turno.setT_Id(1);
				turno.setT_Diagnostico("");
				turno.setT_DniUsuario(Us.getU_DNI());
				if(tdao.SP_Turno_Alta(turno))
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Usuario Guardado Correctamente','','success');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("Consultorio-Turnos.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.include(request, response);
				}
				else
				{
					// cartel alta de turno fallida
					miDispacher = request.getRequestDispatcher("HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.include(request, response);
				}
				
			
		}
		 
		
		
		if(request.getParameter("btnCancelarTurno")!=null)
		{

			clsTurnoDao tdao = new clsTurnoDao();
			if(tdao.CancelarTurno(Integer.parseInt(request.getParameter("txtIDTurno"))));
			{
		        miDispacher = request.getRequestDispatcher("HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
		     // cartel desea cancelar turno 
			}
		}

		
		doGet(request, response);
	}

}

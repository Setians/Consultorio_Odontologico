package Servlets;

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
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import dominio.clsObraSocial;
import dominio.clsObraSocialDao;
import dominio.clsUsuario;
import dominio.clsUsuarioDao;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnLogout")!=null)
		{
			System.out.print("se entro en btnLogout");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("Home.jsp");
		}
		else 
		{
			clsUsuarioDao UTdao = new clsUsuarioDao();
			System.out.print("Lista usuarios");
			ArrayList<clsUsuario> ListaUT=  UTdao.Usuario_TraerTodos();
			RequestDispatcher miDispacher = null;
			
			if(!ListaUT.isEmpty())
			{
				System.out.print("Lista no vacia");
				request.setAttribute("ListaUsuarios", ListaUT);
			
			}
			
	        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
	        miDispacher.forward(request, response);
	        
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnLogin")!=null)
		{
			System.out.print("Se clickeo btnLogin");
			//En htttpSession obtengo todas las variables session creadas
			HttpSession session = request.getSession();
			
			String Email="";
			String contra="";
			RequestDispatcher miDispacher = null;
			if(!request.getParameter("txtEmail").isEmpty()  && !request.getParameter("txtContraseña").isEmpty())
			{
				System.out.print("Se entro al if");
				System.out.print(request.getParameter("txtContraseña"));
				Email=request.getParameter("txtEmail");
				System.out.print(Email);
				contra=request.getParameter("txtContraseña");
				System.out.print(contra);
				
				clsUsuarioDao Udao= new clsUsuarioDao();
			
				clsUsuario User = (clsUsuario)Udao.VerificarLoginUsuario(Email, contra);
				//clsUsuario User = (clsUsuario)Udao.Usuario_TraerPorID(Integer.parseInt(contra));
				//Mediate el setAttribute creo la variable session

				System.out.print("sssssssssssss");
				
				if(User.getU_Email()!=null) {
					session.setAttribute("Session_Ej2", User);
					System.out.print("Usuario distinto de null");
					System.out.print(User.getU_IdTipo());
					System.out.print(User.getU_Email());
					//Redirijo a otro jsp
					try {
						
						 if(User.getU_IdTipo()==1)
				    	{
				    		 miDispacher = request.getRequestDispatcher("/HomeAdministradorLogueado.jsp?s=1");
				    	}
						 else if (User.getU_IdTipo()==2) {
						miDispacher = request.getRequestDispatcher("/HomeDoctorLogueado.jsp"); 
						}
						else if (User.getU_IdTipo()==3) {
							System.out.print("xd");
						miDispacher = request.getRequestDispatcher("/HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
						}
						 System.out.print(request);
						miDispacher.forward(request, response);
					}
					catch(Exception e)
					{
						e.printStackTrace();
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
				        out.println("swal('Error al inicio de sesion','Email o contraseña incorrecta','error');");
				        out.println("});");
				        out.println("</script>");
				        
				        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
		        out.println("swal('Error al inicio de sesion','Email o contraseña incorrecta','error');");
		        out.println("});");
		        out.println("</script>");
		        
		        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
			
			
			
		}
		
		if(request.getParameter("btnRegistro")!=null)
		{
			RequestDispatcher miDispacher = null;
			if(request.getParameter("Registro_DNI")!=""&&request.getParameter("Registro_nombre")!=""&&request.getParameter("Registro_apellido")!=""&&request.getParameter("Registro_telefono")!=""&&request.getParameter("Registro_obra")!=""&&request.getParameter("Registro_email")!=""&&request.getParameter("Registro_Contraseña").equalsIgnoreCase(request.getParameter("Registro_ContraseñaVerificar")))
			{
				clsUsuario user = new clsUsuario();
				user.setU_DNI(Integer.parseInt(request.getParameter("Registro_DNI")));
				user.setU_Nombre(request.getParameter("Registro_nombre"));
				user.setU_Apellido(request.getParameter("Registro_apellido"));
				user.setU_Email(request.getParameter("Registro_email"));
				user.setU_Telefono(request.getParameter("Registro_telefono"));
				user.setU_IdTipo(3);
				user.setU_IdObraSocial(Integer.parseInt(request.getParameter("Registro_obra")));
				user.setU_Contrasena(request.getParameter("Registro_Contraseña"));
				clsUsuarioDao udao= new clsUsuarioDao();			
				
				if(udao.SP_Usuario_Alta(user))
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
			        
			        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
			        out.println("swal('Error al guardar el usuario, el DNI ya fue registrado','','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
		        
		        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
		}
		if(request.getParameter("btnModificar")!=null)
		{
			RequestDispatcher miDispacher = null;
			if(request.getParameter("Modificar_DNI")!="")
			{
				clsUsuario user = new clsUsuario();
				user.setU_DNI(Integer.parseInt(request.getParameter("Modificar_DNI")));
				user.setU_IdTipo(Integer.parseInt(request.getParameter("Modificar_Tipo")));
				clsUsuarioDao udao= new clsUsuarioDao();			
				
				if(udao.cambiarTipoUsuario(user.getU_DNI(),user.getU_IdTipo()))
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
			        
			        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
			        out.println("swal('Error al guardar el usuario ','','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
		        
		        miDispacher = request.getRequestDispatcher("Home.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
		}
		
		
		if(request.getParameter("btnModificarCli")!=null)
		{
			RequestDispatcher miDispacher = null;
			if(request.getParameter("Modificar_DNI")!="")
			{

				HttpSession session = request.getSession();
				clsUsuario usuario = (clsUsuario)session.getAttribute("Session_Ej2");
				
				clsUsuario user = new clsUsuario();
				user.setU_DNI(usuario.getU_DNI());
				user.setU_IdTipo(3);
				user.setU_IdObraSocial(Integer.parseInt(request.getParameter("Modificar_OS")));
				user.setU_Apellido(request.getParameter("Modificar_apellido"));
				user.setU_Nombre(request.getParameter("Modificar_nombre"));
				user.setU_Telefono(request.getParameter("Modificar_telefono"));
				user.setU_Email(usuario.getU_Email());
				user.setU_Contrasena(usuario.getU_Contrasena());
				clsUsuarioDao udao= new clsUsuarioDao();			
				
				if(udao.SP_Usuario_Modificacion(user))
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

					session.setAttribute("Session_Ej2", user);
			        
			        miDispacher = request.getRequestDispatcher("HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
			        miDispacher.forward(request, response);
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
			        out.println("swal('Error al guardar el usuario ','','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
		        
		        miDispacher = request.getRequestDispatcher("HomeUsuarioLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
		}
		if(request.getParameter("btnRegistro_DesdeAdmin")!=null)
		{
			RequestDispatcher miDispacher = null;
			if(request.getParameter("Registro_DNI")!=""&&request.getParameter("Registro_nombre")!=""&&request.getParameter("Registro_apellido")!=""&&request.getParameter("Registro_telefono")!=""&&request.getParameter("Registro_obra")!=""&&request.getParameter("Registro_email")!="")
			{
				clsUsuario user = new clsUsuario();
				user.setU_DNI(Integer.parseInt(request.getParameter("Registro_DNI")));
				user.setU_Nombre(request.getParameter("Registro_nombre"));
				user.setU_Apellido(request.getParameter("Registro_apellido"));
				user.setU_Email(request.getParameter("Registro_email"));
				user.setU_Telefono(request.getParameter("Registro_telefono"));
				user.setU_IdTipo(3);
				user.setU_IdObraSocial(Integer.parseInt(request.getParameter("Registro_obra")));
				user.setU_Contrasena(request.getParameter("Registro_DNI"));
				clsUsuarioDao udao= new clsUsuarioDao();			
				
				if(udao.SP_Usuario_Alta(user))
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
			        
			        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
			        out.println("swal('Error al guardar el usuario','','error');");
			        out.println("});");
			        out.println("</script>");
			        
			        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
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
		        
		        miDispacher = request.getRequestDispatcher("HomeAdministradorLogueado.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
		        miDispacher.include(request, response);
			}
		}
		
		if(request.getParameter("btnLogout")!=null)
		{
			System.out.print("se entro en btnLogout");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("Home.jsp");
		}
		
	}

}

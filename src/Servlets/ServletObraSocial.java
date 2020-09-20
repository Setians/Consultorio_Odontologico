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

import dominio.clsEstadoObraSocial;
import dominio.clsObraSocial;
import dominio.clsObraSocialDao;
import dominio.clsUsuario;
import dominio.clsUsuarioDao;
import sun.awt.image.IntegerComponentRaster;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class ServletObraSocial
 */
@WebServlet("/ServletObraSocial")
public class ServletObraSocial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletObraSocial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.print("Se entro al get");
		clsObraSocialDao odao = new clsObraSocialDao();
		RequestDispatcher miDispacher = null;
		ArrayList<clsObraSocial> ListaObras=  odao.ObraSocial_TraerTodos();
     	ArrayList<clsEstadoObraSocial> lst = odao.EstadoObraSocial_TraerTodos();
     	request.setAttribute("ListaObras", ListaObras);
     	request.setAttribute("EstadosObras", lst);
     	miDispacher = request.getRequestDispatcher("Consultorio-ObrasSociales.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
        miDispacher.include(request, response);

		}
        

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		if(request.getParameter("btnAgregarObra")!=null)
		{
			RequestDispatcher miDispacher = null;
			if(request.getParameter("txtNombre")!="")
			{
				clsObraSocial obra = new clsObraSocial();
				obra.setDetalle(request.getParameter("txtNombre"));
				obra.setEstado(1);
				clsObraSocialDao osdao= new clsObraSocialDao();			
				
				if(osdao.SP_ObraSocial_Alta(obra))
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Obra Social Guardada Correctamente','','success');");
			        out.println("});");
			        out.println("</script>");
			        doGet(request, response);
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
			        out.println("swal('Error al guardar obra social','Ya existe la obra social','error');");
			        out.println("});");
			        out.println("</script>");
			        doGet(request, response);
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
	        out.println("swal('Error al guardar obra social','Fato agregar algun dato','error');");
	        out.println("});");
	        out.println("</script>");
	        doGet(request, response);
		}
		}
		if(request.getParameter("btnModificarObra")!=null)
		{
			System.out.print("Entro a modificar");
			RequestDispatcher miDispacher = null;
			if(request.getParameter("txtNombreObra")!="")
			{
				System.out.print(Integer.parseInt(request.getParameter("txtidObra")));
				System.out.print(request.getParameter("txtNombreObra"));
				System.out.print(Integer.parseInt(request.getParameter("ddlEstado")));
				clsObraSocial obra = new clsObraSocial();
				obra.setId(Integer.parseInt(request.getParameter("txtidObra")));
				obra.setDetalle(request.getParameter("txtNombreObra"));
				obra.setEstado(Integer.parseInt(request.getParameter("ddlEstado")));
				clsObraSocialDao osdao= new clsObraSocialDao();			
				
				if(osdao.SP_ObraSocial_Modificacion(obra))
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
			        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
			        out.println("<script>");
			        out.println("$(document).ready(function(){");
			        out.println("swal('Obra Social Guardada Correctamente','','success');");
			        out.println("});");
			        out.println("</script>");
			        
			        doGet(request, response);
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
	        out.println("swal('Error al guardar obra social','Fato agregar algun dato','error');");
	        out.println("});");
	        out.println("</script>");
	        
	        miDispacher = request.getRequestDispatcher("Consultorio-ObrasSociales.jsp"); // Es el archivo JSP al que le vamos a enviar la informacion
	        miDispacher.include(request, response);
		}
		}
		
		
		
	}

}

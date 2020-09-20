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
import dominio.clsOdontograma;
import dominio.clsOdontogramaDao;
import dominio.clsUsuario;
import dominio.clsUsuarioDao;
import sun.awt.image.IntegerComponentRaster;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class ServletObraSocial
 */
@WebServlet("/ServletOdontograma")
public class ServletOdontograma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletOdontograma() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("Se entro al get");
		if (request.getParameter("ClienteDNI") != null) {
			clsUsuarioDao udao = new clsUsuarioDao();
			RequestDispatcher miDispacher = null;
			clsUsuario Usuario = udao.Usuario_TraerPorID(Integer.parseInt(request.getParameter("ClienteDNI")));
			clsOdontogramaDao odao = new clsOdontogramaDao();
			ArrayList<clsOdontograma> listaOdontograma = odao.SP_TraerOdontograma_TraerPorDNI
					(Integer.parseInt(request.getParameter("ClienteDNI")));
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(
					"<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("localStorage.clear();");
			for (clsOdontograma var : listaOdontograma) 
			{
			out.println("localStorage.setItem(\""+var.geto_IdNroDiente() +"-"+var.geto_IdSeccion()+"-"+var.geto_IdReferencia()
			+"\", \""+var.geto_IdNroDiente() +","+var.geto_IdSeccion()+","+var.geto_IdReferencia()
			+"\");");
			}
			out.println("</script>");
			miDispacher = request.getRequestDispatcher("Consultorio-Odontograma.jsp"); // Es el archivo JSP al que le
																						// vamos a enviar la informacion
			miDispacher.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//if (request.getParameter("btnGuardarOdontograma") != null) {
			//System.out.print("Se entro al post");
			//System.out.print(request.getParameter("datosArray"));
			//System.out.print(request.getParameter("ClienteDNI"));
			String datos = request.getParameter("datosArray");
			String dni = request.getParameter("ClienteDNI");
			String[] DatosArray = datos.split("d");
			ArrayList<clsOdontograma> odonts= new ArrayList<clsOdontograma>();
			clsOdontograma odo = new clsOdontograma();
			clsOdontogramaDao odao= new clsOdontogramaDao();
			for( int i = 0; i < DatosArray.length; i++)
			{
				//System.out.print(DatosArray[i]);
				if(i> 0)
				{
					String[] ddatos=DatosArray[i].split(",");
					odo.seto_IdNroDiente(Integer.parseInt( ddatos[1]));
					odo.seto_IdReferencia(Integer.parseInt( ddatos[3]));
					odo.seto_IdSeccion(Integer.parseInt( ddatos[2]));
					odo.seto_Dni(Integer.parseInt(DatosArray[0]));
					odonts.add(odo);
					odo= new clsOdontograma();
				}
			}
			odao.SP_Odontograma_Baja(Integer.parseInt(DatosArray[0]));
			if(odao.SP_Odontograma_Alta(odonts))
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
		        out.println("<script>");
		        out.println("$(document).ready(function(){");
		        out.println("swal('Odontograma Guardado Correctamente','','success');");
		        out.println("});");
		        out.println("</script>");
		        doGet(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
		        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
		        //out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script");
		        out.println("<script>");
		        out.println("$(document).ready(function(){");
		        out.println("swal('Error al guardar Odontograma','','Error');");
		        out.println("});");
		        out.println("</script>");
		        doGet(request, response);
			}
			
	}

}

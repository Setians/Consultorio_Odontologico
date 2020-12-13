package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.clsReportesDao;
import dominio.clsReporteCanceladosUsuario;
import dominio.clsReporteTurnosMes;
import dominio.clsReporteTurnosObraSocial;
import dominio.clsReporteTurnosUsuario;

/**
 * Servlet implementation class ServletReportes
 */
@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReportes() {
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
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();

		// Obtengo los datos de la peticion
		String btn = request.getParameter("btn");
		if(btn.equals("FCliente") )
		{
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th scope=\"col\">DNI</th>");
			out.println("<th scope=\"col\">Obra Social</th>");
			out.println("<th scope=\"col\">Cantidad de Turnos</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			clsReportesDao ReportesDao = new clsReportesDao();
			ArrayList<clsReporteTurnosUsuario> ListaTUsuarios = ReportesDao.SP_Reporte_CantidadporUsuario();
			if (ListaTUsuarios != null) {	
			
				for (clsReporteTurnosUsuario TUsuarios : ListaTUsuarios) {
					out.println("<tr>");
					out.println("<td>"+TUsuarios.getDni() +"</td>");
					out.println("<td>"+TUsuarios.getObraSocial()+"</td>");
					out.println("<td>"+TUsuarios.getCantidadTurnos()+"</td>");
					out.println("</tr>");
				}

			}
			out.println("</tbody>");
		}
		else if(btn.equals("FObraSocial") )
		{
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th scope=\"col\">Obra Social</th>");
			out.println("<th scope=\"col\">Cantidad de Turnos</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			clsReportesDao ReportesDao = new clsReportesDao();
			ArrayList<clsReporteTurnosObraSocial> ListaTObraSocial = ReportesDao.SP_ReporteTurnosObraSocial();
			if (ListaTObraSocial != null) {	
			
				for (clsReporteTurnosObraSocial TObraSocial : ListaTObraSocial) {
					out.println("<tr>");
					out.println("<td>"+TObraSocial.getObraSocial()+"</td>");
					out.println("<td>"+TObraSocial.getCantidadTurnos()+"</td>");
					out.println("</tr>");
				}

			}
			out.println("</tbody>");
		}
		else if(btn.equals("FCUsuario") )
		{
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th scope=\"col\">DNI</th>");
			out.println("<th scope=\"col\">Porcentaje de Turnos Cancelados</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			clsReportesDao ReportesDao = new clsReportesDao();
			ArrayList<clsReporteCanceladosUsuario> ListaTCUsuario = ReportesDao.SP_ReporteCanceladosUsuario();
			if (ListaTCUsuario != null) {	
			
				for (clsReporteCanceladosUsuario TCUsuario : ListaTCUsuario) {
					out.println("<tr>");
					out.println("<td>"+TCUsuario.getDNI()+"</td>");
					out.println("<td>"+TCUsuario.getPorcentaje()+"</td>");
					out.println("</tr>");
				}

			}
			out.println("</tbody>");
		}
		else if(btn.equals("FMes") )
		{
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th scope=\"col\">Mes</th>");
			out.println("<th scope=\"col\">Cantidad de Turnos</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			clsReportesDao ReportesDao = new clsReportesDao();
			ArrayList<clsReporteTurnosMes> ListaTMes= ReportesDao.SP_ReporteMes();
			if (ListaTMes != null) {	
			
				for (clsReporteTurnosMes TMes : ListaTMes) {
					out.println("<tr>");
					out.println("<td>"+TMes.getMes().toUpperCase()+"</td>");
					out.println("<td>"+TMes.getCantidadTurnos()+"</td>");
					out.println("</tr>");
				}

			}
			out.println("</tbody>");
		}
			

		
		}
		
		
		
	}



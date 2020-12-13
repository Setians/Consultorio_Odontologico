package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.clsObraSocial;

public class clsReportesDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdconsultorio";
	private String driver = "com.mysql.jdbc.Driver";
	
	public clsReportesDao()
	{
		
	}
	
	public ArrayList<clsReporteTurnosUsuario> SP_Reporte_CantidadporUsuario()
	{
		ArrayList<clsReporteTurnosUsuario> lista = new ArrayList<clsReporteTurnosUsuario>();
		clsReporteTurnosUsuario cls = new clsReporteTurnosUsuario();
		Connection cn = null;

		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_ReporteTurnosUsuario()");
			//cst.setInt(1, DNI); // parametros para el procedure
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				cls.setDni(Integer.parseInt(resultado.getString(1)));
				cls.setObraSocial(resultado.getString(2));
				cls.setCantidadTurnos(Integer.parseInt(resultado.getString(3)));
			
			lista.add(cls);
			cls = new clsReporteTurnosUsuario();
			}
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return lista;	
	}
	
	public ArrayList<clsReporteTurnosObraSocial> SP_ReporteTurnosObraSocial()
	{
		ArrayList<clsReporteTurnosObraSocial> lista = new ArrayList<clsReporteTurnosObraSocial>();
		clsReporteTurnosObraSocial cls = new clsReporteTurnosObraSocial();
		Connection cn = null;

		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_ReporteTurnosObraSocial()");
			//cst.setInt(1, DNI); // parametros para el procedure
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				cls.setObraSocial(resultado.getString(1));
				cls.setCantidadTurnos(Integer.parseInt(resultado.getString(2)));
			
			lista.add(cls);
			cls = new clsReporteTurnosObraSocial();
			}
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return lista;	
	}
	
	public ArrayList<clsReporteCanceladosUsuario> SP_ReporteCanceladosUsuario()
	{
		ArrayList<clsReporteCanceladosUsuario> lista = new ArrayList<clsReporteCanceladosUsuario>();
		clsReporteCanceladosUsuario cls = new clsReporteCanceladosUsuario();
		Connection cn = null;

		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_ReporteCanceladosUsuario()");
			//cst.setInt(1, DNI); // parametros para el procedure
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				cls.setDNI(Integer.parseInt(resultado.getString(1)));
				cls.setPorcentaje(resultado.getString(2));
			
			lista.add(cls);
			cls = new clsReporteCanceladosUsuario();
			}
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return lista;	
	}
	
	public ArrayList<clsReporteTurnosMes> SP_ReporteMes()
	{
		ArrayList<clsReporteTurnosMes> lista = new ArrayList<clsReporteTurnosMes>();
		clsReporteTurnosMes cls = new clsReporteTurnosMes();
		Connection cn = null;

		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_ReporteTurnosMes()");
			//cst.setInt(1, DNI); // parametros para el procedure
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				cls.setMes(resultado.getString(1));
				cls.setCantidadTurnos(Integer.parseInt(resultado.getString(2)));
			
			lista.add(cls);
			cls = new clsReporteTurnosMes();
			}
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return lista;	
	}
	
}

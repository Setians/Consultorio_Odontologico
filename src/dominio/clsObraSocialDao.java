package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.clsObraSocial;

public class clsObraSocialDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdconsultorio";
	private String driver = "com.mysql.jdbc.Driver";
	
	public clsObraSocialDao()
	{
		
	}
	
	public boolean SP_ObraSocial_Alta(clsObraSocial ObraSocial)
	{ 
		boolean result = ABM_ObraSocial('I',ObraSocial);
		return result;
	}
	
	public boolean SP_ObraSocial_Baja(clsObraSocial ObraSocial)
	{
		return ABM_ObraSocial('D',ObraSocial);
	}
	
	public boolean SP_ObraSocial_Modificacion(clsObraSocial ObraSocial)
	{
		return ABM_ObraSocial('U',ObraSocial);
	}
	
	private boolean ABM_ObraSocial(char opcion, clsObraSocial ObraSocial)
	{
		Connection cn = null;
		boolean result = false;
		  try
		  {
				Class.forName(driver);
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_ABM_ObraSocial(?,?,?,?)");
			 cst.setString(1, String.valueOf(opcion));
			 cst.setInt(2, ObraSocial.getId());
			 cst.setString(3, ObraSocial.getDetalle());
			 cst.setInt(4, ObraSocial.getEstado());
			 cst.execute();
			 cst.close();
			 result = true;
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}

		  return result;
	}
	
	public clsObraSocial TraerObraSocial(int id)
	{
		clsObraSocial cls = new clsObraSocial();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerObraSocial(?)");

			cst.setInt(1, id); // parametros para el procedure
			
			ResultSet resultado = cst.executeQuery();
			resultado.next();

			cls.setId(Integer.parseInt(resultado.getString(1)));
			cls.setDetalle(resultado.getString(2));
			cls.setEstado(Integer.parseInt(resultado.getString(3)));
			
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return cls;
		
	}
	
	public ArrayList<clsObraSocial> ObraSocial_TraerTodos()
	{
		ArrayList<clsObraSocial> lista = new ArrayList<clsObraSocial>();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerObraSocial_Todos()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){

				clsObraSocial cls = new clsObraSocial();
				cls.setId(Integer.parseInt(resultado.getString(1)));
				cls.setDetalle(resultado.getString(2));
				cls.setEstado(Integer.parseInt(resultado.getString(3)));

			lista.add(cls);
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
		
	public ArrayList<clsEstadoObraSocial> EstadoObraSocial_TraerTodos()
	{
		ArrayList<clsEstadoObraSocial> lista = new ArrayList<clsEstadoObraSocial>();
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerEstadoObraSocial_Todos()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){

				clsEstadoObraSocial cls = new clsEstadoObraSocial();
				cls.setU_Id(Integer.parseInt(resultado.getString(1)));
				cls.setU_Detalle(resultado.getString(2));

				System.out.print(resultado.getString(1));

				
				lista.add(cls);
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
	
	public clsEstadoObraSocial EstadoObraSocial_TraerPorID(int ID)
	{
		clsEstadoObraSocial cls = new clsEstadoObraSocial();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerEstadoObraSocial(?)");

			cst.setInt(1, ID); // parametros para el procedure

			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
				cls.setU_Id(resultado.getInt(1));
				cls.setU_Detalle(resultado.getString(2));
			
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return cls;
	}
}

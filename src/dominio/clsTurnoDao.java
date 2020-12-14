package dominio;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;


import dominio.clsTurno;

public class clsTurnoDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdconsultorio";
	private String driver = "com.mysql.jdbc.Driver";
	
	public clsTurnoDao()
	{
		
	}
	
	public boolean SP_Turno_Alta(clsTurno turno)
	{ 
		return ABM_Turno('I',turno);
	}
	
	public boolean SP_Turno_Baja(clsTurno turno)
	{
		return ABM_Turno('D',turno);
	}
	
	public boolean SP_Turno_Modificacion(clsTurno turno)
	{
		return ABM_Turno('U',turno);
	}
	
	private boolean ABM_Turno(char opcion, clsTurno turno)
	{
		Connection cn = null;
		boolean result = false;
		  try
		  {
				Class.forName(driver);
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_ABM_Turno(?,?,?,?,?,?,?,?)");
			 cst.setString(1, String.valueOf(opcion));
			 cst.setInt(2, turno.getT_Id());
			 cst.setInt(3, turno.getT_DniUsuario());
			 cst.setDate(4, turno.getT_fecha());
			 cst.setString(5, turno.getT_HoraInicio());
			 cst.setString(6, turno.getT_HoraFin());
			 cst.setString(7, turno.getT_Diagnostico());
			 cst.setInt(8, turno.getT_IdEstado());
			 cst.execute();
			 
			 cn.close();
			 result = true;
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
			
	}
	
	public clsTurno Turno_TraerPorID(int id)
	{
		clsTurno cls = new clsTurno();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno(?)");

			cst.setInt(1, id); // parametros para el procedure
			
			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
			cls.setT_Id(Integer.parseInt(resultado.getString(1)));
			cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
			cls.setT_fecha(Date.valueOf(resultado.getString(3)));
			cls.setT_HoraInicio(resultado.getString(4));
			cls.setT_HoraFin(resultado.getString(5));
			cls.setT_Diagnostico(resultado.getString(6));
			cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			
			cn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
		}
		return cls;
		
	}
	
	public ArrayList<clsTurno> Turno_TraerPorDNI(int DNI)
	{
		ArrayList<clsTurno> lista = new ArrayList<clsTurno>();
		clsTurno cls = new clsTurno();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno_PorDNI(?)");

			cst.setInt(1, DNI); // parametros para el procedure

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){

				cls.setT_Id(Integer.parseInt(resultado.getString(1)));
				cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
				cls.setT_fecha(Date.valueOf(resultado.getString(3)));
				cls.setT_HoraInicio(resultado.getString(4));
				cls.setT_HoraFin(resultado.getString(5));
				cls.setT_Diagnostico(resultado.getString(6));
				cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			
			lista.add(cls);
			 
			 cn.close();
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
	
	public ArrayList<clsTurno> Turno_TraerPorDNI_Pendientes(int DNI)
	{

		ArrayList<clsTurno> lista = new ArrayList<clsTurno>();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno_PorDNI_Pendientes(?)");

			cst.setInt(1, DNI); // parametros para el procedure

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){

				clsTurno cls = new clsTurno();

				cls.setT_Id(Integer.parseInt(resultado.getString(1)));
				cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
				cls.setT_fecha(Date.valueOf(resultado.getString(3)));
				cls.setT_HoraInicio(resultado.getString(4));
				cls.setT_HoraFin(resultado.getString(5));
				cls.setT_Diagnostico(resultado.getString(6));
				cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			
			lista.add(cls);
			 
			}
			 cn.close();
			
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
	
	public ArrayList<clsTurno> Turno_TraerTodos()
	{
		ArrayList<clsTurno> lista = new ArrayList<clsTurno>();
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno_Todos()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsTurno cls = new clsTurno();
				cls.setT_Id(Integer.parseInt(resultado.getString(1)));
				cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
				cls.setT_fecha(Date.valueOf(resultado.getString(3)));
				cls.setT_HoraInicio(resultado.getString(4));
				cls.setT_HoraFin(resultado.getString(5));
				cls.setT_Diagnostico(resultado.getString(6));
				cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			System.out.print(cls.getT_Id());
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
	
	public ArrayList<clsTurno> Turno_TraerPorFecha_Pendientes(String fecha)
	{
		ArrayList<clsTurno> lista = new ArrayList<clsTurno>();
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno_PorFecha_Pendientes(?)");
			cst.setString(1, fecha);
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsTurno cls = new clsTurno();
				cls.setT_Id(Integer.parseInt(resultado.getString(1)));
				cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
				cls.setT_fecha(Date.valueOf(resultado.getString(3)));
				cls.setT_HoraInicio(resultado.getString(4));
				cls.setT_HoraFin(resultado.getString(5));
				cls.setT_Diagnostico(resultado.getString(6));
				cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			System.out.print(cls.getT_Id());
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
	
	public ArrayList<clsTurno> Turno_TraerTodos_Pendientes()
	{
		ArrayList<clsTurno> lista = new ArrayList<clsTurno>();
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTurno_Todos_Pendientes()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsTurno cls = new clsTurno();
				cls.setT_Id(Integer.parseInt(resultado.getString(1)));
				cls.setT_DniUsuario(Integer.parseInt(resultado.getString(2)));
				cls.setT_fecha(Date.valueOf(resultado.getString(3)));
				cls.setT_HoraInicio(resultado.getString(4));
				cls.setT_HoraFin(resultado.getString(5));
				cls.setT_Diagnostico(resultado.getString(6));
				cls.setT_IdEstado(Integer.parseInt(resultado.getString(7)));
			System.out.print(cls.getT_Id());
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
	
	public boolean CancelarTurno(int id)
	{
		boolean estado=false;
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_CancelarTurno(?)");

			cst.setInt(1, id); // parametros para el procedure
			
			cst.executeQuery();
			
			cn.close();
			estado=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return estado;
		// aca deberiamos retornar algo que confirme si cancelo turno (inserte emoji pensante)
	}
	
	
	
	public ArrayList<clsEstadoTurno> EstadoTurno_TraerTodos()
	{

		ArrayList<clsEstadoTurno> lista = new ArrayList<clsEstadoTurno>();
		
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerEstadoTurno_Todos()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsEstadoTurno cls = new clsEstadoTurno();
				cls.setU_Id(Integer.parseInt(resultado.getString(1)));
				cls.setU_Detalle(resultado.getString(2));

			
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
	
	
	public clsEstadoTurno EstadoTurno_TraerPorID(int ID)
	{
		clsEstadoTurno cls = new clsEstadoTurno();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerEstadoTurno(?)");

			cst.setInt(1, ID); // parametros para el procedure

			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
				cls.setU_Id(Integer.parseInt(resultado.getString(1)));
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
	
	public boolean validarTurno(clsTurno turno, String motivoError)
	{
		return true;
	}
}

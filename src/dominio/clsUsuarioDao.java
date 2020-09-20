package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Bool;

import dominio.clsUsuario;

public class clsUsuarioDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdconsultorio";
	private String driver = "com.mysql.jdbc.Driver";
	
	public clsUsuarioDao()
	{
		
	}
	
	public boolean SP_Usuario_Alta(clsUsuario usuario)
	{ 
		return ABM_Usuario('I',usuario);
	}
	
	public boolean SP_Usuario_Baja(clsUsuario usuario)
	{
		return ABM_Usuario('D',usuario);
	}
	
	public boolean SP_Usuario_Modificacion(clsUsuario usuario)
	{
		return ABM_Usuario('U',usuario);
	}
	
	private boolean ABM_Usuario(char opcion, clsUsuario usuario)
	{
		boolean result = false;
		Connection cn = null;
		  try
		  {
				Class.forName(driver);
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_ABM_Usuario(?,?,?,?,?,?,?,?,?)");
			 cst.setString(1, String.valueOf(opcion));
			 cst.setInt(2, usuario.getU_DNI());
			 cst.setInt(3, usuario.getU_IdTipo());
			 cst.setInt(4, usuario.getU_IdObraSocial());
			 cst.setString(5, usuario.getU_Nombre());
			 cst.setString(6, usuario.getU_Apellido());
			 cst.setString(7, usuario.getU_Telefono());
			 cst.setString(8, usuario.getU_Email());
			 cst.setString(9, usuario.getU_Contrasena());
			 cst.execute();
			 result = true;
			 cn.close();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
			
	}
	
	public boolean cambiarTipoUsuario(int DNI, int tipo)
	{
		boolean result = false;
		Connection cn = null;
		  try
		  {
			 Class.forName(driver);
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 CallableStatement cst = cn.prepareCall("CALL SP_Usuario_CambiarTipo(?,?)");
			 cst.setInt(1, DNI);
			 cst.setInt(2, tipo);
			 cst.execute();
			 result = true;
			 cn.close();
		  }
		  catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
			
	}
	
	
	public clsUsuario Usuario_TraerPorID(int DNI)
	{
			clsUsuario cls = new clsUsuario();
			Connection cn = null;
			try{
				Class.forName(driver);
				cn = DriverManager.getConnection(host + dbName, user, pass);
				CallableStatement cst = cn.prepareCall("CALL SP_TraerUsuario(?)");

				cst.setInt(1, DNI); // parametros para el procedure
				
				ResultSet resultado = cst.executeQuery();
				resultado.next();
				
				cls.setU_DNI(Integer.parseInt(resultado.getString(1)));
				cls.setU_IdTipo(Integer.parseInt(resultado.getString(2)));
				cls.setU_IdObraSocial(Integer.parseInt(resultado.getString(3)));
				cls.setU_Nombre(resultado.getString(4));
				cls.setU_Apellido(resultado.getString(5));
				cls.setU_Telefono(resultado.getString(6));
				cls.setU_Email(resultado.getString(7));
				cls.setU_Contrasena(resultado.getString(8));
				
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
	
	public clsUsuario Usuario_TraerPorMail(String mail)
	{
		clsUsuario cls = new clsUsuario();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerUsuario_PorMail(?)");

			cst.setString(1, mail); // parametros para el procedure
			
			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
			cls.setU_DNI(Integer.parseInt(resultado.getString(1)));
			cls.setU_IdTipo(Integer.parseInt(resultado.getString(2)));
			cls.setU_IdObraSocial(Integer.parseInt(resultado.getString(3)));
			cls.setU_Nombre(resultado.getString(4));
			cls.setU_Apellido(resultado.getString(5));
			cls.setU_Telefono(resultado.getString(6));
			cls.setU_Email(resultado.getString(7));
			cls.setU_Contrasena(resultado.getString(8));
			
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
	
	public ArrayList<clsUsuario> Usuario_TraerTodos()
	{
		return Usuario_EjecutarConsulta_ArrayList("CALL SP_TraerUsuario_Todos()");
	}
	
	public ArrayList<clsUsuario> Usuario_TraerClientes()
	{
		return Usuario_EjecutarConsulta_ArrayList("CALL SP_TraerClientes()");
	}
	
	public ArrayList<clsUsuario> Usuario_TraerDoctores()
	{
		return Usuario_EjecutarConsulta_ArrayList("CALL SP_TraerDoctores()");
	}
	
	public ArrayList<clsUsuario> Usuario_TraerAdministradores()
	{
		return Usuario_EjecutarConsulta_ArrayList("CALL SP_TraerAdministradores()");
	}
	
	private ArrayList<clsUsuario> Usuario_EjecutarConsulta_ArrayList(String consulta)
	{
		ArrayList<clsUsuario> lista = new ArrayList<clsUsuario>();
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall(consulta);

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsUsuario cls = new clsUsuario();
				cls.setU_DNI(Integer.parseInt(resultado.getString(1)));
				cls.setU_IdTipo(Integer.parseInt(resultado.getString(2)));
				cls.setU_IdObraSocial(Integer.parseInt(resultado.getString(3)));
				cls.setU_Nombre(resultado.getString(4));
				cls.setU_Apellido(resultado.getString(5));
				cls.setU_Telefono(resultado.getString(6));
				cls.setU_Email(resultado.getString(7));
				cls.setU_Contrasena(resultado.getString(8));
			lista.add(cls);
			System.out.print(cls.getU_DNI());
			
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
	
	public ArrayList<clsTipoUsuario> TipoUsuario_TraerTodos()
	{
		ArrayList<clsTipoUsuario> lista = new ArrayList<clsTipoUsuario>();
		
		
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTipoUsuario_Todos()");

			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){
				clsTipoUsuario cls = new clsTipoUsuario();
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
	

	public clsTipoUsuario TipoUsuario_TraerPorID(int ID)
	{
		clsTipoUsuario cls = new clsTipoUsuario();
		Connection cn = null;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerTipoUsuario(?)");

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
	
	public Boolean Existe(int DNI)
	{
		Connection cn = null;
		boolean existe = false;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerUsuario(?)");

			cst.setInt(1, DNI); // parametros para el procedure
			
			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
			if(resultado != null){existe = true;}
			
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return existe;
	}
	
	public Boolean Existe_PorMail(String mail)
	{
		Connection cn = null;
		boolean existe = false;
		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerUsuario_PorMail(?)");

			cst.setString(1, mail); // parametros para el procedure
			
			ResultSet resultado = cst.executeQuery();
			resultado.next();
			
			if(resultado != null){existe = true;}
			
			cn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		}
		return existe;
	}
	
	public clsUsuario VerificarLoginUsuario(String mail, String contra)
	{
			clsUsuario cls = new clsUsuario();
			Connection cn = null;
			try{
				Class.forName(driver);
				cn = DriverManager.getConnection(host + dbName, user, pass);
				CallableStatement cst = cn.prepareCall("CALL SP_VerificarLoginUsuario(?,?)");

				cst.setString("uMail", mail); // parametros para el procedure
				cst.setString("uContrasena", contra); // parametros para el procedure
				
				ResultSet resultado = cst.executeQuery();
				resultado.next();
				
				cls.setU_DNI(Integer.parseInt(resultado.getString(1)));
				cls.setU_IdTipo(Integer.parseInt(resultado.getString(2)));
				cls.setU_IdObraSocial(Integer.parseInt(resultado.getString(3)));
				cls.setU_Nombre(resultado.getString(4));
				cls.setU_Apellido(resultado.getString(5));
				cls.setU_Telefono(resultado.getString(6));
				cls.setU_Email(resultado.getString(7));
				cls.setU_Contrasena(resultado.getString(8));
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
	
	
}

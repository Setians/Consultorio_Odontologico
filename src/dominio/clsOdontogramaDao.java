package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.clsObraSocial;

public class clsOdontogramaDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdconsultorio";
	private String driver = "com.mysql.jdbc.Driver";
	
	public clsOdontogramaDao()
	{
		
	}
		
	public boolean SP_Odontograma_Alta(ArrayList<clsOdontograma> odontodos)
	{
		for(clsOdontograma odontograma : odontodos)
		{
			if(!GuardarOdontograma(odontograma)) return false;			
		}
		return true;
	}
	
	public boolean SP_Odontograma_Baja(int DNI)
	{
		Connection cn = null;
		boolean result = false;
		try
		{
			Class.forName(driver);
			cn = DriverManager.getConnection(host+dbName,user,pass);
			CallableStatement cst = cn.prepareCall("CALL SP_BorrarOdontograma_PorDNI(?)");
			cst.setInt(1, DNI);
			cst.execute();
			cst.close();
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	private boolean GuardarOdontograma(clsOdontograma odontograma)
	{
		Connection cn = null;
		boolean result = false;
		try
		{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_AgregarOdontograma(?,?,?,?)");
			cst.setInt(1, odontograma.geto_Dni());
			cst.setInt(2, odontograma.geto_IdNroDiente());
			cst.setInt(3, odontograma.geto_IdReferencia());
			cst.setInt(4, odontograma.geto_IdSeccion());
			cst.execute();
			cst.close();
			result = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public ArrayList<clsOdontograma> SP_TraerOdontograma_TraerPorDNI(int DNI)
	{
		ArrayList<clsOdontograma> lista = new ArrayList<clsOdontograma>();
		clsOdontograma cls = new clsOdontograma();
		Connection cn = null;

		try{
			Class.forName(driver);
			cn = DriverManager.getConnection(host + dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL SP_TraerOdontograma(?)");
			cst.setInt(1, DNI); // parametros para el procedure
			ResultSet resultado = cst.executeQuery();
			
			while(resultado.next()){

				cls.seto_Dni(Integer.parseInt(resultado.getString(1)));
				cls.seto_IdNroDiente(Integer.parseInt(resultado.getString(2)));
				cls.seto_IdReferencia(Integer.parseInt(resultado.getString(3)));
				cls.seto_IdSeccion(Integer.parseInt(resultado.getString(4)));
			
			lista.add(cls);
			cls = new clsOdontograma();
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

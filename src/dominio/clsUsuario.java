package dominio;

public class clsUsuario {
	private int u_DNI;
	private int u_IdTipo;
	private int u_IdObraSocial;
	private String u_Nombre;
	private String u_Apellido;
	private String u_Telefono;
	private String u_Email;
	private String u_Contrasena;
	private Boolean u_Estado;

	
	public clsUsuario()
	{
		
	}


	public clsUsuario(int u_DNI, int u_Tipo, int u_ObraSocial, String u_Nombre, String u_Apellido, String u_Telefono, String u_Email, String u_Contrasena, Boolean u_Estado) {
		super();
		this.u_DNI = u_DNI;
		this.u_IdTipo = u_Tipo;
		this.u_IdObraSocial = u_ObraSocial;
		this.u_Nombre = u_Nombre;
		this.u_Apellido = u_Apellido;
		this.u_Telefono = u_Telefono;
		this.u_Email = u_Email;
		this.u_Contrasena = u_Contrasena;
		this.u_Estado = u_Estado;
	}


	public int getU_DNI() {
		return u_DNI;
	}


	public void setU_DNI(int u_DNI) {
		this.u_DNI = u_DNI;
	}


	public int getU_IdTipo() {
		return u_IdTipo;
	}


	public void setU_IdTipo(int u_IdTipo) {
		this.u_IdTipo = u_IdTipo;
	}


	public int getU_IdObraSocial() {
		return u_IdObraSocial;
	}


	public void setU_IdObraSocial(int u_IdObraSocial) {
		this.u_IdObraSocial = u_IdObraSocial;
	}


	public String getU_Nombre() {
		return u_Nombre;
	}


	public void setU_Nombre(String u_Nombre) {
		this.u_Nombre = u_Nombre;
	}


	public String getU_Apellido() {
		return u_Apellido;
	}


	public void setU_Apellido(String u_Apellido) {
		this.u_Apellido = u_Apellido;
	}


	public String getU_Telefono() {
		return u_Telefono;
	}


	public void setU_Telefono(String u_Telefono) {
		this.u_Telefono = u_Telefono;
	}


	public String getU_Email() {
		return u_Email;
	}


	public void setU_Email(String u_Email) {
		this.u_Email = u_Email;
	}


	public String getU_Contrasena() {
		return u_Contrasena;
	}


	public void setU_Contrasena(String u_Contrasena) {
		this.u_Contrasena = u_Contrasena;
	}


	public Boolean getU_Estado() {
		return u_Estado;
	}


	public void setU_Estado(Boolean u_Estado) {
		this.u_Estado = u_Estado;
	}
	
}

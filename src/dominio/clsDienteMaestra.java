package dominio;

public class clsDienteMaestra {
	private int d_NroDiente;
	private String d_Nombre;
	private String d_Grupo;
	private String d_Cuadrante;

	
	public clsDienteMaestra()
	{
		
	}


	public clsDienteMaestra(int d_nrodiente, String d_nombre,String d_grupo,String d_cuadrante) {
		super();
		this.d_NroDiente = d_nrodiente;
		this.d_Nombre = d_nombre;
		this.d_Grupo = d_grupo;
		this.d_Cuadrante = d_cuadrante;
	}


	public int getd_NroDiente() {
		return d_NroDiente;
	}


	public void setd_NroDiente(int u_DNI) {
		this.d_NroDiente = u_DNI;
	}


	public String getd_Nombre() {
		return d_Nombre;
	}


	public void setd_Nombre(String d_Nombre) {
		this.d_Nombre = d_Nombre;
	}

	public String getd_Grupo() {
		return d_Grupo;
	}


	public void setd_Grupo(String d_Grupo) {
		this.d_Grupo = d_Grupo;
	}

	public void setd_Cuadrante(String d_Cuadrante) {
		this.d_Cuadrante = d_Cuadrante;
	}


	public String getd_Cuadrante() {
		return d_Cuadrante;
	}
	
}

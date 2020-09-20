package dominio;

public class clsReferenciaMaestra {
	private int r_IdReferencia;
	private String r_Sigla;
	private String r_Detalle;

	
	public clsReferenciaMaestra()
	{
		
	}


	public clsReferenciaMaestra(int r_IdReferencia, String r_Sigla,String r_Detalle) {
		super();
		this.r_IdReferencia = r_IdReferencia;
		this.r_Sigla = r_Sigla;
		this.r_Detalle = r_Detalle;
	}


	public int getr_IdReferencia() {
		return r_IdReferencia;
	}


	public void setr_IdReferencia(int r_IdReferencia) {
		this.r_IdReferencia = r_IdReferencia;
	}


	public String getr_Sigla() {
		return r_Sigla;
	}


	public void setr_Sigla(String r_Sigla) {
		this.r_Sigla = r_Sigla;
	}

	public String getr_Detalle() {
		return r_Detalle;
	}


	public void setr_Detalle(String r_Detalle) {
		this.r_Detalle = r_Detalle;
	}

	
}

package dominio;

public class clsTipo {
	private int t_ID;
	private String t_Detalle;
	
	
	public clsTipo() {}


	public int getT_ID() {
		return t_ID;
	}


	public void setT_ID(int t_ID) {
		this.t_ID = t_ID;
	}


	public String getT_Detalle() {
		return t_Detalle;
	}


	public void setT_Detalle(String t_Detalle) {
		this.t_Detalle = t_Detalle;
	}


	public clsTipo(int t_ID, String t_Detalle) {
		super();
		this.t_ID = t_ID;
		this.t_Detalle = t_Detalle;
	}
	
}

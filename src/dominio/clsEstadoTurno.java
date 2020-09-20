package dominio;

public class clsEstadoTurno {
	
	private int u_Id;
	private String u_Detalle;
		
	public clsEstadoTurno() {
	}
			
	public clsEstadoTurno(int u_Id, String u_Detalle) {
		super();
		this.u_Id = u_Id;
		this.u_Detalle = u_Detalle;
	}

	public int getU_Id() {
		return u_Id;
	}

	public void setU_Id(int u_Id) {
		this.u_Id = u_Id;
	}

	public String getU_Detalle() {
		return u_Detalle;
	}

	public void setU_Detalle(String u_Detalle) {
		this.u_Detalle = u_Detalle;
	}

}

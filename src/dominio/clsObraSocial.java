package dominio;

public class clsObraSocial {
	private int Id;
	private String Detalle;
	private int Estado;
	
	public clsObraSocial() {}
	
	public clsObraSocial(int os_Id, String os_Detalle, int os_Estado) {
		super();
		Id = os_Id;
		Detalle = os_Detalle;
		Estado = os_Estado;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	
}

package dominio;

public class clsDienteUsuario {
	private int du_Dni;
	private int du_IdNroDiente;

	
	public clsDienteUsuario()
	{
		
	}


	public clsDienteUsuario(int du_Dni, int du_IdNroDiente) {
		super();
		this.du_Dni = du_Dni;
		this.du_IdNroDiente = du_IdNroDiente;
	}


	public int getdu_Dni() {
		return du_Dni;
	}


	public void setdu_Dni(int du_Dni) {
		this.du_Dni = du_Dni;
	}


	public int getdu_IdNroDiente() {
		return du_IdNroDiente;
	}


	public void setdu_IdNroDiente(int du_IdNroDiente) {
		this.du_IdNroDiente = du_IdNroDiente;
	}
	
}

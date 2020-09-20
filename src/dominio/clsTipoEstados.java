package dominio;

public class clsTipoEstados {
	private int TE_Id;
	private String TE_Detalle;
	
	public clsTipoEstados() {}

	public int getTE_Id() {
		return TE_Id;
	}

	public void setTE_Id(int tE_Id) {
		TE_Id = tE_Id;
	}

	public String getTE_Detalle() {
		return TE_Detalle;
	}

	public void setTE_Detalle(String tE_Detalle) {
		TE_Detalle = tE_Detalle;
	}

	@Override
	public String toString() {
		return "clsTipoEstados [TE_Id=" + TE_Id + ", TE_Detalle=" + TE_Detalle + "]";
	}

	public clsTipoEstados(int tE_Id, String tE_Detalle) {
		super();
		TE_Id = tE_Id;
		TE_Detalle = tE_Detalle;
	}
	
}

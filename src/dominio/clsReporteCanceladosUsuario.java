package dominio;

public class clsReporteCanceladosUsuario {
	private int DNI;
	private String Porcentaje;
	
	public clsReporteCanceladosUsuario() {}
	
	public clsReporteCanceladosUsuario(int rtu_DNI, String rtu_Porcentaje) {
		super();
		DNI = rtu_DNI;
		Porcentaje = rtu_Porcentaje;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getPorcentaje() {
		return Porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		Porcentaje = porcentaje;
	}

	
}

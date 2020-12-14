package dominio;

public class clsReporteTurnosUsuario {
	private int DNI;
	private String ObraSocial;
	private int CantidadTurnos;
	
	public clsReporteTurnosUsuario() {}
	
	public clsReporteTurnosUsuario(int rtu_DNI, String rtu_ObraSocial, int rtu_CantidadTurnos) {
		super();
		DNI = rtu_DNI;
		ObraSocial = rtu_ObraSocial;
		CantidadTurnos = rtu_CantidadTurnos;
	}

	public int getDni() {
		return DNI;
	}

	public void setDni(int dni) {
		DNI = dni;
	}

	public String getObraSocial() {
		return ObraSocial;
	}

	public void setObraSocial(String obraSocial) {
		ObraSocial = obraSocial;
	}

	public int getCantidadTurnos() {
		return CantidadTurnos;
	}

	public void setCantidadTurnos(int cTurnos) {
		CantidadTurnos = cTurnos;
	}

	
}

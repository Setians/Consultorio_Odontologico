package dominio;

public class clsReporteTurnosObraSocial {
	private String ObraSocial;
	private int CantidadTurnos;
	
	public clsReporteTurnosObraSocial() {}
	
	public clsReporteTurnosObraSocial(String rtu_ObraSocial, int rtu_CantidadTurnos) {
		super();
		ObraSocial = rtu_ObraSocial;
		CantidadTurnos = rtu_CantidadTurnos;
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

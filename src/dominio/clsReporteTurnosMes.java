package dominio;

public class clsReporteTurnosMes {
	private String Mes;
	private int CantidadTurnos;
	
	public clsReporteTurnosMes() {}
	
	public clsReporteTurnosMes(String rtu_Mes, int rtu_CantidadTurnos) {
		super();
		Mes = rtu_Mes;
		CantidadTurnos = rtu_CantidadTurnos;
	}

	public String getMes() {
		return Mes;
	}

	public void setMes(String mes) {
		Mes = mes;
	}

	public int getCantidadTurnos() {
		return CantidadTurnos;
	}

	public void setCantidadTurnos(int cTurnos) {
		CantidadTurnos = cTurnos;
	}

	
}

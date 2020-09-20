package dominio;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


public class clsTurno {
	
	private int t_Id;
	private int t_DniUsuario;
	private Date t_fecha;
	private String t_HoraInicio;
	private String t_HoraFin;
	private String t_Diagnostico;
	private int t_IdEstado;
	
	public clsTurno() {}

	public int getT_Id() {
		return t_Id;
	}

	public void setT_Id(int t_Id) {
		this.t_Id = t_Id;
	}

	public int getT_DniUsuario() {
		return t_DniUsuario;
	}

	public void setT_DniUsuario(int t_DniUsuario) {
		this.t_DniUsuario = t_DniUsuario;
	}

	public Date getT_fecha() {
		return t_fecha;
	}

	public void setT_fecha(Date t_fecha) {
		this.t_fecha = t_fecha;
	}

	public String getT_HoraInicio() {
		return t_HoraInicio;
	}

	public void setT_HoraInicio(String t_HoraInicio) {
		this.t_HoraInicio = t_HoraInicio;
	}

	public String getT_HoraFin() {
		return t_HoraFin;
	}

	public void setT_HoraFin(String t_HoraFin) {
		this.t_HoraFin = t_HoraFin;
	}

	public String getT_Diagnostico() {
		return t_Diagnostico;
	}

	public void setT_Diagnostico(String t_Diagnostico) {
		this.t_Diagnostico = t_Diagnostico;
	}

	public int getT_IdEstado() {
		return t_IdEstado;
	}

	public void setT_IdEstado(int t_IdEstado) {
		this.t_IdEstado = t_IdEstado;
	}

	public clsTurno(int t_Id, int t_DniUsuario, Date t_fecha, String t_HoraInicio, String t_HoraFin,
			String t_Diagnostico, int t_IdEstado) {
		super();
		this.t_Id = t_Id;
		this.t_DniUsuario = t_DniUsuario;
		this.t_fecha = t_fecha;
		this.t_HoraInicio = t_HoraInicio;
		this.t_HoraFin = t_HoraFin;
		this.t_Diagnostico = t_Diagnostico;
		this.t_IdEstado = t_IdEstado;
	}

	
	
}
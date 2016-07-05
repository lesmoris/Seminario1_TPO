package DTOs;

import java.sql.Date;

public class MantenimientoDTO {

	private Date fechaInicio;
	private Date fechaFin;
	private String problema;
	private String solucion;
	private int idMantenimiento;
	
	public MantenimientoDTO(Date fechaInicio, Date fechaFin, String problema, String solucion, int idMantenimiento){
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.problema=problema;
		this.solucion=solucion;
		this.idMantenimiento=idMantenimiento;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getSolucion() {
		return solucion;
	}
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}
	public int getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
}

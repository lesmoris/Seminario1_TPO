package Modelo;

import java.util.Date;

public class Mantenimiento {

	private Date fechaInicio;
	private Date fechaFin;
	private String problema;
	private String solucion;
	private int idMantenimiento;
	
	public Mantenimiento(){
		Date d = new Date();
		
		fechaInicio = d;
		fechaFin = null;
	}
	
	public void cerrar(String solucion) {
		Date d = new Date();
		
		fechaFin = d;
	}
	
	public boolean estasActivo() {
		return this.getFechaFin() == null;
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

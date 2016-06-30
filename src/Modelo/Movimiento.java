package Modelo;

import java.util.Date;

public class Movimiento {

	private int idMovimiento;
	private Sucursal origen;
	private Sucursal destino;
	private Date fechaInicio;
	private Date fechaFin;

	public Movimiento() {
		Date d = new Date();
		
		fechaInicio = d;
		fechaFin = null;
	}
	
	public void cerrar() {
		Date d = new Date();
		
		fechaFin = d;
	}
	
	public boolean estasActivo() {
		return this.getFechaFin() == null;
	}
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Sucursal getOrigen() {
		return origen;
	}
	public void setOrigen(Sucursal origen) {
		this.origen = origen;
	}
	public Sucursal getDestino() {
		return destino;
	}
	public void setDestino(Sucursal destino) {
		this.destino = destino;
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
	
	
	
	
	
}

package Modelo;

import java.sql.Date;
import java.util.Calendar;

import Mappers.movimientoMapper;

public class Movimiento {

	private int idMovimiento;
	private Sucursal origen;
	private Sucursal destino;
	private Date fechaInicio;
	private Date fechaFin;

	// Constructor
	public Movimiento() {
		fechaInicio = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		fechaFin = null;
	}
	
	// Metodos
	public void cerrar() {
		fechaFin = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	}
	
	public boolean estasActivo() {
		return this.getFechaFin() == null;
	}
	
	// Manejo de BD
	public void Insert(int idVehiculo) throws Exception 
	{
		movimientoMapper.getInstance().Insert(this, idVehiculo);
	}
	
	public void Update() throws Exception
	{
		movimientoMapper.getInstance().Update(this);
	}
	
	// Getters and Setters
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

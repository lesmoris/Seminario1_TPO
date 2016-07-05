package Modelo;

import java.sql.Date;
import java.util.Calendar;

import DTOs.MantenimientoDTO;
import Mappers.mantenimientoMapper;

public class Mantenimiento {

	private Date fechaInicio;
	private Date fechaFin;
	private String problema;
	private String solucion;
	private int idMantenimiento;

	// Constructor
	public Mantenimiento() {
		fechaInicio = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());
		fechaFin = null;
	}

	// Metodos
	public void cerrar(String solucion) {
		fechaFin = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		this.solucion = solucion;
	}

	public boolean estasActivo() {
		return this.getFechaFin() == null;
	}

	// Manejo de BD
	public int Insert(int idVehiculo) throws Exception {
		return mantenimientoMapper.getInstance().Insert(this, idVehiculo);
	}

	public void Update() throws Exception {
		mantenimientoMapper.getInstance().Update(this);
	}
	
	
	public MantenimientoDTO crearVista(){
		
		MantenimientoDTO m = new MantenimientoDTO(fechaFin, fechaFin, problema, problema, idMantenimiento);
		
		return m;
	}
	
	// Getters and Setters
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

package DTOs;

import java.sql.Date;

import Modelo.Sucursal;
import Modelo.Vehiculo;

public class MantenimientoDTO {

	private Date fechaInicio;
	private Date fechaFin;
	private String problema;
	private String solucion;
	private int idMantenimiento;
	private String vehiculo;
	private String sucursal;

	public MantenimientoDTO(Date fechaInicio, Date fechaFin, String problema,
			String solucion, int idMantenimiento, String vehiculo,
			String sucursal) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.problema = problema;
		this.solucion = solucion;
		this.idMantenimiento = idMantenimiento;
		this.setVehiculo(vehiculo);
		this.setSucursal(sucursal);
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

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
}

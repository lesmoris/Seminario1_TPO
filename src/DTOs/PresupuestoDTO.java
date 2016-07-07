package DTOs;

import java.sql.Date;

import Modelo.Sucursal;
import Modelo.Vehiculo;

public class PresupuestoDTO {

	private int idPresupuesto;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEmision;
	private float importe;
	private String cliente;
	private String vehiculo;
	private String sucursalOrigen;
	private String sucursalDestino;

	public PresupuestoDTO(int idPresupuesto, Date fechaInicio, Date fechaFin,
			Date fechaEmision, float importe, String cliente, String vehiculo,
			String sucursalOrigen, String sucursalDestino) {
		super();
		this.idPresupuesto = idPresupuesto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaEmision = fechaEmision;
		this.importe = importe;
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.sucursalOrigen = sucursalOrigen;
		this.sucursalDestino = sucursalDestino;
	}

	public int getIdPresupuesto() {
		return idPresupuesto;
	}

	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
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

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(String sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public String getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(String sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

}

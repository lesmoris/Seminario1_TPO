package Modelo;

import java.util.Date;

public class ContratoAlquiler {
	
	private int numero;
	private String estado;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEmision;
	private float importe;
	private Sucursal sucursalOrigen;
	private Sucursal sucursalDestino;
	private PresupuestoAlquiler presupuesto;
	
	// Metodos
	public boolean sosDeLaSucursalOrigenODestino (String sucOr, String sucDes) {
		return this.sucursalOrigen.getNombre().equals(sucOr) && this.sucursalDestino.getNombre().equals(sucDes);
	}
	
//	public boolean estasEnRango(Date fechaInicio, Date fechaFin) {
//		if ((fechaInicio <= this.fechaInicio <= fechaFin) && (fechaInicio<=this.fechaFin<=fechaFin))
//			if ((fechaInico.after(this.fechaInicio)) && (this.fechaInicio<=fechaFin))
//			return true;
//		return false;
//	}

	public boolean sosContrato(int numero) {
		return numero == this.numero;
	}
	
	// Getters and Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public PresupuestoAlquiler getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(PresupuestoAlquiler presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}
package DTOs;

import java.sql.Date;

import Modelo.Sucursal;
import Modelo.Vehiculo;

public class ContratoAlquilerDTO {

	private int idContratoAlquiler;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEmision;
	private float importe;
	private float punitorio;
	private String sucursalDestino;
	private PresupuestoDTO presupuesto;

	public ContratoAlquilerDTO(int idContratoAlquiler, Date fechaInicio,
			Date fechaFin, Date fechaEmision, float importe, float punitorio,
			String sucursalDestino, PresupuestoDTO presupuesto) {
		super();
		this.idContratoAlquiler = idContratoAlquiler;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaEmision = fechaEmision;
		this.importe = importe;
		this.punitorio = punitorio;
		this.sucursalDestino = sucursalDestino;
		this.presupuesto = presupuesto;
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

	public float getPunitorio() {
		return punitorio;
	}

	public void setPunitorio(float punitorio) {
		this.punitorio = punitorio;
	}

	public String getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(String sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public int getNumeroContratoAlquiler() {
		return idContratoAlquiler;
	}

	public void setNumeroContratoAlquiler(int nroContratoAlquiler) {
		this.idContratoAlquiler = nroContratoAlquiler;
	}

	public PresupuestoDTO getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(PresupuestoDTO presupuesto) {
		this.presupuesto = presupuesto;
	}
}

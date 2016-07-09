package Modelo;

import java.sql.Date;

import DTOs.ContratoAlquilerDTO;
import Mappers.contratoMapper;

public class ContratoAlquiler {

	private int numero;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaEmision;
	private float importe;
	private float punitorio;
	private Sucursal sucursalDestino;
	private PresupuestoAlquiler presupuesto;

	// Metodos
	public boolean sosContrato(int numero) {
		return numero == this.numero;
	}

	public void Insert() throws Exception {
		contratoMapper.getInstance().Insert(this);

	}

	public ContratoAlquilerDTO crearVista() {
		return new ContratoAlquilerDTO(this.numero, this.fechaInicio,
				this.fechaFin, this.fechaEmision, this.importe, this.punitorio,
				this.sucursalDestino.getNombre(), this.presupuesto.crearVista());
	}

	// Getters and Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public float getPunitorio() {
		return punitorio;
	}

	public void setPunitorio(float punitorio) {
		this.punitorio = punitorio;
	}

}
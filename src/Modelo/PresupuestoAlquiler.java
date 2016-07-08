package Modelo;

import java.sql.Date;

import DTOs.PresupuestoDTO;
import Helpers.HelperDate;
import Mappers.presupuestoMapper;

public class PresupuestoAlquiler {

	// A presupuesto le quite el atributo estado, ya que si esta vigente o no,
	// lo podemos calcular
	// comparando la fecha actual con la fecha de vencimiento
	// Y si fue aceptado o no, lo calculamos buscando si hay algun contrato que
	// se genero en base a ese presupuesto

	private int idPresupuesto;
	private Date fechaEmision;
	private Date fechaInicio;
	private Date fechaFin;
	private float importe;
	private Sucursal sucursalOrigen;
	private Sucursal sucursalDestino;
	private Date fechaVencimiento;
	private Cliente cliente;
	private Vehiculo vehiculo;

	// Metodos

	public void calcularImporte() {

		
		int cantidadDias = HelperDate.diferenciaEntreDosfechas(this.getFechaInicio(),
				this.getFechaFin()); 
		
		float precioPorDia = this.getVehiculo().getPrecioPorDia();

		float importe = precioPorDia*cantidadDias;
		
		float recargo = 0;
		
		if (!this.getSucursalDestino().sosSucursal(this.getSucursalOrigen().getNombre())) {
		recargo = (float) (importe * 0.2);	  
		importe = importe + recargo;
		}
		this.setImporte(importe);
	}

	public boolean sosDelCliente(String numero, String tipo) {

		if (this.cliente.sosCliente(numero, tipo)) {
			return true;
		}
		return false;
	}

	public boolean estasActivo() {
		// TODO: return this.FechaVencimiento.after(FECHA DEL MOMENTO DE LA
		// LLAMADA AL METODO)
		return true;
	}

	public boolean sosDeVehiculo(String dominio) {

		if (this.vehiculo.sosVehiculo(dominio))
			return true;

		return false;

	}

	public PresupuestoDTO crearVista() {
		return new PresupuestoDTO(this.idPresupuesto, this.fechaInicio,
				this.fechaFin, this.fechaEmision, this.fechaVencimiento,
				this.importe, this.cliente.getNombre(),
				this.vehiculo.getDominio(), this.sucursalOrigen.getNombre(),
				this.sucursalDestino.getNombre());
	}

	public void Insert(PresupuestoAlquiler p) throws Exception {
		presupuestoMapper.getInstance().insert(p);

	}

	// Getters y Setters
	public int getIdPresupuesto() {
		return idPresupuesto;
	}

	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		fechaVencimiento = fechaVencimiento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}

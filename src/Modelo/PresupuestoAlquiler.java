package Modelo;

import java.sql.Date;

public class PresupuestoAlquiler {

	
	// A presupuesto le quite el atributo estado, ya que si esta vigente o no, lo podemos calcular 
	// comparando la fecha actual con la fecha de vencimiento
	// Y si fue aceptado o no, lo calculamos buscando si hay algun contrato que se genero en base a ese presupuesto
	
	private int idPresupuesto;
	private Date fechaEmision;
	private Date fechaInicio;
	private float importe;
	private Sucursal sucursalOrigen;
	private Sucursal sucursalDestino;
	private Date FechaVencimiento;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	// Metodos
	public boolean sosDelCliente (String numero, String tipo){
		
		if (this.cliente.sosCliente(numero, tipo)){
			return true;
		}
		return false;
	}
	
	public boolean estasActivo (){
		  //return this.FechaVencimiento.after(FECHA DEL MOMENTO DE LA LLAMADA AL METODO) 
		return true;
	}
	
	public boolean sosSucursalOD(String sucOrigen, String sucDestino){
		
		if (this.sucursalOrigen.getNombre()==sucOrigen && this.sucursalDestino.getNombre()==sucDestino){
			return true;
		}
		return false;
	}
	
	public boolean sosDeVehiculo (String dominio){
		
		if (this.vehiculo.sosVehiculo(dominio))
			return true;
		
		return false;
		
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
		return FechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
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
}

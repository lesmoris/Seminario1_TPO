package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehiculo {

	private int idVehiculo;
	private String dominio;
	private String marca;
	private String modelo;
	private int kilometraje;
	private int cantidadPuertas;
	private String color;
	private Sucursal sucursal;
	private String tamaño;
	private String transmision;
	private String tipoCombustible;
	private boolean aireAcondicionado;
	private float precioPorDia;
	private List<Movimiento> movimientos;
	private List<Mantenimiento> mantenimientos;
	private String estado;
	
	public Vehiculo(){
		mantenimientos = new ArrayList<Mantenimiento>();
		movimientos = new ArrayList<Movimiento>();	
	}
	
	public boolean sosVehiculo(String dominio) {
		return this.dominio.equals(dominio);
	}
	
	public boolean estasDisponible() {
		return this.estado.equals("DISPONIBLE");
	}
	
	public boolean estasEnMantenimiento() {
		return this.estado.equals("ENMANTENIMIENTO");
	}
	
	public boolean estasEnMovimiento() {
		return this.estado.equals("ENMOVIMIENTO");
	}
	
	public void mover(Sucursal origen, Sucursal destino) {
		
		this.setEstado("ENMOVIMIENTO");
		
		Movimiento movimiento = new Movimiento();
		movimiento.setOrigen(origen);
		movimiento.setDestino(destino);
		
		this.movimientos.add(movimiento);
		
	}

	public void recibir(Sucursal destino) {

		Movimiento movimiento = movimientoActivo();
//		if (movimiento == null)
//			throw new Exception("Vehiclo no esta en movimiento");
		movimiento.setDestino(destino);
		movimiento.cerrar();
		
		this.setEstado("DISPONIBLE");
	}
	
	public Movimiento movimientoActivo() {
		for (Movimiento m: movimientos) {
			if (m.estasActivo())
				return m;
		}
		return null;
	}
	
	public void agregarMantenimiento (String problema){
		
		Mantenimiento mantenimiento = new Mantenimiento();
//		if (mantenimiento == null)
//			throw new Exception("Vehiclo no esta en movimiento");
		mantenimiento.setProblema(problema);
		
		this.setEstado("ENMANTENIMIENTO");
		
		this.mantenimientos.add(mantenimiento);
	}	
	
	public void cerrarMantenimiento(String solucion){

		Mantenimiento mantenimiento = mantenimientoActivo();
//		if (mantenimiento == null)
//			throw new Exception("Vehiclo no esta en mantenimiento");
		mantenimiento.cerrar(solucion);
		
		this.setEstado("DISPONIBLE");
	}
	
	public Mantenimiento mantenimientoActivo() {
		for (Mantenimiento m: mantenimientos) {
			if (m.estasActivo())
				return m;
		}
		return null;
	}
	
	// GETTERS Y SETTERS
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public int getCantidadPuertas() {
		return cantidadPuertas;
	}
	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public String getTamaño() {
		return tamaño;
	}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}
	public String getTransmision() {
		return transmision;
	}
	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstado(){
		return this.estado;
	}
	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}
	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public boolean tenesAC() {
		return this.aireAcondicionado;
	}
	public void setAC(Boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}
	public String getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	public float getPrecioPorDia() {
		return precioPorDia;
	}
	public void setPrecioPorDia(float precioPorDia) {
		this.precioPorDia = precioPorDia;
	}
}

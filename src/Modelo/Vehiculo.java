package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

	private String dominio;
	private String marca;
	private String modelo;
	private int kilometraje;
	private int cantidadPuertas;
	private String color;
	private Sucursal sucursal;
	private String tamaño;
	private String transmision;
	private boolean aireAcondicionado;
	private float precioPorDia;
	private List<Movimiento> movimientos;
	private List<Mantenimiento> mantenimientos;
	private String estado;
	
	
	// CONSTRUCTOR
	public Vehiculo(){
		
		
	mantenimientos = new ArrayList<Mantenimiento>();
	movimientos = new ArrayList<Movimiento>();	
	
	
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


	public void agregarMantenimiento (Mantenimiento m){
		
		this.mantenimientos.add(m);
		
	}



	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}






	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	
	
	
	
	
	
}

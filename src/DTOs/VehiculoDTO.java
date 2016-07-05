package DTOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Mappers.vehiculoMapper;

public class VehiculoDTO {

	private int idVehiculo;
	private String dominio;
	private String marca;
	private String modelo;
	private int kilometraje;
	private int cantidadPuertas;
	private String color;
	private String sucursal;
	private String tamaño;
	private String transmision;
	private String tipoCombustible;
	private boolean aireAcondicionado;
	private float precioPorDia;
	private String estado;

	// Constructor
	public VehiculoDTO(int idVehiculo, String dominio, String marca,
			String modelo, int kilometraje, int cantidadPuertas, String color,
			String sucursal, String tamaño, String transmision,
			String tipoCombustible, boolean aireAcondicionado,
			float precioPorDia, String estado) {
		super();
		this.idVehiculo = idVehiculo;
		this.dominio = dominio;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.cantidadPuertas = cantidadPuertas;
		this.color = color;
		this.sucursal = sucursal;
		this.tamaño = tamaño;
		this.transmision = transmision;
		this.tipoCombustible = tipoCombustible;
		this.aireAcondicionado = aireAcondicionado;
		this.precioPorDia = precioPorDia;
		this.estado = estado;
	}

	// Getters and Setters
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

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
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

	public String getEstado() {
		return this.estado;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
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

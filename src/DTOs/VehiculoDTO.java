package DTOs;

import java.util.List;

import Modelo.Mantenimiento;
import Modelo.Movimiento;
import Modelo.Sucursal;
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
	private SucursalDTO sucursal;
	private String tamaño;
	private String transmision;
	private String tipoCombustible;
	private boolean aireAcondicionado;
	private float precioPorDia;
	private List<MovimientoDTO> movimientos;
	private List<MantenimientoDTO> mantenimientos;
	private String estado;
	
	public VehiculoDTO(int idVehiculo, String dominio, String marca, String modelo, int kilometraje, int cantidadPuertas,
			String color, SucursalDTO sucursal, String tamaño, String transmision, String tipoCombustible, boolean aireAcondicionado,
			float precioPorDia, List<MovimientoDTO> movimientos, List<MantenimientoDTO> mantenimientos, String estado){
		
		this.idVehiculo=idVehiculo;
		this.dominio=dominio;
		this.marca=marca;
		this.modelo=modelo;
		this.kilometraje=kilometraje;
		this.cantidadPuertas=cantidadPuertas;
		this.color=color;
		this.sucursal=sucursal;
		this.tamaño=tamaño;
		this.transmision=transmision;
		this.tipoCombustible=tipoCombustible;
		this.aireAcondicionado=aireAcondicionado;
		this.precioPorDia=precioPorDia;
		this.movimientos=movimientos;
		this.mantenimientos=mantenimientos;
		this.estado=estado;
		
		
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

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

	public SucursalDTO getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalDTO sucursal) {
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

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public float getPrecioPorDia() {
		return precioPorDia;
	}

	public void setPrecioPorDia(float precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public List<MovimientoDTO> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoDTO> movimientos) {
		this.movimientos = movimientos;
	}

	public List<MantenimientoDTO> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<MantenimientoDTO> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}

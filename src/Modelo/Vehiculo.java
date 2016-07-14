package Modelo;

import java.util.ArrayList;
import java.util.List;

import DTOs.MantenimientoDTO;
import DTOs.VehiculoDTO;
import DTOs.MovimientoDTO;
import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Mappers.vehiculoMapper;

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

	// Constructor
	public Vehiculo() {
		mantenimientos = new ArrayList<Mantenimiento>();
		movimientos = new ArrayList<Movimiento>();
	}

	// Metodos
	public boolean sosVehiculo(String dominio) {
		return this.dominio.equals(dominio);
	}

	public boolean estasDisponible() {
		return this.estado.equals("DISPONIBLE");
	}

	public boolean estasEnMovimiento() {
		return this.estado.equals("ENMOVIMIENTO");
	}

	public boolean estasEnMantenimiento() {
		return this.estado.equals("ENMANTENIMIENTO");
	}

	public void mover(Sucursal destino) throws Exception {

		if (this.estasEnMovimiento())
			throw new Exception("Vehiclo esta en movimiento");

		if (this.sucursal.sosSucursal(destino.getNombre()))
			throw new Exception(
					"La sucursal de destino es la misma en la que el vehiculo se encuentra actualmente");

		Movimiento movimiento = new Movimiento();
		movimiento.setOrigen(this.sucursal);
		movimiento.setDestino(destino);
		movimiento.setVehiculo(this);
		movimiento.Insert(this.idVehiculo);

		this.movimientos.add(movimiento);

		this.setEstado("ENMOVIMIENTO");
		vehiculoMapper.getInstance().SetStatus(this, "ENMOVIMIENTO");
	}

	public void recibir(Sucursal destino) throws Exception {

		if (!this.estasEnMovimiento())
			throw new Exception("Vehiculo no esta en movimiento");

		Movimiento movimiento = movimientoActivo();
		movimiento.setDestino(destino);
		movimiento.cerrar();
		movimiento.Update();

		this.setEstado("DISPONIBLE");
		this.setSucursal(destino);
		vehiculoMapper.getInstance().SetStatus(this, "DISPONIBLE");
		vehiculoMapper.getInstance().UpdateSucursal(this, destino);
	}

	public int agregarMantenimiento(String problema) throws Exception {

		if (this.estasEnMantenimiento())
			throw new Exception("Vehiclo esta actualmente en mantenimiento");

		Mantenimiento mantenimiento = new Mantenimiento();
		mantenimiento.setProblema(problema);
		mantenimiento.setVehiculo(this);
		mantenimiento.setSucursal(this.sucursal);
		int id = mantenimiento.Insert(this);

		this.mantenimientos.add(mantenimiento);

		this.setEstado("ENMANTENIMIENTO");
		vehiculoMapper.getInstance().SetStatus(this, "ENMANTENIMIENTO");

		return id;
	}

	public void cerrarMantenimiento(String solucion) throws Exception {

		if (!this.estasEnMantenimiento())
			throw new Exception("Vehiculo no esta en mantenimiento");

		Mantenimiento mantenimiento = mantenimientoActivo();
		mantenimiento.cerrar(solucion);
		mantenimiento.Update();

		this.setEstado("DISPONIBLE");
		vehiculoMapper.getInstance().SetStatus(this, "DISPONIBLE");
	}

	public Movimiento movimientoActivo() {
		for (Movimiento m : movimientos) {
			if (m.estasActivo())
				return m;
		}
		return null;
	}

	public Mantenimiento mantenimientoActivo() {
		for (Mantenimiento m : mantenimientos) {
			if (m.estasActivo())
				return m;
		}
		return null;
	}

	public void alquilar() throws Exception {

		// Setear el estado del vehiculo a ENALQUILER

		this.setEstado("ENALQUILER");
		vehiculoMapper.getInstance().SetStatus(this, "ENALQUILER");

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

	public String getEstado() {
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

	public VehiculoDTO crearVista() {

		List<MovimientoDTO> movimientosDTO = new ArrayList<MovimientoDTO>();
		for (Movimiento m : this.movimientos) {
			movimientosDTO.add(m.crearVista());
		}

		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();
		for (Mantenimiento m : this.mantenimientos) {
			mantenimientosDTO.add(m.crearVista());
		}

		VehiculoDTO v = new VehiculoDTO(idVehiculo, dominio, marca, modelo,
				kilometraje, cantidadPuertas, color, sucursal.crearVista(),
				tamaño, transmision, tipoCombustible, aireAcondicionado,
				precioPorDia, movimientosDTO, mantenimientosDTO, estado);

		return v;
	}

	public void ponerDisponibleEnSucursal(Sucursal sucDestino) throws Exception {
		
		this.setEstado("DISPONIBLE");
		vehiculoMapper.getInstance().SetStatus(this, "DISPONIBLE");
		vehiculoMapper.getInstance().UpdateSucursal(this, sucDestino);
		
	}
}

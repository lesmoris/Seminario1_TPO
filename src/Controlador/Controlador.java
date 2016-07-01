package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mappers.clienteMapper;
import Mappers.contratoMapper;
import Mappers.presupuestoMapper;
import Mappers.sucursalMapper;
import Mappers.vehiculoMapper;
import Modelo.Cliente;
import Modelo.ContratoAlquiler;
import Modelo.PresupuestoAlquiler;
import Modelo.Sucursal;
import Modelo.Vehiculo;

//PRUEBA GIT
//XXX
public class Controlador {

	public static Controlador instancia;
	public List<Vehiculo> vehiculos;
	public List<Cliente> clientes;
	public List<Sucursal> sucursales;
	public List<ContratoAlquiler> contratosAlquiler;
	public List<PresupuestoAlquiler> presupuestosAlquiler;

	// CONSTRUCTOR
	public Controlador() {

		instancia = this;

		vehiculos = new ArrayList<Vehiculo>();
		clientes = new ArrayList<Cliente>();
		contratosAlquiler = new ArrayList<ContratoAlquiler>();
		presupuestosAlquiler = new ArrayList<PresupuestoAlquiler>();

	}

	// SINGLETON
	public static Controlador getInstance() {

		if (instancia == null)
			instancia = new Controlador();

		return instancia;

	}

	public Vehiculo buscarVehiculo(String dominio) {

		for (Vehiculo v : vehiculos) {
			if (v.sosVehiculo(dominio))
				return v;
		}

		Vehiculo vehiculo = vehiculoMapper.getInstance().Select(dominio);

		if (vehiculo != null)
			vehiculos.add(vehiculo);

		return vehiculo;
	}

	public ContratoAlquiler buscarContrato(int numeroContrato) {

		for (ContratoAlquiler c : contratosAlquiler) {
			if (c.sosContrato(numeroContrato))
				return c;
		}

		ContratoAlquiler contrato = contratoMapper.getInstance().Select(
				numeroContrato);

		if (contrato != null)
			contratosAlquiler.add(contrato);

		return contrato;
	}

	public Cliente buscarCliente(String dni, String tipodoc) {

		for (Cliente c : this.clientes) {
			if (c.sosCliente(dni, tipodoc)) {
				return c;
			}
		}

		Cliente cliente = clienteMapper.getInstance().SelectCliente(dni,
				tipodoc);

		if (cliente != null) {
			clientes.add(cliente);
		}

		return cliente;
	}

	public Sucursal buscarSucursal(String nombreSucursal) {
		for (Sucursal s : this.sucursales) {
			if (s.sosSucursal(nombreSucursal)) {
				return s;
			}
		}

		Sucursal sucursal = sucursalMapper.getInstance().Select(nombreSucursal);

		if (sucursal != null) {
			sucursales.add(sucursal);
		}

		return sucursal;

	}

	public boolean moverVehiculo(String sucursalOrigen, String sucursalDestino,
			String dominioVehiculo) {

		Sucursal sucOrigen = buscarSucursal(sucursalOrigen);
		Sucursal sucDestino = buscarSucursal(sucursalDestino);
		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);

		if (vehiculo.estasDisponible()) {
			vehiculo.mover(sucOrigen, sucDestino);
			return true;
		} else
			return false;
	}

	public boolean recibirVehiculo(String sucursalDestino,
			String dominioVehiculo) {

		Sucursal sucDestino = buscarSucursal(sucursalDestino);
		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);

		if (vehiculo.estasEnMovimiento()) {
			vehiculo.recibir(sucDestino);
			return true;
		} else
			return false;
	}

	public boolean solicitarMantenimiento(String dominioVehiculo,
			String problema) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);
		if (vehiculo.estasDisponible()) {
			vehiculo.agregarMantenimiento(problema);
			return true;
		} else
			return false;
	}

	public boolean cerrarMantenimiento(String dominioVehiculo, String solucion) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);
		if (vehiculo.estasDisponible()) {
			vehiculo.cerrarMantenimiento(solucion);
			return true;
		} else
			return false;
	}

	public PresupuestoAlquiler buscarPresupuesto(int idPresupuesto)
			throws SQLException {

		for (PresupuestoAlquiler pa : this.presupuestosAlquiler) {

			if (pa.getIdPresupuesto() == idPresupuesto) {
				return pa;
			}
		}

		PresupuestoAlquiler p = null;
		// Terminar el meotodo de SelectPresupuesto
		p = presupuestoMapper.getInstance().SelectPresupuesto(idPresupuesto);

		if (p != null)
			presupuestosAlquiler.add(p);
			
		return p; 
	}

	public List <PresupuestoAlquiler> consultaPresupuestoAlquier(String TipoDNI, String DNI){

		List<PresupuestoAlquiler> res = new ArrayList<PresupuestoAlquiler>();
		Cliente cli;

		// Busco cliente

		cli = this.buscarCliente(DNI, TipoDNI);

		// Cliente existe?
		if (cli != null) {

			// Falta
			for (PresupuestoAlquiler pa : this.presupuestosAlquiler){

				if (pa.getCliente()==cli && pa.estasActivo()){
					res.add(pa);
				}		
			
		}
		return res;
	}
		return null;
}
	public List<Vehiculo> buscarVehiculosPorDetalle(String marca,
			String modelo, String color, int cantPuertas, String tamano,
			String tipoTrans, boolean ac) {

		// Agrego al cache todos los vehiculos

		// this.vehiculos = vehiculoMapper.getInstance().SelectAll();

		List<Vehiculo> vehiculosReporte = new ArrayList<Vehiculo>();

		for (Vehiculo v : vehiculos) {
			if (v.cumplisCondiciones(marca, modelo, color, cantPuertas, tamano,
					tipoTrans, ac))
				vehiculosReporte.add(v);
		}

		return vehiculosReporte;
	}
	
	

}

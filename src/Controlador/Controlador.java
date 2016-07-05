package Controlador;

import java.util.ArrayList;
import java.util.List;

import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetVehiculo;
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

public class Controlador {

	private static Controlador instancia;
	private List<Vehiculo> vehiculos;
	private List<Cliente> clientes;
	private List<Sucursal> sucursales;
	private List<ContratoAlquiler> contratosAlquiler;
	private List<PresupuestoAlquiler> presupuestosAlquiler;

	// CONSTRUCTOR
	private Controlador() {

		instancia = this;

		vehiculos = new ArrayList<Vehiculo>();
		clientes = new ArrayList<Cliente>();
		contratosAlquiler = new ArrayList<ContratoAlquiler>();
		presupuestosAlquiler = new ArrayList<PresupuestoAlquiler>();
		sucursales = new ArrayList<Sucursal>();

	}

	// SINGLETON
	public static Controlador getInstance() {

		if (instancia == null)
			instancia = new Controlador();

		return instancia;

	}

	private Vehiculo buscarVehiculo(String dominio) {

		for (Vehiculo v : vehiculos) {
			if (v.sosVehiculo(dominio))
				return v;
		}

		Vehiculo vehiculo = vehiculoMapper.getInstance().Select(dominio);

		if (vehiculo != null)
			vehiculos.add(vehiculo);

		return vehiculo;
	}

	private ContratoAlquiler buscarContrato(int numeroContrato) {

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

	private Cliente buscarCliente(String dni, String tipodoc) {

		for (Cliente c : this.clientes) {
			if (c.sosCliente(dni, tipodoc)) {
				return c;
			}
		}

		Cliente cliente = clienteMapper.getInstance().Select(dni, tipodoc);

		if (cliente != null) {
			clientes.add(cliente);
		}

		return cliente;
	}

	private Sucursal buscarSucursal(String nombreSucursal) {
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

	private void actualizarSucursales() {

		this.sucursales = sucursalMapper.getInstance().SelectAll();

	}
	
	public List<VehiculoDTO> getVehiculosEnMovimiento(){
		
		List<VehiculoDTO> vehiculosEnMovimiento = new ArrayList<VehiculoDTO>();
		
		
		vehiculosEnMovimiento = vehiculoMapper.getInstance().selectAllEnMovimientoDTO();
		
		
		return vehiculosEnMovimiento;
	}

	public List<SucursalDTO> getSucursales() {

		actualizarSucursales();

		List<SucursalDTO> lista = new ArrayList<SucursalDTO>();

		for (Sucursal s : this.sucursales) {
			lista.add(s.crearVista());
		}

		return lista;
	}

	public ResultadoOperacionGetVehiculo getVehiculo(String dominio) {

		if (dominio.isEmpty())
			return new ResultadoOperacionGetVehiculo(false,
					"Elija un vehiculo, por favor", null);

		VehiculoDTO vehDTO = null;

		Vehiculo veh = buscarVehiculo(dominio);

		if (veh != null) {
			vehDTO = veh.crearVista();
			return new ResultadoOperacionGetVehiculo(true, "", vehDTO);
		}

		return new ResultadoOperacionGetVehiculo(false,
				"Vehiculo no encontrado", null);
	}

	public ResultadoOperacion moverVehiculo(String sucursalDestino,
			String dominioVehiculo) {

		if (sucursalDestino.isEmpty())
			return new ResultadoOperacion(false,
					"Elija una sucursal de destino, por favor");

		if (dominioVehiculo.isEmpty())
			return new ResultadoOperacion(false, "Elija un vehiculo, por favor");

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);
		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		Sucursal sucDestino = buscarSucursal(sucursalDestino);
		if (sucDestino == null)
			return new ResultadoOperacion(false,
					"La sucursal de destino no existe");

		if (vehiculo.estasDisponible()) {
			try {
				vehiculo.mover(sucDestino);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true,
					"Se ha generado el Movimiento del Vehiculo de dominio: "
							+ dominioVehiculo + " a la Sucursal: "
							+ sucursalDestino);
		} else
			return new ResultadoOperacion(false,
					"El Vehiculo no esta disponible para movimiento");
	}

	public ResultadoOperacion recibirVehiculo(String sucursalDestino,
			String dominioVehiculo) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);

		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		Sucursal sucDestino = buscarSucursal(sucursalDestino);

		if (sucDestino == null)
			return new ResultadoOperacion(false,
					"La sucursal de destino no existe");

		if (vehiculo.estasEnMovimiento()) {
			try {
				vehiculo.recibir(sucDestino);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true,
					"Vehiculo recibido en sucursal con exito");
		} else
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en movimiento");
	}

	public ResultadoOperacion solicitarMantenimiento(String dominioVehiculo,
			String problema) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);
		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		if (vehiculo.estasDisponible()) {
			try {
				vehiculo.agregarMantenimiento(problema);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true, "Vehiculo en mantenimiento");
		} else
			return new ResultadoOperacion(false,
					"El Vehiculo no esta disponible para mantenimiento");
	}

	public ResultadoOperacion cerrarMantenimiento(String dominioVehiculo,
			String solucion) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);

		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		if (vehiculo.estasEnMantenimiento()) {
			try {
				vehiculo.cerrarMantenimiento(solucion);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true,
					"Vehiculo devuelto de mantenimiento con exito");
		} else
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en mantenimiento");
	}

	private PresupuestoAlquiler buscarPresupuesto(int idPresupuesto) {

		for (PresupuestoAlquiler pa : this.presupuestosAlquiler) {

			if (pa.getIdPresupuesto() == idPresupuesto) {
				return pa;
			}
		}

		PresupuestoAlquiler p = null;
		// Terminar el meotodo de SelectPresupuesto
		p = presupuestoMapper.getInstance().Select(idPresupuesto);

		if (p != null)
			presupuestosAlquiler.add(p);

		return p;
	}
	
	
	
	
	
	public List<PresupuestoAlquiler> consultaPresupuestoAlquiler(
			String TipoDNI, String DNI) {

		List<PresupuestoAlquiler> res = new ArrayList<PresupuestoAlquiler>();
		Cliente cli;

		// Busco cliente

		cli = this.buscarCliente(DNI, TipoDNI);

		// Cliente existe?
		if (cli != null) {

			// Falta
			for (PresupuestoAlquiler pa : this.presupuestosAlquiler) {

				if (pa.getCliente() == cli && pa.estasActivo()) {
					res.add(pa);
				}

			}
			return res;
		}
		return null;
	}

	
	private List<Vehiculo> buscarVehiculosPorDetalle(String marca,
			String modelo, String color, int cantPuertas, String tamano,
			String tipoTrans, boolean ac) {

		// Agrego al cache todos los vehiculos

		// this.vehiculos = vehiculoMapper.getInstance().SelectAll();

		List<Vehiculo> vehiculosReporte = new ArrayList<Vehiculo>();

		for (Vehiculo v : vehiculos) { // llamar al mapper con los parametros y
										// que filtre al armar el sql
			// if (v.cumplisCondiciones(marca, modelo, color, cantPuertas,
			// tamano, tipoTrans, ac))
			// Saque este metodo, reemplazar por sql dinamico
			// vehiculosReporte.add(v);
		}

		return vehiculosReporte;
	}

}

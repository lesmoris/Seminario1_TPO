package Controlador;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import DTOs.ContratoAlquilerDTO;
import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import DTOs.PresupuestoDTO;
import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Helpers.HelperDate;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetContratos;
import Interfaces.ResultadoOperacionGetListaVehiculos;
import Interfaces.ResultadoOperacionGetPresupuestos;
import Interfaces.ResultadoOperacionGetVehiculo;
import Interfaces.ResultadoOperacionHistorialMantenimiento;
import Interfaces.ResultadoOperacionReporteAlquileres;
import Interfaces.ResultadoOperacionReporteMovimientosVehiculos;
import Mappers.clienteMapper;
import Mappers.contratoMapper;
import Mappers.mantenimientoMapper;
import Mappers.movimientoMapper;
import Mappers.presupuestoMapper;
import Mappers.sucursalMapper;
import Mappers.vehiculoMapper;
import Modelo.Cliente;
import Modelo.ContratoAlquiler;
import Modelo.Mantenimiento;
import Modelo.Movimiento;
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

	public ResultadoOperacionGetContratos buscarContratodeCliente(
			String numDoc, String tipoDoc) {

		Cliente c = buscarCliente(numDoc, tipoDoc);

		if (c == null) {
			return new ResultadoOperacionGetContratos(false,
					"No se encontro cliente", null);
		}

		List<ContratoAlquiler> lista = contratoMapper.getInstance()
				.SelectDeUnCliente(c.getIdCliente());

		List<ContratoAlquilerDTO> resultado = new ArrayList<ContratoAlquilerDTO>();

		for (ContratoAlquiler pa : lista) {

			resultado.add(pa.crearVista());

		}

		if (resultado.isEmpty()) {
			return new ResultadoOperacionGetContratos(false,
					"No hay contratos de ese cliente", null);
		}

		return new ResultadoOperacionGetContratos(true, "contratos:", resultado);

	}

	public ResultadoOperacionGetPresupuestos buscarPresupuestosDeCliente(
			String numDoc, String tipoDoc) {

		Cliente c = buscarCliente(numDoc, tipoDoc);

		if (c == null) {
			return new ResultadoOperacionGetPresupuestos(false,
					"No se encontro cliente", null);
		}

		List<PresupuestoAlquiler> lista = presupuestoMapper.getInstance()
				.SelectPresupuestosDeUnCliente(c.getIdCliente());

		List<PresupuestoDTO> resultado = new ArrayList<PresupuestoDTO>();

		for (PresupuestoAlquiler pa : lista) {

			resultado.add(pa.crearVista());
		}

		if (resultado.isEmpty()) {
			return new ResultadoOperacionGetPresupuestos(false,
					"No hay presupuestos de ese cliente", null);
		}

		return new ResultadoOperacionGetPresupuestos(true, "Presupuestos:",
				resultado);

	}

	private void actualizarVehiculoParaBusqueda(String dominio) {

		for (Vehiculo v : vehiculos) {
			if (v.sosVehiculo(dominio)) {
				vehiculos.remove(v);
				Vehiculo vehiculo = vehiculoMapper.getInstance()
						.Select(dominio);
				vehiculos.add(vehiculo);
				return;
			}
		}
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

	private PresupuestoAlquiler buscarPresupuesto(int idPresupuesto) {

		for (PresupuestoAlquiler pa : this.presupuestosAlquiler) {

			if (pa.getIdPresupuesto() == idPresupuesto) {
				return pa;
			}
		}

		PresupuestoAlquiler p = presupuestoMapper.getInstance().Select(
				idPresupuesto);

		if (p != null)
			presupuestosAlquiler.add(p);

		return p;
	}

	private void actualizarSucursales() {

		this.sucursales = sucursalMapper.getInstance().SelectAll();

	}

	public List<MovimientoDTO> getMovimientosEnCurso() {

		List<Movimiento> movimientoEnCurso = movimientoMapper.getInstance()
				.ListMovimientosEnCurso();

		List<MovimientoDTO> movimientoEnCursoDTO = new ArrayList<MovimientoDTO>();

		for (Movimiento m : movimientoEnCurso) {
			movimientoEnCursoDTO.add(m.crearVista());
		}

		return movimientoEnCursoDTO;
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

		if (dominio.trim().isEmpty())
			return new ResultadoOperacionGetVehiculo(false,
					"Ingrese un dominio, por favor", null);

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
				actualizarVehiculoParaBusqueda(dominioVehiculo);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true,
					"Se ha generado el Movimiento del Vehiculo de dominio: "
							+ dominioVehiculo + " a la Sucursal: "
							+ sucursalDestino);
		} else if (vehiculo.estasEnMantenimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo esta mantenimiento");
		} else if (vehiculo.estasEnMovimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo ya se encuentra actualmente en movimiento");
		} else {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta disponible para movimientos");
		}
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
				actualizarVehiculoParaBusqueda(dominioVehiculo);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true,
					"Vehiculo recibido en sucursal con exito");
		} else if (vehiculo.estasEnMantenimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en movimiento, esta en mantenimiento");
		} else {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en movimiento");
		}
	}

	public ResultadoOperacion solicitarMantenimiento(String dominioVehiculo,
			String problema) {

		int nroOrden = 0;
		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);
		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		if (problema.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Debe ingresar un problema a solucionar");

		if (vehiculo.estasDisponible()) {
			try {
				nroOrden = vehiculo.agregarMantenimiento(problema);
				actualizarVehiculoParaBusqueda(dominioVehiculo);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true, "Vehiculo " + dominioVehiculo
					+ " en mantenimiento. Nro de Orden : " + nroOrden);
		} else if (vehiculo.estasEnMovimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta disponible para mantenimiento, esta en movimiento");
		} else if (vehiculo.estasEnMantenimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo ya se encuentra actualmente en mantenimiento");
		} else {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta disponible para mantenimiento");
		}
	}

	public ResultadoOperacion cerrarMantenimiento(String dominioVehiculo,
			String solucion) {

		Vehiculo vehiculo = buscarVehiculo(dominioVehiculo);

		if (vehiculo == null)
			return new ResultadoOperacion(false, "El vehiculo no existe");

		if (solucion.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Debe ingresa una solucion al problema inicial");

		if (vehiculo.estasEnMantenimiento()) {
			try {
				vehiculo.cerrarMantenimiento(solucion);
				actualizarVehiculoParaBusqueda(dominioVehiculo);
			} catch (Exception e) {
				return new ResultadoOperacion(false, e.getMessage());
			}
			return new ResultadoOperacion(true, "Vehiculo " + dominioVehiculo
					+ " devuelto de mantenimiento con exito");
		} else if (vehiculo.estasEnMovimiento()) {
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en mantenimiento, esta en movimiento");
		} else
			return new ResultadoOperacion(false,
					"El Vehiculo no esta en mantenimiento");
	}

	public ResultadoOperacionHistorialMantenimiento historialMantenimientosPorVehiculo(
			String dominio) {

		if (dominio.trim().isEmpty())
			return new ResultadoOperacionHistorialMantenimiento(false,
					"Ingrese un dominio, por favor", null);

		List<Mantenimiento> mantenimientos = mantenimientoMapper.getInstance()
				.ListMantenimientosCerrados(dominio);

		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();

		if (mantenimientos.size() > 0) {
			for (Mantenimiento m : mantenimientos) {
				mantenimientosDTO.add(m.crearVista());
			}

			return new ResultadoOperacionHistorialMantenimiento(true, "",
					mantenimientosDTO);

		} else {
			return new ResultadoOperacionHistorialMantenimiento(
					false,
					"No hay mantenimientos efectuados para el vehiculo seleccionado",
					null);
		}
	}

	public ResultadoOperacionHistorialMantenimiento reporteMantenimientosAbiertosPorSucursal(
			String sucursal) {

		if (sucursal.trim().isEmpty())
			return new ResultadoOperacionHistorialMantenimiento(false,
					"Ingrese una sucursal, por favor", null);

		List<Mantenimiento> mantenimientos = mantenimientoMapper.getInstance()
				.ListMantenimientosAbiertos(sucursal);

		List<MantenimientoDTO> mantenimientosDTO = new ArrayList<MantenimientoDTO>();

		if (mantenimientos.size() > 0) {
			for (Mantenimiento m : mantenimientos) {
				mantenimientosDTO.add(m.crearVista());
			}

			return new ResultadoOperacionHistorialMantenimiento(true, "",
					mantenimientosDTO);

		} else {
			return new ResultadoOperacionHistorialMantenimiento(
					false,
					"No hay mantenimientos efectuados para la sucursal seleccionada",
					null);
		}
	}

	public ResultadoOperacionReporteMovimientosVehiculos generarReporteDeMovimientoDeVehiculos(
			String fechaInicioDesde, String fechaInicioHasta,
			String fechaFinDesde, String fechaFinHasta, String sucursalOrigen,
			String sucursalDestino) {

		// Valido solo que las fechas tengan sentido (Desde no puede ser mayor a
		// Hasta)

		// Validaciones
		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaInicioDesde)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha Inicio Desde no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaInicioHasta)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha Inicio Hasta no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaFinDesde)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha Fin Desde no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaFinHasta)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha Fin Hasta no es valida", null);

		try {
			if (HelperDate.diferenciaEntreDosfechas(
					HelperDate.FormateaFechaDDMMYYYY(fechaInicioDesde),
					HelperDate.FormateaFechaDDMMYYYY(fechaInicioHasta)) < 0)
				return new ResultadoOperacionReporteMovimientosVehiculos(
						false,
						"La fecha Inicio Desde no puede ser mayor a Inicio Hasta",
						null);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			if (HelperDate.diferenciaEntreDosfechas(
					HelperDate.FormateaFechaDDMMYYYY(fechaFinDesde),
					HelperDate.FormateaFechaDDMMYYYY(fechaFinHasta)) < 0)
				return new ResultadoOperacionReporteMovimientosVehiculos(
						false,
						"La fecha Inicio Desde no puede ser mayor a Inicio Hasta",
						null);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// No valido por que pueden venir vacios, ahi trae todo

		List<Movimiento> movimientos = movimientoMapper.getInstance()
				.ListMovimientos(fechaInicioDesde, fechaInicioHasta,
						fechaFinDesde, fechaFinHasta, sucursalOrigen,
						sucursalDestino);

		List<MovimientoDTO> movimientosDTO = new ArrayList<MovimientoDTO>();

		if (movimientos.size() > 0) {
			for (Movimiento m : movimientos) {
				movimientosDTO.add(m.crearVista());
			}

			return new ResultadoOperacionReporteMovimientosVehiculos(true, "",
					movimientosDTO);

		} else {
			return new ResultadoOperacionReporteMovimientosVehiculos(
					false,
					"No hay movimientos efectuados para los filtros ingresados",
					null);
		}
	}

	public ResultadoOperacionGetListaVehiculos getvehiculosFiltro(
			String sucursal, String nombre, String marca, String modelo,
			String ac, String tipoCombustible, String transmision,
			int cantPuertas, String color, String tamaño) {

		List<VehiculoDTO> listaDTO = new ArrayList<VehiculoDTO>();
		List<Vehiculo> lista = vehiculoMapper.getInstance().SelectAll(sucursal,
				nombre, marca, modelo, ac, tipoCombustible, transmision,
				cantPuertas, color, tamaño);

		if (lista.size() > 0) {
			for (Vehiculo v : lista) {
				listaDTO.add(v.crearVista());
			}

			return new ResultadoOperacionGetListaVehiculos(true, "", listaDTO);

		} else {
			return new ResultadoOperacionGetListaVehiculos(
					false,
					"No hay vehiculos disponibles para los filtros seleccionados",
					null);

		}

	}

	public ResultadoOperacion existeCliente(String tipoDoc, String numDoc) {

		if (tipoDoc.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Ingrese un tipo de documento, por favor");

		if (numDoc.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Ingrese un numero de documento, por favor");

		Cliente c = buscarCliente(numDoc, tipoDoc);

		if (c != null)
			return new ResultadoOperacion(true, "Cliente existe");
		else
			return new ResultadoOperacion(false, "Cliente inexistente");

	}

	public ResultadoOperacion generarPresupuesto(String dominio,
			String tipoDoc, String numDoc, String fechaInicio, String fechaFin,
			String sucOrigen, String sucDestino) {

		// LEO : Validacion de parametros. Si alguno falta o esta mal, tirar
		// error y que la vista lo muestre
		if (sucOrigen.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Elija una sucursal de origen, por favor");

		if (sucDestino.trim().isEmpty())
			return new ResultadoOperacion(false,
					"Elija una sucursal de destino, por favor");

		if (numDoc.trim().isEmpty())
			return new ResultadoOperacion(false, "Elija un cliente, por favor");

		if (dominio.trim().isEmpty())
			return new ResultadoOperacion(false, "Elija un vehiculo, por favor");

		if (!fechaInicio.trim().isEmpty()
				&& !HelperDate.esFechaValida(HelperDate
						.FormateaFechaDDMMYYYY(fechaInicio)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha de Inicio no es valida", null);

		if (!fechaFin.trim().isEmpty()
				&& !HelperDate.esFechaValida(HelperDate
						.FormateaFechaDDMMYYYY(fechaFin))
				&& !HelperDate.esMenorAHoy(HelperDate
						.FormateaFechaDDMMYYYY(fechaFin)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha de Fin no es valida", null);

		if (HelperDate.esMenorAHoy(HelperDate.FormateaFechaDDMMYYYY(fechaFin)))
			return new ResultadoOperacionReporteMovimientosVehiculos(false,
					"La fecha de Fin es menor a hoy", null);

		try {
			if (HelperDate.diferenciaEntreDosfechas(
					HelperDate.FormateaFechaDDMMYYYY(fechaInicio),
					HelperDate.FormateaFechaDDMMYYYY(fechaFin)) > 0)
				return new ResultadoOperacionReporteMovimientosVehiculos(false,
						"La fecha de Fin es menor a la fecha de Inicio", null);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {

			PresupuestoAlquiler p = new PresupuestoAlquiler();

			p.setCliente(buscarCliente(numDoc, tipoDoc));

			p.setFechaInicio(HelperDate.obtenerFechadeString(HelperDate
					.FormateaFechaDDMMYYYY(fechaInicio)));
			p.setFechaFin(HelperDate.obtenerFechadeString(HelperDate
					.FormateaFechaDDMMYYYY(fechaFin)));

			p.setSucursalDestino(buscarSucursal(sucDestino));
			p.setSucursalOrigen(buscarSucursal(sucOrigen));
			p.setVehiculo(buscarVehiculo(dominio));

			p.calcularImporte();

			p.Insert();

			presupuestosAlquiler.add(p);

			return new ResultadoOperacion(true, "Contrato generado con exito");
		} catch (Exception ex) {
			return new ResultadoOperacion(false, "Fallo al generar contrato : "
					+ ex.getMessage());
		}
	}

	public ResultadoOperacionReporteAlquileres generarReporteDeAlquileres(
			String fechaInicioDesde, String fechaInicioHasta,
			String fechaFinDesde, String fechaFinHasta, String sucursalorigen,
			String sucursalDestino, String tipoDoc, String nroDoc,
			String marca, String tamanio, String modelo, String transmision,
			int cantPuertas, String color, String ac, String tipoCombustible) {

		// Validaciones
		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaInicioDesde)))
			return new ResultadoOperacionReporteAlquileres(false,
					"La fecha Inicio Desde no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaInicioHasta)))
			return new ResultadoOperacionReporteAlquileres(false,
					"La fecha Inicio Hasta no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaFinDesde)))
			return new ResultadoOperacionReporteAlquileres(false,
					"La fecha Fin Desde no es valida", null);

		if (!HelperDate.esFechaValida(HelperDate
				.FormateaFechaDDMMYYYY(fechaFinHasta)))
			return new ResultadoOperacionReporteAlquileres(false,
					"La fecha Fin Hasta no es valida", null);

		try {
			if (HelperDate.diferenciaEntreDosfechas(
					HelperDate.FormateaFechaDDMMYYYY(fechaInicioDesde),
					HelperDate.FormateaFechaDDMMYYYY(fechaInicioHasta)) < 0)
				return new ResultadoOperacionReporteAlquileres(
						false,
						"La fecha Inicio Desde no puede ser mayor a Inicio Hasta",
						null);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			if (HelperDate.diferenciaEntreDosfechas(
					HelperDate.FormateaFechaDDMMYYYY(fechaFinDesde),
					HelperDate.FormateaFechaDDMMYYYY(fechaFinHasta)) < 0)
				return new ResultadoOperacionReporteAlquileres(
						false,
						"La fecha Inicio Desde no puede ser mayor a Inicio Hasta",
						null);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// El resto no lo valido por que pueden venir vacios, ahi trae todo

		List<ContratoAlquiler> alquileres = contratoMapper.getInstance()
				.SelectAll(fechaInicioDesde, fechaInicioHasta, fechaFinDesde,
						fechaFinHasta, sucursalorigen, sucursalDestino,
						tipoDoc, nroDoc, marca, tamanio, modelo, transmision,
						cantPuertas, color, ac, tipoCombustible);

		List<ContratoAlquilerDTO> alquileresDTO = new ArrayList<ContratoAlquilerDTO>();

		if (alquileres.size() > 0) {
			for (ContratoAlquiler c : alquileres) {
				alquileresDTO.add(c.crearVista());
			}

			return new ResultadoOperacionReporteAlquileres(true, "",
					alquileresDTO);

		} else {
			return new ResultadoOperacionReporteAlquileres(
					false,
					"No hay movimientos efectuados para los filtros ingresados",
					null);
		}
	}

	public ResultadoOperacion generarContratoAlquiler(int idPresupuesto) {

		// Validaciones
		PresupuestoAlquiler presupuesto = buscarPresupuesto(idPresupuesto);

		if (presupuesto == null)
			return new ResultadoOperacion(false,
					"El presupuesto indicado no existe");

		try {
			ContratoAlquiler ca = new ContratoAlquiler();

			// Ver si estos atributos los seteamos, o si los borramos y los
			// buscamos
			// desde el presupuesto asociado.
			ca.setPresupuesto(presupuesto);
			ca.setFechaInicio(ca.getPresupuesto().getFechaInicio());
			ca.setFechaFin(ca.getPresupuesto().getFechaFin());
			ca.setImporte(ca.getPresupuesto().getImporte());
			ca.setSucursalDestino(ca.getPresupuesto().getSucursalDestino());

			ca.Insert();

			ca.getPresupuesto().getVehiculo().alquilar();

			this.contratosAlquiler.add(ca);

			// REVISAR COMO HACEMOS PARA REALIZAR LOS PRESUPUESTOS QUE DESPUES
			// GENERAN CONTRATOS
			ca.getPresupuesto().realizar();

			return new ResultadoOperacion(false, "Contrato generado con exito");
		} catch (Exception ex) {
			return new ResultadoOperacion(false, "Error al generar contrato: "
					+ ex.getMessage());

		}

	}
}

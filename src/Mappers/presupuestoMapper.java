package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Helpers.DBUtils;
import Modelo.Cliente;
import Modelo.PresupuestoAlquiler;
import Modelo.Sucursal;
import Modelo.Vehiculo;

public class presupuestoMapper extends baseMapper {

	public static presupuestoMapper instancia;

	// SINGLETON
	public static presupuestoMapper getInstance() {

		if (instancia == null)
			instancia = new presupuestoMapper();

		return instancia;

	}

	public PresupuestoAlquiler Select(int idPresupuesto) throws Exception {

		Connection con = null;
		try {
			con = Conectar();

			PresupuestoAlquiler pa = null;

			String senten = "SELECT (fecha, fechaInicio, fechaFin, importe, "
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo, idpresupuesto, estado) FROM PRESUPUESTO "
					+ "WHERE idpresupuesto = ?";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idPresupuesto);

			ResultSet res = ps.executeQuery();

			while (res.next()) {

				pa = new PresupuestoAlquiler();
				pa.setIdPresupuesto(res.getInt("idpresupuesto"));
				pa.setFechaEmision(res.getDate("fecha"));
				pa.setFechaInicio(res.getDate("fechaInicio"));
				pa.setFechaVencimiento(res.getDate("fechaFin"));
				pa.setImporte(res.getFloat("importe"));

				Vehiculo v = vehiculoMapper.getInstance().SelectPORID(
						res.getInt("idvehiculo"));
				pa.setVehiculo(v);

				Cliente c = clienteMapper.getInstance().SelectClientePORID(
						res.getInt("idcliente"));
				pa.setCliente(c);

				Sucursal origen = sucursalMapper.getInstance().SelectPORID(
						res.getInt("idsucursalorigen"));
				pa.setSucursalOrigen(origen);

				Sucursal destino = sucursalMapper.getInstance().SelectPORID(
						res.getInt("idsucursaldestino"));
				pa.setSucursalDestino(destino);
			}

			return pa;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}

	}

	public List<PresupuestoAlquiler> SelectAll() throws Exception {

		Connection con = null;

		try {

			List<PresupuestoAlquiler> lista = new ArrayList<PresupuestoAlquiler>();
			con = Conectar();

			String senten = "SELECT (fecha, fechaInicio, fechaFin, importe,"
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo, idpresupuesto, estado) FROM PRESUPUESTO";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);

			ResultSet res = ps.executeQuery();

			while (res.next()) {

				PresupuestoAlquiler pa = new PresupuestoAlquiler();
				pa.setIdPresupuesto(res.getInt("idpresupuesto"));
				pa.setFechaEmision(res.getDate("fecha"));
				pa.setFechaInicio(res.getDate("fechaInicio"));
				pa.setFechaVencimiento(res.getDate("fechaFin"));
				pa.setImporte(res.getFloat("importe"));

				Vehiculo v = vehiculoMapper.getInstance().SelectPORID(
						res.getInt("idvehiculo"));
				pa.setVehiculo(v);

				Cliente c = clienteMapper.getInstance().SelectClientePORID(
						res.getInt("idcliente"));
				pa.setCliente(c);

				Sucursal origen = sucursalMapper.getInstance().SelectPORID(
						res.getInt("idsucursalorigen"));
				pa.setSucursalOrigen(origen);

				Sucursal destino = sucursalMapper.getInstance().SelectPORID(
						res.getInt("idsucursaldestino"));
				pa.setSucursalDestino(destino);

				lista.add(pa);

			}

			return lista;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}

	}

	public void insert(PresupuestoAlquiler p) throws Exception {

		Connection con = null;
		try {
			con = Conectar();

			String senten = "INSERT INTO PRESUPUESTO (fecha, fechaInicio, fechaFin, importe, "
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo) "
					+ "VALUES (?,?,?,?,?,?,?,?) ; SELECT SCOPE_IDENTITY() as idPresupuesto";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);

			// Ver que Date usar, si util o sql
			// ps.setDate(1, p.getFechaEmision());
			// ps.setDate(2, p.getFechaInicio());
			// ps.setDate(3, p.getFechaVencimiento());
			ps.setFloat(4, p.getImporte());
			ps.setInt(5, p.getCliente().getIdCliente());
			ps.setInt(6, p.getSucursalOrigen().getIdSucursal());
			ps.setInt(7, p.getSucursalDestino().getIdSucursal());
			ps.setInt(8, p.getVehiculo().getIdVehiculo());

			ps.execute();
			// Ver si este resultset funciona con el SELECT de la senten,o sino
			// hacer dos preparedStatement separados
			ResultSet resID = ps.executeQuery();

			while (resID.next()) {

				p.setIdPresupuesto(resID.getInt("idPresupuesto"));

			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}

	}
}

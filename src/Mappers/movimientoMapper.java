package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helpers.DBUtils;
import Modelo.Movimiento;
import Modelo.Vehiculo;

public class movimientoMapper extends baseMapper {

	private static movimientoMapper instancia;

	// SINGLETON
	public static movimientoMapper getInstance() {

		if (instancia == null)
			instancia = new movimientoMapper();

		return instancia;

	}

	public List<Movimiento> ListMovimientos(Vehiculo veh) {
		List<Movimiento> listMovs = new ArrayList<Movimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino FROM movimiento where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, veh.getIdVehiculo());
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Movimiento mov = new Movimiento();

				mov.setIdMovimiento(res.getInt("idMovimiento"));
				mov.setOrigen(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));
				mov.setVehiculo(veh);

				listMovs.add(mov);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listMovs;
	}

	public List<Movimiento> ListMovimientosEnCurso() {
		
		List<Movimiento> listMovs = new ArrayList<Movimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino, idVehiculo FROM movimiento where fechaFin is null ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Movimiento mov = new Movimiento();

				mov.setOrigen(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));
				mov.setVehiculo(vehiculoMapper.getInstance().SelectPorID(res.getInt("idVehiculo")));

				listMovs.add(mov);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listMovs;
	}
	
	public List<Movimiento> ListMovimientosCerrados() {
		
		List<Movimiento> listMovs = new ArrayList<Movimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino, idVehiculo FROM movimiento where fechaFin is not null ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Movimiento mov = new Movimiento();

				mov.setOrigen(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));
				mov.setVehiculo(vehiculoMapper.getInstance().SelectPorID(res.getInt("idVehiculo")));

				listMovs.add(mov);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listMovs;
	}
	
	public void Insert(Movimiento movimiento, int idVehiculo) throws Exception {

		Connection con = null;

		try {
			con = Conectar();
			con.setAutoCommit(false);

			String senten = "INSERT INTO MOVIMIENTO(fechaInicio, fechaFin, idvehiculo, idsucursalOrigen, idsucursalDestino) "
					+ "VALUES (?, ?, ?, ?, ?); ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setDate(1, movimiento.getFechaInicio());
			ps.setDate(2, movimiento.getFechaFin());
			ps.setInt(3, idVehiculo);
			ps.setInt(4, movimiento.getOrigen().getIdSucursal());
			ps.setInt(5, movimiento.getDestino().getIdSucursal());
			ps.execute();

			movimiento.setIdMovimiento(DBUtils.getLastInsertedID(con, "MOVIMIENTO"));

			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}
	}

	public void Update(Movimiento movimiento) throws Exception {

		Connection con = null;

		try {
			con = Conectar();
			con.setAutoCommit(false);

			String senten = "UPDATE MOVIMIENTO SET fechaInicio = ?, "
					+ "fechaFin = ?, idSucursalOrigen = ?, "
					+ "idSucursalDestino = ? WHERE idMovimiento = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setDate(1, movimiento.getFechaInicio());
			ps.setDate(2, movimiento.getFechaFin());
			ps.setInt(3, movimiento.getOrigen().getIdSucursal());
			ps.setInt(4, movimiento.getDestino().getIdSucursal());
			ps.setInt(5, movimiento.getIdMovimiento());
			ps.execute();

			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}
	}
}

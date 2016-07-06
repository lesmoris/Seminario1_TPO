package Mappers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helpers.DBUtils;
import Modelo.Sucursal;
import Modelo.Vehiculo;

public class vehiculoMapper extends baseMapper {

	private static vehiculoMapper instancia;

	// SINGLETON
	public static vehiculoMapper getInstance() {

		if (instancia == null)
			instancia = new vehiculoMapper();

		return instancia;

	}

	public Vehiculo SelectPorID(int idVehiculo) {

		Connection con = null;
		Vehiculo veh = null;

		try {
			con = Conectar();

			String senten = "SELECT dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño, idSucursal FROM vehiculo where idvehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veh = new Vehiculo();

				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursal")));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setAC(res.getString("aireAcondicionado").equals("S"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return veh;

	}

	public Vehiculo SelectPorIDConMovimientosYMantenimientos(int idVehiculo) {

		Vehiculo veh = this.SelectPorID(idVehiculo);
		if (veh != null) {

			veh.setMovimientos(movimientoMapper.getInstance().ListMovimientos(
					veh));
			veh.setMantenimientos(mantenimientoMapper.getInstance()
					.ListMantenimientos(idVehiculo));
		}
		return veh;

	}

	public Vehiculo Select(String dominio) {

		Connection con = null;
		Vehiculo veh = null;

		try {
			con = Conectar();

			String senten = "SELECT idVehiculo, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño, idSucursal, estado FROM vehiculo where dominio = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1, dominio);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veh = new Vehiculo();

				int idVehiculo = res.getInt("idVehiculo");

				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(dominio);
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setEstado(res.getString("estado"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursal")));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setTipoCombustible(res.getString("tipoCombustible"));
				veh.setMovimientos(movimientoMapper.getInstance()
						.ListMovimientos(veh));
				veh.setMantenimientos(mantenimientoMapper.getInstance()
						.ListMantenimientos(idVehiculo));
				veh.setAC(res.getString("aireAcondicionado").equals("S"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return veh;

	}

	public List<Vehiculo> SelectAll(int idSucursal) {

		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idvehiculo, dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño FROM vehiculo where idSucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idSucursal);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Vehiculo veh = new Vehiculo();

				int idVehiculo = res.getInt("idVehiculo");

				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
						idSucursal));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(movimientoMapper.getInstance()
						.ListMovimientos(veh));
				veh.setMantenimientos(mantenimientoMapper.getInstance()
						.ListMantenimientos(idVehiculo));
				veh.setAC(res.getString("aireAcondicionado").equals("S"));
				
				listavehiculos.add(veh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listavehiculos;
	}

	public void SetStatus(Vehiculo vehiculo, String estado) throws Exception {
		Connection con = null;
		try {

			con = Conectar();
			String senten = " UPDATE VEHICULO SET estado = ? "
					+ "  WHERE idVehiculo = ? ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1, estado);
			ps.setInt(2, vehiculo.getIdVehiculo());
			ps.execute();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}
	}

	public void UpdateSucursal(Vehiculo vehiculo, Sucursal sucursal)
			throws Exception {
		Connection con = null;
		try {

			con = Conectar();
			String senten = " UPDATE VEHICULO SET idSucursal = ? "
					+ "  WHERE idVehiculo = ? ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, sucursal.getIdSucursal());
			ps.setInt(2, vehiculo.getIdVehiculo());
			ps.execute();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}
	}

	public List<Vehiculo> SelectAll(String sucursal, String nombre,
			String marca, String modelo, String ac, String tipoCombustible,
			String transmision, int cantPuertas, String color, String tamaño) {
		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;

		try {
			con = Conectar();

			String SP_ListVehiculos = "{call SP_ListVehiculos(?,?,?,?,?,?,?,?,?)}";
			CallableStatement callableStatement = con.prepareCall(SP_ListVehiculos);
			callableStatement.setString(1, sucursal);
			callableStatement.setString(2, marca != null && !marca.trim().isEmpty() ? marca : null);
			callableStatement.setString(3, modelo != null && !modelo.trim().isEmpty() ? modelo : null);
			callableStatement.setString(4, ac != null && !ac.trim().isEmpty() ? ac : null);
			callableStatement.setString(5, tipoCombustible != null && !tipoCombustible.trim().isEmpty() ? tipoCombustible : null);
			callableStatement.setString(6, transmision != null && !transmision.trim().isEmpty() ? transmision : null);
			callableStatement.setInt(7, cantPuertas);
			callableStatement.setString(8, color != null && !color.trim().isEmpty() ? color : null);
			callableStatement.setString(9, tamaño != null && !tamaño.trim().isEmpty() ? tamaño : null);
			
			ResultSet res = callableStatement.executeQuery();
			
			while (res.next()) {
				Vehiculo veh = new Vehiculo();

				int idVehiculo = res.getInt("idVehiculo");

				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setTipoCombustible(res.getString("tipoCombustible"));
				veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursal")));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setEstado(res.getString("estado"));
				veh.setPrecioPorDia(res.getFloat("precioPorDia"));
				veh.setAC(res.getString("aireAcondicionado").equals("S"));
				
				listavehiculos.add(veh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listavehiculos;
	}
}

package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTOs.VehiculoDTO;
import Helpers.DBUtils;
import Modelo.Mantenimiento;
import Modelo.Movimiento;
import Modelo.Vehiculo;

public class vehiculoMapper extends baseMapper {

	private static vehiculoMapper instancia;

	// SINGLETON
	public static vehiculoMapper getInstance() {

		if (instancia == null)
			instancia = new vehiculoMapper();

		return instancia;

	}

	public Vehiculo SelectPORID(int idVehiculo) {

		Connection con = null;
		Vehiculo veh = null;

		try {
			con = Conectar();

			String senten = "SELECT idVehiculo, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño, idSucursal FROM vehiculo where idvehiculo = ?";
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
				veh.setMovimientos(movimientoMapper.ListMovimientos(idVehiculo));
				veh.setMantenimientos(mantenimientoMapper.ListMantenimientos(idVehiculo));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeQuietly(con);
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
				veh.setMovimientos(movimientoMapper.ListMovimientos(idVehiculo));
				veh.setMantenimientos(mantenimientoMapper.ListMantenimientos(idVehiculo));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
				veh.setMovimientos(movimientoMapper.ListMovimientos(idVehiculo));
				veh.setMantenimientos(mantenimientoMapper.ListMantenimientos(idVehiculo));

				listavehiculos.add(veh);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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

	public List<VehiculoDTO> selectAllEnMovimientoDTO() {
		
		List<VehiculoDTO> listavehiculos = new ArrayList<VehiculoDTO>();
		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idvehiculo, dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, idSucursal, tamaño FROM vehiculo where estado = 'ENMOVIMIENTO'";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			
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
						res.getInt("idSucursal")));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(movimientoMapper.ListMovimientos(idVehiculo));
				veh.setMantenimientos(mantenimientoMapper.ListMantenimientos(idVehiculo));

				listavehiculos.add(veh.crearVista());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listavehiculos;

		
		
	}
}

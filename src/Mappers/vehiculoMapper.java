package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public Vehiculo SelectPORID(int idVehiculo) throws Exception {

		Connection con = null;
		Vehiculo veh = null;

		try {
			con = Conectar();

			String senten = "SELECT idVehiculo, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tama�o, idSucursal FROM vehiculo where idvehiculo = ?";
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
				veh.setTama�o(res.getString("tama�o"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(this.ListMovimientos(idVehiculo));
				veh.setMantenimientos(this.ListMantenimientos(idVehiculo));
			}

			con.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		}

		finally {
			DBUtils.closeQuietly(con);
		}
		return veh;

	}

	public Vehiculo Select(String dominio) throws Exception {

		Connection con = null;
		Vehiculo veh = null;

		try {
			con = Conectar();

			String senten = "SELECT idVehiculo, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tama�o, idSucursal FROM vehiculo where dominio = ?";
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
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursal")));
				veh.setTama�o(res.getString("tama�o"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(this.ListMovimientos(idVehiculo));
				veh.setMantenimientos(this.ListMantenimientos(idVehiculo));
			}

			con.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return veh;

	}

	public List<Vehiculo> SelectAll(int idSucursal) throws Exception {

		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idvehiculo, dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tama�o FROM vehiculo where idSucursal = ?";
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
				veh.setTama�o(res.getString("tama�o"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(this.ListMovimientos(idVehiculo));
				veh.setMantenimientos(this.ListMantenimientos(idVehiculo));

				listavehiculos.add(veh);
			}

			con.close();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listavehiculos;
	}

	private List<Movimiento> ListMovimientos(int idVehiculo) throws Exception {
		List<Movimiento> listMovs = new ArrayList<Movimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino FROM movimientos where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Movimiento mov = new Movimiento();

				mov.setOrigen(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));

				listMovs.add(mov);

			}
			con.close();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listMovs;
	}

	private List<Mantenimiento> ListMantenimientos(int idVehiculo) throws Exception {
		List<Mantenimiento> listMants = new ArrayList<Mantenimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmantenimiento, fechaInicio, fechaFin, problema, solucion FROM mantenimiento where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Mantenimiento mant = new Mantenimiento();

				mant.setFechaInicio(res.getDate("fechaInicio"));
				mant.setFechaFin(res.getDate("fechaFin"));
				mant.setIdMantenimiento(res.getInt("idMantenimiento"));
				mant.setProblema(res.getString("problema"));
				mant.setSolucion(res.getString("solucion"));

				listMants.add(mant);

			}

			return listMants;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
		finally {
			DBUtils.closeQuietly(con);
		}
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

			con.close();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}
	}
}

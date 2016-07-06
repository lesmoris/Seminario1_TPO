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

public class mantenimientoMapper extends baseMapper {

	private static mantenimientoMapper instancia;
	
	// SINGLETON
	public static mantenimientoMapper getInstance(){
		
		if (instancia==null)
			instancia = new mantenimientoMapper();
		
		return instancia;
		
	}
	
	public List<Mantenimiento> ListMantenimientos(int idVehiculo) {
		List<Mantenimiento> listMants = new ArrayList<Mantenimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmantenimiento, fechaInicio, fechaFin, problema, solucion, idSucursal FROM mantenimiento where idVehiculo = ?";
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
				mant.setVehiculo(vehiculoMapper.getInstance().SelectPorID(idVehiculo));
				mant.setSucursal(sucursalMapper.getInstance().SelectPORID(res.getInt("idSucursal")));
				
				listMants.add(mant);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listMants;
	}
	
	public List<Mantenimiento> ListMantenimientosCerrados(String dominio) {
		List<Mantenimiento> listMants = new ArrayList<Mantenimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmantenimiento, fechaInicio, fechaFin, problema, solucion, m.idVehiculo, m.idSucursal FROM mantenimiento m inner join vehiculo v on v.idVehiculo = m.idVehiculo where v.dominio = ? and m.fechaFin is not null";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1, dominio);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Mantenimiento mant = new Mantenimiento();

				mant.setFechaInicio(res.getDate("fechaInicio"));
				mant.setFechaFin(res.getDate("fechaFin"));
				mant.setIdMantenimiento(res.getInt("idMantenimiento"));
				mant.setProblema(res.getString("problema"));
				mant.setSolucion(res.getString("solucion"));
				mant.setVehiculo(vehiculoMapper.getInstance().SelectPorID(res.getInt("idVehiculo")));
				mant.setSucursal(sucursalMapper.getInstance().SelectPORID(res.getInt("idSucursal")));

				listMants.add(mant);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listMants;
	}
	
	public List<Mantenimiento> ListMantenimientosAbiertos(String sucursal) {
		List<Mantenimiento> listMants = new ArrayList<Mantenimiento>();

		Connection con = null;

		try {
			con = Conectar();

			String senten = "SELECT idmantenimiento, fechaInicio, fechaFin, problema, solucion, m.idVehiculo, m.idSucursal FROM mantenimiento m inner join vehiculo v on v.idVehiculo = m.idVehiculo inner join sucursal s on s.idsucursal = m.idsucursal where s.nombre = ? and m.fechaFin is null";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setString(1, sucursal);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Mantenimiento mant = new Mantenimiento();

				mant.setFechaInicio(res.getDate("fechaInicio"));
				mant.setFechaFin(res.getDate("fechaFin"));
				mant.setIdMantenimiento(res.getInt("idMantenimiento"));
				mant.setProblema(res.getString("problema"));
				mant.setSolucion(res.getString("solucion"));
				mant.setVehiculo(vehiculoMapper.getInstance().SelectPorID(res.getInt("idVehiculo")));
				mant.setSucursal(sucursalMapper.getInstance().SelectPORID(res.getInt("idSucursal")));

				listMants.add(mant);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.closeQuietly(con);
		}
		return listMants;
	}

	public int Insert(Mantenimiento mantenimiento, Vehiculo vehiculo) throws Exception {
		
		Connection con = null;

		try {
			con = Conectar();
			con.setAutoCommit(false);
			
			String senten = "INSERT INTO MANTENIMIENTO(fechaInicio, fechaFin, idvehiculo, problema, solucion, idsucursal) "
					      + "VALUES (?, ?, ?, ?, ?, ?); ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setDate(1, mantenimiento.getFechaInicio());
			ps.setDate(2, mantenimiento.getFechaFin());
			ps.setInt(3, vehiculo.getIdVehiculo());
			ps.setString(4, mantenimiento.getProblema());
			ps.setString(5, mantenimiento.getSolucion());
			ps.setInt(6, vehiculo.getSucursal().getIdSucursal());
			ps.execute();
			
			mantenimiento.setIdMantenimiento(DBUtils.getLastInsertedID(con, "MANTENIMIENTO"));
			
			con.commit();
			
			return mantenimiento.getIdMantenimiento();

		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}
	}

	
	public void Update(Mantenimiento mantenimiento) throws Exception {
		
		Connection con = null;

		try {
			con = Conectar();
			con.setAutoCommit(false);
			
			String senten = "UPDATE MANTENIMIENTO SET "
					      + "fechaInicio = ?, "
					      + "fechaFin = ?, "
					      + "problema = ?, "
					      + "solucion = ? "
					      + "WHERE idMantenimiento = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setDate(1, mantenimiento.getFechaInicio());
			ps.setDate(2, mantenimiento.getFechaFin());
			ps.setString(3, mantenimiento.getProblema());
			ps.setString(4, mantenimiento.getSolucion());
			ps.setInt(5, mantenimiento.getIdMantenimiento());
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

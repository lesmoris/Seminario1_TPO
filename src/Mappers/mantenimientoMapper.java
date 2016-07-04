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
	
	public void Insert(Mantenimiento mantenimiento, int idVehiculo) throws Exception {
		
		Connection con = null;

		try {
			con = Conectar();
			con.setAutoCommit(false);
			
			String senten = "INSERT INTO MANTENIMIENTO(fechaInicio, fechaFin, idvehiculo, problema, solucion) "
					      + "VALUES (?, ?, ?, ?, ?); "
					      + "SELECT SCOPE_IDENTITY() as idMantenimiento";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setDate(1, mantenimiento.getFechaInicio());
			ps.setDate(2, mantenimiento.getFechaFin());
			ps.setInt(3, idVehiculo);
			ps.setString(4, mantenimiento.getProblema());
			ps.setString(5, mantenimiento.getSolucion());
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				mantenimiento.setIdMantenimiento(res.getInt("idMovimiento"));
			}
			
			con.commit();

		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
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
					      + "solucion = ?, "
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
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}
	}
}

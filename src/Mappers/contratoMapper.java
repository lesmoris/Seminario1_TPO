package Mappers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Helpers.DBUtils;
import Modelo.ContratoAlquiler;

public class contratoMapper extends baseMapper {

	private static contratoMapper instancia;

	// SINGLETON
	public static contratoMapper getInstance() {

		if (instancia == null)
			instancia = new contratoMapper();

		return instancia;

	}

	public ContratoAlquiler Select(int numeroContrato) {

		Connection con = null;
		ContratoAlquiler cont = null;

		try {
			con = Conectar();

			String senten = "SELECT idalquiler, fechainicio, fechafin, fechaemision, estado, importe, idsucursaldestino, punitorio, idPresupuesto FROM ALQUILER where numeroContrato = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, numeroContrato);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				cont = new ContratoAlquiler();

				cont.setEstado(res.getString("estado"));
				cont.setFechaInicio(res.getDate("fechaInicio"));
				cont.setFechaFin(res.getDate("fechaFin"));
				cont.setFechaEmision(res.getDate("fechaemision"));
				cont.setImporte(res.getFloat("importe"));
				cont.setNumero(res.getInt("idAlquiler"));
				cont.setSucursalDestino(sucursalMapper.getInstance()
						.SelectPORID(res.getInt("idsucursaldestino")));

			}
			con.close();
		} catch (SQLException e) {
		} finally {
			DBUtils.closeQuietly(con);
		}
		return cont;
	}
	public void insert (ContratoAlquiler cont) throws Exception {
		
		// Conectamos la BD
		Connection con = null;
		try {
			con = Conectar();
	
		
		String senten = "INSERT INTO ALQUILER (fechainicio, fechafin, fechaemision, importe, idsucursaldestino) VALUES (?,?,?,?,?) ";
		
		// PONERSE DE ACUERDO SI VAMOS A USAR SQL.DATE O UTIL.DATE
		
		PreparedStatement ps = null;
		ps = con.prepareStatement(senten);
		ps.setDate(1, (Date) cont.getFechaInicio());
		ps.setDate(2, (Date) cont.getFechaFin());
		ps.setDate(3, (Date) cont.getFechaEmision());
		ps.setFloat(4, cont.getImporte());
		ps.setInt(5, cont.getSucursalDestino().getIdSucursal());
		
		ps.execute();
		
		// Cerramos conexion a BD
		
		con.commit();
		
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}	
		
		
		
	}
	
}

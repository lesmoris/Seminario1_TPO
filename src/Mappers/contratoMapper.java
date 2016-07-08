package Mappers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			String senten = "SELECT idalquiler, fechainicio, fechafin, fechaemision, importe, idsucursaldestino, punitorio, idPresupuesto FROM ALQUILER where numeroContrato = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, numeroContrato);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				cont = new ContratoAlquiler();

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
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return cont;
	}

	public void insert(ContratoAlquiler cont) throws Exception {

		// Conectamos la BD
		Connection con = null;
		try {
			con = Conectar();

			con.setAutoCommit(false);
			
			String senten = "INSERT INTO ALQUILER (fechainicio, fechafin, fechaemision, importe, idsucursaldestino) VALUES (?,?,?,?,?) ";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setDate(1, (Date) cont.getFechaInicio());
			ps.setDate(2, (Date) cont.getFechaFin());
			ps.setDate(3, (Date) cont.getFechaEmision());
			ps.setFloat(4, cont.getImporte());
			ps.setInt(5, cont.getSucursalDestino().getIdSucursal());

			ps.execute();
			
			con.commit();

			
			
			cont.setNumero(DBUtils.getLastInsertedID(con, "ALQUILER"));
			
		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}

	}

	public List<ContratoAlquiler> SelectAll(String fechaInicioDesde,
			String fechaInicioHasta, String fechaFinDesde,
			String fechaFinHasta, String sucursalOrigen,
			String sucursalDestino, String tipoDoc, String nroDoc,
			String marca, String tamanio, String modelo, String transmision,
			int cantPuertas, String color, String ac, String tipoCombustible) {

		List<ContratoAlquiler> listaContratos = new ArrayList<ContratoAlquiler>();
		Connection con = null;

		try {
			con = Conectar();

			String SP_ListAlquileres = "{call SP_ListAlquileres(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )}";
			CallableStatement callableStatement = con
					.prepareCall(SP_ListAlquileres);

			callableStatement.setString(1,
					!fechaInicioDesde.trim().isEmpty() ? fechaInicioDesde
							: null);
			callableStatement.setString(2,
					!fechaInicioHasta.trim().isEmpty() ? fechaInicioHasta
							: null);
			callableStatement.setString(3,
					!fechaFinDesde.trim().isEmpty() ? fechaFinDesde : null);
			callableStatement.setString(4,
					!fechaFinHasta.trim().isEmpty() ? fechaFinHasta : null);
			callableStatement.setString(5,
					!sucursalOrigen.trim().isEmpty() ? sucursalOrigen : null);
			callableStatement.setString(6,
					!sucursalDestino.trim().isEmpty() ? sucursalDestino : null);

			callableStatement.setString(7, tipoDoc != null
					&& !tipoDoc.trim().isEmpty() ? tipoDoc : null);
			callableStatement.setString(8, nroDoc != null
					&& !nroDoc.trim().isEmpty() ? nroDoc : null);

			callableStatement.setString(9, marca != null
					&& !marca.trim().isEmpty() ? marca : null);
			callableStatement.setString(10, modelo != null
					&& !modelo.trim().isEmpty() ? modelo : null);
			callableStatement.setString(11,
					ac != null && !ac.trim().isEmpty() ? ac : null);
			callableStatement.setString(12, tipoCombustible != null
					&& !tipoCombustible.trim().isEmpty() ? tipoCombustible
					: null);
			callableStatement.setString(13, transmision != null
					&& !transmision.trim().isEmpty() ? transmision : null);
			callableStatement.setInt(14, cantPuertas);
			callableStatement.setString(15, color != null
					&& !color.trim().isEmpty() ? color : null);
			callableStatement.setString(16, tamanio != null
					&& !tamanio.trim().isEmpty() ? tamanio : null);

			ResultSet res = callableStatement.executeQuery();

			while (res.next()) {
				ContratoAlquiler cont = new ContratoAlquiler();

				cont.setNumero(res.getInt("idAlquiler"));
				cont.setFechaEmision(res.getDate("fechaEmision"));
				cont.setFechaFin(res.getDate("fechaFin"));
				cont.setFechaInicio(res.getDate("fechaInicio"));
				cont.setImporte(res.getFloat("importe"));
				cont.setPunitorio(res.getFloat("punitorio"));
				cont.setPresupuesto(presupuestoMapper.getInstance().Select(res.getInt("idPresupuesto")));
				cont.setSucursalDestino(sucursalMapper.getInstance().SelectPORID(res.getInt("idSucursalDestino")));
				
				listaContratos.add(cont);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listaContratos;
	}

}

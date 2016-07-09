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
import Helpers.HelperDate;
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

	public void Insert(ContratoAlquiler cont) throws Exception {

		// Conectamos la BD
		Connection con = null;
		try {
			con = Conectar();

			con.setAutoCommit(false);

			String senten = "INSERT INTO ALQUILER (fechainicio, fechafin, importe, "
					+ "idsucursaldestino, idPresupuesto) VALUES (?,?,?,?,?) ";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setDate(1, (Date) cont.getFechaInicio());
			ps.setDate(2, (Date) cont.getFechaFin());
			ps.setFloat(3, cont.getImporte());
			ps.setInt(4, cont.getSucursalDestino().getIdSucursal());
			ps.setInt(5, cont.getPresupuesto().getIdPresupuesto());

			ps.execute();

			cont.setNumero(DBUtils.getLastInsertedID(con, "ALQUILER"));

			senten = "SELECT fechaEmision FROM ALQUILER WHERE idAlquiler = ?";
			ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, cont.getNumero());

			ResultSet res = ps.executeQuery();

			res.next();
			cont.setFechaEmision(res.getDate("fechaEmision"));

			con.commit();

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

			callableStatement.setString(
					1,
					!fechaInicioDesde.trim().isEmpty() ? HelperDate
							.FormateaFechaYYYYMMDD(fechaInicioDesde) : null);
			callableStatement.setString(
					2,
					!fechaInicioHasta.trim().isEmpty() ? HelperDate
							.FormateaFechaYYYYMMDD(fechaInicioHasta) : null);
			callableStatement.setString(
					3,
					!fechaFinDesde.trim().isEmpty() ? HelperDate
							.FormateaFechaYYYYMMDD(fechaFinDesde) : null);
			callableStatement.setString(
					4,
					!fechaFinHasta.trim().isEmpty() ? HelperDate
							.FormateaFechaYYYYMMDD(fechaFinHasta) : null);
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
				cont.setPresupuesto(presupuestoMapper.getInstance().Select(
						res.getInt("idPresupuesto")));
				cont.setSucursalDestino(sucursalMapper.getInstance()
						.SelectPORID(res.getInt("idSucursalDestino")));

				listaContratos.add(cont);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		return listaContratos;
	}

	public List<ContratoAlquiler> SelectContratosAbiertosDeCliente(int idCliente) {

		Connection con = null;

		List<ContratoAlquiler> resultado = new ArrayList<ContratoAlquiler>();

		try {
			con = Conectar();

			String senten = "SELECT p.idPresupuesto, idCliente, idalquiler, a.fechainicio, a.fechafin, a.importe,"
					+ " a.idsucursaldestino, punitorio, a.fechaemision FROM ALQUILER a "
					+ "INNER JOIN PRESUPUESTO p on  a.idPresupuesto = p.idPresupuesto "
					+ "where p.idCliente = ? " + "and a.fechaFin is null ";

			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idCliente);

			ResultSet res = ps.executeQuery();

			while (res.next()) {

				ContratoAlquiler ca = new ContratoAlquiler();
				ca.setFechaEmision(res.getDate("fechaemision"));
				ca.setFechaFin(res.getDate("fechafin"));
				ca.setFechaInicio(res.getDate("fechainicio"));
				ca.setImporte(res.getFloat("importe"));
				ca.setNumero(res.getInt("idalquiler"));
				ca.setPunitorio(0); // REVISAR ESTO, O SI PASARLO COMO NULL EN
									// ESTE MOMENTO
				ca.setSucursalDestino(sucursalMapper.getInstance().SelectPORID(
						res.getInt("idsucursaldestino")));
				ca.setPresupuesto(presupuestoMapper.getInstance().Select(
						res.getInt("idPresupuesto")));

				resultado.add(ca);

			}

			return resultado;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}

		return null;
	}

	public void Update(ContratoAlquiler contrato) throws Exception {
		Connection con = null;
		try {

			con = Conectar();
			String senten = " UPDATE ALQUILER SET fechaFin = ?, idSucursalDestino = ?, importe = ?, punitorio = ? "
					+ "  WHERE idAlquiler = ? ";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setDate(1, (Date) contrato.getFechaFin());
			ps.setInt(2, contrato.getSucursalDestino().getIdSucursal());
			ps.setFloat(3, contrato.getImporte());
			ps.setFloat(4, contrato.getPunitorio());
			ps.setInt(5, contrato.getNumero());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw e;
		} finally {
			DBUtils.closeQuietly(con);
		}

	}

}

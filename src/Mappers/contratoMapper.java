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
import Modelo.Vehiculo;

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

		} catch (SQLException e) {
			con.rollback();
			throw new Exception(e.getMessage());
		} finally {
			DBUtils.closeQuietly(con);
		}

	}
	
	public List<ContratoAlquiler> SelectAll(String sucursal, String nombre,
				String marca, String modelo, String ac, String tipoCombustible,
				String transmision, int cantPuertas, String color, String tama�o) {
		
			List<ContratoAlquiler> listaContratos = new ArrayList<ContratoAlquiler>();
			Connection con = null;

			try {
				con = Conectar();

//				String SP_ListVehiculos = "{call SP_ListVehiculos(?,?,?,?,?,?,?,?,?)}";
//				CallableStatement callableStatement = con.prepareCall(SP_ListVehiculos);
//				callableStatement.setString(1, sucursal);
//				callableStatement.setString(2, marca != null && !marca.trim().isEmpty() ? marca : null);
//				callableStatement.setString(3, modelo != null && !modelo.trim().isEmpty() ? modelo : null);
//				callableStatement.setString(4, ac != null && !ac.trim().isEmpty() ? ac : null);
//				callableStatement.setString(5, tipoCombustible != null && !tipoCombustible.trim().isEmpty() ? tipoCombustible : null);
//				callableStatement.setString(6, transmision != null && !transmision.trim().isEmpty() ? transmision : null);
//				callableStatement.setInt(7, cantPuertas);
//				callableStatement.setString(8, color != null && !color.trim().isEmpty() ? color : null);
//				callableStatement.setString(9, tama�o != null && !tama�o.trim().isEmpty() ? tama�o : null);
				
//				ResultSet res = callableStatement.executeQuery();
				
//				while (res.next()) {
//					Contrato cont = new Contrato();

//					int idVehiculo = res.getInt("idVehiculo");
//
//					veh.setIdVehiculo(idVehiculo);
//					veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
//					veh.setColor(res.getString("color"));
//					veh.setDominio(res.getString("dominio"));
//					veh.setKilometraje(res.getInt("kilometraje"));
//					veh.setMarca(res.getString("marca"));
//					veh.setModelo(res.getString("modelo"));
//					veh.setTipoCombustible(res.getString("tipoCombustible"));
//					veh.setSucursal(sucursalMapper.getInstance().SelectPORID(
//							res.getInt("idSucursal")));
//					veh.setTama�o(res.getString("tama�o"));
//					veh.setTransmision(res.getString("transmision"));
//					veh.setEstado(res.getString("estado"));
//					veh.setPrecioPorDia(res.getFloat("precioPorDia"));
//					veh.setAC(res.getString("aireAcondicionado").equals("S"));
					
//					listaContratos.add(cont);
//				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.closeQuietly(con);
			}
			return listaContratos;
	}

}

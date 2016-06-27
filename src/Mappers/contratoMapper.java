package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controlador.Controlador;
import Modelo.ContratoAlquiler;
import Modelo.Mantenimiento;
import Modelo.Movimiento;
import Modelo.Vehiculo;

public class contratoMapper extends baseMapper {

	public static contratoMapper instancia;
	
	// SINGLETON
	public static contratoMapper getInstance(){
		
		if (instancia==null)
			instancia = new contratoMapper();
		
		return instancia;
		
	}
	
	public ContratoAlquiler Select(int numeroContrato){

		Connection con = null;
		ContratoAlquiler cont = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT idalquiler, fechainicio, fechafin, fechaemision, estado, importe, idsucursaldestino, punitorio, idPresupuesto FROM alquileres where numeroContrato = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, numeroContrato);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				cont = new ContratoAlquiler();

				cont.setEstado(res.getString("estado"));
				cont.setFechaInicio(res.getDate("fechaInicio"));
				cont.setFechaFin(res.getDate("fechaFin"));
				cont.setFechaEmision(res.getDate("fechaemision"));
				cont.setImporte(res.getFloat("fechaInicio"));
				cont.setNumero(res.getInt("idAlquiler"));
				cont.setSucursalDestino(sucursalMapper.getInstance().Select(res.getInt("idsucursaldestino")));

			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cont;
		
	}
	
}

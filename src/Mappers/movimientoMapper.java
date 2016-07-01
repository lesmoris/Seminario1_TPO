package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Mantenimiento;
import Modelo.Movimiento;
import Modelo.Vehiculo;

public class movimientoMapper extends baseMapper {

	public static movimientoMapper instancia;
	
	// SINGLETON
	public static movimientoMapper getInstance(){
		
		if (instancia==null)
			instancia = new movimientoMapper();
		
		return instancia;
		
	}
	
	public void Insert(Movimiento movimiento, int idVehiculo) {
		
		Connection con = null;

		try {
			con = Conectar();
			
			String senten = "INSERT INTO MOVIMIENTO(fechaInicio, fechaFin, idvehiculo, idsucursalOrigen, idsucursalDestino) "
					      + "VALUES (?, ?, ?, ?, ?); "
					      + "SELECT SCOPE_IDENTITY() as idMovimiento";
			PreparedStatement ps = null;
		// VER SI USAMOS SQL DATE O UTIL DATE
			ps = con.prepareStatement(senten);			
			//ps.setDate(1, movimiento.getFechaInicio());
			//ps.setDate(2, movimiento.getFechaFin());
			ps.setInt(3, idVehiculo);
			ps.setInt(4, movimiento.getOrigen().getIdSucursal());
			ps.setInt(5, movimiento.getDestino().getIdSucursal());
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				movimiento.setIdMovimiento(res.getInt("idMovimiento"));
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

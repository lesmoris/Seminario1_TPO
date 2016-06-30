package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.PresupuestoAlquiler;

public class presupuestoMapper extends baseMapper{

	public static presupuestoMapper instancia;
	
	
	
	// SINGLETON
		public static presupuestoMapper getInstance(){
			
			if (instancia==null)
				instancia = new presupuestoMapper();
			
			return instancia;
			
		}
	
		
		public PresupuestoAlquiler SelectPresupuesto(int idPresupuesto) throws SQLException{
	
			Connection con = Conectar();
			
			String senten = "SELECT (fecha, fechaInicio, fechaFin, importe, "
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo, idpresupuesto, estado) FROM PRESUPUESTO "
					+ "WHERE idpresupuesto = ?";
			
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idPresupuesto);
					
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
				PresupuestoAlquiler pa = new PresupuestoAlquiler();
				pa.setIdPresupuesto(res.getInt("idpresupuesto"));
				pa.setFechaEmision(res.getDate("fecha"));
				pa.setFechaInicio(res.getDate("fechaInicio"));
				pa.setFechaVencimiento(res.getDate("fechaFin"));
				pa.setImporte(res.getFloat("importe"));
				pa.set
				
			}
			
					
			return null;
		}
		
	
}

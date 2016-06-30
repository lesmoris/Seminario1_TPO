package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import Modelo.PresupuestoAlquiler;
import Modelo.Sucursal;
import Modelo.Vehiculo;

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
			
			PresupuestoAlquiler pa = null;
			
			String senten = "SELECT (fecha, fechaInicio, fechaFin, importe, "
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo, idpresupuesto, estado) FROM PRESUPUESTO "
					+ "WHERE idpresupuesto = ?";
			
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			ps.setInt(1, idPresupuesto);
					
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
				pa = new PresupuestoAlquiler();
				pa.setIdPresupuesto(res.getInt("idpresupuesto"));
				pa.setFechaEmision(res.getDate("fecha"));
				pa.setFechaInicio(res.getDate("fechaInicio"));
				pa.setFechaVencimiento(res.getDate("fechaFin"));
				pa.setImporte(res.getFloat("importe"));
				
				Vehiculo v = vehiculoMapper.getInstance().SelectPORID(res.getInt("idvehiculo"));
				pa.setVehiculo(v);
				
				Cliente c = clienteMapper.getInstance().SelectClientePORID(res.getInt("idcliente"));
				pa.setCliente(c);
				
				Sucursal origen = sucursalMapper.getInstance().SelectPORID(res.getInt("idsucursalorigen"));
				pa.setSucursalOrigen(origen);
				
				Sucursal destino = sucursalMapper.getInstance().SelectPORID(res.getInt("idsucursaldestino"));
				pa.setSucursalDestino(destino);
			}

		return pa;
		}
		
		public List<PresupuestoAlquiler> SelectAll() throws SQLException{
		
			List<PresupuestoAlquiler> lista = new ArrayList<PresupuestoAlquiler>();
			Connection con = Conectar();
			
			String senten = "SELECT (fecha, fechaInicio, fechaFin, importe," 
					+ "idcliente, idsucursalorigen, idsucursaldestino, idvehiculo, idpresupuesto, estado) FROM PRESUPUESTO";
			
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
				PresupuestoAlquiler pa = new PresupuestoAlquiler();
				pa.setIdPresupuesto(res.getInt("idpresupuesto"));
				pa.setFechaEmision(res.getDate("fecha"));
				pa.setFechaInicio(res.getDate("fechaInicio"));
				pa.setFechaVencimiento(res.getDate("fechaFin"));
				pa.setImporte(res.getFloat("importe"));
				
				Vehiculo v = vehiculoMapper.getInstance().SelectPORID(res.getInt("idvehiculo"));
				pa.setVehiculo(v);
				
				Cliente c = clienteMapper.getInstance().SelectClientePORID(res.getInt("idcliente"));
				pa.setCliente(c);
				
				Sucursal origen = sucursalMapper.getInstance().SelectPORID(res.getInt("idsucursalorigen"));
				pa.setSucursalOrigen(origen);
				
				Sucursal destino = sucursalMapper.getInstance().SelectPORID(res.getInt("idsucursaldestino"));
				pa.setSucursalDestino(destino);
				
				lista.add(pa);
				
			}
			
			return lista;
			
		}
		
		
	
}

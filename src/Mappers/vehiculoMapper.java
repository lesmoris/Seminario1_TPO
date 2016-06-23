package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Movimiento;
import Modelo.Vehiculo;

public class vehiculoMapper extends baseMapper {

	public List<Vehiculo> SelectAll(int idSucursal){
		
		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT idvehiculo, dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño FROM vehiculo where idSucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idSucursal);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Vehiculo veh = new Vehiculo();
				
				int idVehiculo = res.getInt("idVehiculo");
				
				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().Select(idSucursal));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(this.ListMovimientos(idVehiculo));
				
				listavehiculos.add(veh);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listavehiculos;
	}
	
	private List<Movimiento> ListMovimientos(int idVehiculo) {
		List<Movimiento> listMovs = new ArrayList<Movimiento>();
			
		Connection con = null;
		
		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino FROM movimientos where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Movimiento mov = new Movimiento();
				
				mov.setOrigen(sucursalMapper.getInstance().Select(res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().Select(res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));
				
				listMovs.add(mov);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMovs;
	}
	
	
}

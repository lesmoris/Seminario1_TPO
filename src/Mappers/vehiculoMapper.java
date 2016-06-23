package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Vehiculo;

public class vehiculoMapper extends baseMapper {

	public List<Vehiculo> SelectAll(int idSucursal){
		
		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT * FROM vehiculo where idSucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idSucursal);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Vehiculo veh = new Vehiculo();
				
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().Select(idSucursal));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
			
				listavehiculos.add(veh);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listavehiculos;
	}
	
	
}

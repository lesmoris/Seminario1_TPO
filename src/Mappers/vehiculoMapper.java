package Mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Vehiculo;

public class vehiculoMapper extends baseMapper {

	
	
	public List<Vehiculo> SelectAll(){
		
		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT * FROM vehiculos";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
		
				
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return listavehiculos;
	}
	
	
}

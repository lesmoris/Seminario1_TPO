package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import Modelo.Vehiculo;

public class clienteMapper extends baseMapper {

	
	public List<Cliente> SelectAll(){
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Connection con = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT * FROM cliente";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	
}

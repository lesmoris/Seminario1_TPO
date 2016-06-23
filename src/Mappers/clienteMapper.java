package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Cliente;

public class clienteMapper extends baseMapper{

	public static clienteMapper instancia;
	
	// SINGLETON
	public static clienteMapper getInstance(){
		
		if (instancia==null)
			instancia = new clienteMapper();
		
		return instancia;
		
	}
	
	public List<Cliente> SelectAll(){
		
		List<Cliente> listaclientes = new ArrayList<Cliente>();
		Connection con = null;
		
		

			try {
				con = Conectar();
			
			
			String senten = "SELECT idcliente,dni,tipodni,nombre,telefono,mail,direccion,estado FROM CLIENTE";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
				Cliente c = new Cliente(res.getString("nombre"), res.getString("dni"), res.getString("mail"), res.getString("direccion"), res.getString("tipodni"));
			
				listaclientes.add(c);
				
			}
			return listaclientes;
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
			return listaclientes;
			
	
			
		}
	
	
		public Cliente SelectCliente(String DNI, String tipoDoc){
			
			Cliente c = new Cliente();
			
			Connection con = null;
			PreparedStatement ps = null;
			
			String senten = "SELECT idcliente,dni,tipodni,nombre,telefono,mail,direccion,estado FROM CLIENTE WHERE tipodni = ? AND dni = ?";
			
			try {
				ps = con.prepareStatement(senten);
			
			ps.setString(1, tipoDoc);
			ps.setString(2, DNI);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				
			c = new Cliente(res.getString("nombre"), res.getString("dni"), res.getString("mail"), res.getString("direccion"), res.getString("tipodni"));
				
				
			}
			
			return c;
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
			
			
		}
	
}

	

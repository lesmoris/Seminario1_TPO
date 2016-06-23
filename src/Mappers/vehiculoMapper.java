package Mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Vehiculo;

public class vehiculoMapper {

	private String jdbc="jdbc:sqlserver://";
	private String servidor="PABLONOTE";
	private String usuario="lala123";
	private String password="123";
	private static vehiculoMapper instancia;
	
	//SINGLETON
	public static vehiculoMapper getInstance(){
		if (instancia==null)
				instancia=new vehiculoMapper();
		
		
		return instancia;
	}
	
	
	
	
	// METODO QUE DEVUELVE LA CONEXION A LA BASE DE DATOS
	public Connection Conectar() throws SQLException{
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
    String dbConnectString = jdbc + servidor; 
    Connection con = DriverManager.getConnection (dbConnectString, usuario, password);
    
    return con;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	}
	
	
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

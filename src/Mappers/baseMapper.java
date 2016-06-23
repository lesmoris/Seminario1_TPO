package Mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseMapper {
	
	private String jdbc="jdbc:sqlserver://";
	private static baseMapper instancia;
	
	//SINGLETON
	public static baseMapper getInstance(){
		if (instancia==null)
				instancia=new vehiculoMapper();
		return instancia;
	}
	
	// METODO QUE DEVUELVE LA CONEXION A LA BASE DE DATOS
	public Connection Conectar() throws SQLException{
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		    String dbConnectString = jdbc + baseMapperConfig.getServidor(); 
		    Connection con = DriverManager.getConnection (dbConnectString, baseMapperConfig.getUsuario(), baseMapperConfig.getPassword());
		    
		    return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}

package Mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseMapper {
	
	private static String jdbc="jdbc:sqlserver://";
	
	// METODO QUE DEVUELVE LA CONEXION A LA BASE DE DATOS
	public static Connection Conectar() throws SQLException{
	
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

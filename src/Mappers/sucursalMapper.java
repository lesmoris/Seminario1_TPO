package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Sucursal;

public class sucursalMapper extends baseMapper {

	private static sucursalMapper instancia;
	
	//SINGLETON
	public static sucursalMapper getInstance(){
		if (instancia == null)
				instancia = new sucursalMapper();
		return instancia;
	}
	
	public Sucursal Select(String nombre){
		
		Connection con = null;
		Sucursal suc = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT idSucursal, direccion, telefono, mail FROM sucursal where nombre = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setString(1, nombre);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				suc = new Sucursal();

				suc.setIdSucursal(res.getInt("idSucursal"));
				suc.setDireccion(res.getString("direccion"));
				suc.setNombre(nombre);
				suc.setMail(res.getString("mail"));
				suc.setTelefono(res.getString("telefono"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return suc;
	}
	
	
}

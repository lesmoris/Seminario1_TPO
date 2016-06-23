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
	
	public Sucursal Select(int idSucursal){
		
		Connection con = null;
		Sucursal suc = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT nombre, direccion, telefono, mail FROM sucursal where idSucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idSucursal);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				suc = new Sucursal();

				suc.setIdSucursal(idSucursal);
				suc.setDireccion(res.getString("direccion"));
				suc.setNombre(res.getString("nombre"));
				suc.setMail(res.getString("mail"));
				suc.setTelefono(res.getString("telefono"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return suc;
	}
	
	
}

package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Helpers.DBUtils;
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
			
			String senten = "SELECT idSucursal, nombre, direccion, telefono, mail FROM sucursal where nombre = ?";
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
		} finally {
			DBUtils.closeQuietly(con);
		}
		
		return suc;
	}
	
	
	public Sucursal SelectPORID(int idsucursal){
		
		Connection con = null;
		Sucursal suc = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT direccion, nombre, telefono, mail FROM sucursal where idsucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idsucursal);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				suc = new Sucursal();

				suc.setIdSucursal(idsucursal);
				suc.setDireccion(res.getString("direccion"));
				suc.setNombre(res.getString("nombre"));
				suc.setMail(res.getString("mail"));
				suc.setTelefono(res.getString("telefono"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		
		return suc;
	}
	
	public List<Sucursal> SelectAll(){
		
		Connection con = null;
		
		List<Sucursal> lista = new ArrayList<Sucursal>();
		
		Sucursal suc = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT idSucursal, nombre, direccion, telefono, mail FROM sucursal";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				suc = new Sucursal();

				
				
				suc.setIdSucursal(res.getInt("idSucursal"));
				suc.setDireccion(res.getString("direccion"));
				suc.setNombre(res.getString("nombre"));
				suc.setMail(res.getString("mail"));
				suc.setTelefono(res.getString("telefono"));
				
				lista.add(suc);
				
				System.out.println(suc.getNombre());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeQuietly(con);
		}
		
		return lista;
	}
	
	
	
	
}

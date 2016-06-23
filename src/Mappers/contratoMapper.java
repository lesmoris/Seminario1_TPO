package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controlador.Controlador;
import Modelo.ContratoAlquiler;
import Modelo.Mantenimiento;
import Modelo.Movimiento;
import Modelo.Vehiculo;

public class contratoMapper extends baseMapper {

	public static contratoMapper instancia;
	
	// SINGLETON
	public static contratoMapper getInstance(){
		
		if (instancia==null)
			instancia = new contratoMapper();
		
		return instancia;
		
	}
	
	public Controlador Select(int idContrato){

		Connection con = null;
		ContratoAlquiler cont = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT fechainicio, fechafin, estado, importe, idsucursaldestino, punitorio FROM vehiculo where idAlquiler = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idContrato);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				cont = new ContratoAlquiler();

				cont.setEstado(estado);
				
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cont;
		
	}
	
}

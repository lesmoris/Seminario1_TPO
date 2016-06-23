package Mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controlador.Controlador;
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
		Controlador cont = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT fechainicio, fechafin, estado, importe, idsucursaldestino, punitorio FROM vehiculo where idAlquiler = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idContrato);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				cont = new Contrato();

			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cont;
		
	}
	
	public List<Vehiculo> SelectAll(int idSucursal){
		
		List<Vehiculo> listavehiculos = new ArrayList<Vehiculo>();
		Connection con = null;
		
		try {
			con = Conectar();
			
			String senten = "SELECT idvehiculo, dominio, marca, modelo, aireAcondicionado, tipoCombustible, precioPorDia, transmision, cantidadPuertas, kilometraje, color, tamaño FROM vehiculo where idSucursal = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idSucursal);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Vehiculo veh = new Vehiculo();
				
				int idVehiculo = res.getInt("idVehiculo");
				
				veh.setIdVehiculo(idVehiculo);
				veh.setCantidadPuertas(res.getInt("cantidadPuertas"));
				veh.setColor(res.getString("color"));
				veh.setDominio(res.getString("dominio"));
				veh.setKilometraje(res.getInt("kilometraje"));
				veh.setMarca(res.getString("marca"));
				veh.setModelo(res.getString("modelo"));
				veh.setSucursal(sucursalMapper.getInstance().Select(idSucursal));
				veh.setTamaño(res.getString("tamaño"));
				veh.setTransmision(res.getString("transmision"));
				veh.setMovimientos(this.ListMovimientos(idVehiculo));
				veh.setMantenimientos(this.ListMantenimientos(idVehiculo));
				
				listavehiculos.add(veh);
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listavehiculos;
	}
	
	private List<Movimiento> ListMovimientos(int idVehiculo) {
		List<Movimiento> listMovs = new ArrayList<Movimiento>();
			
		Connection con = null;
		
		try {
			con = Conectar();

			String senten = "SELECT idmovimiento, fechaInicio, fechaFin, idsucursalOrigen, idsucursalDestino FROM movimientos where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Movimiento mov = new Movimiento();
				
				mov.setOrigen(sucursalMapper.getInstance().Select(res.getInt("idSucursalOrigen")));
				mov.setDestino(sucursalMapper.getInstance().Select(res.getInt("idSucursalDestino")));
				mov.setFechaInicio(res.getDate("fechaInicio"));
				mov.setFechaFin(res.getDate("fechaFin"));
				
				listMovs.add(mov);
				
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMovs;
	}
	
	private List<Mantenimiento> ListMantenimientos(int idVehiculo) {
		List<Mantenimiento> listMants = new ArrayList<Mantenimiento>();
			
		Connection con = null;
		
		try {
			con = Conectar();

			String senten = "SELECT idmantenimiento, fechaInicio, fechaFin, problema, solucion FROM mantenimiento where idVehiculo = ?";
			PreparedStatement ps = null;
			ps = con.prepareStatement(senten);			
			ps.setInt(1, idVehiculo);
			ResultSet res = ps.executeQuery();
			
			while (res.next()){
				Mantenimiento mant = new Mantenimiento();
				
				mant.setFechaInicio(res.getDate("fechaInicio"));
				mant.setFechaFin(res.getDate("fechaFin"));
				mant.setIdMantenimiento(res.getInt("idMantenimiento"));
				mant.setProblema(res.getString("problema"));
				mant.setSolucion(res.getString("solucion"));
				
				listMants.add(mant);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMants;
	}

}

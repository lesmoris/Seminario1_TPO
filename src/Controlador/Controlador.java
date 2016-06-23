package Controlador;

import java.util.ArrayList;
import java.util.List;

import Mappers.vehiculoMapper;
import Modelo.Cliente;
import Modelo.Vehiculo;

public class Controlador {

	public static Controlador instancia;
	public List<Vehiculo> vehiculos;
	public List<Cliente> clientes;
	
	public Controlador(){
		
		instancia = this;
		
		vehiculos = new ArrayList<Vehiculo>();
		clientes = new ArrayList<Cliente>();
	}
	
	public static Controlador getInstance(){
		
		if (instancia==null)
			instancia = new Controlador();
		
		return instancia;
		
	}
	
	Vehiculo buscarVehiculo(int idVehiculo) {
		
		for(Vehiculo v:vehiculos) {
			if (v.sosVehiculo(idVehiculo))
				return v;
		}
				
		return vehiculoMapper.getInstance().Select(idVehiculo);
	}
	
}

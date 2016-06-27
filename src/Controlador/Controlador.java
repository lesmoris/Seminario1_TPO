package Controlador;

import java.util.ArrayList;
import java.util.List;

import Mappers.contratoMapper;
import Mappers.vehiculoMapper;
import Modelo.Cliente;
import Modelo.ContratoAlquiler;
import Modelo.Vehiculo;

public class Controlador {

	public static Controlador instancia;
	public List<Vehiculo> vehiculos;
	public List<Cliente> clientes;
	public List<ContratoAlquiler> contratosAlquiler;
	
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
	
	Vehiculo buscarVehiculo(String dominio) {
		
		for(Vehiculo v:vehiculos) {
			if (v.sosVehiculo(dominio))
				return v;
		}
				
		Vehiculo vehiculo = vehiculoMapper.getInstance().Select(dominio);
		
		if (vehiculo != null)
			vehiculos.add(vehiculo);
			
		return vehiculo;
	}
	
	ContratoAlquiler buscarContrato(int numeroContrato) {
		
		for(ContratoAlquiler c:contratosAlquiler) {
			if (c.sosContrato(numeroContrato))
				return c;
		}
			
		ContratoAlquiler contrato = contratoMapper.getInstance().Select(numeroContrato);
		
		if (contrato != null)
			contratosAlquiler.add(contrato);
			
		return contrato; 
	}
	
}

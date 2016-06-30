package Controlador;

import java.util.ArrayList;
import java.util.List;

import Mappers.clienteMapper;
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
	
	// CONSTRUCTOR
	public Controlador(){
		
		instancia = this;
		
		vehiculos = new ArrayList<Vehiculo>();
		clientes = new ArrayList<Cliente>();
	}
	
	// SINGLETON
	public static Controlador getInstance(){
		
		if (instancia==null)
			instancia = new Controlador();
		
		return instancia;
		
	}
	
	public Vehiculo buscarVehiculo(String dominio) {
		
		for(Vehiculo v:vehiculos) {
			if (v.sosVehiculo(dominio))
				return v;
		}
				
		Vehiculo vehiculo = vehiculoMapper.getInstance().Select(dominio);
		
		if (vehiculo != null)
			vehiculos.add(vehiculo);
			
		return vehiculo;
	}		
	
	public ContratoAlquiler buscarContrato(int numeroContrato) {
		
		for(ContratoAlquiler c:contratosAlquiler) {
				if (c.sosContrato(numeroContrato))
					return c;
		}
		
		ContratoAlquiler contrato = contratoMapper.getInstance().Select(numeroContrato);
			
		if (contrato != null)
			contratosAlquiler.add(contrato);
			
		return contrato; 
	}
	
	public Cliente buscarCliente(String dni, String tipodoc) {
		
		for (Cliente c:this.clientes){
			if (c.sosCliente(dni, tipodoc)){
				return c;
			}
		}
	
		Cliente cliente = clienteMapper.getInstance().SelectCliente(dni, tipodoc);
	
		if (cliente != null) {
			clientes.add(cliente);
		}
		
		return cliente;
	}
}

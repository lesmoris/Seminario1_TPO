package Controlador;

import java.util.ArrayList;
import java.util.List;

import Mappers.clienteMapper;
import Modelo.Cliente;
import Modelo.Vehiculo;

public class Controlador {

	public static Controlador instancia;
	public List<Vehiculo> vehiculos;
	public List<Cliente> clientes;
	
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
	
	
	public Cliente buscarCliente(String dni, String tipodoc){
		
		for (Cliente c:this.clientes){
			if (c.soscliente(dni, tipodoc)){
				return c;
			}
		}
		return clienteMapper.getInstance().SelectCliente(dni, tipodoc);
		}
		
		
	
	
}

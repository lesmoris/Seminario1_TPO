package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mappers.clienteMapper;
import Mappers.contratoMapper;
import Mappers.presupuestoMapper;
import Mappers.vehiculoMapper;
import Modelo.Cliente;
import Modelo.ContratoAlquiler;
import Modelo.PresupuestoAlquiler;
import Modelo.Vehiculo;

public class Controlador {

	public static Controlador instancia;
	public List<Vehiculo> vehiculos;
	public List<Cliente> clientes;
	public List<ContratoAlquiler> contratosAlquiler;
	public List<PresupuestoAlquiler> presupuestosAlquiler;
	
	
	// CONSTRUCTOR
	public Controlador(){
		
		instancia = this;
		
		vehiculos = new ArrayList<Vehiculo>();
		clientes = new ArrayList<Cliente>();
		contratosAlquiler = new ArrayList<ContratoAlquiler>();
		presupuestosAlquiler = new ArrayList<PresupuestoAlquiler>();
		
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
	
	
	public PresupuestoAlquiler buscarPresupuesto (int idPresupuesto) throws SQLException{
		
		for (PresupuestoAlquiler pa : this.presupuestosAlquiler){
			
			if (pa.getIdPresupuesto()==idPresupuesto){
				return pa;
			}
			
		}
		
		PresupuestoAlquiler p = null;
				// Terminar el meotodo de SelectPresupuesto
		p = presupuestoMapper.getInstance().SelectPresupuesto(idPresupuesto);
		
		return p;
		
	
		
	}
	
	
}

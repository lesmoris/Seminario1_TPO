package Interfaces;

import java.util.List;

import DTOs.PresupuestoDTO;

public class ResultadoOperacionGetPresupuestos extends ResultadoOperacion{

	private List<PresupuestoDTO> presupuestos;
	
	public ResultadoOperacionGetPresupuestos(boolean resultado, String message, List<PresupuestoDTO> lista) {
		super(resultado, message);
		
		this.presupuestos = lista;
	}

	public List<PresupuestoDTO> getPresupuestos(){
		
		return this.presupuestos;
	}
	
	
}

package Interfaces;

import java.util.List;

import DTOs.ContratoAlquilerDTO;
import DTOs.PresupuestoDTO;

public class ResultadoOperacionGetContratos extends ResultadoOperacion {

	private List<ContratoAlquilerDTO> contratos;

	public ResultadoOperacionGetContratos(boolean resultado, String message,
			List<ContratoAlquilerDTO> contratos) {
		super(resultado, message);
		
		this.contratos=contratos;

	}

	public List<ContratoAlquilerDTO> getContratos(){
		return this.contratos;
	}
	
}

package Interfaces;

import java.util.List;

import DTOs.VehiculoDTO;

public class ResultadoOperacionGetListaVehiculos extends ResultadoOperacion {

	private List<VehiculoDTO> listasVehiculoDTO;
	
	public ResultadoOperacionGetListaVehiculos(boolean resultado, String message, List<VehiculoDTO> listasVehiculoDTO) {
		super(resultado, message);
		this.listasVehiculoDTO = listasVehiculoDTO;
	}

	public List<VehiculoDTO> getListaVehiculosDTO() {
		return listasVehiculoDTO;
	}
}

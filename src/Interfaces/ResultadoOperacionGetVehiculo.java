package Interfaces;

import DTOs.VehiculoDTO;

public class ResultadoOperacionGetVehiculo extends ResultadoOperacion {

	private VehiculoDTO vehiculoDTO;
	
	public ResultadoOperacionGetVehiculo(boolean resultado, String message, VehiculoDTO vehiculoDTO) {
		super(resultado, message);
		this.vehiculoDTO = vehiculoDTO;
	}

	public VehiculoDTO getVehiculoDTO() {
		return vehiculoDTO;
	}
}

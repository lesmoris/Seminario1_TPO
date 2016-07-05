package Interfaces;

import java.util.List;

import DTOs.MantenimientoDTO;

public class ResultadoOperacionHistorialMantenimiento extends ResultadoOperacion {

	private List<MantenimientoDTO> mantenimientosDTO;
	
	public ResultadoOperacionHistorialMantenimiento(boolean resultado, String message, List<MantenimientoDTO> mantenimientosDTO) {
		super(resultado, message);
		this.mantenimientosDTO = mantenimientosDTO;
	}

	public List<MantenimientoDTO> getMantenimientosDTO() {
		return mantenimientosDTO;
	}

	public void setMantenimientosDTO(List<MantenimientoDTO> mantenimientosDTO) {
		this.mantenimientosDTO = mantenimientosDTO;
	}
	
}

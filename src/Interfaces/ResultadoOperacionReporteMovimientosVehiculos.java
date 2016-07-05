package Interfaces;

import java.util.List;

import DTOs.MovimientoDTO;

public class ResultadoOperacionReporteMovimientosVehiculos extends ResultadoOperacion {

	private List<MovimientoDTO> movimientosDTO;
	
	public ResultadoOperacionReporteMovimientosVehiculos(boolean resultado, String message, List<MovimientoDTO> movimientosDTO) {
		super(resultado, message);
		this.setMovimientosDTO(movimientosDTO);
	}

	public List<MovimientoDTO> getMovimientosDTO() {
		return movimientosDTO;
	}

	public void setMovimientosDTO(List<MovimientoDTO> movimientosDTO) {
		this.movimientosDTO = movimientosDTO;
	}

}

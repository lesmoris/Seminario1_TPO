package Interfaces;

import java.util.List;

import DTOs.ContratoAlquilerDTO;
import DTOs.MovimientoDTO;

public class ResultadoOperacionReporteAlquileres extends ResultadoOperacion {

	private List<ContratoAlquilerDTO> alquileresDTO;
	
	public ResultadoOperacionReporteAlquileres(boolean resultado, String message, List<ContratoAlquilerDTO> alquileresDTO) {
		super(resultado, message);
		this.setAlquileresDTO(alquileresDTO);
	}

	public List<ContratoAlquilerDTO> getAlquileresDTO() {
		return alquileresDTO;
	}

	public void setAlquileresDTO(List<ContratoAlquilerDTO> alquileresDTO) {
		this.alquileresDTO = alquileresDTO;
	}

}

package Interfaces;

public class ResultadoOperacion {

	private boolean resultado;
	private String message;
	
	public ResultadoOperacion(boolean resultado, String message) {
		super();
		this.resultado = resultado;
		this.message = message;
	}
	public boolean sosExitoso() {
		return resultado == true;
	}
	public String getMessage() {
		return message;
	}
	
}

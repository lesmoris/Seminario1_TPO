package Interfaces;

public class ResultadoOperacionGenerarPresupuesto extends ResultadoOperacion{

	
	private float importe;
	
	public ResultadoOperacionGenerarPresupuesto(boolean resultado, String message, float importe) {
		super(resultado, message);

		this.importe=importe;
		
	}
	
	
	public float getImporte(){
		return this.importe;
	}

}

package Tests;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;

public class Seminario1_TPO_Tests {
	
	public static void main(String[] args) {
		
		MoverVehiculoTest_OperacionNormalSinFalla();
	}
	
	public static boolean MoverVehiculoTest_OperacionNormalSinFalla() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("SucCABA", "AMD123");
		
		if (!res.sosExitoso()) return false;  
		
		res = controlador.recibirVehiculo("SucCABA", "AMD123");
		
		if (!res.sosExitoso()) return false;
		
		return true;
	}
}

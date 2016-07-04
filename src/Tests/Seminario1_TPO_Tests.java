package Tests;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;

public class Seminario1_TPO_Tests {
	
	private static Controlador controlador = Controlador.getInstance();
	
	public static void main(String[] args) {
		
		MoverVehiculoTest_OperacionNormalSinFalla();
		EfectuarMantenimientoTest_OperacionNormalSinFalla();
	}
	
	private static boolean EfectuarMantenimientoTest_OperacionNormalSinFalla() {

		ResultadoOperacion res = controlador.solicitarMantenimiento("AMD123", "El auto no funciona. Se rompio la caja de cambios");
		
		if (!res.sosExitoso()) return false;  
		
		res = controlador.cerrarMantenimiento("AMD123", "Se le cambio la caja de cambios");
		
		if (!res.sosExitoso()) return false;
		
		return true;
	}

	public static boolean MoverVehiculoTest_OperacionNormalSinFalla() 
	{
		ResultadoOperacion res = controlador.moverVehiculo("SucCABA", "AMD123");
		
		if (!res.sosExitoso()) return false;  
		
		res = controlador.recibirVehiculo("SucCABA", "AMD123");
		
		if (!res.sosExitoso()) return false;
		
		return true;
	}
}

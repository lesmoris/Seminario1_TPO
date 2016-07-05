package Tests;

import java.util.List;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;
import Mappers.vehiculoMapper;
import Modelo.Vehiculo;

public class Seminario1_TPO_Tests {
	
	private static Controlador controlador = Controlador.getInstance();
	
	public static void main(String[] args) {
		
//		MoverVehiculoTest_OperacionNormalSinFalla();
//		EfectuarMantenimientoTest_OperacionNormalSinFalla();
		List<Vehiculo> vehiculos = vehiculoMapper.getInstance().SelectAll("SucLP", null, null, null, null, null, null, 0, null, null);
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

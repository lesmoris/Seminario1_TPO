package Tests;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;

public class Seminario1_TPO_Tests {
	
	public static void main(String[] args) {
		
		MoverVehiculoTest_OperacionNormalSinFalla();
		MoverVehiculoTest_VehiculoNoExiste();
		MoverVehiculoTest_SucursalOrigenNoExiste();
		MoverVehiculoTest_SucursalDestinoNoExiste();
		MoverVehiculoTest_VehiculoNoDisponible();
	}
	
	public static boolean MoverVehiculoTest_OperacionNormalSinFalla() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("Suc1", "Suc2", "ASD123");
		
		if (!res.sosExitoso()) return false;  
		
		controlador.recibirVehiculo("Suc2", "ASD123");
		
		if (!res.sosExitoso()) return false;
		
		return true;
	}

	public static boolean MoverVehiculoTest_VehiculoNoExiste() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("Suc1", "Suc2", "ASD123");
		
		if (res.getMessage().equals("El vehiculo no existe")) return true;
		
		return false;
	}

	public static boolean MoverVehiculoTest_SucursalOrigenNoExiste() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("Suc1", "Suc2", "ASD123");
		
		if (res.getMessage().equals("La sucursal de origen no existe")) return true;
		
		return false;
	}

	public static boolean MoverVehiculoTest_SucursalDestinoNoExiste() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("Suc1", "Suc2", "ASD123");
		
		if (res.getMessage().equals("La sucursal de destino no existe")) return true;
		
		return false;
	}

	public static boolean MoverVehiculoTest_VehiculoNoDisponible() 
	{
		Controlador controlador = Controlador.getInstance();
		
		ResultadoOperacion res = controlador.moverVehiculo("Suc1", "Suc2", "ASD123");
		
		if (res.getMessage().equals("El Vehiculo no esta disponible para movimiento")) return true;
		
		return false;
	}
}

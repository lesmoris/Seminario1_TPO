package Mappers;

import Modelo.PresupuestoAlquiler;

public class presupuestoMapper extends baseMapper{

	public static presupuestoMapper instancia;
	
	
	
	// SINGLETON
		public static presupuestoMapper getInstance(){
			
			if (instancia==null)
				instancia = new presupuestoMapper();
			
			return instancia;
			
		}
	
		
		public PresupuestoAlquiler SelectPresupuesto(int idPresupuesto){
	
			
			
			
			return null;
		}
		
	
}

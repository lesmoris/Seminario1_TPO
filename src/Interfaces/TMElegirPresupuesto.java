package Interfaces;

import java.util.List;
import java.sql.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.PresupuestoDTO;
import Helpers.HelperDate;

public class TMElegirPresupuesto implements TableModel{
	
	List<PresupuestoDTO> presupuestos;
	
	public TMElegirPresupuesto(List<PresupuestoDTO> presupuestos){
		
		this.presupuestos=presupuestos;
		
	}
	
	public void addTableModelListener(TableModelListener arg0) {

	}

	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int arg0) {
		String valor = "";

		switch (arg0) {

		case 0:{
			valor = "Id";
			break;
		}
		case 1: {
			valor = "Dominio";
			break;
		}
		case 2: {
			valor = "Sucursal Origen";
			break;
		}
		case 3: {
			valor = "Sucursal Destino";
			break;
		}
		case 4: {
			valor = "Inicio";
			break;
		}
		case 5: {
			valor = "Precio";
			break;
		}
				}
		return valor;
	}

	public int getRowCount() {
		return presupuestos.size();
	}

	public Object getValueAt(int fila, int columna) {

		PresupuestoDTO p = presupuestos.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = String.valueOf(p.getIdPresupuesto());
			break;
		}
		case 1: {
			valor = p.getVehiculo();
			break;
		}
		case 2: {
			valor = p.getSucursalOrigen();
			break;
		}
		case 3: {
			valor = p.getSucursalDestino();
			break;
		}
		case 4: {
			valor = HelperDate.obtenerStringDeDate(p.getFechaInicio());
			break;
		}
		case 5: {
			valor = String.valueOf(p.getImporte());
			break;
		}
		
		}
		return valor;

	}

	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {

	}

	public void setValueAt(Object arg0, int arg1, int arg2) {

	}

}

package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.ContratoAlquilerDTO;
import DTOs.PresupuestoDTO;
import Helpers.HelperDate;

public class TMElegirContrato implements TableModel{
	
	private List<ContratoAlquilerDTO> contratos;

	public TMElegirContrato(List<ContratoAlquilerDTO> contratos) {
		this.contratos = contratos;
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

		case 0: {
			valor = "Numero Contrato";
			break;
		}
		case 1: {
			valor = "Sucursal Origen";
			break;
		}case 2: {
			valor = "Sucursal Destino";
			break;
		}
		case 3: {
			valor = "Fecha Inicio";
			break;
		}
		case 4: {
			valor = "Cliente";
			break;
		}
		case 5: {
			valor = "Vehiculo";
			break;
		}
		
		}
		return valor;
	}

	public int getRowCount() {
		return contratos.size();
	}

	public Object getValueAt(int fila, int columna) {

		ContratoAlquilerDTO c = contratos.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = String.valueOf(c.getNumeroContratoAlquiler());
			break;
		}
		case 1: {
			valor = c.getPresupuesto().getSucursalOrigen();
			break;
		}
		case 2: {
			valor = c.getPresupuesto().getSucursalDestino();
			break;
		}
		case 3: {
			valor = c.getFechaInicio().toString();
			break;
		}
		case 4: {
			valor = c.getPresupuesto().getCliente();
			break;
		}
		case 5: {
			valor = c.getPresupuesto().getVehiculo();
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

package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import DTOs.VehiculoDTO;
import Helpers.HelperDate;
import Modelo.Vehiculo;

public class TMmantenimientosPorVehiculoTABLA implements TableModel {

	private List<MantenimientoDTO> mantenimientos;

	public TMmantenimientosPorVehiculoTABLA(List<MantenimientoDTO> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public void addTableModelListener(TableModelListener arg0) {

	}

	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int arg0) {
		String valor = "";

		switch (arg0) {

		case 0: {
			valor = "Problema";
			break;
		}
		case 1: {
			valor = "Solucion";
			break;
		}
		case 2: {
			valor = "Fecha Inicio";
			break;
		}
		case 3: {
			valor = "Fecha Finalizacion";
			break;
		}
		}
		return valor;
	}

	public int getRowCount() {
		return mantenimientos.size();
	}

	public Object getValueAt(int fila, int columna) {

		MantenimientoDTO m = mantenimientos.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = m.getProblema();
			break;
		}
		case 1: {
			valor = m.getSolucion();
			break;
		}
		case 2: {
			valor = HelperDate.obtenerStringDeDate(m.getFechaInicio());
			break;
		}
		case 3: {
			valor = HelperDate.obtenerStringDeDate(m.getFechaFin());
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

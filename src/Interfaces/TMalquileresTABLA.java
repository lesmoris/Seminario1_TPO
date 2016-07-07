package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.ContratoAlquilerDTO;
import DTOs.MovimientoDTO;

public class TMalquileresTABLA implements TableModel {

	private List<ContratoAlquilerDTO> alquileres;

	public TMalquileresTABLA(List<ContratoAlquilerDTO> alquileres) {
		this.alquileres = alquileres;
	}

	public void addTableModelListener(TableModelListener arg0) {

	}

	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int arg0) {
		String valor = "";

		switch (arg0) {

		case 0: {
			valor = "Dominio";
			break;
		}
		case 1: {
			valor = "Origen";
			break;
		}
		case 2: {
			valor = "Destino";
			break;
		}
		case 3: {
			valor = "Fecha Inicio";
			break;
		}
		case 4: {
			valor = "Fecha Finalizacion";
			break;
		}
		}
		return valor;
	}

	public int getRowCount() {
		return alquileres.size();
	}

	public Object getValueAt(int fila, int columna) {

		ContratoAlquilerDTO m = alquileres.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
//			valor = m.getDominio();
			break;
		}
		case 1: {
			break;
		}
		case 2: {
			break;
		}		
		case 3: {
			break;
		}
		case 4: {
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
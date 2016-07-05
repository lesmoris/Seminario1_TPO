package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import DTOs.VehiculoDTO;
import Modelo.Vehiculo;

public class TMmovimientosDeVehiculosTABLA implements TableModel {

	private List<MovimientoDTO> movimientos;

	public TMmovimientosDeVehiculosTABLA(List<MovimientoDTO> movimientos) {
		this.movimientos = movimientos;
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
		return movimientos.size();
	}

	public Object getValueAt(int fila, int columna) {

		MovimientoDTO m = movimientos.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = m.getDominio();
			break;
		}
		case 1: {
			valor = m.getOrigen().getNombre();
			break;
		}
		case 2: {
			valor = m.getDestino().getNombre();
			break;
		}		
		case 3: {
			valor = m.getFechaInicio().toString();
			break;
		}
		case 4: {
			valor = m.getFechaFin().toString();
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

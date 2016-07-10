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
		return 9;
	}

	public String getColumnName(int arg0) {
		String valor = "";

		switch (arg0) {

		case 0: {
			valor = "Sucursal Origen";
			break;
		}
		case 1: {
			valor = "Sucursal Destino";
			break;
		}
		case 2: {
			valor = "Fecha Inicio";
			break;
		}
		case 3: {
			valor = "Fecha Fin";
			break;
		}
		case 4: {
			valor = "Importe";
			break;
		}
		case 5: {
			valor = "Punitorio";
			break;
		}
		case 6: {
			valor = "Cliente";
			break;
		}
		case 7: {
			valor = "Vehiculo";
			break;
		}
		case 8: {
			valor = "Fecha Emision";
			break;
		}
		}
		return valor;
	}

	public int getRowCount() {
		return alquileres.size();
	}

	public Object getValueAt(int fila, int columna) {

		ContratoAlquilerDTO c = alquileres.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = c.getPresupuesto().getSucursalOrigen();
			break;
		}
		case 1: {
			valor = c.getSucursalDestino();
			break;
		}
		case 2: {
			valor = c.getFechaInicio().toString();
			break;
		}
		case 3: {
			if (c.getFechaFin()!=null){
			valor = c.getFechaFin().toString();
			}else{
				valor = " - ";
			}
			break;
		}
		case 4: {
			valor = Float.toString(c.getImporte());
			break;
		}
		case 5: {
			valor = Float.toString(c.getPunitorio());
			break;
		}
		case 6: {
			valor = c.getPresupuesto().getCliente();
			break;
		}
		case 7: {
			valor = c.getPresupuesto().getVehiculo();
			break;
		}
		case 8: {
			valor = c.getFechaEmision().toString();
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

package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.ClienteDTO;
import DTOs.VehiculoDTO;

public class TMClientes implements TableModel{
	
	private List<ClienteDTO> clientes;
	
public TMClientes(List<ClienteDTO> clientes){
		
		this.clientes=clientes;
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
			valor = "Nombre";
			break;
		}
		case 1: {
			valor = "Tipo Doc";
			break;
		}
		case 2: {
			valor = "Num Doc";
			break;
		}
		case 3: {
			valor = "Direccion";
			break;
		}
		case 4: {
			valor = "Mail";
			break;
		}
		
		}
		return valor;
	}

	public int getRowCount() {
		return clientes.size();
	}

	public Object getValueAt(int fila, int columna) {

		ClienteDTO c = clientes.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = c.getNombre();
			break;
		}
		case 1: {
			valor = c.getTipoDNI();
			break;
		}
		case 2: {
			valor = c.getDNI();
			break;
		}
		case 3: {
			valor = c.getDireccion();
			break;
		}
		case 4: {
			valor = c.getMail();
			break;
		}
		}
		return valor;

	}

	public boolean isCellEditable(int arg0, int arg1) {
		
		if (arg1==2){
			return true;
		}
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {

	}

	public void setValueAt(Object arg0, int arg1, int arg2) {

	}
	

}

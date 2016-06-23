package Interfaces;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMrecibirvehiculoTABLA implements TableModel{

	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int arg0) {
		String valor = "";
		
		switch (arg0){
		
		case 0:{ 
			valor = "Dominio";
			break;
		}
		case 1: {
			valor= "Origen";
			break;
		}
		case 2: {
			valor = "Destino";
			break;
		}
		case 3: {
			valor = "Fecha Salida";
			break;
		}
		
		}
		return valor;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

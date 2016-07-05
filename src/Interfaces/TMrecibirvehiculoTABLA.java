package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.VehiculoDTO;
import Modelo.Vehiculo;

public class TMrecibirvehiculoTABLA implements TableModel{

	private List<VehiculoDTO> vehiculos;
	
	public TMrecibirvehiculoTABLA(List<VehiculoDTO> vehiculos){
		
	this.vehiculos=vehiculos;	
		
		
	}
	
	
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return String.class;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

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
		
		
		}
		return valor;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return vehiculos.size();
	}

	public Object getValueAt(int fila, int columna) {
		
		VehiculoDTO v = vehiculos.get(fila);
		
		String valor = null;
		
		switch (columna){
		
		case 0:	{
			valor = v.getDominio();
				break;
		}
		case 1:	{
			valor = v.getSucursal().getNombre();
				break;
		}
		
		}
		return valor;
		
	}

	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

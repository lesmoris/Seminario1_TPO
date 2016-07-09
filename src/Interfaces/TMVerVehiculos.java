package Interfaces;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DTOs.VehiculoDTO;

public class TMVerVehiculos implements TableModel {

	
private List<VehiculoDTO> vehiculos;
	
	
	public TMVerVehiculos(List<VehiculoDTO> vehiculos){
		
		this.vehiculos=vehiculos;
	}
	
	public void addTableModelListener(TableModelListener arg0) {

	}

	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	public int getColumnCount() {
		return 13;
	}

	public String getColumnName(int arg0) {
		String valor = "";

		switch (arg0) {

		case 0: {
			valor = "Dominio";
			break;
		}
		case 1: {
			valor = "Marca";
			break;
		}
		case 2: {
			valor = "Modelo";
			break;
		}
		case 3: {
			valor = "Kilometraje";
			break;
		}
		case 4: {
			valor = "Cant Puertas";
			break;
		}
		case 5: {
			valor = "Color";
			break;
		}
		case 6: {
			valor = "Tamaño";
			break;
		}
		case 7: {
			valor = "Transmision";
			break;
		}
		case 8: {
			valor = "Combustible";
			break;
		}
		case 9: {
			valor = "Aire Acond";
			break;
		}
		case 10: {
			valor = "Precio por Dia";
			break;
		}
		case 11: {
			valor = "Estado";
			break;
		}
		case 12: {
			valor = "Sucursal Actual";
			break;
		}
		}
		return valor;
	}

	public int getRowCount() {
		return vehiculos.size();
	}

	public Object getValueAt(int fila, int columna) {

		VehiculoDTO v = vehiculos.get(fila);

		String valor = null;

		switch (columna) {

		case 0: {
			valor = v.getDominio();
			break;
		}
		case 1: {
			valor = v.getMarca();
			break;
		}
		case 2: {
			valor = v.getModelo();
			break;
		}
		case 3: {
			valor = String.valueOf(v.getKilometraje());
			break;
		}
		case 4: {
			valor = String.valueOf(v.getCantidadPuertas());
			break;
		}
		case 5: {
			valor = v.getColor();
			break;
		}
		case 6: {
			valor = v.getTamaño();
			break;
		}
		case 7: {
			valor = v.getTransmision();
			break;
		}
		case 8: {
			valor = v.getTipoCombustible();
			break;
		}
		case 9: {
			if (v.isAireAcondicionado())	
			valor = "SI";
			if (!v.isAireAcondicionado())
			valor ="NO";
			break;
		}
		case 10: {
			valor = String.valueOf(v.getPrecioPorDia());
			break;
		}
		case 11: {
			valor = v.getEstado();
			break;
		}
		case 12: {
			if (v.getEstado().equals("ENALQUILER")){
				valor = " - ";
				break;
			}else{
			valor = v.getSucursal().getNombre();
			}
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

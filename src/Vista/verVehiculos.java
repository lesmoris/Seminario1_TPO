package Vista;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.VehiculoDTO;
import Interfaces.TMVerVehiculos;
import Mappers.vehiculoMapper;

public class verVehiculos extends JInternalFrame {

	
	private JTable vehiculosTABLA;
	private JScrollPane scrollPane;
	private Controlador controlador;
	
	public verVehiculos() {
	
		
		this.controlador = Controlador.getInstance();
		iniciarComponentes();
		
		

		
		
	}

	private void iniciarComponentes() {

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 32, 729, 356);
		getContentPane().add(scrollPane);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		vehiculosTABLA = new JTable();
		scrollPane.setViewportView(vehiculosTABLA);
		
		TMVerVehiculos modelo = new TMVerVehiculos(controlador.getVehiculos());
		
		vehiculosTABLA.setModel(modelo);
		
		
		
	}
}

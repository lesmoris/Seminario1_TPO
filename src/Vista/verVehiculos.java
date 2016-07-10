package Vista;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.VehiculoDTO;
import Interfaces.TMVerVehiculos;
import Interfaces.crearExcel;
import Mappers.vehiculoMapper;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

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
		scrollPane.setBounds(21, 32, 729, 338);
		getContentPane().add(scrollPane);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		vehiculosTABLA = new JTable();
		scrollPane.setViewportView(vehiculosTABLA);
		
		TMVerVehiculos modelo = new TMVerVehiculos(controlador.getVehiculos());
		
		vehiculosTABLA.setModel(modelo);
		
		JButton btnExportarAExcel = new JButton("Exportar a Excel");
		btnExportarAExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					controlador.crearExcel(vehiculosTABLA, "Vehiculos");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnExportarAExcel.setBounds(31, 381, 142, 23);
		getContentPane().add(btnExportarAExcel);
		
		
		
	}
}

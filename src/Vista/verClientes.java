package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import Helpers.HelperExcel;
import Interfaces.TMClientes;

public class verClientes extends JInternalFrame {
	private JTable clientesTABLA;
	private Controlador controlador;
	
	public verClientes() throws Exception {
		
		iniciarComponentes();
		
		

	}

	private void iniciarComponentes() throws Exception {

		controlador = Controlador.getInstance();
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 75, 820, 361);
		getContentPane().add(scrollPane);
		
		clientesTABLA = new JTable();
		
		
		TMClientes modelo = new TMClientes(controlador.getClientes());
		clientesTABLA.setModel(modelo);
		scrollPane.setViewportView(clientesTABLA);
		
		JButton btnExportarAExcel = new JButton("Exportar a Excel");
		btnExportarAExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				HelperExcel.crearExcel(clientesTABLA, "CLIENTES");
				
			}
		});
		btnExportarAExcel.setBounds(726, 484, 138, 23);
		getContentPane().add(btnExportarAExcel);
		
	}
}

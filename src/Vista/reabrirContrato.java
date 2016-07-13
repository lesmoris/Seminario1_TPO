package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import DTOs.ContratoAlquilerDTO;
import Interfaces.TMElegirContrato;

public class reabrirContrato extends JInternalFrame {
	private JTable ContratosTABLA;
	private JTextField textField;

	
	public reabrirContrato() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 100, 696, 395);
		getContentPane().add(scrollPane);
		
		ContratosTABLA = new JTable();
		
		List<ContratoAlquilerDTO> listavacia = new ArrayList<ContratoAlquilerDTO>();	
		
		TMElegirContrato modelo = new TMElegirContrato(listavacia);
		ContratosTABLA.setModel(modelo);
		
		
		scrollPane.setViewportView(ContratosTABLA);
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(23, 90, 65, 14);
		getContentPane().add(lblTipoDoc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 87, 94, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDoc = new JLabel("Numero Doc");
		lblNumeroDoc.setBounds(23, 139, 81, 14);
		getContentPane().add(lblNumeroDoc);
		
		textField = new JTextField();
		textField.setBounds(108, 136, 94, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(53, 219, 111, 23);
		getContentPane().add(btnBuscarCliente);
		
		JButton btnReabrirContrato = new JButton("Reabrir Contrato");
		btnReabrirContrato.setBounds(537, 531, 137, 23);
		getContentPane().add(btnReabrirContrato);
		

	}
}

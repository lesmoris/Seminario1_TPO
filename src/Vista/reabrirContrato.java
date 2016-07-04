package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class reabrirContrato extends JInternalFrame {
	private JTextField textField;

	
	public reabrirContrato() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReabrirContratoCerrado = new JLabel("Reabrir Contrato cerrado por error");
		lblReabrirContratoCerrado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReabrirContratoCerrado.setBounds(251, 24, 348, 46);
		getContentPane().add(lblReabrirContratoCerrado);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(90, 124, 86, 14);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 123, 86, 17);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(93, 171, 101, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(204, 168, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(133, 224, 113, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblContratosCerrados = new JLabel("Contratos Cerrados");
		lblContratosCerrados.setBounds(362, 142, 113, 14);
		getContentPane().add(lblContratosCerrados);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(485, 139, 132, 17);
		getContentPane().add(comboBox_1);
		
		JButton btnReabrirContrato = new JButton("Reabrir Contrato");
		btnReabrirContrato.setBounds(429, 312, 139, 23);
		getContentPane().add(btnReabrirContrato);

	}

}

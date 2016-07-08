package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JButton;

public class bajaCliente extends JInternalFrame {
	private JTextField textField;

	
	public bajaCliente() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(45, 83, 103, 21);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 83, 123, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Nro Documento:");
		lblNumeroDocumento.setBounds(45, 136, 103, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(167, 133, 123, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(299, 197, 117, 36);
		getContentPane().add(btnConfirmar);

	}
}

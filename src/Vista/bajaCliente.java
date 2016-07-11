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
		
		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(383, 226, 103, 21);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(505, 226, 123, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Nro Documento:");
		lblNumeroDocumento.setBounds(383, 260, 103, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(505, 257, 123, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(444, 288, 103, 23);
		getContentPane().add(btnConfirmar);

	}
}

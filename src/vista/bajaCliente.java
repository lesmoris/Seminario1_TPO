package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class bajaCliente extends JInternalFrame {
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public bajaCliente() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblBajaCliente = new JLabel("Baja Cliente");
		lblBajaCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBajaCliente.setBounds(167, 11, 123, 36);
		getContentPane().add(lblBajaCliente);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(45, 83, 103, 21);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 83, 123, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento:");
		lblNumeroDocumento.setBounds(45, 136, 103, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(167, 133, 123, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

	}

}

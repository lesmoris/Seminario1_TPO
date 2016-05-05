package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class altaCliente extends JInternalFrame {
	private JTextField nombreTF;
	private JTextField docTF;
	private JTextField textField;
	private JTextField textField_1;


	public altaCliente() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAltaCliente = new JLabel("Alta Cliente");
		lblAltaCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltaCliente.setBounds(134, 11, 168, 41);
		getContentPane().add(lblAltaCliente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(40, 78, 86, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(40, 115, 103, 14);
		getContentPane().add(lblTipoDocumento);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(40, 150, 118, 14);
		getContentPane().add(lblNumeroDocumento);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(40, 185, 86, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(40, 222, 86, 14);
		getContentPane().add(lblTelefono);
		
		nombreTF = new JTextField();
		nombreTF.setBounds(157, 75, 86, 20);
		getContentPane().add(nombreTF);
		nombreTF.setColumns(10);
		
		JComboBox tipodocCB = new JComboBox();
		tipodocCB.setBounds(167, 112, 76, 20);
		getContentPane().add(tipodocCB);
		
		docTF = new JTextField();
		docTF.setBounds(157, 147, 86, 20);
		getContentPane().add(docTF);
		docTF.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(157, 182, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 219, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(271, 222, 89, 23);
		getContentPane().add(btnAceptar);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
	}
}

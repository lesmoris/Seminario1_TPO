package Vista;

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
	private JTextField mailTF;


	public altaCliente() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAltaCliente = new JLabel("Alta Cliente");
		lblAltaCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltaCliente.setBounds(336, 11, 111, 41);
		getContentPane().add(lblAltaCliente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(292, 78, 111, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(292, 115, 111, 14);
		getContentPane().add(lblTipoDocumento);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(292, 150, 111, 14);
		getContentPane().add(lblNumeroDocumento);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(292, 185, 111, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(292, 222, 111, 14);
		getContentPane().add(lblTelefono);
		
		nombreTF = new JTextField();
		nombreTF.setBounds(409, 75, 90, 20);
		getContentPane().add(nombreTF);
		nombreTF.setColumns(10);
		
		JComboBox tipodocCB = new JComboBox();
		tipodocCB.setBounds(409, 112, 90, 20);
		getContentPane().add(tipodocCB);
		
		docTF = new JTextField();
		docTF.setBounds(409, 147, 90, 20);
		getContentPane().add(docTF);
		docTF.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(409, 182, 90, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(409, 219, 90, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(346, 298, 90, 23);
		getContentPane().add(btnAceptar);
		
		JLabel mailLB = new JLabel("Mail");
		mailLB.setBounds(292, 255, 111, 14);
		getContentPane().add(mailLB);
		
		mailTF = new JTextField();
		mailTF.setBounds(409, 252, 90, 20);
		getContentPane().add(mailTF);
		mailTF.setColumns(10);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
	}
}
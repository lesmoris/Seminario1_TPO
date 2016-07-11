package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;

public class altaCliente extends JInternalFrame {
	private JTextField nombreTF;
	private JTextField docTF;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField mailTF;


	public altaCliente() {
		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(404, 147, 111, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(404, 184, 111, 14);
		getContentPane().add(lblTipoDocumento);
		
		JLabel lblNumeroDocumento = new JLabel("Nro Documento");
		lblNumeroDocumento.setBounds(404, 219, 111, 14);
		getContentPane().add(lblNumeroDocumento);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(404, 254, 111, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(404, 291, 111, 14);
		getContentPane().add(lblTelefono);
		
		nombreTF = new JTextField();
		nombreTF.setBounds(521, 144, 90, 20);
		getContentPane().add(nombreTF);
		nombreTF.setColumns(10);
		
		JComboBox tipodocCB = new JComboBox();
		tipodocCB.setBounds(521, 181, 90, 20);
		getContentPane().add(tipodocCB);
		
		docTF = new JTextField();
		docTF.setBounds(521, 216, 90, 20);
		getContentPane().add(docTF);
		docTF.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(521, 251, 90, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(521, 288, 90, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Confirmar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
			}
		});
		btnAceptar.setBounds(456, 368, 100, 23);
		getContentPane().add(btnAceptar);
		
		JLabel mailLB = new JLabel("Mail");
		mailLB.setBounds(404, 324, 111, 14);
		getContentPane().add(mailLB);
		
		mailTF = new JTextField();
		mailTF.setBounds(521, 321, 90, 20);
		getContentPane().add(mailTF);
		mailTF.setColumns(10);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
	}
}

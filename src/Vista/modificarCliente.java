package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class modificarCliente extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField mailTF;

	public modificarCliente() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(310, 175, 109, 14);
		getContentPane().add(lblTipoDocumento);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(421, 172, 86, 20);
		getContentPane().add(comboBox);

		JLabel lblNumeroDocumento = new JLabel("Nro Documento");
		lblNumeroDocumento.setBounds(310, 203, 109, 14);
		getContentPane().add(lblNumeroDocumento);

		textField = new JTextField();
		textField.setBounds(421, 200, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(576, 171, 123, 23);
		getContentPane().add(btnBuscarCliente);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(310, 238, 109, 14);
		getContentPane().add(lblNombre);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(421, 235, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(310, 269, 109, 14);
		getContentPane().add(lblDomicilio);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(310, 300, 109, 14);
		getContentPane().add(lblTelefono);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(421, 266, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(421, 297, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.setBounds(576, 199, 123, 23);
		getContentPane().add(btnConfirmar);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(310, 331, 109, 14);
		getContentPane().add(lblMail);

		mailTF = new JTextField();
		mailTF.setBounds(421, 328, 86, 20);
		getContentPane().add(mailTF);
		mailTF.setColumns(10);

	}

}

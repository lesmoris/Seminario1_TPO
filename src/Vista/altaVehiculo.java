package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class altaVehiculo extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField preciopordiaTF;


	public altaVehiculo() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(317, 178, 68, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(317, 209, 68, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblKilometraje = new JLabel("Kilometraje");
		lblKilometraje.setBounds(317, 240, 68, 14);
		getContentPane().add(lblKilometraje);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(317, 271, 75, 14);
		getContentPane().add(lblCantPuertas);
		
		JCheckBox chckbxAireAcondicionado = new JCheckBox("Aire Acondicionado");
		chckbxAireAcondicionado.setBounds(542, 236, 152, 23);
		getContentPane().add(chckbxAireAcondicionado);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(542, 178, 68, 14);
		getContentPane().add(lblTamao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(624, 175, 70, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(414, 175, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(414, 206, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(414, 237, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(414, 268, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(542, 209, 102, 14);
		getContentPane().add(lblTransmision);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(624, 206, 70, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnAceptar = new JButton("Confirmar");
		btnAceptar.setBounds(575, 284, 102, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(317, 302, 68, 14);
		getContentPane().add(lblDominio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(414, 299, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(317, 333, 68, 14);
		getContentPane().add(lblColor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(414, 330, 86, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(317, 364, 68, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(414, 361, 86, 20);
		getContentPane().add(comboBox_3);
		
		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(317, 395, 112, 14);
		getContentPane().add(lblPrecioPorDia);
		
		preciopordiaTF = new JTextField();
		preciopordiaTF.setBounds(414, 392, 86, 20);
		getContentPane().add(preciopordiaTF);
		preciopordiaTF.setColumns(10);

	}
}

package vista;

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
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAltaVehiculo = new JLabel("Alta Vehiculo");
		lblAltaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltaVehiculo.setBounds(136, 11, 158, 29);
		getContentPane().add(lblAltaVehiculo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(68, 61, 68, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(68, 100, 68, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblKilometraje = new JLabel("Kilometraje");
		lblKilometraje.setBounds(68, 135, 68, 14);
		getContentPane().add(lblKilometraje);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(68, 171, 75, 14);
		getContentPane().add(lblCantPuertas);
		
		JCheckBox chckbxAireAcondicionado = new JCheckBox("Aire Acondicionado");
		chckbxAireAcondicionado.setBounds(259, 131, 151, 23);
		getContentPane().add(chckbxAireAcondicionado);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(286, 58, 68, 14);
		getContentPane().add(lblTamao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(352, 55, 70, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(146, 58, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 97, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 132, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 168, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(250, 97, 104, 14);
		getContentPane().add(lblTransmision);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(352, 94, 70, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(311, 220, 89, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(68, 202, 68, 14);
		getContentPane().add(lblDominio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 199, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(68, 227, 68, 14);
		getContentPane().add(lblColor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(146, 230, 86, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(68, 276, 68, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(146, 273, 86, 20);
		getContentPane().add(comboBox_3);
		
		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(68, 325, 86, 14);
		getContentPane().add(lblPrecioPorDia);
		
		preciopordiaTF = new JTextField();
		preciopordiaTF.setBounds(146, 322, 86, 20);
		getContentPane().add(preciopordiaTF);
		preciopordiaTF.setColumns(10);

	}
}

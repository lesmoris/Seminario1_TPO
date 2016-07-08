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
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(192, 125, 68, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(192, 156, 68, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblKilometraje = new JLabel("Kilometraje");
		lblKilometraje.setBounds(192, 187, 68, 14);
		getContentPane().add(lblKilometraje);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(192, 218, 75, 14);
		getContentPane().add(lblCantPuertas);
		
		JCheckBox chckbxAireAcondicionado = new JCheckBox("Aire Acondicionado");
		chckbxAireAcondicionado.setBounds(417, 183, 152, 23);
		getContentPane().add(chckbxAireAcondicionado);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(417, 125, 68, 14);
		getContentPane().add(lblTamao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(495, 119, 70, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(289, 122, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 153, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(289, 184, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(289, 215, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(417, 156, 102, 14);
		getContentPane().add(lblTransmision);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(495, 153, 70, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnAceptar = new JButton("Confirmar");
		btnAceptar.setBounds(450, 231, 102, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(192, 249, 68, 14);
		getContentPane().add(lblDominio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(289, 246, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(192, 280, 68, 14);
		getContentPane().add(lblColor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(289, 277, 86, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(192, 311, 68, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(289, 308, 86, 20);
		getContentPane().add(comboBox_3);
		
		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(192, 342, 112, 14);
		getContentPane().add(lblPrecioPorDia);
		
		preciopordiaTF = new JTextField();
		preciopordiaTF.setBounds(289, 339, 86, 20);
		getContentPane().add(preciopordiaTF);
		preciopordiaTF.setColumns(10);

	}
}

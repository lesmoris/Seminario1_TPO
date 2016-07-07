package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class generarReporteAlquileres extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;



	public generarReporteAlquileres() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReporteDeAlquileres = new JLabel("REPORTE DE ALQUILERES");
		lblReporteDeAlquileres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteDeAlquileres.setBounds(289, 25, 263, 33);
		getContentPane().add(lblReporteDeAlquileres);
		
		JLabel lblNewLabel = new JLabel("Sucursal Origen");
		lblNewLabel.setBounds(388, 94, 99, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(492, 116, 96, 20);
		getContentPane().add(comboBox);
		
		JLabel lblFechaDesde = new JLabel("Desde");
		lblFechaDesde.setBounds(10, 94, 71, 14);
		getContentPane().add(lblFechaDesde);
		
		JLabel lblFechaHasta = new JLabel("Hasta");
		lblFechaHasta.setBounds(10, 119, 71, 14);
		getContentPane().add(lblFechaHasta);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(10, 69, 83, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(173, 69, 71, 14);
		getContentPane().add(lblFechaFin);
		
		textField = new JTextField();
		textField.setBounds(52, 91, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 116, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(173, 94, 46, 14);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(173, 119, 46, 14);
		getContentPane().add(lblHasta);
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 91, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(254, 116, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(388, 119, 99, 14);
		getContentPane().add(lblSucursalDestino);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(492, 91, 96, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(613, 69, 76, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblSucursales = new JLabel("SUCURSALES");
		lblSucursales.setBounds(388, 69, 91, 14);
		getContentPane().add(lblSucursales);
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(613, 94, 65, 14);
		getContentPane().add(lblTipoDoc);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(688, 91, 86, 20);
		getContentPane().add(comboBox_2);
		
		JLabel lblNroDoc = new JLabel("Nro Doc");
		lblNroDoc.setBounds(613, 119, 65, 14);
		getContentPane().add(lblNroDoc);
		
		textField_4 = new JTextField();
		textField_4.setBounds(688, 116, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(10, 147, 83, 14);
		getContentPane().add(lblVehiculo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 171, 46, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(294, 171, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 205, 46, 14);
		getContentPane().add(lblColor);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(613, 171, 108, 14);
		getContentPane().add(lblCantPuertas);
		
		textField_5 = new JTextField();
		textField_5.setBounds(52, 171, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(340, 168, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(52, 202, 86, 20);
		getContentPane().add(comboBox_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(703, 168, 71, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JCheckBox chckbxAireAcondicionado = new JCheckBox("Aire Acondicionado");
		chckbxAireAcondicionado.setBounds(144, 201, 178, 23);
		getContentPane().add(chckbxAireAcondicionado);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(627, 201, 147, 23);
		getContentPane().add(btnGenerar);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(148, 171, 65, 14);
		getContentPane().add(lblTamao);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(436, 171, 83, 14);
		getContentPane().add(lblTransmision);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(198, 168, 86, 20);
		getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(512, 168, 76, 20);
		getContentPane().add(comboBox_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 764, 199);
		getContentPane().add(scrollPane);
		
		
	}
}

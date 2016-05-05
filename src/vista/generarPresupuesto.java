package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class generarPresupuesto extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public generarPresupuesto() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoPresupuesto = new JLabel("Nuevo Presupuesto");
		lblNuevoPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoPresupuesto.setBounds(117, 11, 214, 40);
		getContentPane().add(lblNuevoPresupuesto);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 59, 46, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(10, 108, 60, 14);
		getContentPane().add(lblTipoDoc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(82, 105, 60, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDoc = new JLabel("Numero Doc");
		lblNumeroDoc.setBounds(10, 149, 71, 14);
		getContentPane().add(lblNumeroDoc);
		
		textField = new JTextField();
		textField.setBounds(92, 146, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(20, 174, 106, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(313, 62, 74, 14);
		getContentPane().add(lblVehiculo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(272, 87, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblTamap = new JLabel("Tama\u00F1o");
		lblTamap.setBounds(272, 127, 46, 14);
		getContentPane().add(lblTamap);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(245, 165, 98, 14);
		getContentPane().add(lblCantPuertas);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(272, 198, 46, 14);
		getContentPane().add(lblColor);
		
		JCheckBox chckbxAireAcond = new JCheckBox("Aire Acondicionado");
		chckbxAireAcond.setBounds(272, 226, 146, 23);
		getContentPane().add(chckbxAireAcond);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(257, 273, 86, 14);
		getContentPane().add(lblTransmision);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(220, 311, 46, 14);
		getContentPane().add(lblMarca);
		
		textField_1 = new JTextField();
		textField_1.setBounds(353, 87, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(355, 124, 84, 20);
		getContentPane().add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(353, 162, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(353, 195, 86, 20);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(353, 270, 86, 20);
		getContentPane().add(comboBox_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(301, 308, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscarAuto = new JButton("Buscar Vehiculo");
		btnBuscarAuto.setBounds(548, 191, 137, 23);
		getContentPane().add(btnBuscarAuto);
		
		JLabel lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setBounds(524, 121, 74, 14);
		getContentPane().add(lblInicio);
		
		textField_4 = new JTextField();
		textField_4.setBounds(626, 118, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal Origen");
		lblSucursal.setBounds(504, 81, 106, 14);
		getContentPane().add(lblSucursal);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(20, 311, 61, 14);
		getContentPane().add(lblFechaFin);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(620, 78, 92, 20);
		getContentPane().add(comboBox_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(104, 308, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino:");
		lblSucursalDestino.setBounds(10, 371, 116, 14);
		getContentPane().add(lblSucursalDestino);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(137, 368, 92, 20);
		getContentPane().add(comboBox_5);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(592, 387, 106, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.setBounds(458, 341, 121, 23);
		getContentPane().add(btnCalcularPrecio);
		
		JLabel lblPrecioCalculado = new JLabel("Precio Calculado:");
		lblPrecioCalculado.setBounds(365, 387, 132, 23);
		getContentPane().add(lblPrecioCalculado);
		
		JLabel lblprecio = new JLabel("\"PRECIO\"");
		lblprecio.setBounds(472, 391, 71, 14);
		getContentPane().add(lblprecio);

	}

}

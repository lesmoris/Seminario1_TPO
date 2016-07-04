package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class consultarPresupuesto extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;


	public consultarPresupuesto() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblConsultarPresupuesto = new JLabel("Consultar Presupuesto");
		lblConsultarPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConsultarPresupuesto.setBounds(311, 27, 239, 45);
		getContentPane().add(lblConsultarPresupuesto);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(51, 110, 107, 22);
		getContentPane().add(lblTipoDocumento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 111, 78, 20);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(51, 172, 104, 14);
		getContentPane().add(lblNumeroDocumento);
		
		textField = new JTextField();
		textField.setBounds(154, 169, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(71, 197, 107, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblPresupuestosVigentes = new JLabel("Presupuestos Vigentes:");
		lblPresupuestosVigentes.setBounds(312, 139, 113, 14);
		getContentPane().add(lblPresupuestosVigentes);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(464, 136, 157, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(64, 268, 57, 14);
		getContentPane().add(lblVehiculo);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 310, 46, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(20, 347, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(20, 386, 46, 14);
		getContentPane().add(lblColor);
		
		JLabel lblTamap = new JLabel("Tama\u00F1o");
		lblTamap.setBounds(20, 425, 46, 14);
		getContentPane().add(lblTamap);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(91, 307, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(91, 344, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(92, 383, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(92, 422, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFechaDePresupuesto = new JLabel("Fecha de Presupuesto");
		lblFechaDePresupuesto.setBounds(229, 310, 118, 14);
		getContentPane().add(lblFechaDePresupuesto);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(357, 307, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(245, 386, 46, 14);
		getContentPane().add(lblMonto);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(357, 383, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(245, 347, 86, 14);
		getContentPane().add(lblSucursalOrigen);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setBounds(357, 344, 86, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnCancelarPresupuesto = new JButton("Cancelar Presupuesto ");
		btnCancelarPresupuesto.setBounds(543, 409, 141, 23);
		getContentPane().add(btnCancelarPresupuesto);
		
		JButton btnBuscarPresupuesto = new JButton("Buscar Presupuesto");
		btnBuscarPresupuesto.setBounds(498, 197, 141, 23);
		getContentPane().add(btnBuscarPresupuesto);

	}
}

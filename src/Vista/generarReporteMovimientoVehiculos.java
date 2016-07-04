package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class generarReporteMovimientoVehiculos extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	public generarReporteMovimientoVehiculos() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReporteMovimientos = new JLabel("REPORTE MOVIMIENTOS");
		lblReporteMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMovimientos.setBounds(163, 11, 265, 51);
		getContentPane().add(lblReporteMovimientos);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(20, 70, 84, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(193, 71, 76, 13);
		getContentPane().add(lblFechaFin);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(10, 95, 46, 14);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(10, 134, 46, 14);
		getContentPane().add(lblHasta);
		
		textField = new JTextField();
		textField.setBounds(53, 95, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 131, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setBounds(173, 95, 46, 14);
		getContentPane().add(lblDesde_1);
		
		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setBounds(173, 134, 46, 14);
		getContentPane().add(lblHasta_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(235, 95, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(235, 131, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(10, 225, 106, 14);
		getContentPane().add(lblSucursalOrigen);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(10, 272, 106, 14);
		getContentPane().add(lblSucursalDestino);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 222, 100, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(163, 269, 100, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnConfirmar = new JButton("Generar Reporte");
		btnConfirmar.setBounds(406, 321, 131, 23);
		getContentPane().add(btnConfirmar);

	}

}

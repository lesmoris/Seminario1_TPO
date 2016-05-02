package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class generarReporteMovimientoVehiculos extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generarReporteMovimientoVehiculos frame = new generarReporteMovimientoVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public generarReporteMovimientoVehiculos() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReporteMovimientos = new JLabel("REPORTE MOVIMIENTOS");
		lblReporteMovimientos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMovimientos.setBounds(163, 11, 265, 51);
		getContentPane().add(lblReporteMovimientos);
		
		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(10, 72, 84, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(183, 73, 76, 13);
		getContentPane().add(lblFechaFin);
		
		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(0, 97, 46, 14);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(0, 136, 46, 14);
		getContentPane().add(lblHasta);
		
		textField = new JTextField();
		textField.setBounds(43, 97, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 133, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setBounds(163, 97, 46, 14);
		getContentPane().add(lblDesde_1);
		
		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setBounds(163, 136, 46, 14);
		getContentPane().add(lblHasta_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 97, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(225, 133, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(10, 225, 76, 14);
		getContentPane().add(lblSucursalOrigen);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(10, 272, 84, 14);
		getContentPane().add(lblSucursalDestino);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(109, 222, 100, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(109, 269, 100, 20);
		getContentPane().add(comboBox_1);
		
		JButton btnConfirmar = new JButton("Generar Reporte");
		btnConfirmar.setBounds(502, 410, 131, 23);
		getContentPane().add(btnConfirmar);

	}

}

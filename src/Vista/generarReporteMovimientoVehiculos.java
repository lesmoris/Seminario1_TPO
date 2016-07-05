package Vista;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import Interfaces.TMmantenimientosPorVehiculoTABLA;
import Interfaces.TMmovimientosDeVehiculosTABLA;

public class generarReporteMovimientoVehiculos extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable HistorialMovimientosTABLA;
	private TMmovimientosDeVehiculosTABLA TM;
	private Controlador controlador;

	public generarReporteMovimientoVehiculos() {
		this.controlador = Controlador.getInstance();

		iniciarComponentes();
	}

	private void iniciarComponentes() {

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
		lblFechaFin.setBounds(179, 71, 76, 13);
		getContentPane().add(lblFechaFin);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(20, 98, 46, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(20, 134, 46, 14);
		getContentPane().add(lblHasta);

		textField = new JTextField();
		textField.setBounds(66, 95, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(66, 131, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setBounds(179, 95, 46, 14);
		getContentPane().add(lblDesde_1);

		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setBounds(179, 134, 46, 14);
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
		lblSucursalOrigen.setBounds(361, 95, 106, 14);
		getContentPane().add(lblSucursalOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(361, 134, 106, 14);
		getContentPane().add(lblSucursalDestino);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(459, 92, 100, 20);
		getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(459, 131, 100, 20);
		getContentPane().add(comboBox_1);

		JButton btnConfirmar = new JButton("Generar Reporte");
		btnConfirmar.setBounds(608, 108, 131, 23);
		getContentPane().add(btnConfirmar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 764, 217);
		getContentPane().add(scrollPane);

		TM = new TMmovimientosDeVehiculosTABLA(
				new ArrayList<MovimientoDTO>());

		HistorialMovimientosTABLA = new JTable();
		HistorialMovimientosTABLA.setModel(TM);
		scrollPane.setViewportView(HistorialMovimientosTABLA);
	}
}

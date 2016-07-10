package Vista;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MantenimientoDTO;
import Interfaces.ResultadoOperacionGetVehiculo;
import Interfaces.ResultadoOperacionHistorialMantenimiento;
import Interfaces.TMmantenimientosPorVehiculoTABLA;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class generarReporteMantenimientoPorVehiculo extends JInternalFrame {
	private JTable HistorialMantenimientosTABLA;
	private TMmantenimientosPorVehiculoTABLA TM;
	private JTextField dominioTF;
	private Controlador controlador;
	private JButton btnExportar;

	public generarReporteMantenimientoPorVehiculo() {
		this.controlador = Controlador.getInstance();

		iniciarComponentes();
	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblDominioVehiculo = new JLabel("Dominio");
		lblDominioVehiculo.setBounds(222, 26, 116, 14);
		getContentPane().add(lblDominioVehiculo);

		dominioTF = new JTextField();
		dominioTF.setBounds(312, 23, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				// Mando el mensaje
				ResultadoOperacionHistorialMantenimiento res = controlador
						.historialMantenimientosPorVehiculo(dominioVehiculo);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					TM = new TMmantenimientosPorVehiculoTABLA(res
							.getMantenimientosDTO());
					HistorialMantenimientosTABLA.setModel(TM);
					btnExportar.setVisible(true);

				} else {
					TM = new TMmantenimientosPorVehiculoTABLA(
							new ArrayList<MantenimientoDTO>());
					HistorialMantenimientosTABLA.setModel(TM);

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(431, 22, 89, 23);
		getContentPane().add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 764, 345);
		getContentPane().add(scrollPane);

		TM = new TMmantenimientosPorVehiculoTABLA(
				new ArrayList<MantenimientoDTO>());

		HistorialMantenimientosTABLA = new JTable();
		HistorialMantenimientosTABLA.setModel(TM);
		scrollPane.setViewportView(HistorialMantenimientosTABLA);
		
		btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controlador.crearExcel(HistorialMantenimientosTABLA, "MANTENIMIENTOS");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnExportar.setVisible(false);
		btnExportar.setBounds(550, 22, 89, 23);
		getContentPane().add(btnExportar);

	}
}

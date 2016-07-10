package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MantenimientoDTO;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacionHistorialMantenimiento;
import Interfaces.TMmantenimientosPorSucursalTABLA;
import Interfaces.TMmantenimientosPorVehiculoTABLA;

public class generarReporteMantenimientosAbiertosPorSucursal extends
		JInternalFrame {
	private Controlador controlador;
	private JTable HistorialMantenimientosTABLA;
	private TMmantenimientosPorSucursalTABLA TM;
	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> cmbSucursal;
	private JButton btnExportar;

	public generarReporteMantenimientosAbiertosPorSucursal() {
		this.controlador = Controlador.getInstance();

		iniciarComponentes();

		cargarSucursales(sucursales);
	}

	// Cargamos los ComboBox
	private void cargarSucursales(List<SucursalDTO> sucursales) {

		this.sucursales = controlador.getSucursales();

		for (SucursalDTO s : this.sucursales) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			cmbSucursal.addItem(cbi);
		}
	}

	private void iniciarComponentes() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(144, 11, 69, 20);
		getContentPane().add(lblSucursal);

		cmbSucursal = new JComboBox();
		cmbSucursal.setBounds(223, 11, 140, 20);
		getContentPane().add(cmbSucursal);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String sucursalDestino = ((ComboBoxItem) cmbSucursal
						.getSelectedItem()).getNombre();

				// Mando el mensaje
				ResultadoOperacionHistorialMantenimiento res = controlador
						.reporteMantenimientosAbiertosPorSucursal(sucursalDestino);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					TM = new TMmantenimientosPorSucursalTABLA(res
							.getMantenimientosDTO());
					HistorialMantenimientosTABLA.setModel(TM);
					btnExportar.setVisible(true);
				} else {
					TM = new TMmantenimientosPorSucursalTABLA(
							new ArrayList<MantenimientoDTO>());
					HistorialMantenimientosTABLA.setModel(TM);

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGenerarReporte.setBounds(408, 11, 164, 23);
		getContentPane().add(btnGenerarReporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 764, 381);
		getContentPane().add(scrollPane);

		TM = new TMmantenimientosPorSucursalTABLA(
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
		btnExportar.setBounds(582, 11, 164, 23);
		getContentPane().add(btnExportar);

	}
}

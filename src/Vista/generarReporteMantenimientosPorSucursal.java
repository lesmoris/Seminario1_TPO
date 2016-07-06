package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class generarReporteMantenimientosPorSucursal extends JInternalFrame {
	private Controlador controlador;
	private JTable HistorialMantenimientosTABLA;
	private TMmantenimientosPorSucursalTABLA TM;
	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> cmbSucursal;

	public generarReporteMantenimientosPorSucursal() {
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

		JLabel lblReporteMantenimiento = new JLabel("Reporte Mantenimiento");
		lblReporteMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMantenimiento.setBounds(267, 22, 215, 59);
		getContentPane().add(lblReporteMantenimiento);

		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(135, 92, 69, 20);
		getContentPane().add(lblSucursal);

		cmbSucursal = new JComboBox();
		cmbSucursal.setBounds(214, 92, 140, 20);
		getContentPane().add(cmbSucursal);

		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String sucursalDestino = ((ComboBoxItem) cmbSucursal
						.getSelectedItem()).getNombre();

				// Mando el mensaje
				ResultadoOperacionHistorialMantenimiento res = controlador
						.historialMantenimientosPorSucursal(sucursalDestino);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					TM = new TMmantenimientosPorSucursalTABLA(
							new ArrayList<MantenimientoDTO>());
					HistorialMantenimientosTABLA.setModel(TM);

				} else {
					TM = new TMmantenimientosPorSucursalTABLA(
							new ArrayList<MantenimientoDTO>());
					HistorialMantenimientosTABLA.setModel(TM);

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGenerarReporte.setBounds(399, 92, 164, 23);
		getContentPane().add(btnGenerarReporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 764, 285);
		getContentPane().add(scrollPane);

		TM = new TMmantenimientosPorSucursalTABLA(
				new ArrayList<MantenimientoDTO>());

		HistorialMantenimientosTABLA = new JTable();
		HistorialMantenimientosTABLA.setModel(TM);
		scrollPane.setViewportView(HistorialMantenimientosTABLA);

	}
}

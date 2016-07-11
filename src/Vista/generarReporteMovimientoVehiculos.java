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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
import Interfaces.JFormattedDateTextField;
import Interfaces.ResultadoOperacionReporteMovimientosVehiculos;
import Interfaces.TMmantenimientosPorVehiculoTABLA;
import Interfaces.TMmovimientosDeVehiculosTABLA;

public class generarReporteMovimientoVehiculos extends JInternalFrame {
	private JTextField fechaInicioDesdeTF;
	private JTextField fechaInicioHastaTF;
	private JTextField fechaFinDesdeTF;
	private JTextField fechaFinHastaTF;
	private JTable HistorialMovimientosTABLA;
	private TMmovimientosDeVehiculosTABLA TM;
	private Controlador controlador;
	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> cmbOrigen;
	private JComboBox<ComboBoxItem> cmbDestino;
	private JButton btnEXPORTAR;

	public generarReporteMovimientoVehiculos() {
		this.controlador = Controlador.getInstance();

		iniciarComponentes();

		cargarSucursales(sucursales);
	}

	// Cargamos los ComboBox
	private void cargarSucursales(List<SucursalDTO> sucursales) {

		this.sucursales = controlador.getSucursales();

		ComboBoxItem cbi = new ComboBoxItem();
		cbi.setCodigo(0);
		cbi.setNombre("");

		cmbOrigen.addItem(cbi);
		cmbDestino.addItem(cbi);

		for (SucursalDTO s : this.sucursales) {

			cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			cmbOrigen.addItem(cbi);
			cmbDestino.addItem(cbi);
		}
	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(20, 25, 84, 14);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(179, 26, 76, 13);
		getContentPane().add(lblFechaFin);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(20, 53, 46, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(20, 78, 46, 14);
		getContentPane().add(lblHasta);

		final JFormattedDateTextField fechaInicioDesdeTF = new JFormattedDateTextField();
		fechaInicioDesdeTF.setBounds(66, 50, 86, 20);
		getContentPane().add(fechaInicioDesdeTF);

		final JFormattedDateTextField fechaInicioHastaTF = new JFormattedDateTextField();
		fechaInicioHastaTF.setBounds(66, 75, 86, 20);
		getContentPane().add(fechaInicioHastaTF);
		
		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setBounds(179, 50, 46, 14);
		getContentPane().add(lblDesde_1);

		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setBounds(179, 78, 46, 14);
		getContentPane().add(lblHasta_1);

		final JFormattedDateTextField fechaFinDesdeTF = new JFormattedDateTextField();
		fechaFinDesdeTF.setBounds(235, 50, 86, 20);
		getContentPane().add(fechaFinDesdeTF);

		final JFormattedDateTextField fechaFinHastaTF = new JFormattedDateTextField();
		fechaFinHastaTF.setBounds(235, 75, 86, 20);
		getContentPane().add(fechaFinHastaTF);

		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(622, 47, 106, 14);
		getContentPane().add(lblSucursalOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(622, 75, 106, 14);
		getContentPane().add(lblSucursalDestino);

		cmbOrigen = new JComboBox();
		cmbOrigen.setBounds(720, 44, 100, 20);
		getContentPane().add(cmbOrigen);

		cmbDestino = new JComboBox();
		cmbDestino.setBounds(720, 72, 100, 20);
		getContentPane().add(cmbDestino);

		JButton btnConfirmar = new JButton("Generar Reporte");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String fechaInicioDesde = fechaInicioDesdeTF.getDate();
				String fechaInicioHasta = fechaInicioHastaTF.getDate();
				String fechaFinDesde = fechaFinDesdeTF.getDate();
				String fechaFinHasta = fechaFinHastaTF.getDate();

				String sucursalOrigen = ((ComboBoxItem) cmbOrigen
						.getSelectedItem()).getNombre();

				String sucursalDestino = ((ComboBoxItem) cmbDestino
						.getSelectedItem()).getNombre();

				// Mando el mensaje
				ResultadoOperacionReporteMovimientosVehiculos res = controlador
						.generarReporteDeMovimientoDeVehiculos(
								fechaInicioDesde, fechaInicioHasta,
								fechaFinDesde, fechaFinHasta, sucursalOrigen,
								sucursalDestino);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					TM = new TMmovimientosDeVehiculosTABLA(res
							.getMovimientosDTO());
					HistorialMovimientosTABLA.setModel(TM);
					btnEXPORTAR.setVisible(true);

				} else {
					TM = new TMmovimientosDeVehiculosTABLA(
							new ArrayList<MovimientoDTO>());
					HistorialMovimientosTABLA.setModel(TM);
					

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnConfirmar.setBounds(867, 44, 131, 23);
		getContentPane().add(btnConfirmar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 116, 988, 444);
		getContentPane().add(scrollPane);

		TM = new TMmovimientosDeVehiculosTABLA(new ArrayList<MovimientoDTO>());

		HistorialMovimientosTABLA = new JTable();
		HistorialMovimientosTABLA.setModel(TM);
		scrollPane.setViewportView(HistorialMovimientosTABLA);
		
		btnEXPORTAR = new JButton("Exportar");
		btnEXPORTAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					controlador.crearExcel(HistorialMovimientosTABLA, "MOVIMIENTOS");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEXPORTAR.setVisible(false);
		btnEXPORTAR.setBounds(867, 72, 131, 23);
		getContentPane().add(btnEXPORTAR);
	}
}

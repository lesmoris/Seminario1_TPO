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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MantenimientoDTO;
import DTOs.MovimientoDTO;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
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

	public generarReporteMovimientoVehiculos() {
		this.controlador = Controlador.getInstance();

		menuPrincipal.getInstance().setTitle("RENT A CAR - Movimiento Vehiculos");
		
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

		fechaInicioDesdeTF = new JTextField();
		fechaInicioDesdeTF.setBounds(66, 95, 86, 20);
		getContentPane().add(fechaInicioDesdeTF);
		fechaInicioDesdeTF.setColumns(10);

		fechaInicioHastaTF = new JTextField();
		fechaInicioHastaTF.setBounds(66, 131, 86, 20);
		getContentPane().add(fechaInicioHastaTF);
		fechaInicioHastaTF.setColumns(10);

		JLabel lblDesde_1 = new JLabel("Desde");
		lblDesde_1.setBounds(179, 95, 46, 14);
		getContentPane().add(lblDesde_1);

		JLabel lblHasta_1 = new JLabel("Hasta");
		lblHasta_1.setBounds(179, 134, 46, 14);
		getContentPane().add(lblHasta_1);

		fechaFinDesdeTF = new JTextField();
		fechaFinDesdeTF.setBounds(235, 95, 86, 20);
		getContentPane().add(fechaFinDesdeTF);
		fechaFinDesdeTF.setColumns(10);

		fechaFinHastaTF = new JTextField();
		fechaFinHastaTF.setBounds(235, 131, 86, 20);
		getContentPane().add(fechaFinHastaTF);
		fechaFinHastaTF.setColumns(10);

		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(361, 95, 106, 14);
		getContentPane().add(lblSucursalOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(361, 134, 106, 14);
		getContentPane().add(lblSucursalDestino);

		cmbOrigen = new JComboBox();
		cmbOrigen.setBounds(459, 92, 100, 20);
		getContentPane().add(cmbOrigen);

		cmbDestino = new JComboBox();
		cmbDestino.setBounds(459, 131, 100, 20);
		getContentPane().add(cmbDestino);

		JButton btnConfirmar = new JButton("Generar Reporte");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String fechaInicioDesde = fechaInicioDesdeTF.getText();
				String fechaInicioHasta = fechaInicioHastaTF.getText();
				String fechaFinDesde = fechaFinDesdeTF.getText();
				String fechaFinHasta = fechaFinHastaTF.getText();

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

				} else {
					TM = new TMmovimientosDeVehiculosTABLA(
							new ArrayList<MovimientoDTO>());
					HistorialMovimientosTABLA.setModel(TM);

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnConfirmar.setBounds(608, 108, 131, 23);
		getContentPane().add(btnConfirmar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 764, 217);
		getContentPane().add(scrollPane);

		TM = new TMmovimientosDeVehiculosTABLA(new ArrayList<MovimientoDTO>());

		HistorialMovimientosTABLA = new JTable();
		HistorialMovimientosTABLA.setModel(TM);
		scrollPane.setViewportView(HistorialMovimientosTABLA);
	}
}

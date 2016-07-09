package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import Controlador.Controlador;
import DTOs.ContratoAlquilerDTO;
import DTOs.SucursalDTO;
import Helpers.HelperValoresFijos;
import Interfaces.ComboBoxItem;
import Interfaces.JFormattedDateTextField;
import Interfaces.ResultadoOperacionReporteAlquileres;
import Interfaces.TMalquileresTABLA;

public class generarReporteAlquileres extends JInternalFrame {
	private JFormattedTextField fechaInicioDesdeTF;
	private JTextField fechaInicioHastaTF;
	private JTextField fechaFinDesdeTF;
	private JTextField fechaFinHastaTF;
	private JTextField nroDocTF;
	private JTextField marcaTF;
	private JTextField modeloTF;
	private JTextField cantPuertasTF;
	private Controlador controlador;
	private List<SucursalDTO> sucursales;
	private List<String> tiposDNI;
	private List<String> tamanios;
	private List<String> transmisiones;
	private List<String> colores;
	private List<String> tiposCombustible;
	private List<String> ac;
	private JComboBox<ComboBoxItem> cmbOrigen;
	private JComboBox<ComboBoxItem> cmbDestino;
	private JComboBox<String> cmbTipoDoc;
	private JComboBox<String> cmbTamanio;
	private JComboBox<String> cmbTransmision;
	private JComboBox<String> cmbColor;
	private JComboBox<String> cmbTipoCombustible;
	private JComboBox<String> cmbAC;

	private JTable AlquileresTABLA;
	private TMalquileresTABLA TM;

	public generarReporteAlquileres() {
		iniciarComponentes();

		this.controlador = Controlador.getInstance();

		cargarCombos();
	}

	private void cargarCombos() {
		cargarSucursales();
		cargarTipoDNI();
		cargarTamanio();
		cargarTransmision();
		cargarColor();
		cargarTipoCombustible();
		cargarAireAcondicionado();
	}

	private void cargarTipoDNI() {
		this.tiposDNI = HelperValoresFijos.getTiposDoc();

		cmbTipoDoc.addItem("");

		for (String s : this.tiposDNI) {

			cmbTipoDoc.addItem(s);
		}
	}

	private void cargarTamanio() {
		this.tamanios = HelperValoresFijos.getTamaños();

		cmbTamanio.addItem("");

		for (String s : this.tamanios) {

			cmbTamanio.addItem(s);
		}
	}

	private void cargarTransmision() {
		this.transmisiones = HelperValoresFijos.getTransmisiones();

		cmbTransmision.addItem("");

		for (String s : this.transmisiones) {

			cmbTransmision.addItem(s);
		}
	}

	private void cargarColor() {
		this.colores = HelperValoresFijos.getColores();

		cmbColor.addItem("");

		for (String s : this.colores) {

			cmbColor.addItem(s);
		}
	}

	private void cargarTipoCombustible() {
		this.tiposCombustible = HelperValoresFijos.getTiposComb();

		cmbTipoCombustible.addItem("");

		for (String s : this.tiposCombustible) {

			cmbTipoCombustible.addItem(s);
		}
	}

	private void cargarAireAcondicionado() {
		this.ac = HelperValoresFijos.getAireAcondicionado();

		cmbAC.addItem("");

		for (String s : this.ac) {

			cmbAC.addItem(s);
		}
	}

	// Cargamos los ComboBox
	private void cargarSucursales() {

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

		JLabel lblNewLabel = new JLabel("Sucursal Origen");
		lblNewLabel.setBounds(388, 36, 99, 14);
		getContentPane().add(lblNewLabel);

		cmbDestino = new JComboBox();
		cmbDestino.setBounds(492, 58, 96, 20);
		getContentPane().add(cmbDestino);

		JLabel lblFechaDesde = new JLabel("Desde");
		lblFechaDesde.setBounds(10, 36, 71, 14);
		getContentPane().add(lblFechaDesde);

		JLabel lblFechaHasta = new JLabel("Hasta");
		lblFechaHasta.setBounds(10, 61, 71, 14);
		getContentPane().add(lblFechaHasta);

		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(10, 11, 83, 14);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(173, 11, 71, 14);
		getContentPane().add(lblFechaFin);

		final JFormattedDateTextField fechaInicioDesdeTF = new JFormattedDateTextField();
		fechaInicioDesdeTF.setBounds(52, 33, 86, 20);
		getContentPane().add(fechaInicioDesdeTF);
		
		final JFormattedDateTextField fechaInicioHastaTF = new JFormattedDateTextField();
		fechaInicioHastaTF.setBounds(52, 58, 86, 20);
		getContentPane().add(fechaInicioHastaTF);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(173, 36, 46, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(173, 61, 46, 14);
		getContentPane().add(lblHasta);

		final JFormattedDateTextField fechaFinDesdeTF = new JFormattedDateTextField();
		fechaFinDesdeTF.setBounds(254, 33, 86, 20);
		getContentPane().add(fechaFinDesdeTF);

		final JFormattedDateTextField fechaFinHastaTF = new JFormattedDateTextField();
		fechaFinHastaTF.setBounds(254, 58, 86, 20);
		getContentPane().add(fechaFinHastaTF);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(388, 61, 99, 14);
		getContentPane().add(lblSucursalDestino);

		cmbOrigen = new JComboBox();
		cmbOrigen.setBounds(492, 33, 96, 20);
		getContentPane().add(cmbOrigen);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(613, 11, 76, 14);
		getContentPane().add(lblCliente);

		JLabel lblSucursales = new JLabel("SUCURSALES");
		lblSucursales.setBounds(388, 11, 91, 14);
		getContentPane().add(lblSucursales);

		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(613, 36, 65, 14);
		getContentPane().add(lblTipoDoc);

		cmbTipoDoc = new JComboBox();
		cmbTipoDoc.setBounds(672, 33, 86, 20);
		getContentPane().add(cmbTipoDoc);

		JLabel lblNroDoc = new JLabel("Nro Doc");
		lblNroDoc.setBounds(613, 61, 65, 14);
		getContentPane().add(lblNroDoc);

		nroDocTF = new JTextField();
		nroDocTF.setBounds(672, 58, 86, 20);
		getContentPane().add(nroDocTF);
		nroDocTF.setColumns(10);

		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(10, 89, 83, 14);
		getContentPane().add(lblVehiculo);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 113, 46, 14);
		getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(294, 113, 46, 14);
		getContentPane().add(lblModelo);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 147, 46, 14);
		getContentPane().add(lblColor);

		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(613, 113, 108, 14);
		getContentPane().add(lblCantPuertas);

		marcaTF = new JTextField();
		marcaTF.setBounds(52, 113, 86, 20);
		getContentPane().add(marcaTF);
		marcaTF.setColumns(10);

		modeloTF = new JTextField();
		modeloTF.setBounds(340, 110, 86, 20);
		getContentPane().add(modeloTF);
		modeloTF.setColumns(10);

		cmbColor = new JComboBox();
		cmbColor.setBounds(52, 144, 86, 20);
		getContentPane().add(cmbColor);

		cantPuertasTF = new JTextField();
		cantPuertasTF.setBounds(687, 110, 71, 20);
		getContentPane().add(cantPuertasTF);
		cantPuertasTF.setColumns(10);

		JButton btnGenerar = new JButton("Generar Reporte");
		btnGenerar.addActionListener(new ActionListener() {
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

				String tipoDoc = (String) cmbTipoDoc.getSelectedItem();
				String nroDoc = nroDocTF.getText();

				String marca = marcaTF.getText();
				String tamanio = (String) cmbTamanio.getSelectedItem();
				String modelo = modeloTF.getText();
				String transmision = (String) cmbTransmision.getSelectedItem();
				int cantPuertas = Integer.parseInt(cantPuertasTF.getText()
						.trim().isEmpty() ? "0" : cantPuertasTF.getText()
						.trim());
				String color = (String) cmbColor.getSelectedItem();
				String ac = (String) cmbAC.getSelectedItem();
				String tipoCombustible = (String) cmbTipoCombustible
						.getSelectedItem();

				// Mando el mensaje
				ResultadoOperacionReporteAlquileres res = controlador
						.generarReporteDeAlquileres(fechaInicioDesde,
								fechaInicioHasta, fechaFinDesde, fechaFinHasta,
								sucursalOrigen, sucursalDestino, tipoDoc,
								nroDoc, marca, tamanio, modelo, transmision,
								cantPuertas, color, ac, tipoCombustible);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					TM = new TMalquileresTABLA(res.getAlquileresDTO());
					AlquileresTABLA.setModel(TM);

				} else {
					TM = new TMalquileresTABLA(
							new ArrayList<ContratoAlquilerDTO>());
					AlquileresTABLA.setModel(TM);

					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnGenerar.setBounds(611, 143, 147, 23);
		getContentPane().add(btnGenerar);

		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(148, 113, 65, 14);
		getContentPane().add(lblTamao);

		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(436, 113, 83, 14);
		getContentPane().add(lblTransmision);

		cmbTamanio = new JComboBox();
		cmbTamanio.setBounds(198, 110, 86, 20);
		getContentPane().add(cmbTamanio);

		cmbTransmision = new JComboBox();
		cmbTransmision.setBounds(512, 110, 76, 20);
		getContentPane().add(cmbTransmision);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 764, 247);
		getContentPane().add(scrollPane);

		TM = new TMalquileresTABLA(new ArrayList<ContratoAlquilerDTO>());

		AlquileresTABLA = new JTable();
		AlquileresTABLA.setModel(TM);
		scrollPane.setViewportView(AlquileresTABLA);

		JLabel lblTipoCombustible = new JLabel("Tipo Combustible");
		lblTipoCombustible.setBounds(403, 147, 99, 14);
		getContentPane().add(lblTipoCombustible);

		cmbTipoCombustible = new JComboBox();
		cmbTipoCombustible.setBounds(512, 144, 76, 20);
		getContentPane().add(cmbTipoCombustible);

		JLabel lblAireAcondicionado = new JLabel("Aire Acond");
		lblAireAcondicionado.setBounds(148, 147, 108, 14);
		getContentPane().add(lblAireAcondicionado);

		cmbAC = new JComboBox();
		cmbAC.setBounds(219, 144, 65, 20);
		getContentPane().add(cmbAC);

	}
}

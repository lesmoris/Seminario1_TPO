package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import Helpers.HelperValoresFijos;
import Interfaces.ComboBoxItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class generarReporteAlquileres extends JInternalFrame {
	private JTextField fechaInicioDesdeTF;
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
	private JComboBox<ComboBoxItem> cmbOrigen;
	private JComboBox<ComboBoxItem> cmbDestino;
	private JComboBox<String> cmbTipoDoc;
	private JComboBox<String> cmbTamanio;
	private JComboBox<String> cmbTransmision;
	private JComboBox<String> cmbColor;
	
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

		JLabel lblReporteDeAlquileres = new JLabel("REPORTE DE ALQUILERES");
		lblReporteDeAlquileres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteDeAlquileres.setBounds(289, 25, 263, 33);
		getContentPane().add(lblReporteDeAlquileres);

		JLabel lblNewLabel = new JLabel("Sucursal Origen");
		lblNewLabel.setBounds(388, 94, 99, 14);
		getContentPane().add(lblNewLabel);

		cmbDestino = new JComboBox();
		cmbDestino.setBounds(492, 116, 96, 20);
		getContentPane().add(cmbDestino);

		JLabel lblFechaDesde = new JLabel("Desde");
		lblFechaDesde.setBounds(10, 94, 71, 14);
		getContentPane().add(lblFechaDesde);

		JLabel lblFechaHasta = new JLabel("Hasta");
		lblFechaHasta.setBounds(10, 119, 71, 14);
		getContentPane().add(lblFechaHasta);

		JLabel lblFechaInicio = new JLabel("FECHA INICIO");
		lblFechaInicio.setBounds(10, 69, 83, 14);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("FECHA FIN");
		lblFechaFin.setBounds(173, 69, 71, 14);
		getContentPane().add(lblFechaFin);

		fechaInicioDesdeTF = new JTextField();
		fechaInicioDesdeTF.setBounds(52, 91, 86, 20);
		getContentPane().add(fechaInicioDesdeTF);
		fechaInicioDesdeTF.setColumns(10);

		fechaInicioHastaTF = new JTextField();
		fechaInicioHastaTF.setBounds(52, 116, 86, 20);
		getContentPane().add(fechaInicioHastaTF);
		fechaInicioHastaTF.setColumns(10);

		JLabel lblDesde = new JLabel("Desde");
		lblDesde.setBounds(173, 94, 46, 14);
		getContentPane().add(lblDesde);

		JLabel lblHasta = new JLabel("Hasta");
		lblHasta.setBounds(173, 119, 46, 14);
		getContentPane().add(lblHasta);

		fechaFinDesdeTF = new JTextField();
		fechaFinDesdeTF.setBounds(254, 91, 86, 20);
		getContentPane().add(fechaFinDesdeTF);
		fechaFinDesdeTF.setColumns(10);

		fechaFinHastaTF = new JTextField();
		fechaFinHastaTF.setBounds(254, 116, 86, 20);
		getContentPane().add(fechaFinHastaTF);
		fechaFinHastaTF.setColumns(10);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(388, 119, 99, 14);
		getContentPane().add(lblSucursalDestino);

		cmbOrigen = new JComboBox();
		cmbOrigen.setBounds(492, 91, 96, 20);
		getContentPane().add(cmbOrigen);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(613, 69, 76, 14);
		getContentPane().add(lblCliente);

		JLabel lblSucursales = new JLabel("SUCURSALES");
		lblSucursales.setBounds(388, 69, 91, 14);
		getContentPane().add(lblSucursales);

		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(613, 94, 65, 14);
		getContentPane().add(lblTipoDoc);

		cmbTipoDoc = new JComboBox();
		cmbTipoDoc.setBounds(688, 91, 86, 20);
		getContentPane().add(cmbTipoDoc);

		JLabel lblNroDoc = new JLabel("Nro Doc");
		lblNroDoc.setBounds(613, 119, 65, 14);
		getContentPane().add(lblNroDoc);

		nroDocTF = new JTextField();
		nroDocTF.setBounds(688, 116, 86, 20);
		getContentPane().add(nroDocTF);
		nroDocTF.setColumns(10);

		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(10, 147, 83, 14);
		getContentPane().add(lblVehiculo);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 171, 46, 14);
		getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(294, 171, 46, 14);
		getContentPane().add(lblModelo);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 205, 46, 14);
		getContentPane().add(lblColor);

		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(613, 171, 108, 14);
		getContentPane().add(lblCantPuertas);

		marcaTF = new JTextField();
		marcaTF.setBounds(52, 171, 86, 20);
		getContentPane().add(marcaTF);
		marcaTF.setColumns(10);

		modeloTF = new JTextField();
		modeloTF.setBounds(340, 168, 86, 20);
		getContentPane().add(modeloTF);
		modeloTF.setColumns(10);

		cmbColor = new JComboBox();
		cmbColor.setBounds(52, 202, 86, 20);
		getContentPane().add(cmbColor);

		cantPuertasTF = new JTextField();
		cantPuertasTF.setBounds(703, 168, 71, 20);
		getContentPane().add(cantPuertasTF);
		cantPuertasTF.setColumns(10);

		JCheckBox chckbxAireAcondicionado = new JCheckBox("Aire Acondicionado");
		chckbxAireAcondicionado.setBounds(144, 201, 178, 23);
		getContentPane().add(chckbxAireAcondicionado);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGenerar.setBounds(627, 201, 147, 23);
		getContentPane().add(btnGenerar);

		JLabel lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(148, 171, 65, 14);
		getContentPane().add(lblTamao);

		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(436, 171, 83, 14);
		getContentPane().add(lblTransmision);

		cmbTamanio = new JComboBox();
		cmbTamanio.setBounds(198, 168, 86, 20);
		getContentPane().add(cmbTamanio);

		cmbTransmision = new JComboBox();
		cmbTransmision.setBounds(512, 168, 76, 20);
		getContentPane().add(cmbTransmision);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 764, 199);
		getContentPane().add(scrollPane);

	}
}

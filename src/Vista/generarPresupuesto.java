package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import Helpers.HelperDate;
import Helpers.HelperValoresFijos;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetListaVehiculos;

public class generarPresupuesto extends JInternalFrame {
	private JTextField numeroDocTF;
	private JTextField modeloTF;
	private JTextField cantPuertasTF;
	private JTextField marcaTF;
	private JTextField fechaInicioTF;
	private Controlador controlador;
	private JComboBox<String> tipoDocCOMBO;
	private JComboBox<String> tamañoCOMBO;
	private JComboBox<String> colorCOMBO;
	private JComboBox<String> transmisionCOMBO;
	private JComboBox<ComboBoxItem> sucOrigenCOMBO;
	private JComboBox<String> combustibleCOMBO;
	private JComboBox<String> cmbAC;
	private JButton verVehiculosBOTON;
	private List<SucursalDTO> sucursalestodas;
	private List<String> tiposDoc;
	private List<String> tamaños;
	private List<String> transmisiones;
	private List<String> colores;
	private List<String> tiposComb;
	private List<String> ac;
	// Estos Strings van para asignar los valores desde la pantalla y llamar al
	// controlador
	private String tipoDoc;
	private String numeroDoc;
	private String dominio;
	private String sucursalOrigen;
	private String sucursalDestino;
	private String fechaInicio;
	private JLabel lblModelo;
	private JLabel lblTamap;
	private JLabel lblCantPuertas;
	private JLabel lblColor;
	private JLabel lblTransmision;
	private JLabel lblCombustible;
	private JLabel lblMarca;
	private JLabel lblInicio;
	private JLabel lblSucursal;
	private JLabel lblSucursalOrigen;
	private JLabel lblVehiculo;
	private JButton btnBuscarCliente;
	private JButton btnEstablecerInicio;
	private JLabel lblAC;

	public generarPresupuesto() {

		iniciarComponentes();

		this.controlador = Controlador.getInstance();

		cargarTiposDoc();
		cargarSucursales();
		cargarTransmisiones();
		cargarTamaños();
		cargarColores();
		cargarCombustible();
		cargarAireAcondicionado();
	}

	private void mostrarComponentesInicio() {

		sucOrigenCOMBO.setVisible(true);
		lblInicio.setVisible(true);
		lblSucursal.setVisible(true);
		lblSucursalOrigen.setVisible(true);
		btnEstablecerInicio.setVisible(true);
		fechaInicioTF.setVisible(true);
		btnBuscarCliente.setVisible(false);
		tipoDocCOMBO.setEnabled(false);
		numeroDocTF.setEditable(false);
		btnBuscarCliente.setVisible(false);

	}

	private void mostrarComponentesVehiculo() {

		sucOrigenCOMBO.setEnabled(false);
		btnEstablecerInicio.setVisible(false);
		fechaInicioTF.setEditable(false);

		verVehiculosBOTON.setVisible(true);
		tamañoCOMBO.setVisible(true);
		colorCOMBO.setVisible(true);
		transmisionCOMBO.setVisible(true);
		combustibleCOMBO.setVisible(true);
		cantPuertasTF.setVisible(true);
		marcaTF.setVisible(true);

		modeloTF.setVisible(true);
		lblCantPuertas.setVisible(true);
		lblColor.setVisible(true);
		lblCombustible.setVisible(true);
		lblMarca.setVisible(true);
		lblModelo.setVisible(true);
		lblTamap.setVisible(true);
		lblTransmision.setVisible(true);
		lblVehiculo.setVisible(true);
		lblAC.setVisible(true);
		cmbAC.setVisible(true);

	}

	private void cargarCombustible() {

		tiposComb = HelperValoresFijos.getTiposComb();

		combustibleCOMBO.addItem(" ");
		for (String s : tiposComb) {
			combustibleCOMBO.addItem(s);
		}

	}

	private void cargarColores() {

		colorCOMBO.addItem(" ");

		this.colores = HelperValoresFijos.getColores();

		for (String s : colores) {

			colorCOMBO.addItem(s);
		}

	}

	private void cargarTamaños() {

		tamañoCOMBO.addItem(" ");

		this.tamaños = HelperValoresFijos.getTamaños();

		for (String t : tamaños) {
			tamañoCOMBO.addItem(t);
		}

	}

	private void cargarTransmisiones() {

		transmisionCOMBO.addItem(" ");

		this.transmisiones = HelperValoresFijos.getTransmisiones();

		for (String s : transmisiones) {
			transmisionCOMBO.addItem(s);
		}

	}

	private void cargarTiposDoc() {

		this.tiposDoc = HelperValoresFijos.getTiposDoc();

		for (String td : tiposDoc) {
			tipoDocCOMBO.addItem(td);
		}
	}

	private void cargarSucursales() {

		this.sucursalestodas = controlador.getSucursales();

		ComboBoxItem cb = new ComboBoxItem();
		cb.setNombre("");
		cb.setCodigo(0);

		for (SucursalDTO s : this.sucursalestodas) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());
			sucOrigenCOMBO.addItem(cbi);
		}

	}

	private void cargarAireAcondicionado() {
		this.ac = HelperValoresFijos.getAireAcondicionado();

		cmbAC.addItem("");

		for (String s : this.ac) {

			cmbAC.addItem(s);
		}
	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(171, 111, 60, 14);
		getContentPane().add(lblCliente);

		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(171, 157, 60, 14);
		getContentPane().add(lblTipoDoc);

		tipoDocCOMBO = new JComboBox();
		tipoDocCOMBO.setBounds(298, 154, 71, 20);
		getContentPane().add(tipoDocCOMBO);

		JLabel lblNumeroDoc = new JLabel("Numero Doc");
		lblNumeroDoc.setBounds(171, 188, 71, 14);
		getContentPane().add(lblNumeroDoc);

		numeroDocTF = new JTextField();
		numeroDocTF.setBounds(251, 185, 118, 20);
		getContentPane().add(numeroDocTF);
		numeroDocTF.setColumns(10);

		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tipoDoc = tipoDocCOMBO.getSelectedItem().toString();
				numeroDoc = numeroDocTF.getText();

				ResultadoOperacion res = controlador.existeCliente(tipoDoc,
						numeroDoc);
				if (res.sosExitoso()) {
					mostrarComponentesInicio();
				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnBuscarCliente.setBounds(211, 213, 158, 23);
		getContentPane().add(btnBuscarCliente);

		lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(479, 111, 74, 14);
		getContentPane().add(lblVehiculo);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(658, 157, 46, 14);
		getContentPane().add(lblModelo);

		lblTamap = new JLabel("Tama\u00F1o");
		lblTamap.setBounds(479, 188, 46, 14);
		getContentPane().add(lblTamap);

		lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(479, 219, 98, 14);
		getContentPane().add(lblCantPuertas);

		lblColor = new JLabel("Color");
		lblColor.setBounds(479, 252, 46, 14);
		getContentPane().add(lblColor);

		lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(479, 284, 86, 14);
		getContentPane().add(lblTransmision);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(479, 157, 46, 14);
		getContentPane().add(lblMarca);

		modeloTF = new JTextField();
		modeloTF.setBounds(724, 154, 129, 20);
		getContentPane().add(modeloTF);
		modeloTF.setColumns(10);

		tamañoCOMBO = new JComboBox();
		tamañoCOMBO.setBounds(560, 185, 84, 20);
		getContentPane().add(tamañoCOMBO);

		cantPuertasTF = new JTextField();
		cantPuertasTF.setBounds(560, 216, 86, 20);
		getContentPane().add(cantPuertasTF);
		cantPuertasTF.setColumns(10);

		colorCOMBO = new JComboBox();
		colorCOMBO.setBounds(560, 249, 86, 20);
		getContentPane().add(colorCOMBO);

		transmisionCOMBO = new JComboBox();
		transmisionCOMBO.setBounds(560, 281, 86, 20);
		getContentPane().add(transmisionCOMBO);

		marcaTF = new JTextField();
		marcaTF.setBounds(560, 154, 83, 20);
		getContentPane().add(marcaTF);
		marcaTF.setColumns(10);

		verVehiculosBOTON = new JButton("Ver Vehiculos");
		verVehiculosBOTON.setVisible(false);
		verVehiculosBOTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ac = (String) cmbAC.getSelectedItem();
				int cantPuertas = !cantPuertasTF.getText().trim().isEmpty() ? Integer
						.parseInt(cantPuertasTF.getText()) : 0;

				ResultadoOperacionGetListaVehiculos res = controlador
						.getvehiculosFiltro(sucOrigenCOMBO.getSelectedItem()
								.toString(), "nombre", marcaTF.getText(),
								modeloTF.getText(), ac, combustibleCOMBO
										.getSelectedItem().toString(),
								transmisionCOMBO.getSelectedItem().toString(),
								cantPuertas, colorCOMBO.getSelectedItem()
										.toString(), tamañoCOMBO
										.getSelectedItem().toString());

				if (res.sosExitoso()) {
					fechaInicio = fechaInicioTF.getText();

					sucursalOrigen = sucOrigenCOMBO.getSelectedItem()
							.toString();
					elegirVehiculo a = new elegirVehiculo(tipoDoc, numeroDoc,
							res.getListaVehiculosDTO(), fechaInicio,
							sucursalOrigen);

					// Vamos a la ventana con el cliente cargado, y los
					// vehiculos filtrados
					menuPrincipal.getInstance().irAVentana(a);
				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		verVehiculosBOTON.setBounds(658, 311, 195, 23);
		getContentPane().add(verVehiculosBOTON);

		lblInicio = new JLabel("Fecha Inicio");
		lblInicio.setBounds(171, 315, 74, 14);
		getContentPane().add(lblInicio);

		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fechaInicioTF = new JFormattedTextField(mf);

		fechaInicioTF.setBounds(277, 312, 92, 20);
		getContentPane().add(fechaInicioTF);
		fechaInicioTF.setColumns(10);

		lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(171, 284, 106, 14);
		getContentPane().add(lblSucursalOrigen);

		sucOrigenCOMBO = new JComboBox();
		sucOrigenCOMBO.setBounds(277, 281, 92, 20);
		getContentPane().add(sucOrigenCOMBO);

		lblCombustible = new JLabel("Combustible");
		lblCombustible.setBounds(479, 312, 86, 20);
		getContentPane().add(lblCombustible);

		combustibleCOMBO = new JComboBox();
		combustibleCOMBO.setBounds(560, 312, 86, 20);
		getContentPane().add(combustibleCOMBO);

		btnEstablecerInicio = new JButton("Establecer Inicio");
		btnEstablecerInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String fechaInicio = fechaInicioTF.getText();

				if (HelperDate.esFechaValida(HelperDate
						.FormateaFechaYYYYMMDD(fechaInicio))
						&& HelperDate.esMayorOIgualAHoy(HelperDate
								.FormateaFechaYYYYMMDD(fechaInicio))) {
					mostrarComponentesVehiculo();
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Ingrese una fecha de inicio valida, mayor o igual a hoy, por favor",
									"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnEstablecerInicio.setBounds(211, 340, 158, 23);
		getContentPane().add(btnEstablecerInicio);

		cmbAC = new JComboBox();
		cmbAC.setBounds(777, 195, 76, 20);
		getContentPane().add(cmbAC);

		lblAC = new JLabel("Aire Acondicionado");
		lblAC.setBounds(658, 198, 129, 14);
		getContentPane().add(lblAC);
		
		lblSucursal = new JLabel("SUCURSAL");
		lblSucursal.setBounds(171, 257, 80, 14);
		getContentPane().add(lblSucursal);

		verVehiculosBOTON.setVisible(false);
		tamañoCOMBO.setVisible(false);
		colorCOMBO.setVisible(false);
		transmisionCOMBO.setVisible(false);
		sucOrigenCOMBO.setVisible(false);
		combustibleCOMBO.setVisible(false);
		cantPuertasTF.setVisible(false);
		marcaTF.setVisible(false);
		fechaInicioTF.setVisible(false);
		modeloTF.setVisible(false);
		lblCantPuertas.setVisible(false);
		lblColor.setVisible(false);
		lblCombustible.setVisible(false);
		lblInicio.setVisible(false);
		lblMarca.setVisible(false);
		lblModelo.setVisible(false);
		lblSucursal.setVisible(false);
		lblSucursalOrigen.setVisible(false);
		lblTamap.setVisible(false);
		lblTransmision.setVisible(false);
		lblVehiculo.setVisible(false);
		cmbAC.setVisible(false);
		lblAC.setVisible(false);
		btnEstablecerInicio.setVisible(false);
	}
}
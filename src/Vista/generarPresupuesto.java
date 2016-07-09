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
	private JButton verVehiculosBOTON;
	private List<SucursalDTO> sucursalestodas;
	private List<String> tiposDoc;
	private List<String> tamaños;
	private List<String> transmisiones;
	private List<String> colores;
	private List<String> tiposComb;
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
	private JCheckBox aireAcondicionadoCB;
	private JLabel lblMarca;
	private JLabel lblInicio;
	private JLabel lblSucursal;
	private JLabel lblVehiculo;
	private JButton btnBuscarCliente;
	private JButton btnEstablecerInicio;

	public generarPresupuesto() {

		iniciarComponentes();

		this.controlador = Controlador.getInstance();

		cargarTiposDoc();
		cargarSucursales();
		cargarTransmisiones();
		cargarTamaños();
		cargarColores();
		cargarCombustible();

	}

	private void mostrarComponentesInicio() {

		sucOrigenCOMBO.setVisible(true);
		lblInicio.setVisible(true);
		lblSucursal.setVisible(true);
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
		aireAcondicionadoCB.setVisible(true);

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

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(58, 62, 46, 14);
		getContentPane().add(lblCliente);

		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		lblTipoDoc.setBounds(10, 108, 60, 14);
		getContentPane().add(lblTipoDoc);

		tipoDocCOMBO = new JComboBox();
		tipoDocCOMBO.setBounds(82, 105, 60, 20);
		getContentPane().add(tipoDocCOMBO);

		JLabel lblNumeroDoc = new JLabel("Numero Doc");
		lblNumeroDoc.setBounds(10, 149, 71, 14);
		getContentPane().add(lblNumeroDoc);

		numeroDocTF = new JTextField();
		numeroDocTF.setBounds(92, 146, 86, 20);
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
		btnBuscarCliente.setBounds(20, 174, 137, 23);
		getContentPane().add(btnBuscarCliente);

		lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(437, 62, 74, 14);
		getContentPane().add(lblVehiculo);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(502, 99, 46, 14);
		getContentPane().add(lblModelo);

		lblTamap = new JLabel("Tama\u00F1o");
		lblTamap.setBounds(328, 139, 46, 14);
		getContentPane().add(lblTamap);

		lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(301, 177, 98, 14);
		getContentPane().add(lblCantPuertas);

		lblColor = new JLabel("Color");
		lblColor.setBounds(328, 210, 46, 14);
		getContentPane().add(lblColor);

		aireAcondicionadoCB = new JCheckBox("Aire Acondicionado");
		aireAcondicionadoCB.setBounds(536, 186, 146, 23);
		getContentPane().add(aireAcondicionadoCB);

		lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(313, 235, 86, 14);
		getContentPane().add(lblTransmision);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(328, 99, 46, 14);
		getContentPane().add(lblMarca);

		modeloTF = new JTextField();
		modeloTF.setBounds(558, 96, 86, 20);
		getContentPane().add(modeloTF);
		modeloTF.setColumns(10);

		tamañoCOMBO = new JComboBox();
		tamañoCOMBO.setBounds(411, 136, 84, 20);
		getContentPane().add(tamañoCOMBO);

		cantPuertasTF = new JTextField();
		cantPuertasTF.setText("4");
		cantPuertasTF.setBounds(409, 174, 86, 20);
		getContentPane().add(cantPuertasTF);
		cantPuertasTF.setColumns(10);

		colorCOMBO = new JComboBox();
		colorCOMBO.setBounds(409, 207, 86, 20);
		getContentPane().add(colorCOMBO);

		transmisionCOMBO = new JComboBox();
		transmisionCOMBO.setBounds(409, 232, 86, 20);
		getContentPane().add(transmisionCOMBO);

		marcaTF = new JTextField();
		marcaTF.setBounds(384, 99, 86, 20);
		getContentPane().add(marcaTF);
		marcaTF.setColumns(10);

		verVehiculosBOTON = new JButton("Ver Vehiculos");
		verVehiculosBOTON.setVisible(false);
		verVehiculosBOTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ac = aireAcondicionadoCB.isSelected() ? "S" : "N";

				ResultadoOperacionGetListaVehiculos res = controlador
						.getvehiculosFiltro(sucOrigenCOMBO.getSelectedItem()
								.toString(), "nombre", marcaTF.getText(),
								modeloTF.getText(), ac, combustibleCOMBO
										.getSelectedItem().toString(),
								transmisionCOMBO.getSelectedItem().toString(),
								Integer.parseInt(cantPuertasTF.getText()),
								colorCOMBO.getSelectedItem().toString(),
								tamañoCOMBO.getSelectedItem().toString());

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
		verVehiculosBOTON.setBounds(438, 319, 137, 23);
		getContentPane().add(verVehiculosBOTON);

		lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setBounds(30, 311, 74, 14);
		getContentPane().add(lblInicio);

		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fechaInicioTF = new JFormattedTextField(mf);

		fechaInicioTF.setBounds(126, 308, 86, 20);
		getContentPane().add(fechaInicioTF);
		fechaInicioTF.setColumns(10);

		lblSucursal = new JLabel("Sucursal Origen");
		lblSucursal.setBounds(10, 282, 106, 14);
		getContentPane().add(lblSucursal);

		sucOrigenCOMBO = new JComboBox();
		sucOrigenCOMBO.setBounds(126, 277, 92, 20);
		getContentPane().add(sucOrigenCOMBO);

		lblCombustible = new JLabel("Combustible");
		lblCombustible.setBounds(301, 263, 86, 20);
		getContentPane().add(lblCombustible);

		combustibleCOMBO = new JComboBox();
		combustibleCOMBO.setBounds(409, 263, 86, 20);
		getContentPane().add(combustibleCOMBO);

		btnEstablecerInicio = new JButton("Establecer Inicio");
		btnEstablecerInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				mostrarComponentesVehiculo();

			}
		});
		btnEstablecerInicio.setBounds(60, 357, 158, 32);
		getContentPane().add(btnEstablecerInicio);

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
		lblTamap.setVisible(false);
		lblTransmision.setVisible(false);
		lblVehiculo.setVisible(false);
		aireAcondicionadoCB.setVisible(false);
		btnEstablecerInicio.setVisible(false);
	}
}
package Vista;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import Helpers.HelperValoresFijos;
import Interfaces.ComboBoxItem;

public class generarPresupuesto extends JInternalFrame {
	private JTextField numeroDocTF;
	private JTextField modeloTF;
	private JTextField cantPuertasTF;
	private JTextField marcaTF;
	private JTextField fechaInicioTF;
	private JTextField fechaFinTF;
	
	private Controlador controlador;
	private JComboBox<String> tipoDocCOMBO;
	private JComboBox<String> tamañoCOMBO;
	private JComboBox<String> colorCOMBO;
	private JComboBox<String> transmisionCOMBO;
	private JComboBox<ComboBoxItem> sucOrigenCOMBO;
	private JComboBox<ComboBoxItem> sucDestinoCOMBO;
	private JComboBox<String> combustibleCOMBO;
	private List<SucursalDTO> sucursalestodas;
	private List<String> tiposDoc;
	private List<String> tamaños;
	private List<String> transmisiones;
	private List<String> colores;
	private List<String> tiposComb;
	// Estos Strings van para asignar los valores desde la pantalla y llamar al controlador
	private String tipoDoc;
	private String numeroDoc;
	private String dominio;
	private String sucursalOrigen;
	private String sucursalDestino;
	
	
	
	public generarPresupuesto() {
		
		iniciarComponentes();
		
		this.controlador=Controlador.getInstance();
		
		
		cargarTiposDoc();
		cargarSucursales();
		cargarTransmisiones();
		cargarTamaños();
		cargarColores();
		cargarCombustible();
	}

	
	private void cargarCombustible() {


		tiposComb = HelperValoresFijos.getInstance().getTiposComb();
	
		for (String s: tiposComb){
			combustibleCOMBO.addItem(s);
		}
		
	}
	


	private void cargarColores() {
		
		this.colores = HelperValoresFijos.getInstance().getColores();
		
		for (String s : colores){
			
			colorCOMBO.addItem(s);
		}
		
	}


	private void cargarTamaños() {
		
		this.tamaños = HelperValoresFijos.getInstance().getTamaños();
		
		for (String t: tamaños){
			tamañoCOMBO.addItem(t);
			}
		
	}


	private void cargarTransmisiones() {
		
		this.transmisiones = HelperValoresFijos.getInstance().getTransmisiones();
		
		for (String s : transmisiones){
			transmisionCOMBO.addItem(s);
		}
		
	}


	private void cargarTiposDoc(){
		
		this.tiposDoc=HelperValoresFijos.getInstance().getTiposDoc();
		
		for (String td: tiposDoc){
		tipoDocCOMBO.addItem(td);
		}
	}
	
	private void cargarSucursales() {

		this.sucursalestodas = controlador.getSucursales();

		for (SucursalDTO s : this.sucursalestodas) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			sucDestinoCOMBO.addItem(cbi);
			sucOrigenCOMBO.addItem(cbi);
		}

	}

	
	
	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNuevoPresupuesto = new JLabel("Nuevo Presupuesto");
		lblNuevoPresupuesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuevoPresupuesto.setBounds(117, 11, 214, 40);
		getContentPane().add(lblNuevoPresupuesto);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 59, 46, 14);
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
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.setBounds(20, 174, 137, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblVehiculo = new JLabel("Vehiculo");
		lblVehiculo.setBounds(313, 62, 74, 14);
		getContentPane().add(lblVehiculo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(272, 87, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblTamap = new JLabel("Tama\u00F1o");
		lblTamap.setBounds(272, 127, 46, 14);
		getContentPane().add(lblTamap);
		
		JLabel lblCantPuertas = new JLabel("Cant Puertas");
		lblCantPuertas.setBounds(245, 165, 98, 14);
		getContentPane().add(lblCantPuertas);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(272, 198, 46, 14);
		getContentPane().add(lblColor);
		
		JCheckBox aireAcondicionadoCB = new JCheckBox("Aire Acondicionado");
		aireAcondicionadoCB.setBounds(272, 278, 146, 23);
		getContentPane().add(aireAcondicionadoCB);
		
		JLabel lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(257, 223, 86, 14);
		getContentPane().add(lblTransmision);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(220, 311, 46, 14);
		getContentPane().add(lblMarca);
		
		modeloTF = new JTextField();
		modeloTF.setBounds(353, 87, 86, 20);
		getContentPane().add(modeloTF);
		modeloTF.setColumns(10);
		
		tamañoCOMBO = new JComboBox();
		tamañoCOMBO.setBounds(355, 124, 84, 20);
		getContentPane().add(tamañoCOMBO);
		
		cantPuertasTF = new JTextField();
		cantPuertasTF.setBounds(353, 162, 86, 20);
		getContentPane().add(cantPuertasTF);
		cantPuertasTF.setColumns(10);
		
		colorCOMBO = new JComboBox();
		colorCOMBO.setBounds(353, 195, 86, 20);
		getContentPane().add(colorCOMBO);
		
		transmisionCOMBO = new JComboBox();
		transmisionCOMBO.setBounds(353, 220, 86, 20);
		getContentPane().add(transmisionCOMBO);
		
		marcaTF = new JTextField();
		marcaTF.setBounds(301, 308, 86, 20);
		getContentPane().add(marcaTF);
		marcaTF.setColumns(10);
		
		JButton btnBuscarAuto = new JButton("Buscar Vehiculo");
		btnBuscarAuto.setBounds(548, 191, 137, 23);
		getContentPane().add(btnBuscarAuto);
		
		JLabel lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setBounds(524, 121, 74, 14);
		getContentPane().add(lblInicio);
		
		fechaInicioTF = new JTextField();
		fechaInicioTF.setBounds(626, 118, 86, 20);
		getContentPane().add(fechaInicioTF);
		fechaInicioTF.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal Origen");
		lblSucursal.setBounds(504, 81, 106, 14);
		getContentPane().add(lblSucursal);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(20, 311, 61, 14);
		getContentPane().add(lblFechaFin);
		
		sucOrigenCOMBO = new JComboBox();
		sucOrigenCOMBO.setBounds(620, 78, 92, 20);
		getContentPane().add(sucOrigenCOMBO);
		
		fechaFinTF = new JTextField();
		fechaFinTF.setBounds(104, 308, 86, 20);
		getContentPane().add(fechaFinTF);
		fechaFinTF.setColumns(10);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino:");
		lblSucursalDestino.setBounds(10, 371, 116, 14);
		getContentPane().add(lblSucursalDestino);
		
		sucDestinoCOMBO = new JComboBox();
		sucDestinoCOMBO.setBounds(137, 368, 92, 20);
		getContentPane().add(sucDestinoCOMBO);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(592, 387, 106, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.setBounds(458, 341, 121, 23);
		getContentPane().add(btnCalcularPrecio);
		
		JLabel lblPrecioCalculado = new JLabel("Precio Calculado:");
		lblPrecioCalculado.setBounds(365, 387, 132, 23);
		getContentPane().add(lblPrecioCalculado);
		
		JLabel precioLABEL = new JLabel("\"PRECIO\"");
		precioLABEL.setBounds(472, 391, 71, 14);
		getContentPane().add(precioLABEL);
		
		JLabel lblCombustible = new JLabel("Combustible");
		lblCombustible.setBounds(245, 251, 86, 20);
		getContentPane().add(lblCombustible);
		
		combustibleCOMBO = new JComboBox();
		combustibleCOMBO.setBounds(353, 251, 86, 20);
		getContentPane().add(combustibleCOMBO);

		
		
	}
}

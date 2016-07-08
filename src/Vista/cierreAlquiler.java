package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import DTOs.ContratoAlquilerDTO;
import DTOs.SucursalDTO;
import Helpers.HelperValoresFijos;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetContratos;
import Interfaces.TMElegirContrato;

public class cierreAlquiler extends JInternalFrame {
	private JTextField numDocTF;
	private JTable contratosTABLA;
	private JLabel lblSucursalDestino;
	private JComboBox<ComboBoxItem> sucDestinoCOMBO;
	private JButton btnFinalizarContrato;
	private JLabel lblContratosVigentes;
	private JComboBox<String> tipoDocCOMBO;
	private JScrollPane scrollPane;
	private List<String> tiposDoc;
	private List<SucursalDTO> sucursalestodas;
	private Controlador controlador;
	private String tipoDocumento;
	private String numeroDocumento;
	private List<ContratoAlquilerDTO> contratos;	
	
	
	public cierreAlquiler() {

		controlador = Controlador.getInstance();

		iniciarComponentes();
		cargarTiposDoc();

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
			sucDestinoCOMBO.addItem(cbi);
		}

	}

	private void mostrarcontratos() {

		
		
		this.numeroDocumento =  numDocTF.getText();
		this.tipoDocumento = tipoDocCOMBO.getSelectedItem().toString();
		
		ResultadoOperacionGetContratos res = controlador.buscarContratodeCliente(numeroDocumento, tipoDocumento);
		
		
		
		if (res.sosExitoso()){
			
			lblSucursalDestino.setVisible(true);
			lblContratosVigentes.setVisible(true);
			scrollPane.setVisible(true);
			btnFinalizarContrato.setVisible(true);
			sucDestinoCOMBO.setVisible(true);
			cargarSucursales();

		
			
			this.contratos = res.getContratos();
		
		TMElegirContrato modelo = new TMElegirContrato(contratos);
		
		contratosTABLA.setModel(modelo);
		contratosTABLA.setVisible(true);

			
		}else{
			JOptionPane.showMessageDialog(null, res.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(10, 109, 100, 14);
		getContentPane().add(lblTipoDocumento);

		tipoDocCOMBO = new JComboBox();
		tipoDocCOMBO.setBounds(146, 106, 60, 20);
		getContentPane().add(tipoDocCOMBO);

		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(10, 145, 114, 14);
		getContentPane().add(lblNumeroDocumento);

		numDocTF = new JTextField();
		numDocTF.setBounds(142, 142, 86, 20);
		getContentPane().add(numDocTF);
		numDocTF.setColumns(10);

		JButton btnBuscarContrato = new JButton("Buscar Contratos");
		btnBuscarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// ResultadoOperacionGetContratos =

				mostrarcontratos();

			}
		});
		btnBuscarContrato.setBounds(41, 199, 143, 23);
		getContentPane().add(btnBuscarContrato);

		lblContratosVigentes = new JLabel("Contratos Vigentes");
		lblContratosVigentes.setBounds(341, 84, 139, 14);
		getContentPane().add(lblContratosVigentes);

		lblSucursalDestino = new JLabel("Sucursal De Devolucion");
		lblSucursalDestino.setBounds(216, 280, 143, 14);
		getContentPane().add(lblSucursalDestino);

		sucDestinoCOMBO = new JComboBox();
		sucDestinoCOMBO.setBounds(387, 277, 133, 20);
		getContentPane().add(sucDestinoCOMBO);

		btnFinalizarContrato = new JButton("Finalizar Contrato");
		btnFinalizarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Aca realizar el metodo de cierre de contrato, y calcular, si
				// existe, el punitorio en base
				// a la cantidad de dias de atraso en la devolucion y/o
				// devolucion en sucursal distinta a la del
				// contrato de alquiler

			}
		});
		btnFinalizarContrato.setBounds(436, 363, 139, 23);
		getContentPane().add(btnFinalizarContrato);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(248, 109, 478, 160);
		getContentPane().add(scrollPane);

		contratosTABLA = new JTable();
		scrollPane.setViewportView(contratosTABLA);

		lblSucursalDestino.setVisible(false);
		lblContratosVigentes.setVisible(false);
		scrollPane.setVisible(false);
		btnFinalizarContrato.setVisible(false);
		contratosTABLA.setVisible(false);
		sucDestinoCOMBO.setVisible(false);

	}

	private void cargarTiposDoc() {

		this.tiposDoc = HelperValoresFijos.getTiposDoc();

		for (String td : tiposDoc) {
			tipoDocCOMBO.addItem(td);
		}
	}

}

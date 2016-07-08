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
import DTOs.PresupuestoDTO;
import Helpers.HelperValoresFijos;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetPresupuestos;
import Interfaces.TMElegirPresupuesto;

public class nuevoContratoAlquiler extends JInternalFrame {
	private JTextField numeroDocTF;
	private JComboBox tipoDocCOMBO;
	private JButton btnBuscarCliente;
	private JButton btnGenerarContrato;
	private JLabel lblPresupuesto;
	private JTable PresupuestoTABLA;
	private JScrollPane scrollPane;
	private List<String> tiposDoc;
	private Controlador controlador;
	private String tipoDocumento;
	private String numeroDocumento;

	public nuevoContratoAlquiler() {

		iniciarComponentes();

		this.controlador = Controlador.getInstance();

		cargarTiposDoc();

	}

	private void cargarTiposDoc() {

		this.tiposDoc = HelperValoresFijos.getTiposDoc();

		for (String td : tiposDoc) {
			tipoDocCOMBO.addItem(td);
		}
	}

	private void mostrarPresupuestos() {

		btnGenerarContrato.setVisible(true);
		PresupuestoTABLA.setVisible(true);
		lblPresupuesto.setVisible(true);
		scrollPane.setVisible(true);

		tipoDocCOMBO.setEnabled(false);
		numeroDocTF.setEditable(false);
		btnBuscarCliente.setVisible(false);

	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(20, 104, 118, 14);
		getContentPane().add(lblTipoDocumento);

		tipoDocCOMBO = new JComboBox();
		tipoDocCOMBO.setBounds(139, 101, 69, 20);
		getContentPane().add(tipoDocCOMBO);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(56, 69, 69, 14);
		getContentPane().add(lblCliente);

		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(20, 147, 133, 14);
		getContentPane().add(lblNumeroDocumento);

		numeroDocTF = new JTextField();
		numeroDocTF.setBounds(139, 144, 86, 20);
		getContentPane().add(numeroDocTF);
		numeroDocTF.setColumns(10);

		btnBuscarCliente = new JButton("Buscar Presupuestos");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tipoDocumento = tipoDocCOMBO.getSelectedItem().toString();
				numeroDocumento = numeroDocTF.getText();

				ResultadoOperacionGetPresupuestos res = controlador
						.buscarPresupuestosDeCliente(numeroDocumento,
								tipoDocumento);				
				if (res.sosExitoso()) {
					mostrarPresupuestos();
					establecerPresupuestos(res.getPresupuestos());

				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(), res
							.sosExitoso() ? "Informacion" : "Error", res
							.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
							: JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarCliente.setBounds(34, 199, 150, 23);
		getContentPane().add(btnBuscarCliente);

		lblPresupuesto = new JLabel("PRESUPUESTOS");
		lblPresupuesto.setBounds(464, 78, 97, 14);
		getContentPane().add(lblPresupuesto);

		btnGenerarContrato = new JButton("Generar Contrato");
		btnGenerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tablaseleccionada(PresupuestoTABLA)) {

					int fila = PresupuestoTABLA.getSelectedRow();
					int idPresupuesto = Integer
							.parseInt((String) PresupuestoTABLA.getValueAt(
									fila, 0));
					try {
						controlador.generarContratoAlquiler(idPresupuesto);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace(); // 
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"debe seleccionar un presupuesto");
				}
			}
		});
		btnGenerarContrato.setBounds(413, 334, 137, 23);
		getContentPane().add(btnGenerarContrato);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 103, 468, 184);
		getContentPane().add(scrollPane);

		PresupuestoTABLA = new JTable();
		scrollPane.setViewportView(PresupuestoTABLA);

		btnGenerarContrato.setVisible(false);
		lblPresupuesto.setVisible(false);
		PresupuestoTABLA.setVisible(false);
		scrollPane.setVisible(false);
	}

	public boolean tablaseleccionada(JTable tabla) {

		boolean seleccionado = false;

		for (int i = 0; i < tabla.getRowCount(); i++) {
			for (int j = 0; j < tabla.getColumnCount(); j++) {
				if (tabla.isCellSelected(i, j)) {
					seleccionado = true;
				}
			}
		}
		return seleccionado;
	}

	private void establecerPresupuestos(List<PresupuestoDTO> presupuestos) {

		TMElegirPresupuesto modelo = new TMElegirPresupuesto(presupuestos);

		PresupuestoTABLA.setModel(modelo);

	}

}
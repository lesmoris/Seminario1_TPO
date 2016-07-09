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
		lblTipoDocumento.setBounds(20, 36, 118, 14);
		getContentPane().add(lblTipoDocumento);

		tipoDocCOMBO = new JComboBox();
		tipoDocCOMBO.setBounds(115, 33, 69, 20);
		getContentPane().add(tipoDocCOMBO);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(20, 11, 69, 14);
		getContentPane().add(lblCliente);

		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setBounds(205, 36, 133, 14);
		getContentPane().add(lblNumeroDocumento);

		numeroDocTF = new JTextField();
		numeroDocTF.setBounds(328, 33, 102, 20);
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
		btnBuscarCliente.setBounds(624, 32, 150, 23);
		getContentPane().add(btnBuscarCliente);

		btnGenerarContrato = new JButton("Generar Contrato");
		btnGenerarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tablaseleccionada(PresupuestoTABLA)) {

					int fila = PresupuestoTABLA.getSelectedRow();
					int idPresupuesto = Integer
							.parseInt((String) PresupuestoTABLA.getValueAt(
									fila, 0));

					ResultadoOperacion res = controlador
							.generarContratoAlquiler(idPresupuesto);

					JOptionPane.showMessageDialog(null, res.getMessage(), res
							.sosExitoso() ? "Informacion" : "Error", res
							.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
							: JOptionPane.ERROR_MESSAGE);

					if (res.sosExitoso())
						menuPrincipal.getInstance().irAMenuPrincipal();

				} else {
					JOptionPane.showMessageDialog(null,
							"Seleccionar un presupuesto, por favor");
				}
			}
		});
		btnGenerarContrato.setBounds(328, 371, 137, 23);
		getContentPane().add(btnGenerarContrato);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 764, 291);
		getContentPane().add(scrollPane);

		PresupuestoTABLA = new JTable();
		scrollPane.setViewportView(PresupuestoTABLA);

		btnGenerarContrato.setVisible(false);
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
		PresupuestoTABLA.removeColumn(PresupuestoTABLA.getColumnModel()
				.getColumn(0)); // Ocultamos el id

	}

}
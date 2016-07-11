package Vista;

import java.awt.Font;
import java.text.ParseException;
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
import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGenerarPresupuesto;
import Interfaces.TMVehiculoTABLA;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class elegirVehiculo extends JInternalFrame {

	private JTable vehiculosTABLA;
	private Controlador controlador;
	private JTextField fechaFinTF;
	private List<SucursalDTO> sucursales;
	public JComboBox<ComboBoxItem> sucursalDestinoCOMBO;
	private String dominio;
	private JLabel fechaInicioLABEL;
	private JLabel numDocLABEL;
	private JLabel tipoDOCLABEL;
	private JLabel sucOrigenLABEL;
	private JLabel precioActualLABEL;
	private String preciopordiaVehiculoActual;
	private String idPresupuestoActual = "";
	private String sucDestino;
	private String fechaFin;
	private String tipoDocumento;
	private String fechaDeInicio;
	private String numDoc;
	private String sucursalOrigen;

	public elegirVehiculo(String tipoDoc, String numeroDoc,
			List<VehiculoDTO> vehiculos, String fechaInicio, String sucOrigen) {

		this.fechaDeInicio = fechaInicio;
		this.numDoc = numeroDoc;
		this.tipoDocumento = tipoDoc;
		this.sucursalOrigen = sucOrigen;

		this.controlador = Controlador.getInstance();

		this.sucursales = Controlador.getInstance().getSucursales();

		setBounds(100, 100, 1024, 668);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 988, 453);
		getContentPane().add(scrollPane);

		vehiculosTABLA = new JTable();

		TMVehiculoTABLA modelo = new TMVehiculoTABLA(vehiculos);

		vehiculosTABLA.setModel(modelo);

		scrollPane.setViewportView(vehiculosTABLA);

		tipoDOCLABEL = new JLabel(" tipoDoc");
		tipoDOCLABEL.setBounds(10, 48, 67, 14);
		getContentPane().add(tipoDOCLABEL);
		tipoDOCLABEL.setText(tipoDoc);

		numDocLABEL = new JLabel("New label");
		numDocLABEL.setBounds(63, 48, 67, 14);
		getContentPane().add(numDocLABEL);
		numDocLABEL.setText(numeroDoc);

		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(10, 23, 86, 14);
		getContentPane().add(lblCliente);

		JButton btnCalcularPrecio = new JButton("Generar Presupuesto");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tablaseleccionada(vehiculosTABLA)) {

					int fila = vehiculosTABLA.getSelectedRow();
					String dominio = vehiculosTABLA.getValueAt(fila, 0)
							.toString();

					fechaFin = fechaFinTF.getText();
					sucDestino = sucursalDestinoCOMBO.getSelectedItem()
							.toString();

					ResultadoOperacion res = controlador.generarPresupuesto(
							dominio, tipoDocumento, numDoc, fechaDeInicio,
							fechaFin, sucursalOrigen, sucDestino);

					if (res.sosExitoso()) {

						JOptionPane.showMessageDialog(null, res.getMessage(),
								"Informacion", JOptionPane.INFORMATION_MESSAGE);
						
						menuPrincipal.getInstance().irAMenuPrincipal();

					} else {
						JOptionPane.showMessageDialog(null, res.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar un vehiculo");
				}

			}
		});
		btnCalcularPrecio.setBounds(837, 539, 161, 21);
		getContentPane().add(btnCalcularPrecio);

		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fechaFinTF = new JFormattedTextField(mf);
		fechaFinTF.setBounds(356, 539, 86, 20);
		getContentPane().add(fechaFinTF);
		fechaFinTF.setColumns(10);

		JLabel lblFechaFinalizacion = new JLabel("Fecha Finalizacion:");
		lblFechaFinalizacion.setBounds(247, 542, 109, 14);
		getContentPane().add(lblFechaFinalizacion);

		precioActualLABEL = new JLabel("");
		precioActualLABEL.setBounds(356, 389, 102, 14);
		getContentPane().add(precioActualLABEL);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino: ");
		lblSucursalDestino.setBounds(531, 542, 109, 14);
		getContentPane().add(lblSucursalDestino);

		sucursalDestinoCOMBO = new JComboBox();
		sucursalDestinoCOMBO.setBounds(632, 539, 106, 20);
		getContentPane().add(sucursalDestinoCOMBO);

		JLabel lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setBounds(10, 539, 91, 14);
		getContentPane().add(lblInicio);

		fechaInicioLABEL = new JLabel("New label");
		fechaInicioLABEL.setBounds(111, 539, 67, 14);
		getContentPane().add(fechaInicioLABEL);

		fechaInicioLABEL.setText(fechaInicio);

		JLabel lblSucOrigen = new JLabel("SUCURSAL ORIGEN");
		lblSucOrigen.setBounds(167, 23, 118, 14);
		getContentPane().add(lblSucOrigen);

		sucOrigenLABEL = new JLabel("");
		sucOrigenLABEL.setBounds(167, 50, 91, 14);
		getContentPane().add(sucOrigenLABEL);

		sucOrigenLABEL.setText(sucOrigen);

		cargarSucursales(sucursales);
	}

	private void cargarSucursales(List<SucursalDTO> sucursales) {

		for (SucursalDTO s : sucursales) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			this.sucursalDestinoCOMBO.addItem(cbi);

		}

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
}

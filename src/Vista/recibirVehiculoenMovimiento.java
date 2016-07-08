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
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.MovimientoDTO;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.TMrecibirvehiculoTABLA;

public class recibirVehiculoenMovimiento extends JInternalFrame {
	private JTable VehiculosEnMovimientoTABLA;
	private TMrecibirvehiculoTABLA TM;
	private List<MovimientoDTO> movimientos;
	private Controlador controlador;
	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> sucursalCOMBO;

	public recibirVehiculoenMovimiento() {

		this.controlador = Controlador.getInstance();

		this.sucursales = controlador.getSucursales();

		this.movimientos = controlador.getMovimientosEnCurso();

		iniciarComponentes();
	}

	private void iniciarComponentes() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JButton btnConfirmarRecepcionVehiculo = new JButton(
				"Confirmar Recepcion");
		btnConfirmarRecepcionVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Comprobamos si se selecciono alguna fila de la tabla
				if (tablaseleccionada(VehiculosEnMovimientoTABLA)) {

					// Obtenemos el dominio del vehiculo seleccionado y lo
					// buscamos

					int fila = VehiculosEnMovimientoTABLA.getSelectedRow();
					String dominio = VehiculosEnMovimientoTABLA.getValueAt(
							fila, 0).toString();
					String sucursalDestino = sucursalCOMBO.getSelectedItem()
							.toString();

					// Llamamos al controlador

					ResultadoOperacion res = controlador.recibirVehiculo(
							sucursalDestino, dominio);

					JOptionPane.showMessageDialog(null, res.getMessage(), res
							.sosExitoso() ? "Informacion" : "Error", res
							.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
							: JOptionPane.ERROR_MESSAGE);

					if (res.sosExitoso())
						menuPrincipal.getInstance().irAMenuPrincipal();

				} else {
					JOptionPane.showMessageDialog(null,
							"Seleccione un vehiculo, por favor");
				}
			}
		});
		btnConfirmarRecepcionVehiculo.setBounds(328, 324, 155, 23);
		getContentPane().add(btnConfirmarRecepcionVehiculo);

		JLabel lblNumeroDeOrden = new JLabel("Sucursal Que Recibe:");
		lblNumeroDeOrden.setBounds(44, 262, 125, 23);
		getContentPane().add(lblNumeroDeOrden);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 164, 525, 64);
		getContentPane().add(scrollPane);

		// Llenamos El TableModel

		TM = new TMrecibirvehiculoTABLA(movimientos);

		VehiculosEnMovimientoTABLA = new JTable();
		VehiculosEnMovimientoTABLA.setModel(TM);
		scrollPane.setViewportView(VehiculosEnMovimientoTABLA);

		sucursalCOMBO = new JComboBox();
		sucursalCOMBO.setBounds(171, 263, 103, 20);
		getContentPane().add(sucursalCOMBO);

		for (SucursalDTO s : this.sucursales) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			sucursalCOMBO.addItem(cbi);
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

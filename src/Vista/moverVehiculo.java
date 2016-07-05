package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetVehiculo;

public class moverVehiculo extends JInternalFrame {
	private JTextField dominioTF;

	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> cmbSucursalDestino;
	private JTextField SucursalOrigenTF;
	private Controlador controlador;

	// Constructor
	public moverVehiculo() {

		iniciarcomponentes();
		sucursales = new ArrayList<SucursalDTO>();
		this.controlador = Controlador.getInstance();
		cargarSucursales(sucursales);

	}

	// Cargamos los ComboBox
	private void cargarSucursales(List<SucursalDTO> sucursales) {

		this.sucursales = controlador.getSucursales();

		for (SucursalDTO s : this.sucursales) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			cmbSucursalDestino.addItem(cbi);
		}

	}

	// Componentes de la pantalla y acciones de los componentes
	private void iniciarcomponentes() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblMoverVehiculoDe = new JLabel("MOVER VEHICULO DE SUCURSAL");
		lblMoverVehiculoDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoverVehiculoDe.setBounds(237, 11, 325, 50);
		getContentPane().add(lblMoverVehiculoDe);

		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(21, 133, 46, 14);
		getContentPane().add(lblDominio);

		dominioTF = new JTextField();
		dominioTF.setBounds(130, 129, 144, 23);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(21, 167, 100, 14);
		getContentPane().add(lblSucursalOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(21, 201, 120, 14);
		getContentPane().add(lblSucursalDestino);

		cmbSucursalDestino = new JComboBox();
		cmbSucursalDestino.setBounds(130, 197, 144, 23);
		getContentPane().add(cmbSucursalDestino);

		final JButton btnIniciarMovimiento = new JButton("Iniciar Movimiento");
		btnIniciarMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				String sucursalDestino = ((ComboBoxItem) cmbSucursalDestino
						.getSelectedItem()).getNombre();

				// Mando el mensaje
				ResultadoOperacion res = controlador.moverVehiculo(
						sucursalDestino, dominioVehiculo);

				// Recibo y muestro el resultado
				JOptionPane.showMessageDialog(null, res.getMessage(), res
						.sosExitoso() ? "Informacion" : "Error", res
						.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
						: JOptionPane.ERROR_MESSAGE);
			}

		});
		btnIniciarMovimiento.setBounds(563, 297, 169, 34);
		btnIniciarMovimiento.setEnabled(false);
		getContentPane().add(btnIniciarMovimiento);

		SucursalOrigenTF = new JTextField();
		SucursalOrigenTF.setEditable(false);
		SucursalOrigenTF.setEnabled(false);
		SucursalOrigenTF.setColumns(10);
		SucursalOrigenTF.setBounds(130, 163, 144, 23);
		getContentPane().add(SucursalOrigenTF);

		JButton btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				// Mando el mensaje
				ResultadoOperacionGetVehiculo res = controlador
						.getVehiculo(dominioVehiculo);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {
					SucursalOrigenTF.setText(res.getVehiculoDTO().getSucursal().getNombre());

					btnIniciarMovimiento.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

					SucursalOrigenTF.setText("");
					btnIniciarMovimiento.setEnabled(false);
				}
			}
		});
		btnBuscarVehiculo.setBounds(286, 129, 120, 23);
		getContentPane().add(btnBuscarVehiculo);

	}
}

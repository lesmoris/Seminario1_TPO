package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetVehiculo;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cerrarMantenimiento extends JInternalFrame {
	private JTextField dominioTF;
	private Controlador controlador;

	public cerrarMantenimiento() {
		iniciarcomponentes();

		this.controlador = Controlador.getInstance();
	}

	private void iniciarcomponentes() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(34, 121, 87, 14);
		getContentPane().add(lblDominio);

		dominioTF = new JTextField();
		dominioTF.setBounds(97, 119, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JLabel lblDescripcionDelMantenimiento = new JLabel(
				"Descripci\u00F3n del mantenimiento realizado:");
		lblDescripcionDelMantenimiento.setBounds(213, 123, 245, 14);
		getContentPane().add(lblDescripcionDelMantenimiento);

		final JTextArea descripcionTA = new JTextArea();
		descripcionTA.setBorder(new LineBorder(new Color(0, 0, 0)));
		descripcionTA.setLineWrap(true);
		descripcionTA.setBounds(214, 146, 733, 138);
		descripcionTA.setEnabled(false);
		getContentPane().add(descripcionTA);

		final JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				String solucion = descripcionTA.getText();

				// Mando el mensaje
				ResultadoOperacion res = controlador.cerrarMantenimiento(
						dominioVehiculo, solucion);

				// Recibo y muestro el resultado
				JOptionPane.showMessageDialog(null, res.getMessage(), res
						.sosExitoso() ? "Informacion" : "Error", res
						.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
						: JOptionPane.ERROR_MESSAGE);

				if (res.sosExitoso())
					menuPrincipal.getInstance().irAMenuPrincipal();

			}
		});
		btnConfirmar.setBounds(841, 295, 106, 23);
		getContentPane().add(btnConfirmar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				// Mando el mensaje
				ResultadoOperacionGetVehiculo res = controlador
						.getVehiculo(dominioVehiculo);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {

					descripcionTA.setEnabled(true);
					btnConfirmar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

					descripcionTA.setEnabled(false);
					btnConfirmar.setEnabled(false);
				}
			}
		});
		btnBuscar.setBounds(98, 149, 89, 23);
		getContentPane().add(btnBuscar);

	}
}

package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;
import Interfaces.ResultadoOperacionGetVehiculo;

public class solicitarMantenimiento extends JInternalFrame {
	private JTextField dominioTF;
	private Controlador controlador;

	public solicitarMantenimiento() {
		iniciarcomponentes();
		
		this.controlador = Controlador.getInstance();
	}

	private void iniciarcomponentes() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblSolicitarMantenimiento = new JLabel("SOLICITAR MANTENIMIENTO");
		lblSolicitarMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolicitarMantenimiento.setBounds(212, 11, 306, 49);
		getContentPane().add(lblSolicitarMantenimiento);

		final JTextArea descripcionFallaTF = new JTextArea();
		descripcionFallaTF.setBorder(new LineBorder(new Color(0, 0, 0)));
		descripcionFallaTF.setLineWrap(true);
		descripcionFallaTF.setBounds(355, 116, 351, 165);
		descripcionFallaTF.setEnabled(false);
		getContentPane().add(descripcionFallaTF);

		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(34, 121, 46, 14);
		getContentPane().add(lblDominio);

		dominioTF = new JTextField();
		dominioTF.setBounds(95, 118, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		final JLabel lblDescripcion = new JLabel("Descripcion de la falla");
		lblDescripcion.setBounds(212, 121, 128, 14);
		getContentPane().add(lblDescripcion);

		final JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				String problema = descripcionFallaTF.getText();
				
				// Mando el mensaje
				ResultadoOperacion res = controlador.solicitarMantenimiento(dominioVehiculo, problema);

				// Recibo y muestro el resultado
				JOptionPane.showMessageDialog(null, res.getMessage(), res
						.sosExitoso() ? "Informacion" : "Error", res
						.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE
						: JOptionPane.ERROR_MESSAGE);
				
				if (res.sosExitoso())
					menuPrincipal.getInstance().irAMenuPrincipal();

			}
		});
		btnConfirmar.setBounds(617, 305, 89, 23);
		getContentPane().add(btnConfirmar);

		JButton btnBuscarVehiculo = new JButton("Buscar");
		btnBuscarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo los datos de la pantalla
				String dominioVehiculo = dominioTF.getText();

				// Mando el mensaje
				ResultadoOperacionGetVehiculo res = controlador
						.getVehiculo(dominioVehiculo);

				// Recibo y muestro el resultado
				if (res.sosExitoso()) {

					descripcionFallaTF.setEnabled(true);
					btnConfirmar.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, res.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

					descripcionFallaTF.setEnabled(false);
					btnConfirmar.setEnabled(false);
				}
			}
		});
		btnBuscarVehiculo.setBounds(95, 149, 89, 23);
		getContentPane().add(btnBuscarVehiculo);

	}
}

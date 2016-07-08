package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class bajaVehiculo extends JInternalFrame {
	private JTextField textField;

	public bajaVehiculo() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblDominioDelVeh = new JLabel("Dominio del Vehiculo");
		lblDominioDelVeh.setBounds(191, 138, 149, 14);
		getContentPane().add(lblDominioDelVeh);

		textField = new JTextField();
		textField.setBounds(321, 135, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnConfirmarBaja = new JButton("Confirmar");
		btnConfirmarBaja.setBounds(418, 134, 114, 23);
		getContentPane().add(btnConfirmarBaja);

	}

}

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
		lblDominioDelVeh.setBounds(34, 106, 149, 14);
		getContentPane().add(lblDominioDelVeh);

		textField = new JTextField();
		textField.setBounds(133, 103, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnConfirmarBaja = new JButton("Confirmar Baja");
		btnConfirmarBaja.setBounds(230, 102, 125, 23);
		getContentPane().add(btnConfirmarBaja);

	}

}

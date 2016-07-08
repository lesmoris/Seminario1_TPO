package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class modificacionVehiculo extends JInternalFrame {
	private JTextField dominioTF;
	private JTextField textField;

	public modificacionVehiculo() {

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblDominio = new JLabel("Dominio:");
		lblDominio.setBounds(231, 150, 86, 14);
		getContentPane().add(lblDominio);

		dominioTF = new JTextField();
		dominioTF.setBounds(327, 147, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(231, 181, 96, 14);
		getContentPane().add(lblPrecioPorDia);

		textField = new JTextField();
		textField.setBounds(327, 178, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(438, 146, 102, 23);
		getContentPane().add(btnConfirmar);

	}
}

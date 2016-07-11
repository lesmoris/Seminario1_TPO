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

		setBounds(100, 100, 1024, 668);
		getContentPane().setLayout(null);

		JLabel lblDominio = new JLabel("Dominio:");
		lblDominio.setBounds(335, 190, 86, 14);
		getContentPane().add(lblDominio);

		dominioTF = new JTextField();
		dominioTF.setBounds(431, 187, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(335, 221, 96, 14);
		getContentPane().add(lblPrecioPorDia);

		textField = new JTextField();
		textField.setBounds(431, 218, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(542, 186, 102, 23);
		getContentPane().add(btnConfirmar);

	}
}

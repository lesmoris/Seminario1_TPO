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
		
		JLabel lblModificarVehiculo = new JLabel("MODIFICAR VEHICULO");
		lblModificarVehiculo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblModificarVehiculo.setBounds(160, 22, 389, 42);
		getContentPane().add(lblModificarVehiculo);
		
		JLabel lblDominio = new JLabel("Dominio:");
		lblDominio.setBounds(10, 112, 86, 14);
		getContentPane().add(lblDominio);
		
		dominioTF = new JTextField();
		dominioTF.setBounds(106, 109, 86, 20);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);
		
		JLabel lblPrecioPorDia = new JLabel("Precio por Dia");
		lblPrecioPorDia.setBounds(10, 181, 96, 14);
		getContentPane().add(lblPrecioPorDia);
		
		textField = new JTextField();
		textField.setBounds(106, 178, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(232, 237, 89, 23);
		getContentPane().add(btnConfirmar);

	}
}

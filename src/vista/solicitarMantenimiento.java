package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class solicitarMantenimiento extends JInternalFrame {
	private JTextField textField;

	
	public solicitarMantenimiento() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblSolicitarMantenimiento = new JLabel("SOLICITAR MANTENIMIENTO");
		lblSolicitarMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSolicitarMantenimiento.setBounds(212, 11, 306, 49);
		getContentPane().add(lblSolicitarMantenimiento);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(34, 121, 46, 14);
		getContentPane().add(lblDominio);
		
		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(56, 74, 63, 14);
		getContentPane().add(lblVehiculo);
		
		textField = new JTextField();
		textField.setBounds(95, 118, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(48, 162, 89, 23);
		getContentPane().add(btnBuscar);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(301, 116, 215, 165);
		getContentPane().add(textArea);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(235, 97, 100, 14);
		getContentPane().add(lblDescripcion);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(481, 313, 89, 23);
		getContentPane().add(btnConfirmar);

	}
}

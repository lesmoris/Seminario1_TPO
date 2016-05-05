package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class cerrarMantenimiento extends JInternalFrame {
	private JTextField textField;

	
	public cerrarMantenimiento() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblCerrarMantenimiento = new JLabel("Cerrar Mantenimiento");
		lblCerrarMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCerrarMantenimiento.setBounds(117, 11, 194, 32);
		getContentPane().add(lblCerrarMantenimiento);
		
		JLabel lblNumeroOrden = new JLabel("Numero Orden");
		lblNumeroOrden.setBounds(39, 83, 87, 14);
		getContentPane().add(lblNumeroOrden);
		
		textField = new JTextField();
		textField.setBounds(142, 80, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcionDelMantenimiento = new JLabel("Descripcion del mantenimiento realizado:");
		lblDescripcionDelMantenimiento.setBounds(37, 131, 245, 14);
		getContentPane().add(lblDescripcionDelMantenimiento);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(39, 156, 204, 103);
		getContentPane().add(textArea);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(311, 223, 106, 23);
		getContentPane().add(btnConfirmar);

	}

}

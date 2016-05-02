package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class bajaVehiculo extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bajaVehiculo frame = new bajaVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bajaVehiculo() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblBajaVehiculo = new JLabel("Baja Vehiculo");
		lblBajaVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBajaVehiculo.setBounds(133, 11, 181, 25);
		getContentPane().add(lblBajaVehiculo);
		
		JLabel lblDominioDelVeh = new JLabel("Dominio del Vehiculo");
		lblDominioDelVeh.setBounds(34, 106, 125, 14);
		getContentPane().add(lblDominioDelVeh);
		
		textField = new JTextField();
		textField.setBounds(145, 103, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmarBaja = new JButton("Confirmar Baja");
		btnConfirmarBaja.setBounds(259, 214, 125, 23);
		getContentPane().add(btnConfirmarBaja);

	}

}

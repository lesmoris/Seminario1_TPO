package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class generarReporteHistoricoMantenimientoVehiculo extends
		JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generarReporteHistoricoMantenimientoVehiculo frame = new generarReporteHistoricoMantenimientoVehiculo();
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
	public generarReporteHistoricoMantenimientoVehiculo() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblHistorialMantenimiento = new JLabel("HISTORIAL MANTENIMIENTO");
		lblHistorialMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistorialMantenimiento.setBounds(263, 11, 281, 44);
		getContentPane().add(lblHistorialMantenimiento);
		
		JLabel lblDominioVehiculo = new JLabel("Dominio Vehiculo");
		lblDominioVehiculo.setBounds(22, 120, 79, 14);
		getContentPane().add(lblDominioVehiculo);
		
		textField = new JTextField();
		textField.setBounds(117, 117, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(171, 195, 89, 23);
		getContentPane().add(btnConfirmar);

	}

}

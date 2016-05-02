package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class generarReporteMantenimiento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generarReporteMantenimiento frame = new generarReporteMantenimiento();
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
	public generarReporteMantenimiento() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReporteMantenimiento = new JLabel("REPORTE MANTENIMIENTO");
		lblReporteMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMantenimiento.setBounds(269, 25, 250, 59);
		getContentPane().add(lblReporteMantenimiento);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(25, 156, 46, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 153, 140, 20);
		getContentPane().add(comboBox);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBounds(368, 264, 113, 23);
		getContentPane().add(btnGenerarReporte);

	}

}

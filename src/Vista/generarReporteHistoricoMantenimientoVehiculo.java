package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class generarReporteHistoricoMantenimientoVehiculo extends
		JInternalFrame {
	private JTextField textField;

	
	public generarReporteHistoricoMantenimientoVehiculo() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblHistorialMantenimiento = new JLabel("Historial Mantenimiento");
		lblHistorialMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHistorialMantenimiento.setBounds(281, 11, 221, 44);
		getContentPane().add(lblHistorialMantenimiento);
		
		JLabel lblDominioVehiculo = new JLabel("Dominio Vehiculo");
		lblDominioVehiculo.setBounds(281, 116, 116, 14);
		getContentPane().add(lblDominioVehiculo);
		
		textField = new JTextField();
		textField.setBounds(406, 113, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(347, 195, 89, 23);
		getContentPane().add(btnConfirmar);

	}

}

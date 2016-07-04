package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class generarReporteMantenimiento extends JInternalFrame {


	public generarReporteMantenimiento() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblReporteMantenimiento = new JLabel("Reporte Mantenimiento");
		lblReporteMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMantenimiento.setBounds(267, 22, 215, 59);
		getContentPane().add(lblReporteMantenimiento);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(249, 137, 69, 20);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(365, 137, 140, 20);
		getContentPane().add(comboBox);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBounds(292, 240, 164, 23);
		getContentPane().add(btnGenerarReporte);

	}

}

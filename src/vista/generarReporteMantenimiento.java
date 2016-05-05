package vista;

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
		
		JLabel lblReporteMantenimiento = new JLabel("REPORTE MANTENIMIENTO");
		lblReporteMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReporteMantenimiento.setBounds(269, 25, 250, 59);
		getContentPane().add(lblReporteMantenimiento);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(25, 156, 69, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(141, 153, 140, 20);
		getContentPane().add(comboBox);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setBounds(333, 264, 148, 23);
		getContentPane().add(btnGenerarReporte);

	}

}

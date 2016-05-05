package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class recibirVehiculoenMovimiento extends JInternalFrame {
	private JTextField textField;

	
	public recibirVehiculoenMovimiento() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAltaDeVehiculo = new JLabel("ALTA DE VEHICULO EN SUCURSAL");
		lblAltaDeVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltaDeVehiculo.setBounds(188, 11, 333, 44);
		getContentPane().add(lblAltaDeVehiculo);
		
		JLabel lblDominioVehiculo = new JLabel("Dominio Vehiculo");
		lblDominioVehiculo.setBounds(10, 155, 115, 14);
		getContentPane().add(lblDominioVehiculo);
		
		textField = new JTextField();
		textField.setBounds(119, 152, 100, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(23, 105, 57, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 102, 90, 20);
		getContentPane().add(comboBox);
		
		JButton btnConfirmarRecepcionVehiculo = new JButton("Confirmar Recepcion");
		btnConfirmarRecepcionVehiculo.setBounds(263, 231, 155, 23);
		getContentPane().add(btnConfirmarRecepcionVehiculo);

	}

}

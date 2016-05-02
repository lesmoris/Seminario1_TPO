package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class moverVehiculo extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moverVehiculo frame = new moverVehiculo();
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
	public moverVehiculo() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblMoverVehiculoDe = new JLabel("MOVER VEHICULO DE SUCURSAL");
		lblMoverVehiculoDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoverVehiculoDe.setBounds(226, 11, 325, 50);
		getContentPane().add(lblMoverVehiculoDe);
		
		JLabel label = new JLabel("");
		label.setBounds(35, 204, 46, 14);
		getContentPane().add(label);
		
		JLabel lblVehiculo = new JLabel("VEHICULO");
		lblVehiculo.setBounds(52, 178, 69, 14);
		getContentPane().add(lblVehiculo);
		
		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(35, 229, 46, 14);
		getContentPane().add(lblDominio);
		
		textField = new JTextField();
		textField.setBounds(99, 226, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.setBounds(52, 286, 107, 23);
		getContentPane().add(btnBuscarVehiculo);
		
		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(35, 107, 75, 14);
		getContentPane().add(lblSucursalOrigen);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 104, 97, 20);
		getContentPane().add(comboBox);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(289, 107, 97, 14);
		getContentPane().add(lblSucursalDestino);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(380, 104, 144, 23);
		getContentPane().add(comboBox_1);
		
		JButton btnIniciarMovimiento = new JButton("Iniciar Movimiento");
		btnIniciarMovimiento.setBounds(401, 204, 133, 23);
		getContentPane().add(btnIniciarMovimiento);

	}

}

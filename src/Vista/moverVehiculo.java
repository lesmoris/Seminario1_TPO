package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import Interfaces.ResultadoOperacion;

public class moverVehiculo extends JInternalFrame {
	private JTextField txtDominio;
	private Controlador controlador;

	public moverVehiculo() {
		
		this.controlador = Controlador.getInstance();

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);

		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);

		JLabel lblMoverVehiculoDe = new JLabel("MOVER VEHICULO DE SUCURSAL");
		lblMoverVehiculoDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMoverVehiculoDe.setBounds(237, 11, 325, 50);
		getContentPane().add(lblMoverVehiculoDe);

		JLabel lblDominio = new JLabel("Dominio");
		lblDominio.setBounds(21, 178, 46, 14);
		getContentPane().add(lblDominio);

		txtDominio = new JTextField();
		txtDominio.setBounds(130, 174, 144, 23);
		getContentPane().add(txtDominio);
		txtDominio.setColumns(10);

		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(21, 107, 100, 14);
		getContentPane().add(lblSucursalOrigen);

		final JComboBox cmbSucursalOrigen = new JComboBox();
		cmbSucursalOrigen.setBounds(130, 104, 144, 23);
		getContentPane().add(cmbSucursalOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(21, 142, 120, 14);
		getContentPane().add(lblSucursalDestino);

		final JComboBox cmbSucursalDestino = new JComboBox();
		cmbSucursalDestino.setBounds(130, 138, 144, 23);
		getContentPane().add(cmbSucursalDestino);

		JButton btnIniciarMovimiento = new JButton("Iniciar Movimiento");
		btnIniciarMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sucursalOrigen = cmbSucursalOrigen.getSelectedItem().toString();
				String sucursalDestino = cmbSucursalDestino.getSelectedItem().toString();
				String dominioVehiculo = txtDominio.getText();
				
				ResultadoOperacion res = controlador.moverVehiculo(sucursalOrigen, sucursalDestino, dominioVehiculo);
				
				JOptionPane.showMessageDialog(null,res.getMessage(),"Mensaje", res.sosExitoso() ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
			}
		});
		btnIniciarMovimiento.setBounds(605, 425, 169, 34);
		getContentPane().add(btnIniciarMovimiento);

	}
}

package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import Interfaces.ComboBoxItem;
import Mappers.sucursalMapper;
import Mappers.vehiculoMapper;
import Modelo.Vehiculo;

public class moverVehiculo extends JInternalFrame {
	private JTextField dominioTF;
	

	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> comboOrigen;
	private JComboBox<ComboBoxItem> comboDestino;
	
	
	// Constructor
	public moverVehiculo(List<SucursalDTO> sucursales) {
		
		iniciarcomponentes();
		cargarSucursales(sucursales);
		
			}

	// Cargamos los ComboBox
	private void cargarSucursales(List<SucursalDTO> sucursales) {
	
		this.sucursales = sucursales;
		
		for (SucursalDTO s : this.sucursales){
			
			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());
			
			comboDestino.addItem(cbi);
			comboOrigen.addItem(cbi);
		}
		
	}

	// Componentes de la pantalla y acciones de los componentes
	private void iniciarcomponentes() {
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

		dominioTF = new JTextField();
		dominioTF.setBounds(130, 174, 144, 23);
		getContentPane().add(dominioTF);
		dominioTF.setColumns(10);

		JLabel lblSucursalOrigen = new JLabel("Sucursal Origen");
		lblSucursalOrigen.setBounds(21, 107, 100, 14);
		getContentPane().add(lblSucursalOrigen);

		comboOrigen = new JComboBox();
		comboOrigen.setBounds(130, 104, 144, 23);
		getContentPane().add(comboOrigen);

		JLabel lblSucursalDestino = new JLabel("Sucursal Destino");
		lblSucursalDestino.setBounds(21, 142, 120, 14);
		getContentPane().add(lblSucursalDestino);

		comboDestino = new JComboBox();
		comboDestino.setBounds(130, 138, 144, 23);
		getContentPane().add(comboDestino);

		JButton btnIniciarMovimiento = new JButton("Iniciar Movimiento");
		btnIniciarMovimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (dominioTF.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "DEBE INGRESAR DOMINIO");
				}else{
				
				Vehiculo v = vehiculoMapper.getInstance().Select(dominioTF.getText());
				
				// Guardamos el codigo de la sucursal elegida como destino
				
				int codigoSucursalDestino = ((ComboBoxItem) comboDestino.getSelectedItem()).getCodigo();
				
						// Iniciamos el movimiento del vehiculo
				try {
					v.mover(sucursalMapper.getInstance().SelectPORID(codigoSucursalDestino));
					
					JOptionPane.showMessageDialog(null, "Se ha generado el Movimiento del Vehiculo de dominio " + 
					v.getDominio() + " a la Sucursal: " + comboDestino.getSelectedItem().toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			}
		});
		btnIniciarMovimiento.setBounds(563, 297, 169, 34);
		getContentPane().add(btnIniciarMovimiento);

		
	}
}

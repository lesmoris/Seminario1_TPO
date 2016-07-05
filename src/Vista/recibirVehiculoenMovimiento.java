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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Interfaces.ComboBoxItem;
import Interfaces.TMrecibirvehiculoTABLA;
import Mappers.sucursalMapper;
import Mappers.vehiculoMapper;
import Modelo.Sucursal;
import Modelo.Vehiculo;

public class recibirVehiculoenMovimiento extends JInternalFrame {
	private JTable VehiculosEnMovimientoTABLA;
	private TMrecibirvehiculoTABLA TM;
	private List<VehiculoDTO> vehiculos;
	private Controlador controlador;
	private List<SucursalDTO> sucursales;
	private JComboBox<ComboBoxItem> sucursalCOMBO;
	
	public recibirVehiculoenMovimiento() {
		
		this.controlador = Controlador.getInstance();
		
		this.vehiculos=controlador.getVehiculosEnMovimiento();
		
		this.sucursales=controlador.getSucursales();
		
		
		iniciarComponentes();
		
		
	}

	private void iniciarComponentes() {
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(null);
		
		JLabel lblAltaDeVehiculo = new JLabel("ALTA DE VEHICULO EN SUCURSAL");
		lblAltaDeVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltaDeVehiculo.setBounds(188, 11, 333, 44);
		getContentPane().add(lblAltaDeVehiculo);
		
		JButton btnConfirmarRecepcionVehiculo = new JButton("Confirmar Recepcion");
		btnConfirmarRecepcionVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Comprobamos si se selecciono alguna fila de la tabla
				if (tablaseleccionada(VehiculosEnMovimientoTABLA)){
				
				// Obtenemos el dominio del vehiculo seleccionado y lo buscamos
					
					int fila = VehiculosEnMovimientoTABLA.getSelectedRow();
					String dominio = VehiculosEnMovimientoTABLA.getValueAt(fila, 0).toString();
					Vehiculo v = vehiculoMapper.getInstance().Select(dominio);
					Sucursal s = sucursalMapper.getInstance().Select(((ComboBoxItem) sucursalCOMBO.getSelectedItem()).getNombre());
					
					try {
						v.recibir(s);
						
						
						// Generar Mensaje de Recepcion
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				}else{
					JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN VEHICULO PARA RECIBIR");
				}
			}
		});
		btnConfirmarRecepcionVehiculo.setBounds(328, 324, 155, 23);
		getContentPane().add(btnConfirmarRecepcionVehiculo);
		
		JLabel lblNumeroDeOrden = new JLabel("Sucursal Que Recibe:");
		lblNumeroDeOrden.setBounds(44, 262, 125, 23);
		getContentPane().add(lblNumeroDeOrden);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 164, 525, 64);
		getContentPane().add(scrollPane);
		
		// Llenamos El TableModel
		
		TM = new TMrecibirvehiculoTABLA(vehiculos);
		
		VehiculosEnMovimientoTABLA = new JTable();
		VehiculosEnMovimientoTABLA.setModel(TM);
		scrollPane.setViewportView(VehiculosEnMovimientoTABLA);
		
		sucursalCOMBO = new JComboBox();
		sucursalCOMBO.setBounds(171, 263, 103, 20);
		getContentPane().add(sucursalCOMBO);

		for (SucursalDTO s : this.sucursales) {

			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());

			sucursalCOMBO.addItem(cbi);
		}
		
		
	}
	
	public boolean tablaseleccionada (JTable tabla){
		
		boolean seleccionado = false;
		
		for (int i=0; i<tabla.getRowCount();i++){
			for (int j=0; j<tabla.getColumnCount();j++){
				if (tabla.isCellSelected(i, j)){
					seleccionado=true;
				}
			}
		}
		
		
		return seleccionado;
	}
	
}

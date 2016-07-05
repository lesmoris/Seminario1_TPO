package Vista;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import DTOs.VehiculoDTO;
import Interfaces.TMrecibirvehiculoTABLA;

public class recibirVehiculoenMovimiento extends JInternalFrame {
	private JTextField nroOrdenTF;
	private JTable VehiculosEnMovimientoTABLA;
	private TMrecibirvehiculoTABLA TM;
	private List<VehiculoDTO> vehiculos;
	
	public recibirVehiculoenMovimiento(List<VehiculoDTO> vehiculos) {
		
		this.vehiculos=vehiculos;
		
		
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
		btnConfirmarRecepcionVehiculo.setBounds(303, 311, 155, 23);
		getContentPane().add(btnConfirmarRecepcionVehiculo);
		
		JLabel lblNumeroDeOrden = new JLabel("Numero de Orden");
		lblNumeroDeOrden.setBounds(33, 130, 108, 23);
		getContentPane().add(lblNumeroDeOrden);
		
		nroOrdenTF = new JTextField();
		nroOrdenTF.setBounds(139, 131, 100, 20);
		getContentPane().add(nroOrdenTF);
		nroOrdenTF.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(286, 130, 89, 23);
		getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 164, 525, 64);
		getContentPane().add(scrollPane);
		
		TM = new TMrecibirvehiculoTABLA(null);
		
		VehiculosEnMovimientoTABLA = new JTable();
		VehiculosEnMovimientoTABLA.setModel(TM);
		scrollPane.setViewportView(VehiculosEnMovimientoTABLA);

		
		
	}
}

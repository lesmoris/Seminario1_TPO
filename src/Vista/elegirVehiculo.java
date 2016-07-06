package Vista;

import java.awt.Font;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import Controlador.Controlador;
import DTOs.VehiculoDTO;
import Interfaces.TMVehiculoTABLA;


public class elegirVehiculo extends JInternalFrame {
	private JTable vehiculosTABLA;
	private Controlador controlador;
	private JTextField fechaFinTF;
	
	public elegirVehiculo(String tipoDoc, String numeroDoc, List<VehiculoDTO> vehiculos) {

		this.controlador=Controlador.getInstance();
		
		setBounds(100, 100, 800, 500);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblElegirVehiculo = new JLabel("ELEGIR VEHICULO");
		lblElegirVehiculo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
		lblElegirVehiculo.setBounds(255, 11, 190, 31);
		getContentPane().add(lblElegirVehiculo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 53, 578, 287);
		getContentPane().add(scrollPane);
		
		vehiculosTABLA = new JTable();
		
		TMVehiculoTABLA modelo = new TMVehiculoTABLA(vehiculos);
		
		vehiculosTABLA.setModel(modelo);
		
		scrollPane.setViewportView(vehiculosTABLA);
		
		
		
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc:");
		lblTipoDoc.setBounds(10, 67, 46, 14);
		getContentPane().add(lblTipoDoc);
		
		JLabel tipoDOCLABEL = new JLabel(" tipoDoc");
		tipoDOCLABEL.setBounds(61, 67, 67, 14);
		getContentPane().add(tipoDOCLABEL);
		tipoDOCLABEL.setText(tipoDoc);
		
		
		JLabel lblNumDoc = new JLabel("num Doc:");
		lblNumDoc.setBounds(10, 107, 46, 14);
		getContentPane().add(lblNumDoc);
		
		JLabel numDocLABEL = new JLabel("New label");
		numDocLABEL.setBounds(61, 107, 67, 14);
		getContentPane().add(numDocLABEL);
		numDocLABEL.setText(numeroDoc);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(36, 39, 65, 14);
		getContentPane().add(lblCliente);
		
		JButton btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.setBounds(376, 351, 109, 23);
		getContentPane().add(btnCalcularPrecio);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(577, 384, 89, 23);
		getContentPane().add(btnConfirmar);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		fechaFinTF = new JFormattedTextField(mf);
		fechaFinTF.setBounds(265, 353, 86, 20);
		getContentPane().add(fechaFinTF);
		fechaFinTF.setColumns(10);
		
		JLabel lblFechaFinalizacion = new JLabel("Fecha Finalizacion:");
		lblFechaFinalizacion.setBounds(107, 356, 109, 14);
		getContentPane().add(lblFechaFinalizacion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(196, 388, 65, 14);
		getContentPane().add(lblPrecio);
		
		JLabel precioLABEL = new JLabel("label dinamico");
		precioLABEL.setBounds(263, 388, 102, 14);
		getContentPane().add(precioLABEL);
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

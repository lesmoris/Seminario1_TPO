package Vista;

import java.awt.Font;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import Controlador.Controlador;
import DTOs.SucursalDTO;
import DTOs.VehiculoDTO;
import Interfaces.ComboBoxItem;
import Interfaces.ResultadoOperacion;
import Interfaces.TMVehiculoTABLA;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class elegirVehiculo extends JInternalFrame {
	
	private JTable vehiculosTABLA;
	private Controlador controlador;
	private JTextField fechaFinTF;
	private List<SucursalDTO> sucursales;
	public JComboBox<ComboBoxItem> sucursalDestinoCOMBO;
	private String dominio;
	private JLabel fechaInicioLABEL;
	private JLabel numDocLABEL;
	private JLabel tipoDOCLABEL;
	private JLabel sucOrigenLABEL;
	private JLabel precioActualLABEL;
	private String preciopordiaVehiculoActual;
	private String idPresupuestoActual ="";
	private String sucDestino;
	private String fechaFin;
	private String tipoDocumento;
	private String fechaDeInicio;
	private String numDoc;
	private String sucursalOrigen;
	
	public elegirVehiculo(String tipoDoc, String numeroDoc, List<VehiculoDTO> vehiculos, String fechaInicio, String sucOrigen) {

		menuPrincipal.getInstance().setTitle("RENT A CAR - Elegir Vehiculo para Presupuesto");
		
		this.fechaDeInicio = fechaInicio;
		this.numDoc = numeroDoc;
		this.tipoDocumento = tipoDoc;
		this.sucursalOrigen = sucOrigen;
		
		this.controlador=Controlador.getInstance();
		
		this.sucursales=Controlador.getInstance().getSucursales();
		
		setBounds(100, 100, 800, 500);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblElegirVehiculo = new JLabel("ELEGIR VEHICULO");
		lblElegirVehiculo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
		lblElegirVehiculo.setBounds(255, 11, 190, 31);
		getContentPane().add(lblElegirVehiculo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 53, 578, 241);
		getContentPane().add(scrollPane);
		
		vehiculosTABLA = new JTable();
		
		TMVehiculoTABLA modelo = new TMVehiculoTABLA(vehiculos);
		
		vehiculosTABLA.setModel(modelo);
		
		scrollPane.setViewportView(vehiculosTABLA);

		
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc Cliente:");
		lblTipoDoc.setBounds(10, 54, 118, 14);
		getContentPane().add(lblTipoDoc);
		
		tipoDOCLABEL = new JLabel(" tipoDoc");
		tipoDOCLABEL.setBounds(10, 82, 67, 14);
		getContentPane().add(tipoDOCLABEL);
		tipoDOCLABEL.setText(tipoDoc);
		
		
		JLabel lblNumDoc = new JLabel("num Doc Cliente:");
		lblNumDoc.setBounds(10, 107, 118, 14);
		getContentPane().add(lblNumDoc);
		
		numDocLABEL = new JLabel("New label");
		numDocLABEL.setBounds(10, 132, 67, 14);
		getContentPane().add(numDocLABEL);
		numDocLABEL.setText(numeroDoc);
		
		JLabel lblCliente = new JLabel("CLIENTE:");
		lblCliente.setBounds(32, 22, 65, 14);
		getContentPane().add(lblCliente);
		
		JButton btnCalcularPrecio = new JButton("Generar Presupuesto");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (tablaseleccionada(vehiculosTABLA)){
					
				// Obtenemos el dominio del vehiculo seleccionado y lo buscamos
					
					int fila = vehiculosTABLA.getSelectedRow();
					String dominio = vehiculosTABLA.getValueAt(fila, 0).toString();
				
				
				
				
				fechaFin = fechaFinTF.getText();
				sucDestino = sucursalDestinoCOMBO.getSelectedItem().toString();
				
				System.out.println(fechaFin);
				System.out.println(fechaDeInicio);
				
				try {
					controlador.generarPresupuesto(dominio, tipoDocumento, numDoc, 
							fechaDeInicio, fechaFin, sucursalOrigen, sucDestino);
					
					menuPrincipal.getInstance().irAMenuPrincipal();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				}else{
					JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN VEHICULO");
				}
				
			}
		});
		btnCalcularPrecio.setBounds(466, 352, 198, 21);
		getContentPane().add(btnCalcularPrecio);
		
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
		
		precioActualLABEL = new JLabel("label dinamico");
		precioActualLABEL.setBounds(263, 388, 102, 14);
		getContentPane().add(precioActualLABEL);
		
		JLabel lblSucursalDestino = new JLabel("Sucursal Destino: ");
		lblSucursalDestino.setBounds(107, 308, 109, 14);
		getContentPane().add(lblSucursalDestino);
		
		sucursalDestinoCOMBO = new JComboBox();
		sucursalDestinoCOMBO.setBounds(255, 305, 96, 20);
		getContentPane().add(sucursalDestinoCOMBO);
		
		JLabel lblInicio = new JLabel("Fecha Inicio:");
		lblInicio.setBounds(10, 157, 91, 14);
		getContentPane().add(lblInicio);
		
		fechaInicioLABEL = new JLabel("New label");
		fechaInicioLABEL.setBounds(10, 175, 67, 14);
		getContentPane().add(fechaInicioLABEL);
		
		fechaInicioLABEL.setText(fechaInicio);
		
		JLabel lblSucOrigen = new JLabel("Suc Origen:");
		lblSucOrigen.setBounds(4, 200, 93, 14);
		getContentPane().add(lblSucOrigen);
		
		sucOrigenLABEL = new JLabel("");
		sucOrigenLABEL.setBounds(10, 225, 91, 14);
		getContentPane().add(sucOrigenLABEL);
		
		sucOrigenLABEL.setText(sucOrigen);
		
		cargarSucursales(sucursales);
	}
	
	
	private void cargarSucursales(List<SucursalDTO> sucursales) {
		
		for (SucursalDTO s: sucursales){
			
			ComboBoxItem cbi = new ComboBoxItem();
			cbi.setCodigo(s.getIdSucursal());
			cbi.setNombre(s.getNombre());
			
			this.sucursalDestinoCOMBO.addItem(cbi);	
			
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
